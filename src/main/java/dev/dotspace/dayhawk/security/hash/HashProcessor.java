package dev.dotspace.dayhawk.security.hash;

import dev.dotspace.dayhawk.security.hash.entity.ImmutableHashValue;
import dev.dotspace.dayhawk.security.hash.exception.HashException;
import dev.dotspace.dayhawk.security.hash.entity.IHashValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import java.util.function.Function;


public final class HashProcessor implements IHashProcessor {
  private final @NotNull String algorithm;

  /**
   * Create new hash manager.
   *
   * @param algorithm to create manager of.
   */
  HashProcessor(@Nullable final String algorithm) {
    //Null check
    Objects.requireNonNull(algorithm);

    this.algorithm = algorithm;
  }

  @Override
  public @NotNull IHashValue hash(byte @Nullable [] secret) throws HashException {
    //Null check
    Objects.requireNonNull(secret);

    return this.hash(secret, bytes -> bytes);
  }

  @Override
  public @NotNull IHashValue hash(@Nullable String secret) throws HashException {
    //Null check
    Objects.requireNonNull(secret);

    return this.hash(secret, s -> s.getBytes(StandardCharsets.UTF_8));
  }

  private <TYPE> IHashValue hash(@NotNull final TYPE type,
                                 @NotNull final Function<TYPE, byte[]> function) throws HashException {
    //Convert bytes of secret to key.
    try {
      return new ImmutableHashValue(this.algorithm, MessageDigest
          .getInstance(this.algorithm)
          .digest(function.apply(type)));
    } catch (final NoSuchAlgorithmException exception) {
      throw new HashException("No such algorithm="+this.algorithm+"("+exception.getMessage()+") found.");
    }
  }
}
