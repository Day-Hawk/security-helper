package dev.dotspace.dayhawk.security.entity;

import org.jetbrains.annotations.NotNull;

/**
 * This interface defines a method to retrieve information about a specific algorithm.
 *
 * @author Day-Hawk
 */
public interface AlgorithmObject {
  /**
   * Returns the name of the algorithm.
   *
   * @return The algorithm name.
   */
  @NotNull String algorithm();
}
