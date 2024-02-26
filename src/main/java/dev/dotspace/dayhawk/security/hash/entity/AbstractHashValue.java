package dev.dotspace.dayhawk.security.hash.entity;

import lombok.Getter;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.Objects;

/**
 * The {@code AbstractHashValue} class is an abstract implementation of the {@link IHashValue} interface,
 * providing common functionality for classes representing the result of a hashing operation.
 *
 * <p>Implementing classes are expected to extend this abstract class and provide specific functionalities
 * related to the details of a hashing operation.</p>
 *
 * <p>This class includes the algorithm used for hashing and the hashed value as a byte array. It implements
 * the {@code IHashValue} interface, ensuring standard methods for accessing the algorithm and hashed value.</p>
 *
 * <p>Usage Example:</p>
 * <pre>
 * {@code
 * // Create a concrete implementation of AbstractHashValue
 * AbstractHashValue hashValue = new ConcreteHashValue("SHA-256", new byte[]{...});
 *
 * // Access algorithm and hashed value
 * String algorithm = hashValue.algorithm();
 * byte[] hashedData = hashValue.digest();
 * }
 * </pre>
 *
 * <p>The {@code AbstractHashValue} class includes an {@code equals} method that compares the algorithm
 * and the hashed value for equality with another {@code IHashValue} instance.</p>
 *
 * @see IHashValue
 */
@Getter
@Accessors(fluent=true)
public abstract class AbstractHashValue implements IHashValue {
  /**
   * The algorithm used for hashing.
   */
  private final @NotNull String algorithm;
  /**
   * The hashed value as a byte array.
   */
  private final byte @NotNull [] digest;

  /**
   * Constructs an {@code AbstractHashValue} with the specified algorithm and hashed value.
   *
   * @param algorithm The algorithm used for hashing.
   * @param digest    The hashed value as a byte array.
   * @throws NullPointerException if the specified algorithm or digest is {@code null}.
   */
  protected AbstractHashValue(@Nullable final String algorithm,
                              final byte @NotNull [] digest) {
    //Null check
    Objects.requireNonNull(algorithm);
    Objects.requireNonNull(digest);

    this.algorithm = algorithm;
    this.digest = digest;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    return obj instanceof IHashValue hashValue &&
        this.algorithm.equals(hashValue.algorithm()) &&
        Arrays.equals(this.digest, hashValue.digest());
  }
}
