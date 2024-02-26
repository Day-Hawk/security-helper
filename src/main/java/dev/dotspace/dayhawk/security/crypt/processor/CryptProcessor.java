package dev.dotspace.dayhawk.security.crypt.processor;

import org.jetbrains.annotations.Nullable;


/**
 * The {@code CryptProcessor} class is a concrete implementation of the {@link AbstractCryptProcessor} abstract class,
 * providing a specific cryptographic processor based on the chosen algorithm.
 *
 * <p>Instances of this class are created to perform encryption and decryption operations using the specified algorithm.</p>
 *
 * <p>This class acts as a concrete implementation of the {@code AbstractCryptProcessor},
 * initializing the cryptographic operations with a specific algorithm during construction.</p>
 *
 * <p>Usage Example:</p>
 * <pre>
 * {@code
 * CryptProcessor cryptProcessor = new CryptProcessor("AES/CBC/PKCS5Padding");
 *
 * // Perform encryption and decryption operations using the created instance
 * // ...
 * }
 * </pre>
 *
 * <p>Instances of this class are typically created with a specific algorithm,
 * and the provided algorithm is used for cryptographic operations throughout the lifecycle of the instance.</p>
 *
 * <p>This class is designed to be a ready-to-use implementation of a cryptographic processor,
 * and it is recommended to use it in scenarios where the algorithm is known at the time of instantiation.</p>
 *
 * @author Day-Hawk
 * @see AbstractCryptProcessor
 */
public final class CryptProcessor extends AbstractCryptProcessor {
  /**
   * Constructs a {@code CryptProcessor} with the specified algorithm for cryptographic operations.
   *
   * @param algorithm The algorithm to be used for encryption and decryption.
   */
  public CryptProcessor(@Nullable String algorithm) {
    super(algorithm);
  }
}
