package dev.dotspace.dayhawk.security.crypt.entity;

import dev.dotspace.dayhawk.security.crypt.mode.CipherMode;
import dev.dotspace.dayhawk.security.entity.AlgorithmObject;
import org.jetbrains.annotations.NotNull;

/**
 * The {@code ICryptValue} interface extends {@link AlgorithmObject} and represents a cryptographic value.
 *
 * <p>This interface defines methods for retrieving the cryptographic data, the associated algorithm,
 * and the cipher mode used for encryption or decryption.</p>
 *
 * <p>Implementations of this interface should provide meaningful implementations for the methods
 * to handle cryptographic data, algorithm information, and cipher mode.</p>
 *
 * <p>Usage example:</p>
 * <pre>
 * {@code
 * ICryptValue cryptValue = // obtain an implementation of ICryptValue
 * byte[] data = cryptValue.data();
 * String algorithm = cryptValue.algorithm();
 * CipherMode mode = cryptValue.cipherMode();
 * // Use the data, algorithm, and cipher mode for cryptographic operations.
 * }
 * </pre>
 *
 * @author Day-Hawk
 */
public interface ICryptValue extends AlgorithmObject {
  /**
   * Retrieves the cryptographic data.
   *
   * @return The byte array representing the cryptographic data.
   */
  byte[] data();
  /**
   * Retrieves the cipher mode associated with the cryptographic value.
   *
   * @return The {@link CipherMode} indicating the cipher mode used for encryption or decryption.
   */
  @NotNull CipherMode cipherMode();
}
