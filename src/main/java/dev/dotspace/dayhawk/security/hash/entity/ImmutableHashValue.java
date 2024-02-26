package dev.dotspace.dayhawk.security.hash.entity;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * The {@code ImmutableHashValue} class is a final implementation of the {@link AbstractHashValue} class,
 * representing an immutable instance of a hashed value resulting from a hashing operation.
 *
 * <p>This class extends {@code AbstractHashValue} and provides a constructor to create an immutable instance
 * with the specified algorithm and hashed value. Once created, the values cannot be modified.</p>
 *
 * <p>Usage Example:</p>
 * <pre>
 * {@code
 * // Create an immutable instance of hashed value
 * ImmutableHashValue hashValue = new ImmutableHashValue("SHA-256", new byte[]{...});
 *
 * // Access algorithm and hashed value
 * String algorithm = hashValue.algorithm();
 * byte[] hashedData = hashValue.digest();
 * }
 * </pre>
 *
 * <p>The {@code ImmutableHashValue} class is intended for situations where an immutable representation
 * of a hashed value is desired.</p>
 *
 * @see AbstractHashValue
 */
public final class ImmutableHashValue extends AbstractHashValue {
  /**
   * Constructs an immutable instance of {@code ImmutableHashValue} with the specified algorithm and hashed value.
   *
   * @param algorithm The algorithm used for hashing.
   * @param digest    The hashed value as a byte array.
   */
  public ImmutableHashValue(@Nullable String algorithm,
                            byte @NotNull [] digest) {
    super(algorithm, digest);
  }
}

