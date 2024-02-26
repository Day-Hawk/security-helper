package dev.dotspace.dayhawk.security.hash.processor;

import dev.dotspace.dayhawk.security.entity.ISecurityProcessor;
import dev.dotspace.dayhawk.security.hash.entity.IHashValue;
import dev.dotspace.dayhawk.security.hash.exception.DigestNotPresentException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


/**
 * The {@code IHashProcessor} interface defines a contract for hash processors in the security framework.
 *
 * <p>Implementations of this interface are responsible for generating hash values based on a given secret.</p>
 *
 * <p>Usage Example:</p>
 * <pre>
 * {@code
 * // Obtain a hash processor instance
 * IHashProcessor hashProcessor = // ...
 *
 * try {
 *     // Generate a hash value for a secret
 *     IHashValue hashValue = hashProcessor.hash(secretBytes);
 * } catch (DigestNotPresentException e) {
 *     // Handle exception indicating that the digest is not present
 * }
 * }
 * </pre>
 *
 * <p>The {@code IHashProcessor} interface extends {@link ISecurityProcessor} and defines a single method for
 * hashing a byte array representing a secret. It throws a {@link DigestNotPresentException} if the resulting
 * hash value is not present.</p>
 *
 * @see ISecurityProcessor
 * @see IHashValue
 * @see DigestNotPresentException
 */
public interface IHashProcessor extends ISecurityProcessor {
  /**
   * Generates a hash value for the given secret.
   *
   * @param secret The byte array representing the secret to be hashed.
   * @return An {@code IHashValue} representing the generated hash.
   * @throws DigestNotPresentException If the resulting hash value is not present.
   */
  @NotNull
  IHashValue hash(final byte @Nullable [] secret) throws DigestNotPresentException;
}

