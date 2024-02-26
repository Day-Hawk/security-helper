package dev.dotspace.dayhawk.security.crypt.mode;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

import javax.crypto.Cipher;


/**
 * The {@code CipherMode} enum represents the modes of operation for a cryptographic cipher, such as
 * encryption or decryption.
 *
 * <p>Each enum constant corresponds to a specific cipher mode identifier used in cryptographic operations.</p>
 *
 * <p>This enum is designed to be used in conjunction with cryptographic operations to indicate the desired
 * mode of the cipher.</p>
 *
 * <p>This enum follows the builder pattern, allowing method chaining for enhanced readability.</p>
 *
 * @author Day-Hawk
 */
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Accessors(fluent = true)
public enum CipherMode {

  /**
   * Represents the encryption mode of a cryptographic cipher.
   */
  ENCRYPT(Cipher.ENCRYPT_MODE),

  /**
   * Represents the decryption mode of a cryptographic cipher.
   */
  DECRYPT(Cipher.DECRYPT_MODE);

  /**
   * The cipher mode identifier associated with the enum constant.
   */
  final int cipherModeId;
}
