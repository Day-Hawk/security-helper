package dev.dotspace.dayhawk.security.crypt.exception;

import org.jetbrains.annotations.Nullable;


/**
 * The {@code PaddingException} class is a specific cryptographic exception
 * indicating an issue related to padding during a cryptographic operation.
 *
 * <p>This exception extends {@code AbstractCryptException} and provides constructors for creating instances
 * with different parameters, including messages and causes.</p>
 *
 * <p>Usage example:</p>
 * <pre>
 * {@code
 * try {
 *     // Perform cryptographic operation that encounters an issue with padding
 * } catch (PaddingException e) {
 *     // Handle exception specific to padding issues
 *     System.err.println("Padding Exception: " + e.getMessage());
 * }
 * }
 * </pre>
 *
 * <p>It is recommended to catch this exception when dealing with situations where issues related to padding are detected.</p>
 *
 * @author Day-Hawk
 */
public final class PaddingException extends AbstractCryptException {
  /**
   * Constructs a {@code PaddingException} with no detail message.
   */
  public PaddingException() {
  }

  /**
   * Constructs a {@code PaddingException} with the specified detail message.
   *
   * @param message The detail message (which is saved for later retrieval by the {@link #getMessage()} method).
   */
  public PaddingException(@Nullable String message) {
    super(message);
  }

  /**
   * Constructs a {@code PaddingException} with the specified detail message and cause.
   *
   * @param message The detail message (which is saved for later retrieval by the {@link #getMessage()} method).
   * @param cause   The cause (which is saved for later retrieval by the {@link #getCause()} method).
   */
  public PaddingException(@Nullable String message, @Nullable Throwable cause) {
    super(message, cause);
  }

  /**
   * Constructs a {@code PaddingException} with the specified cause.
   *
   * @param cause The cause (which is saved for later retrieval by the {@link #getCause()} method).
   */
  public PaddingException(@Nullable Throwable cause) {
    super(cause);
  }

  /**
   * Constructs a {@code PaddingException} with the specified detail message,
   * cause, suppression enabled or disabled, and writable stack trace enabled or disabled.
   *
   * @param message            The detail message (which is saved for later retrieval by the {@link #getMessage()} method).
   * @param cause              The cause (which is saved for later retrieval by the {@link #getCause()} method).
   * @param enableSuppression  Whether or not suppression is enabled or disabled.
   * @param writableStackTrace Whether or not the stack trace should be writable.
   */
  public PaddingException(@Nullable String message,
                          @Nullable Throwable cause,
                          boolean enableSuppression,
                          boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}

