package dev.dotspace.dayhawk.security.crypt;

import dev.dotspace.dayhawk.security.crypt.processor.ICryptProcessor;
import dev.dotspace.dayhawk.security.entity.ISecurityManager;


/**
 * The {@code ICryptManager} interface, authored by Day-Hawk, extends the {@link ISecurityManager}
 * interface with specialized functionalities related to cryptographic management. It specifically deals
 * with the management of {@link ICryptProcessor} instances.
 *
 * <p>Implementing classes are expected to provide methods for creating, retrieving, and managing
 * cryptographic processors, enabling secure encryption and decryption operations.</p>
 *
 * <p>This interface serves as a specialized extension of the more general {@code ISecurityManager},
 * concentrating on cryptographic aspects and providing access to cryptographic processors.</p>
 *
 * <p>Usage Example:</p>
 * <pre>
 * {@code
 * ICryptManager cryptManager = // Create an instance of a class implementing ICryptManager
 *
 * // Perform cryptographic management operations
 * // ...
 * }
 * </pre>
 *
 * <p>The type parameter {@code <T>} represents the specific type of {@code ICryptProcessor}
 * that this manager deals with.</p>
 *
 * @author Day-Hawk
 * @see ISecurityManager
 * @see ICryptProcessor
 */
public interface ICryptManager extends ISecurityManager<ICryptProcessor> {
}
