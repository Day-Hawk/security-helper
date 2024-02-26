package dev.dotspace.dayhawk.security.hash;

import dev.dotspace.dayhawk.security.crypt.processor.CryptProcessor;
import dev.dotspace.dayhawk.security.crypt.processor.ICryptProcessor;
import dev.dotspace.dayhawk.security.entity.AbstractSecurityManager;
import dev.dotspace.dayhawk.security.exception.AbstractSecurityException;
import dev.dotspace.dayhawk.security.hash.exception.DigestNotPresentException;
import dev.dotspace.dayhawk.security.hash.processor.HashProcessor;
import dev.dotspace.dayhawk.security.hash.processor.IHashProcessor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.security.Security;
import java.util.ArrayList;


/**
 * The {@code AbstractHashManager} class is an abstract implementation of the {@link AbstractSecurityManager}
 * class for hash managers in the security framework.
 *
 * <p>This class extends {@code AbstractSecurityManager} and implements the {@link IHashManager} interface. It
 * provides support for hashing operations and includes a default constructor that initializes the list of
 * supported cryptographic algorithms based on the available message digest algorithms.</p>
 *
 * <p>Usage Example:</p>
 * <pre>
 * {@code
 * // Create a hash manager instance
 * AbstractHashManager hashManager = new ConcreteHashManager();
 *
 * // Obtain a hash processor for a specific algorithm
 * IHashProcessor hashProcessor = hashManager.processor("SHA-256");
 * }
 * </pre>
 *
 * <p>The {@code AbstractHashManager} class is designed to be extended by concrete hash manager implementations,
 * which must provide the actual implementation for the hash processor creation.</p>
 *
 * @see AbstractSecurityManager
 * @see IHashManager
 * @see IHashProcessor
 */
public abstract class AbstractHashManager extends AbstractSecurityManager<IHashProcessor> implements IHashManager {

  /**
   * Constructs an {@code AbstractHashManager} with the specified list of supported cryptographic algorithms.
   */
  protected AbstractHashManager() {
    super(new ArrayList<>(Security.getAlgorithms("MessageDigest")));
  }

  /**
   * Creates and returns a hash processor for the specified algorithm.
   *
   * @param algorithm The cryptographic algorithm for which a hash processor is to be created.
   * @return An {@code IHashProcessor} instance for the specified algorithm.
   */
  @Override
  public @NotNull IHashProcessor processor(@Nullable String algorithm) {
    return new HashProcessor(algorithm);
  }
}

