package dev.dotspace.dayhawk.security.crypt.exception;

import org.jetbrains.annotations.Nullable;


/**
 * The {@code AlgorithmNotPresentException} class is a specific cryptographic exception
 * indicating that a required algorithm is not present or supported.
 *
 * <p>This exception extends {@code AbstractCryptException} and provides constructors for creating instances
 * with different parameters, including messages and causes.</p>
 *
 * <p>Usage example:</p>
 * <pre>
 * {@code
 * try {
 *     // Perform cryptographic operation that requires a specific algorithm
 * } catch (AlgorithmNotPresentException e) {
 *     // Handle exception specific to the absence of the required algorithm
 *     System.err.println("Algorithm Not Present: " + e.getMessage());
 * }
 * }
 * </pre>
 *
 * <p>It is recommended to catch this exception when dealing with situations where a required algorithm is missing.</p>
 *
 * @author Day-Hawk
 */
public final class AlgorithmNotPresentException extends AbstractCryptException {
  /**
   * Constructs an {@code AlgorithmNotPresentException} with no detail message.
   */
  public AlgorithmNotPresentException() {
  }

  /**
   * Constructs an {@code AlgorithmNotPresentException} with the specified detail message.
   *
   * @param message The detail message (which is saved for later retrieval by the {@link #getMessage()} method).
   */
  public AlgorithmNotPresentException(@Nullable String message) {
    super(message);
  }

  /**
   * Constructs an {@code AlgorithmNotPresentException} with the specified detail message and cause.
   *
   * @param message The detail message (which is saved for later retrieval by the {@link #getMessage()} method).
   * @param cause   The cause (which is saved for later retrieval by the {@link #getCause()} method).
   */
  public AlgorithmNotPresentException(@Nullable String message, @Nullable Throwable cause) {
    super(message, cause);
  }

  /**
   * Constructs an {@code AlgorithmNotPresentException} with the specified cause.
   *
   * @param cause The cause (which is saved for later retrieval by the {@link #getCause()} method).
   */
  public AlgorithmNotPresentException(@Nullable Throwable cause) {
    super(cause);
  }

  /**
   * Constructs an {@code AlgorithmNotPresentException} with the specified detail message,
   * cause, suppression enabled or disabled, and writable stack trace enabled or disabled.
   *
   * @param message            The detail message (which is saved for later retrieval by the {@link #getMessage()} method).
   * @param cause              The cause (which is saved for later retrieval by the {@link #getCause()} method).
   * @param enableSuppression  Whether or not suppression is enabled or disabled.
   * @param writableStackTrace Whether or not the stack trace should be writable.
   */
  public AlgorithmNotPresentException(@Nullable String message,
                                      @Nullable Throwable cause,
                                      boolean enableSuppression,
                                      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}

