package dev.dotspace.dayhawk.security.entity;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * This interface defines a method to retrieve a list of algorithms.
 *
 * @author Day-Hawk
 */
public interface ISecurityManager<PROCESSOR extends ISecurityProcessor> {
  /**
   * Returns a list of algorithms.
   *
   * @return A list of algorithm names.
   */
  @NotNull List<String> algorithmList();

  /**
   * Retrieves a cryptographic processor for the specified algorithm.
   *
   * @param algorithm The name of the cryptographic algorithm.
   * @return An {@link PROCESSOR} for the specified algorithm.
   */
  @NotNull PROCESSOR processor(@Nullable final String algorithm);
}
