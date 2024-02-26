package dev.dotspace.dayhawk.security.hash.processor;

import dev.dotspace.dayhawk.security.hash.entity.IHashValue;
import dev.dotspace.dayhawk.security.hash.entity.ImmutableHashValue;
import dev.dotspace.dayhawk.security.hash.exception.DigestNotPresentException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import java.util.function.Function;


public abstract class AbstractHashProcessor implements IHashProcessor {
  private @Nullable MessageDigest messageDigest;

  /**
   * Constructs a new {@code HashProcessor} for the specified hash algorithm.
   *
   * <p>The hash processor is designed to generate hash values using the provided algorithm.</p>
   *
   * @param algorithm The name of the hash algorithm. Must not be {@code null}.
   * @throws NullPointerException If the provided algorithm is {@code null}.
   * @since 2024-02-25
   */
  protected AbstractHashProcessor(@Nullable final String algorithm){
    //Null check
    Objects.requireNonNull(algorithm);

    try {
      this.messageDigest = MessageDigest.getInstance(algorithm);
    } catch (final NoSuchAlgorithmException exception) {
      this.messageDigest = null;
      //Later error handling.
    }
  }

  /**
   * See {@link IHashProcessor#hash(byte[])}
   */
  @Override
  public @NotNull IHashValue hash(byte @Nullable [] secret) throws DigestNotPresentException {
    //Null check
    Objects.requireNonNull(secret);

    return this.hashValue(secret, bytes -> bytes);
  }

  /**
   * Performs a hash operation on the specified input using the provided function and returns
   * an {@link IHashValue} representing the result.
   *
   * <p>The input of the hash operation is processed by the specified function, which converts
   * the input into a byte array. The resulting byte array is then hashed using the underlying
   * {@link MessageDigest} instance associated with this {@code IHashProcessor}.</p>
   *
   * <p>The resulting {@code IHashValue} encapsulates the algorithm used for hashing and the
   * hashed value.</p>
   *
   * <p>Usage Example:</p>
   * <pre>
   * {@code
   * IHashProcessor hashProcessor = // Create an instance of a class implementing IHashProcessor
   *
   * // Perform a hash operation on a specific input
   * IHashValue hashValue = hashProcessor.hash("example", String::getBytes);
   * }
   * </pre>
   *
   * @param type     The input value to be hashed.
   * @param function The function that converts the input value into a byte array for hashing.
   * @param <TYPE>   The type of the input value to be hashed.
   * @return An {@code IHashValue} representing the result of the hash operation.
   * @throws NullPointerException if the specified input value or function is {@code null}.
   * @see IHashProcessor
   * @see IHashValue
   */
  private <TYPE> IHashValue hashValue(@NotNull final TYPE type,
                                      @NotNull final Function<TYPE, byte[]> function) throws DigestNotPresentException {
    if(this.messageDigest == null) {
      throw new DigestNotPresentException("No message digest algorithm found.");
    }

    //Convert bytes of secret to key.
    return new ImmutableHashValue(
        this.messageDigest.getAlgorithm(),
        this.messageDigest.digest(function.apply(type)));
  }
}
