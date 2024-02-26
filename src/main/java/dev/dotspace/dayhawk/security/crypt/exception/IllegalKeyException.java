package dev.dotspace.dayhawk.security.crypt.exception;

import org.jetbrains.annotations.Nullable;


/**
 * The {@code IllegalKeyException} class is a specific cryptographic exception
 * indicating that an illegal or invalid key has been encountered during a cryptographic operation.
 *
 * <p>This exception extends {@code AbstractCryptException} and provides constructors for creating instances
 * with different parameters, including messages and causes.</p>
 *
 * <p>Usage example:</p>
 * <pre>
 * {@code
 * try {
 *     // Perform cryptographic operation that encounters an illegal or invalid key
 * } catch (IllegalKeyException e) {
 *     // Handle exception specific to encountering an illegal or invalid key
 *     System.err.println("Illegal or Invalid Key: " + e.getMessage());
 * }
 * }
 * </pre>
 *
 * <p>It is recommended to catch this exception when dealing with situations where an illegal or invalid key is detected.</p>
 *
 * @author Day-Hawk
 */
public final class IllegalKeyException extends AbstractCryptException {
  /**
   * Constructs an {@code IllegalKeyException} with no detail message.
   */
  public IllegalKeyException() {
  }

  /**
   * Constructs an {@code IllegalKeyException} with the specified detail message.
   *
   * @param message The detail message (which is saved for later retrieval by the {@link #getMessage()} method).
   */
  public IllegalKeyException(@Nullable String message) {
    super(message);
  }

  /**
   * Constructs an {@code IllegalKeyException} with the specified detail message and cause.
   *
   * @param message The detail message (which is saved for later retrieval by the {@link #getMessage()} method).
   * @param cause   The cause (which is saved for later retrieval by the {@link #getCause()} method).
   */
  public IllegalKeyException(@Nullable String message, @Nullable Throwable cause) {
    super(message, cause);
  }

  /**
   * Constructs an {@code IllegalKeyException} with the specified cause.
   *
   * @param cause The cause (which is saved for later retrieval by the {@link #getCause()} method).
   */
  public IllegalKeyException(@Nullable Throwable cause) {
    super(cause);
  }

  /**
   * Constructs an {@code IllegalKeyException} with the specified detail message,
   * cause, suppression enabled or disabled, and writable stack trace enabled or disabled.
   *
   * @param message            The detail message (which is saved for later retrieval by the {@link #getMessage()} method).
   * @param cause              The cause (which is saved for later retrieval by the {@link #getCause()} method).
   * @param enableSuppression  Whether or not suppression is enabled or disabled.
   * @param writableStackTrace Whether or not the stack trace should be writable.
   */
  public IllegalKeyException(@Nullable String message,
                             @Nullable Throwable cause,
                             boolean enableSuppression,
                             boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}

