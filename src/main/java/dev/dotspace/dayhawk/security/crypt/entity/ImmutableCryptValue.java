package dev.dotspace.dayhawk.security.crypt.entity;

import dev.dotspace.dayhawk.security.crypt.mode.CipherMode;
import org.jetbrains.annotations.Nullable;


/**
 * The {@code ImmutableCryptValue} class is a concrete implementation of {@code AbstractCryptValue}
 * representing an immutable cryptographic value.
 *
 * <p>This class extends {@code AbstractCryptValue} and provides a constructor to initialize
 * the cryptographic data, cipher mode, and algorithm information during instantiation.</p>
 *
 * <p>Once created, the values of this cryptographic object cannot be modified.</p>
 *
 * <p>Usage example:</p>
 * <pre>
 * {@code
 * // Create an immutable cryptographic value
 * ImmutableCryptValue cryptValue = new ImmutableCryptValue(data, cipherMode, algorithm);
 * byte[] data = cryptValue.data();
 * String algorithm = cryptValue.algorithm();
 * CipherMode mode = cryptValue.cipherMode();
 * // Use the data, algorithm, and cipher mode for cryptographic operations.
 * }
 * </pre>
 *
 * <p>It is recommended to use this class for scenarios where immutability of cryptographic values is desired.</p>
 *
 * @author Day-Hawk
 */
public final class ImmutableCryptValue extends AbstractCryptValue {
  /**
   * Constructs an {@code ImmutableCryptValue} with the specified cryptographic data, cipher mode, and algorithm.
   *
   * @param data       The byte array representing the cryptographic data.
   * @param cipherMode The {@link CipherMode} indicating the cipher mode used for encryption or decryption.
   * @param algorithm  The name of the cryptographic algorithm.
   */
  public ImmutableCryptValue(byte @Nullable [] data,
                             @Nullable CipherMode cipherMode,
                             @Nullable String algorithm) {
    super(data, cipherMode, algorithm);
  }
}
