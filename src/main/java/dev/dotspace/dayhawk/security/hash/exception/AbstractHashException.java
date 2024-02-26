package dev.dotspace.dayhawk.security.hash.exception;

import dev.dotspace.dayhawk.security.exception.AbstractSecurityException;
import org.jetbrains.annotations.Nullable;


/**
 * The {@code AbstractHashException} class is an abstract implementation of the {@link AbstractSecurityException}
 * class, providing a base class for exceptions related to hashing operations.
 *
 * <p>This class extends {@code AbstractSecurityException} and includes constructors for creating instances
 * with various levels of detail, such as a message, cause, and suppression flags.</p>
 *
 * <p>Usage Example:</p>
 * <pre>
 * {@code
 * // Create a custom hash exception
 * AbstractHashException hashException = // ...
 *
 * // Access exception details
 * String message = hashException.getMessage();
 * Throwable cause = hashException.getCause();
 * }
 * </pre>
 *
 * <p>The {@code AbstractHashException} class is intended to be extended by specific hash-related exceptions,
 * providing a common base class for exception handling in hashing operations.</p>
 *
 * @see AbstractSecurityException
 */
public abstract class AbstractHashException extends AbstractSecurityException {

  /**
   * Constructs an {@code AbstractHashException} with no detail message.
   */
  public AbstractHashException() {
  }

  /**
   * Constructs an {@code AbstractHashException} with the specified detail message.
   *
   * @param message The detail message (which is saved for later retrieval by the {@link #getMessage()} method).
   */
  public AbstractHashException(@Nullable String message) {
    super(message);
  }

  /**
   * Constructs an {@code AbstractHashException} with the specified detail message and cause.
   *
   * @param message The detail message (which is saved for later retrieval by the {@link #getMessage()} method).
   * @param cause   The cause (which is saved for later retrieval by the {@link #getCause()} method).
   */
  public AbstractHashException(@Nullable String message, @Nullable Throwable cause) {
    super(message, cause);
  }

  /**
   * Constructs an {@code AbstractHashException} with the specified cause and a detail message of
   * (cause==null ? null : cause.toString()) (which typically contains the class and detail message
   * of cause).
   *
   * @param cause The cause (which is saved for later retrieval by the {@link #getCause()} method).
   */
  public AbstractHashException(@Nullable Throwable cause) {
    super(cause);
  }

  /**
   * Constructs an {@code AbstractHashException} with the specified detail message, cause,
   * suppression enabled or disabled, and writable stack trace enabled or disabled.
   *
   * @param message            The detail message (which is saved for later retrieval by the {@link #getMessage()} method).
   * @param cause              The cause (which is saved for later retrieval by the {@link #getCause()} method).
   * @param enableSuppression  Whether or not suppression is enabled or disabled.
   * @param writableStackTrace Whether or not the stack trace should be writable.
   */
  public AbstractHashException(@Nullable String message,
                               @Nullable Throwable cause,
                               boolean enableSuppression,
                               boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}

