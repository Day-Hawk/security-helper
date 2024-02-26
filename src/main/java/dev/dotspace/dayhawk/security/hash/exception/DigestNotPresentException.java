package dev.dotspace.dayhawk.security.hash.exception;

import org.jetbrains.annotations.Nullable;

/**
 * The {@code DigestNotPresentException} class is a specific implementation of the {@link AbstractHashException}
 * class, representing an exception indicating that a digest is not present in a hashing operation.
 *
 * <p>This class extends {@code AbstractHashException} and includes constructors for creating instances
 * with various levels of detail, such as a message, cause, and suppression flags.</p>
 *
 * <p>Usage Example:</p>
 * <pre>
 * {@code
 * // Create a digest not present exception
 * DigestNotPresentException digestException = // ...
 *
 * // Access exception details
 * String message = digestException.getMessage();
 * Throwable cause = digestException.getCause();
 * }
 * </pre>
 *
 * <p>The {@code DigestNotPresentException} class is intended to be thrown when a digest is expected
 * but not found in a hashing operation.</p>
 *
 * @see AbstractHashException
 */
public final class DigestNotPresentException extends AbstractHashException {

  /**
   * Constructs a {@code DigestNotPresentException} with no detail message.
   */
  public DigestNotPresentException() {
  }

  /**
   * Constructs a {@code DigestNotPresentException} with the specified detail message.
   *
   * @param message The detail message (which is saved for later retrieval by the {@link #getMessage()} method).
   */
  public DigestNotPresentException(@Nullable String message) {
    super(message);
  }

  /**
   * Constructs a {@code DigestNotPresentException} with the specified detail message and cause.
   *
   * @param message The detail message (which is saved for later retrieval by the {@link #getMessage()} method).
   * @param cause   The cause (which is saved for later retrieval by the {@link #getCause()} method).
   */
  public DigestNotPresentException(@Nullable String message, @Nullable Throwable cause) {
    super(message, cause);
  }

  /**
   * Constructs a {@code DigestNotPresentException} with the specified cause and a detail message of
   * (cause==null ? null : cause.toString()) (which typically contains the class and detail message
   * of cause).
   *
   * @param cause The cause (which is saved for later retrieval by the {@link #getCause()} method).
   */
  public DigestNotPresentException(@Nullable Throwable cause) {
    super(cause);
  }

  /**
   * Constructs a {@code DigestNotPresentException} with the specified detail message, cause,
   * suppression enabled or disabled, and writable stack trace enabled or disabled.
   *
   * @param message            The detail message (which is saved for later retrieval by the {@link #getMessage()} method).
   * @param cause              The cause (which is saved for later retrieval by the {@link #getCause()} method).
   * @param enableSuppression  Whether or not suppression is enabled or disabled.
   * @param writableStackTrace Whether or not the stack trace should be writable.
   */
  public DigestNotPresentException(@Nullable String message,
                                   @Nullable Throwable cause,
                                   boolean enableSuppression,
                                   boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}

