package dev.dotspace.dayhawk.security.hash.processor;

import dev.dotspace.dayhawk.security.hash.exception.DigestNotPresentException;
import org.jetbrains.annotations.Nullable;


/**
 * See {@link IHashProcessor}
 */
public final class HashProcessor extends AbstractHashProcessor {
  /**
   * Constructs a new {@code HashProcessor} for the specified hash algorithm.
   *
   * <p>The hash processor is designed to generate hash values using the provided algorithm.</p>
   *
   * @param algorithm The name of the hash algorithm. Must not be {@code null}.
   * @throws NullPointerException If the provided algorithm is {@code null}.
   */
  public HashProcessor(@Nullable String algorithm) {
    super(algorithm);
  }
}
