package dev.dotspace.dayhawk.security.crypt;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;

/**
 * The {@code CryptManager} class is a singleton implementation of the {@code ICryptManager} interface,
 * extending {@code AbstractCryptManager}.
 *
 * <p>This class provides a single instance of the {@code ICryptManager} interface and ensures
 * that only one instance is created.</p>
 *
 * <p>It extends {@code AbstractCryptManager} to inherit functionality related to cryptographic processing.</p>
 *
 * <p>The singleton instance can be accessed using the {@code getInstance()} method.</p>
 *
 * <p>Usage example:</p>
 * <pre>
 * {@code
 * ICryptManager cryptManager = CryptManager.getInstance();
 * ICryptProcessor processor = cryptManager.processor("AES");
 * // Use the processor for cryptographic operations.
 * }
 * </pre>
 *
 * @author Day-Hawk
 */
@NoArgsConstructor(access=AccessLevel.PRIVATE)
public final class CryptManager extends AbstractCryptManager {
  /**
   * The singleton instance of the {@code ICryptManager}.
   */
  @Getter
  @Accessors(fluent=true)
  private final static @NotNull ICryptManager instance = new CryptManager();
}
