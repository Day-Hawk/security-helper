package dev.dotspace.dayhawk.security.crypt.processor;

import dev.dotspace.dayhawk.security.crypt.entity.ICryptValue;
import dev.dotspace.dayhawk.security.crypt.exception.AlgorithmNotPresentException;
import dev.dotspace.dayhawk.security.crypt.exception.IllegalBlockException;
import dev.dotspace.dayhawk.security.crypt.exception.IllegalKeyException;
import dev.dotspace.dayhawk.security.crypt.exception.PaddingException;
import dev.dotspace.dayhawk.security.entity.ISecurityProcessor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.security.Key;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.spec.AlgorithmParameterSpec;


/**
 * The {@code ICryptProcessor} interface defines methods for cryptographic processing,
 * including encryption and decryption operations using different parameters.
 * Implementations of this interface handle various cryptographic tasks, such as key management,
 * algorithm specifications, and randomization for secure cryptographic operations.
 *
 * <p>Usage Example:</p>
 * <pre>
 * {@code
 * ICryptProcessor cryptProcessor = // Create an instance of a class implementing ICryptProcessor
 * Key key = // Obtain a key for encryption or decryption
 * byte[] data = // Data to be encrypted or decrypted
 *
 * // Perform encryption
 * ICryptValue encryptedValue = cryptProcessor.encrypt(key, data);
 *
 * // Perform decryption
 * ICryptValue decryptedValue = cryptProcessor.decrypt(key, encryptedValue.data());
 * }
 * </pre>
 *
 * <p>Implementing classes are expected to handle various cryptographic scenarios
 * by providing multiple methods with different combinations of parameters.</p>
 *
 * <p>Exceptions thrown during cryptographic operations include:
 * {@link PaddingException}, {@link AlgorithmNotPresentException},
 * {@link IllegalBlockException}, and {@link IllegalKeyException}.</p>
 *
 * <p>Implementations should ensure proper handling of these exceptions
 * to address specific issues encountered during cryptographic processing.</p>
 *
 * @author Day-Hawk
 */
public interface ICryptProcessor extends ISecurityProcessor {
  /**
   * Encrypts the given data using the specified key.
   *
   * @param key  The key used for encryption.
   * @param data The data to be encrypted.
   * @return An {@code ICryptValue} representing the result of the encryption operation.
   * @throws PaddingException             If an issue with padding is encountered.
   * @throws AlgorithmNotPresentException If the specified algorithm is not present or misconfigured.
   * @throws IllegalBlockException        If there is an issue with the block size during encryption.
   * @throws IllegalKeyException          If there is an issue with the provided key.
   */
  @NotNull ICryptValue encrypt(@Nullable final Key key,
                               final byte @Nullable [] data)
      throws PaddingException, AlgorithmNotPresentException, IllegalBlockException, IllegalKeyException;

  /**
   * Encrypts the given data using the specified key and a secure random number generator.
   *
   * @param key          The key used for encryption.
   * @param secureRandom The secure random number generator for additional randomness.
   * @param data         The data to be encrypted.
   * @return An {@code ICryptValue} representing the result of the encryption operation.
   * @throws PaddingException             If an issue with padding is encountered.
   * @throws AlgorithmNotPresentException If the specified algorithm is not present or misconfigured.
   * @throws IllegalBlockException        If there is an issue with the block size during encryption.
   * @throws IllegalKeyException          If there is an issue with the provided key.
   */
  @NotNull ICryptValue encrypt(@Nullable final Key key,
                               @Nullable final SecureRandom secureRandom,
                               final byte @Nullable [] data)
      throws PaddingException, AlgorithmNotPresentException, IllegalBlockException, IllegalKeyException;

  /**
   * Encrypts the given data using the specified key and algorithm parameter specification.
   *
   * @param key                    The key used for encryption.
   * @param algorithmParameterSpec The algorithm parameter specification for additional parameters.
   * @param data                   The data to be encrypted.
   * @return An {@code ICryptValue} representing the result of the encryption operation.
   * @throws PaddingException             If an issue with padding is encountered.
   * @throws AlgorithmNotPresentException If the specified algorithm is not present or misconfigured.
   * @throws IllegalBlockException        If there is an issue with the block size during encryption.
   * @throws IllegalKeyException          If there is an issue with the provided key.
   */
  @NotNull ICryptValue encrypt(@Nullable final Key key,
                               @Nullable final AlgorithmParameterSpec algorithmParameterSpec,
                               final byte @Nullable [] data)
      throws PaddingException, AlgorithmNotPresentException, IllegalBlockException, IllegalKeyException;

  /**
   * Encrypts the given data using the specified key, algorithm parameter specification, and secure random number generator.
   *
   * @param key                    The key used for encryption.
   * @param algorithmParameterSpec The algorithm parameter specification for additional parameters.
   * @param secureRandom           The secure random number generator for additional randomness.
   * @param data                   The data to be encrypted.
   * @return An {@code ICryptValue} representing the result of the encryption operation.
   * @throws PaddingException             If an issue with padding is encountered.
   * @throws AlgorithmNotPresentException If the specified algorithm is not present or misconfigured.
   * @throws IllegalBlockException        If there is an issue with the block size during encryption.
   * @throws IllegalKeyException          If there is an issue with the provided key.
   */
  @NotNull ICryptValue encrypt(@Nullable final Key key,
                               @Nullable final AlgorithmParameterSpec algorithmParameterSpec,
                               @Nullable final SecureRandom secureRandom,
                               final byte @Nullable [] data)
      throws PaddingException, AlgorithmNotPresentException, IllegalBlockException, IllegalKeyException;

  /**
   * Encrypts the given data using the specified certificate.
   *
   * @param certificate The certificate used for encryption.
   * @param data        The data to be encrypted.
   * @return An {@code ICryptValue} representing the result of the encryption operation.
   * @throws PaddingException             If an issue with padding is encountered.
   * @throws AlgorithmNotPresentException If the specified algorithm is not present or misconfigured.
   * @throws IllegalBlockException        If there is an issue with the block size during encryption.
   * @throws IllegalKeyException          If there is an issue with the provided key.
   */
  @NotNull ICryptValue encrypt(@Nullable final Certificate certificate,
                               final byte @Nullable [] data)
      throws PaddingException, AlgorithmNotPresentException, IllegalBlockException, IllegalKeyException;

  /**
   * Encrypts the given data using the specified certificate and a secure random number generator.
   *
   * @param certificate  The certificate used for encryption.
   * @param secureRandom The secure random number generator for additional randomness.
   * @param data         The data to be encrypted.
   * @return An {@code ICryptValue} representing the result of the encryption operation.
   * @throws PaddingException             If an issue with padding is encountered.
   * @throws AlgorithmNotPresentException If the specified algorithm is not present or misconfigured.
   * @throws IllegalBlockException        If there is an issue with the block size during encryption.
   * @throws IllegalKeyException          If there is an issue with the provided key.
   */
  @NotNull ICryptValue encrypt(@Nullable final Certificate certificate,
                               @Nullable final SecureRandom secureRandom,
                               final byte @Nullable [] data)
      throws PaddingException, AlgorithmNotPresentException, IllegalBlockException, IllegalKeyException;

  /**
   * Decrypts the given encrypted data using the specified key.
   *
   * @param key           The key used for decryption.
   * @param encryptedData The encrypted data to be decrypted.
   * @return An {@code ICryptValue} representing the result of the decryption operation.
   * @throws PaddingException             If an issue with padding is encountered.
   * @throws AlgorithmNotPresentException If the specified algorithm is not present or misconfigured.
   * @throws IllegalBlockException        If there is an issue with the block size during decryption.
   * @throws IllegalKeyException          If there is an issue with the provided key.
   */
  @NotNull ICryptValue decrypt(@Nullable final Key key,
                               final byte @Nullable [] encryptedData)
      throws PaddingException, AlgorithmNotPresentException, IllegalBlockException, IllegalKeyException;

  /**
   * Decrypts the given encrypted data using the specified key and a secure random number generator.
   *
   * @param key           The key used for decryption.
   * @param secureRandom  The secure random number generator for additional randomness.
   * @param encryptedData The encrypted data to be decrypted.
   * @return An {@code ICryptValue} representing the result of the decryption operation.
   * @throws PaddingException             If an issue with padding is encountered.
   * @throws AlgorithmNotPresentException If the specified algorithm is not present or misconfigured.
   * @throws IllegalBlockException        If there is an issue with the block size during decryption.
   * @throws IllegalKeyException          If there is an issue with the provided key.
   */
  @NotNull ICryptValue decrypt(@Nullable final Key key,
                               @Nullable final SecureRandom secureRandom,
                               final byte @Nullable [] encryptedData)
      throws PaddingException, AlgorithmNotPresentException, IllegalBlockException, IllegalKeyException;

  /**
   * Decrypts the given encrypted data using the specified key and algorithm parameter specification.
   *
   * @param key                    The key used for decryption.
   * @param algorithmParameterSpec The algorithm parameter specification for additional parameters.
   * @param encryptedData          The encrypted data to be decrypted.
   * @return An {@code ICryptValue} representing the result of the decryption operation.
   * @throws PaddingException             If an issue with padding is encountered.
   * @throws AlgorithmNotPresentException If the specified algorithm is not present or misconfigured.
   * @throws IllegalBlockException        If there is an issue with the block size during decryption.
   * @throws IllegalKeyException          If there is an issue with the provided key.
   */
  @NotNull ICryptValue decrypt(@Nullable final Key key,
                               @Nullable final AlgorithmParameterSpec algorithmParameterSpec,
                               final byte @Nullable [] encryptedData)
      throws PaddingException, AlgorithmNotPresentException, IllegalBlockException, IllegalKeyException;

  /**
   * Decrypts the given encrypted data using the specified key, algorithm parameter specification, and secure random number generator.
   *
   * @param key                    The key used for decryption.
   * @param algorithmParameterSpec The algorithm parameter specification for additional parameters.
   * @param secureRandom           The secure random number generator for additional randomness.
   * @param encryptedData          The encrypted data to be decrypted.
   * @return An {@code ICryptValue} representing the result of the decryption operation.
   * @throws PaddingException             If an issue with padding is encountered.
   * @throws AlgorithmNotPresentException If the specified algorithm is not present or misconfigured.
   * @throws IllegalBlockException        If there is an issue with the block size during decryption.
   * @throws IllegalKeyException          If there is an issue with the provided key.
   */
  @NotNull ICryptValue decrypt(@Nullable final Key key,
                               @Nullable final AlgorithmParameterSpec algorithmParameterSpec,
                               @Nullable final SecureRandom secureRandom,
                               final byte @Nullable [] encryptedData)
      throws PaddingException, AlgorithmNotPresentException, IllegalBlockException, IllegalKeyException;

  /**
   * Decrypts the given encrypted data using the specified certificate.
   *
   * @param certificate   The certificate used for decryption.
   * @param encryptedData The encrypted data to be decrypted.
   * @return An {@code ICryptValue} representing the result of the decryption operation.
   * @throws PaddingException             If an issue with padding is encountered.
   * @throws AlgorithmNotPresentException If the specified algorithm is not present or misconfigured.
   * @throws IllegalBlockException        If there is an issue with the block size during decryption.
   * @throws IllegalKeyException          If there is an issue with the provided key.
   */
  @NotNull ICryptValue decrypt(@Nullable final Certificate certificate,
                               final byte @Nullable [] encryptedData)
      throws PaddingException, AlgorithmNotPresentException, IllegalBlockException, IllegalKeyException;

  /**
   * Decrypts the given encrypted data using the specified certificate and a secure random number generator.
   *
   * @param certificate   The certificate used for decryption.
   * @param secureRandom  The secure random number generator for additional randomness.
   * @param encryptedData The encrypted data to be decrypted.
   * @return An {@code ICryptValue} representing the result of the decryption operation.
   * @throws PaddingException             If an issue with padding is encountered.
   * @throws AlgorithmNotPresentException If the specified algorithm is not present or misconfigured.
   * @throws IllegalBlockException        If there is an issue with the block size during decryption.
   * @throws IllegalKeyException          If there is an issue with the provided key.
   */
  @NotNull ICryptValue decrypt(@Nullable final Certificate certificate,
                               @Nullable final SecureRandom secureRandom,
                               final byte @Nullable [] encryptedData)
      throws PaddingException, AlgorithmNotPresentException, IllegalBlockException, IllegalKeyException;
}
