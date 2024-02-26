package dev.dotspace.dayhawk.security.crypt.processor;

import dev.dotspace.dayhawk.security.crypt.entity.ICryptValue;
import dev.dotspace.dayhawk.security.crypt.entity.ImmutableCryptValue;
import dev.dotspace.dayhawk.security.crypt.exception.AlgorithmNotPresentException;
import dev.dotspace.dayhawk.security.crypt.exception.IllegalBlockException;
import dev.dotspace.dayhawk.security.crypt.exception.IllegalKeyException;
import dev.dotspace.dayhawk.security.crypt.exception.PaddingException;
import dev.dotspace.dayhawk.security.crypt.mode.CipherMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Objects;


/**
 * The {@code AbstractCryptProcessor} class is an abstract implementation of the {@link ICryptProcessor} interface,
 * providing a foundation for cryptographic processing with various encryption and decryption methods.
 *
 * <p>It uses a specified algorithm for cryptographic operations, and implementations are expected to handle
 * different scenarios such as key-based or certificate-based encryption and decryption.</p>
 *
 * <p>This class provides a template for cryptographic operations, including null checks, initialization,
 * and exception handling. It utilizes the {@link Cipher} class for actual encryption and decryption.</p>
 *
 * <p>Usage Example:</p>
 * <pre>
 * {@code
 * AbstractCryptProcessor cryptProcessor = // Create an instance of a class extending AbstractCryptProcessor
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
 * <p>Exceptions thrown during cryptographic operations include:
 * {@link PaddingException}, {@link AlgorithmNotPresentException},
 * {@link IllegalBlockException}, and {@link IllegalKeyException}.</p>
 *
 * <p>Implementing classes are expected to handle specific cryptographic scenarios
 * by providing the necessary parameters for encryption and decryption methods.</p>
 *
 * @author Day-Hawk
 * @see ICryptProcessor
 */
public abstract class AbstractCryptProcessor implements ICryptProcessor {
  private final @NotNull String algorithm;

  /**
   * Constructs an {@code AbstractCryptProcessor} with the specified algorithm.
   *
   * @param algorithm The algorithm to be used for cryptographic operations.
   * @throws NullPointerException If the provided algorithm is {@code null}.
   */
  protected AbstractCryptProcessor(@Nullable String algorithm) {
    //Null check
    Objects.requireNonNull(algorithm);

    this.algorithm = algorithm;
  }

  /**
   * See {@link ICryptProcessor#encrypt(Key, byte[])}
   */
  @Override
  public @NotNull ICryptValue encrypt(@Nullable Key key,
                                      byte @Nullable [] data)
      throws PaddingException, AlgorithmNotPresentException, IllegalBlockException, IllegalKeyException {
    //Null check
    Objects.requireNonNull(key);

    return this.process(CipherMode.ENCRYPT, data, (mode, cipher) -> cipher.init(mode, key));
  }

  /**
   * See {@link ICryptProcessor#encrypt(Key, SecureRandom, byte[])}
   */
  @Override
  public @NotNull ICryptValue encrypt(@Nullable Key key,
                                      @Nullable SecureRandom secureRandom,
                                      byte @Nullable [] data)
      throws PaddingException, AlgorithmNotPresentException, IllegalBlockException, IllegalKeyException {
    //Null check
    Objects.requireNonNull(key);
    Objects.requireNonNull(secureRandom);

    return this.process(CipherMode.ENCRYPT, data, (mode, cipher) -> cipher.init(mode, key, secureRandom));
  }

  /**
   * See {@link ICryptProcessor#encrypt(Key, AlgorithmParameterSpec, byte[])}
   */
  @Override
  public @NotNull ICryptValue encrypt(@Nullable Key key,
                                      @Nullable AlgorithmParameterSpec algorithmParameterSpec,
                                      byte @Nullable [] data)
      throws PaddingException, AlgorithmNotPresentException, IllegalBlockException, IllegalKeyException {
    //Null check
    Objects.requireNonNull(key);
    Objects.requireNonNull(algorithmParameterSpec);

    return this.process(CipherMode.ENCRYPT, data, (mode, cipher) -> cipher.init(mode, key, algorithmParameterSpec));
  }

  /**
   * See {@link ICryptProcessor#encrypt(Key, AlgorithmParameterSpec, SecureRandom, byte[])}
   */
  @Override
  public @NotNull ICryptValue encrypt(@Nullable Key key,
                                      @Nullable AlgorithmParameterSpec algorithmParameterSpec,
                                      @Nullable SecureRandom secureRandom,
                                      byte @Nullable [] data)
      throws PaddingException, AlgorithmNotPresentException, IllegalBlockException, IllegalKeyException {
    //Null check
    Objects.requireNonNull(key);
    Objects.requireNonNull(algorithmParameterSpec);
    Objects.requireNonNull(secureRandom);

    return this.process(CipherMode.ENCRYPT, data,
        (mode, cipher) -> cipher.init(mode, key, algorithmParameterSpec, secureRandom));
  }

  /**
   * See {@link ICryptProcessor#encrypt(Certificate, byte[])}
   */
  @Override
  public @NotNull ICryptValue encrypt(@Nullable Certificate certificate,
                                      byte @Nullable [] data)
      throws PaddingException, AlgorithmNotPresentException, IllegalBlockException, IllegalKeyException {
    //Null check
    Objects.requireNonNull(certificate);

    return this.process(CipherMode.ENCRYPT, data, (mode, cipher) -> cipher.init(mode, certificate));
  }

  /**
   * See {@link ICryptProcessor#encrypt(Certificate, SecureRandom, byte[])}
   */
  @Override
  public @NotNull ICryptValue encrypt(@Nullable Certificate certificate,
                                      @Nullable SecureRandom secureRandom,
                                      byte @Nullable [] data)
      throws PaddingException, AlgorithmNotPresentException, IllegalBlockException, IllegalKeyException {
    //Null check
    Objects.requireNonNull(certificate);
    Objects.requireNonNull(secureRandom);

    return this.process(CipherMode.ENCRYPT, data, (mode, cipher) ->
        cipher.init(mode, certificate, secureRandom));
  }

  /**
   * See {@link ICryptProcessor#decrypt(Key, byte[])}
   */
  @Override
  public @NotNull ICryptValue decrypt(@Nullable Key key,
                                      byte @Nullable [] encryptedData)
      throws PaddingException, AlgorithmNotPresentException, IllegalBlockException, IllegalKeyException {
    //Null check
    Objects.requireNonNull(key);

    return this.process(CipherMode.DECRYPT, encryptedData,
        (mode, cipher) -> cipher.init(mode, key));
  }

  /**
   * See {@link ICryptProcessor#decrypt(Key, SecureRandom, byte[])}
   */
  @Override
  public @NotNull ICryptValue decrypt(@Nullable Key key,
                                      @Nullable SecureRandom secureRandom,
                                      byte @Nullable [] encryptedData)
      throws PaddingException, AlgorithmNotPresentException, IllegalBlockException, IllegalKeyException {
    //Null check
    Objects.requireNonNull(key);
    Objects.requireNonNull(secureRandom);

    return this.process(CipherMode.DECRYPT, encryptedData, (mode, cipher) -> cipher.init(mode, key, secureRandom));
  }

  /**
   * See {@link ICryptProcessor#decrypt(Key, AlgorithmParameterSpec, byte[])}
   */
  @Override
  public @NotNull ICryptValue decrypt(@Nullable Key key,
                                      @Nullable AlgorithmParameterSpec algorithmParameterSpec,
                                      byte @Nullable [] encryptedData)
      throws PaddingException, AlgorithmNotPresentException, IllegalBlockException, IllegalKeyException {
    //Null check
    Objects.requireNonNull(key);
    Objects.requireNonNull(algorithmParameterSpec);

    return this.process(CipherMode.DECRYPT, encryptedData, (mode, cipher) ->
        cipher.init(mode, key, algorithmParameterSpec));
  }

  /**
   * See {@link ICryptProcessor#decrypt(Key, AlgorithmParameterSpec, SecureRandom, byte[])}
   */
  @Override
  public @NotNull ICryptValue decrypt(@Nullable Key key,
                                      @Nullable AlgorithmParameterSpec algorithmParameterSpec,
                                      @Nullable SecureRandom secureRandom,
                                      byte @Nullable [] encryptedData)
      throws PaddingException, AlgorithmNotPresentException, IllegalBlockException, IllegalKeyException {
    //Null check
    Objects.requireNonNull(key);
    Objects.requireNonNull(algorithmParameterSpec);
    Objects.requireNonNull(secureRandom);

    return this.process(CipherMode.DECRYPT, encryptedData, (mode, cipher) ->
        cipher.init(mode, key, algorithmParameterSpec, secureRandom));
  }

  /**
   * See {@link ICryptProcessor#decrypt(Certificate, byte[])}
   */
  @Override
  public @NotNull ICryptValue decrypt(@Nullable Certificate certificate,
                                      byte @Nullable [] encryptedData)
      throws PaddingException, AlgorithmNotPresentException, IllegalBlockException, IllegalKeyException {
    //Null check
    Objects.requireNonNull(certificate);

    return this.process(CipherMode.DECRYPT, encryptedData, (mode, cipher) ->
        cipher.init(mode, certificate));
  }

  /**
   * See {@link ICryptProcessor#decrypt(Certificate, SecureRandom, byte[])}
   */
  @Override
  public @NotNull ICryptValue decrypt(@Nullable Certificate certificate,
                                      @Nullable SecureRandom secureRandom,
                                      byte @Nullable [] encryptedData)
      throws PaddingException, AlgorithmNotPresentException, IllegalBlockException, IllegalKeyException {
    //Null check
    Objects.requireNonNull(certificate);
    Objects.requireNonNull(secureRandom);

    return this.process(CipherMode.DECRYPT, encryptedData, (mode, cipher) ->
        cipher.init(mode, certificate, secureRandom));
  }

  /**
   * Processes the cryptographic operation using the specified cipher mode, data, and initialization consumer.
   *
   * @param cipherMode   The cipher mode indicating encryption or decryption.
   * @param data         The data to be processed.
   * @param initConsumer The initialization consumer for configuring the cipher.
   * @return An {@code ICryptValue} representing the result of the cryptographic operation.
   * @throws AlgorithmNotPresentException If the specified algorithm is not present or misconfigured.
   * @throws PaddingException             If an issue with padding is encountered.
   * @throws IllegalBlockException        If there is an issue with the block size.
   * @throws IllegalKeyException          If there is an issue with the provided key or certificate.
   */
  public @NotNull ICryptValue process(@NotNull final CipherMode cipherMode,
                                      byte @Nullable [] data,
                                      @NotNull final AbstractCryptProcessor.CipherFunction initConsumer)
      throws AlgorithmNotPresentException, PaddingException, IllegalBlockException, IllegalKeyException {
    //Null check
    Objects.requireNonNull(data);

    try {
      final Cipher cipher = Cipher.getInstance(this.algorithm);
      initConsumer.accept(cipherMode.cipherModeId(), cipher);
      return this.cryptValue(cipher, data, cipherMode);

      //Algorithm error
    } catch (final NoSuchAlgorithmException | InvalidAlgorithmParameterException exception) {
      throw new AlgorithmNotPresentException("Algorithm=%s is not present or wrong configuration.".formatted(this.algorithm), exception);

      //Error with padding, not present or padding can't be used.
    } catch (final NoSuchPaddingException | BadPaddingException exception) {
      throw new PaddingException(exception);

      //Error with block size.
    } catch (final IllegalBlockSizeException exception) {
      throw new IllegalBlockException(exception);

      //Something is wrong with given key.
    } catch (InvalidKeyException exception) {
      throw new IllegalKeyException(exception);
    }
  }


  /**
   * Creates an {@code ICryptValue} from the result of the cryptographic operation.
   *
   * @param cipher     The initialized cipher for encryption or decryption.
   * @param data       The data to be processed.
   * @param cipherMode The cipher mode indicating encryption or decryption.
   * @return An {@code ICryptValue} representing the result of the cryptographic operation.
   * @throws BadPaddingException       If an issue with padding is encountered during cryptographic processing.
   * @throws IllegalBlockSizeException If there is an issue with the block size during cryptographic processing.
   */
  private @NotNull ICryptValue cryptValue(@NotNull Cipher cipher,
                                          byte @NotNull [] data,
                                          @NotNull CipherMode cipherMode) throws BadPaddingException, IllegalBlockSizeException {
    return new ImmutableCryptValue(cipher.doFinal(data), cipherMode, this.algorithm);
  }

  /**
   * Functional interface for initializing the cipher during cryptographic processing.
   */
  interface CipherFunction {
    /**
     * Initializes the cipher with the specified mode and cipher instance.
     *
     * @param mode   The cipher mode indicating encryption or decryption.
     * @param cipher The initialized cipher instance.
     * @throws InvalidKeyException                If the provided key or certificate is invalid.
     * @throws InvalidAlgorithmParameterException If there is an issue with the algorithm parameters.
     */
    void accept(final int mode,
                @NotNull final Cipher cipher)
        throws InvalidKeyException, InvalidAlgorithmParameterException;
  }
}
