package dev.dotspace.dayhawk.security.hash;

import lombok.Getter;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;


/**
 * The {@code HashManager} class is a concrete implementation of the {@link AbstractHashManager}
 * class for hash managers in the security framework.
 *
 * <p>This class serves as a singleton instance of the {@code IHashManager} interface and extends
 * the {@code AbstractHashManager} to provide specific implementation details for creating hash processors.</p>
 *
 * <p>Usage Example:</p>
 * <pre>
 * {@code
 * // Access the singleton instance of the hash manager
 * IHashManager hashManager = HashManager.instance();
 *
 * // Obtain a hash processor for a specific algorithm
 * IHashProcessor hashProcessor = hashManager.processor("SHA-256");
 * }
 * </pre>
 *
 * <p>The {@code HashManager} class follows the singleton pattern and provides a static instance of the
 * {@code IHashManager} interface for obtaining hash processors.</p>
 *
 * @see AbstractHashManager
 * @see IHashManager
 */
public final class HashManager extends AbstractHashManager {

  /**
   * The singleton instance of the {@code IHashManager}.
   */
  @Getter
  @Accessors(fluent=true)
  private final static @NotNull IHashManager instance = new HashManager();
}