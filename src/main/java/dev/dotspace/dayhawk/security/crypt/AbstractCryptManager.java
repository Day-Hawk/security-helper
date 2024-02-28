package dev.dotspace.dayhawk.security.crypt;

import dev.dotspace.dayhawk.security.crypt.processor.CryptProcessor;
import dev.dotspace.dayhawk.security.crypt.processor.ICryptProcessor;
import dev.dotspace.dayhawk.security.entity.AbstractSecurityManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


/**
 * The {@code AbstractCryptManager} class is an abstract implementation of the {@code ICryptManager} interface.
 * It provides a default implementation of the interface methods and initializes the list of supported algorithms
 * based on the available security providers.
 *
 * <p>Subclasses must implement the actual cryptographic processing logic in the {@link CryptProcessor} class.</p>
 *
 * <p>The algorithm list is populated during the instantiation of the class by querying the security providers
 * for available Cipher services.</p>
 *
 * <p>Usage example:</p>
 * <pre>
 * {@code
 * ICryptManager cryptManager = new CryptManager();
 * List<String> algorithms = cryptManager.algorithmList();
 * ICryptProcessor processor = cryptManager.processor("AES");
 * // Use the algorithm list and processor for cryptographic operations.
 * }
 * </pre>
 *
 * @author Day-Hawk
 */
public abstract class AbstractCryptManager
    extends AbstractSecurityManager<ICryptProcessor>
    implements ICryptManager {
  /**
   * Constructs an {@code AbstractCryptManager} and initializes the list of supported algorithms
   * based on available security providers.
   */
  protected AbstractCryptManager() {
    super("Cipher");
  }

  /**
   * Creates and returns a cryptographic processor for the specified algorithm.
   *
   * @param algorithm The name of the cryptographic algorithm.
   * @return An {@link ICryptProcessor} for the specified algorithm.
   */
  @Override
  public @NotNull ICryptProcessor processor(@Nullable String algorithm) {
    return new CryptProcessor(algorithm);
  }
}
