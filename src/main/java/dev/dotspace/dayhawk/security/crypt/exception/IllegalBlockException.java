package dev.dotspace.dayhawk.security.crypt.exception;

import org.jetbrains.annotations.Nullable;


/**
 * The {@code IllegalBlockException} class is a specific cryptographic exception
 * indicating that an illegal block or input has been encountered during a cryptographic operation.
 *
 * <p>This exception extends {@code AbstractCryptException} and provides constructors for creating instances
 * with different parameters, including messages and causes.</p>
 *
 * <p>Usage example:</p>
 * <pre>
 * {@code
 * try {
 *     // Perform cryptographic operation that encounters an illegal block or input
 * } catch (IllegalBlockException e) {
 *     // Handle exception specific to encountering an illegal block or input
 *     System.err.println("Illegal Block or Input: " + e.getMessage());
 * }
 * }
 * </pre>
 *
 * <p>It is recommended to catch this exception when dealing with situations where an illegal block or input is detected.</p>
 *
 * @author Day-Hawk
 */
public final class IllegalBlockException extends AbstractCryptException {
  /**
   * Constructs an {@code IllegalBlockException} with no detail message.
   */
  public IllegalBlockException() {
  }

  /**
   * Constructs an {@code IllegalBlockException} with the specified detail message.
   *
   * @param message The detail message (which is saved for later retrieval by the {@link #getMessage()} method).
   */
  public IllegalBlockException(@Nullable String message) {
    super(message);
  }

  /**
   * Constructs an {@code IllegalBlockException} with the specified detail message and cause.
   *
   * @param message The detail message (which is saved for later retrieval by the {@link #getMessage()} method).
   * @param cause   The cause (which is saved for later retrieval by the {@link #getCause()} method).
   */
  public IllegalBlockException(@Nullable String message, @Nullable Throwable cause) {
    super(message, cause);
  }

  /**
   * Constructs an {@code IllegalBlockException} with the specified cause.
   *
   * @param cause The cause (which is saved for later retrieval by the {@link #getCause()} method).
   */
  public IllegalBlockException(@Nullable Throwable cause) {
    super(cause);
  }

  /**
   * Constructs an {@code IllegalBlockException} with the specified detail message,
   * cause, suppression enabled or disabled, and writable stack trace enabled or disabled.
   *
   * @param message            The detail message (which is saved for later retrieval by the {@link #getMessage()} method).
   * @param cause              The cause (which is saved for later retrieval by the {@link #getCause()} method).
   * @param enableSuppression  Whether or not suppression is enabled or disabled.
   * @param writableStackTrace Whether or not the stack trace should be writable.
   */
  public IllegalBlockException(@Nullable String message,
                               @Nullable Throwable cause,
                               boolean enableSuppression,
                               boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}

