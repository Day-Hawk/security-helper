package dev.dotspace.dayhawk.security.hash.entity;

import dev.dotspace.dayhawk.security.entity.AlgorithmObject;
import org.jetbrains.annotations.NotNull;

/**
 * The {@code IHashValue} interface extends the {@link AlgorithmObject} interface, representing the result
 * of a hashing operation. It provides methods to retrieve the algorithm used for hashing and the
 * hashed value as a byte array.
 *
 * <p>Implementing classes are expected to encapsulate the details of a specific hashing operation and
 * provide a means to access the algorithm and the resulting hash value.</p>
 *
 * <p>Usage Example:</p>
 * <pre>
 * {@code
 * // Create an instance of a class implementing IHashValue
 * IHashValue hashValue = // ...
 *
 * // Access the algorithm and hashed value
 * String algorithm = hashValue.algorithm();
 * byte[] hashedData = hashValue.digest();
 * }
 * </pre>
 *
 * <p>The {@code IHashValue} interface is typically used to represent the result of hashing operations,
 * providing a standardized way to access algorithm information and hashed values.</p>
 *
 * @see AlgorithmObject
 */
public interface IHashValue extends AlgorithmObject {

  /**
   * Retrieves the hashed value as a byte array.
   *
   * @return The byte array representing the hashed value.
   */
  byte @NotNull [] digest();
}
