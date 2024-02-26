package dev.dotspace.dayhawk.security.crypt.entity;

import dev.dotspace.dayhawk.security.crypt.mode.CipherMode;
import lombok.Getter;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

/**
 * The {@code AbstractCryptValue} class is an abstract implementation of the {@code ICryptValue} interface.
 *
 * <p>This class provides a base implementation for cryptographic values, including cryptographic data,
 * cipher mode, and algorithm information.</p>
 *
 * <p>Subclasses must implement their own constructors to set the cryptographic data, cipher mode,
 * and algorithm information during instantiation.</p>
 *
 * <p>Usage example:</p>
 * <pre>
 * {@code
 * // Create a concrete implementation of AbstractCryptValue
 * AbstractCryptValue cryptValue = new ConcreteCryptValue(data, cipherMode, algorithm);
 * byte[] data = cryptValue.data();
 * String algorithm = cryptValue.algorithm();
 * CipherMode mode = cryptValue.cipherMode();
 * // Use the data, algorithm, and cipher mode for cryptographic operations.
 * }
 * </pre>
 *
 * <p>It is recommended to use concrete implementations of this class for specific cryptographic values.</p>
 *
 * @author Day-Hawk
 */
@Getter
@Accessors(fluent=true)
public abstract class AbstractCryptValue implements ICryptValue {
  /**
   * The byte array representing the cryptographic data.
   */
  private final byte @NotNull [] data;
  /**
   * The {@link CipherMode} indicating the cipher mode used for encryption or decryption.
   */
  private final @NotNull CipherMode cipherMode;
  /**
   * The name of the cryptographic algorithm.
   */
  private final @NotNull String algorithm;

  /**
   * Constructs an {@code AbstractCryptValue} with the specified cryptographic data, cipher mode, and algorithm.
   *
   * @param data       The byte array representing the cryptographic data.
   * @param cipherMode The {@link CipherMode} indicating the cipher mode used for encryption or decryption.
   * @param algorithm  The name of the cryptographic algorithm.
   * @throws NullPointerException if any of the parameters is {@code null}.
   */
  public AbstractCryptValue(byte @Nullable [] data,
                            @Nullable CipherMode cipherMode,
                            @Nullable String algorithm) {
    //Null check
    Objects.requireNonNull(data);
    Objects.requireNonNull(cipherMode);
    Objects.requireNonNull(algorithm);

    this.data = data;
    this.cipherMode = cipherMode;
    this.algorithm = algorithm;
  }
}
