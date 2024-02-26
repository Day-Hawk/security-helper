package dev.dotspace.dayhawk.security.hash;

import dev.dotspace.dayhawk.security.entity.ISecurityManager;
import dev.dotspace.dayhawk.security.hash.processor.IHashProcessor;


/**
 * The {@code IHashManager} interface extends the {@link ISecurityManager} interface
 * with specialized functionalities related to hash management. It specifically deals
 * with the management of {@link IHashProcessor} instances for secure hashing operations.
 *
 * <p>Implementing classes are expected to provide methods for creating, retrieving, and managing
 * hash processors, enabling secure hashing of data.</p>
 *
 * <p>This interface serves as a specialized extension of the more general {@code ISecurityManager},
 * focusing on hash-related aspects and providing access to hash processors.</p>
 *
 * <p>Usage Example:</p>
 * <pre>
 * {@code
 * IHashManager hashManager = // Create an instance of a class implementing IHashManager
 *
 * // Perform hash management operations
 * // ...
 * }
 * </pre>
 *
 * <p>The type parameter {@code <T>} represents the specific type of {@code IHashProcessor}
 * that this manager deals with.</p>
 *
 * @author Day-Hawk
 * @see ISecurityManager
 * @see IHashProcessor
 */
public interface IHashManager extends ISecurityManager<IHashProcessor> {
}
