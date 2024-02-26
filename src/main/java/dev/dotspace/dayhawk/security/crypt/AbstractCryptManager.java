package dev.dotspace.dayhawk.security.crypt;

import dev.dotspace.dayhawk.security.crypt.processor.CryptProcessor;
import dev.dotspace.dayhawk.security.crypt.processor.ICryptProcessor;
import dev.dotspace.dayhawk.security.entity.AbstractSecurityManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.security.Provider.Service;
import java.security.Security;
import java.util.Arrays;


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
    super(Arrays.stream(Security.getProviders())
        .flatMap(provider ->
            provider.getServices()
                .stream()
                .filter(AbstractCryptManager::isCipher)
                .map(Service::getAlgorithm))
        .toList());
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

  //static

  /**
   * Checks if the provided service represents a Cipher algorithm.
   *
   * @param service The service to check.
   * @return {@code true} if the service represents a Cipher algorithm, {@code false} otherwise.
   */
  private static boolean isCipher(@NotNull final Service service) {
    return "Cipher".equals(service.getType());
  }
}
