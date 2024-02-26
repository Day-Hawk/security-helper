package dev.dotspace.dayhawk.security.entity;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;


/**
 * The {@code AbstractSecurityManager} class is an abstract implementation of the {@link ISecurityManager}
 * interface, providing common functionality for security managers dealing with specific processors.
 *
 * <p>Implementing classes are expected to extend this abstract class and provide processor-specific
 * functionalities for secure operations.</p>
 *
 * <p>This class includes a list of supported cryptographic algorithms, and it implements the
 * {@code ISecurityManager} interface to provide a standard way of accessing the supported algorithms.</p>
 *
 * <p>Usage Example:</p>
 * <pre>
 * {@code
 * // Create a concrete implementation of AbstractSecurityManager for a specific processor
 * AbstractSecurityManager<MyProcessor> securityManager = new ConcreteSecurityManager();
 *
 * // Access the list of supported algorithms
 * List<String> supportedAlgorithms = securityManager.algorithmList();
 * }
 * </pre>
 *
 * <p>The list of supported cryptographic algorithms is initialized during construction and can be accessed
 * using the {@code algorithmList} method.</p>
 *
 * @param <PROCESSOR> The type of the security processor managed by this manager.
 * @see ISecurityManager
 */
public abstract class AbstractSecurityManager<PROCESSOR extends ISecurityProcessor>
    implements ISecurityManager<PROCESSOR> {
  /**
   * The list of supported cryptographic algorithms.
   */
  private final @NotNull List<String> algorithmList;

  /**
   * Constructs an {@code AbstractSecurityManager} with the specified list of supported cryptographic algorithms.
   *
   * @param algorithmList The list of supported cryptographic algorithms.
   */
  protected AbstractSecurityManager(@NotNull final List<String> algorithmList) {
    this.algorithmList = algorithmList;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public @NotNull List<String> algorithmList() {
    return new ArrayList<>(this.algorithmList);
  }
}
