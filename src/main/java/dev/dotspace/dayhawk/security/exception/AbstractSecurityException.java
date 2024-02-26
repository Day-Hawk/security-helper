package dev.dotspace.dayhawk.security.exception;

import org.jetbrains.annotations.Nullable;

/**
 * The {@code AbstractCryptException} class is the base class for exceptions related to cryptographic operations.
 *
 * <p>This class extends {@code Exception} and provides constructors for creating exceptions with various
 * combinations of messages and causes.</p>
 *
 * @author Daniel Riethmüller (Day-Hawk)
 * @version 1.0
 * @since 2024-02-25
 */
public abstract class AbstractSecurityException extends Exception {
  /**
   * Constructs a new {@code AbstractCryptException} with no specified detail message.
   */
  public AbstractSecurityException() {
  }
  /**
   * Constructs a new {@code AbstractCryptException} with the specified detail message.
   *
   * @param message The detail message. Can be {@code null}.
   */
  public AbstractSecurityException(@Nullable final String message) {
    super(message);
  }
  /**
   * Constructs a new {@code AbstractCryptException} with the specified detail message and cause.
   *
   * @param message The detail message. Can be {@code null}.
   * @param cause   The cause. Can be {@code null}.
   */
  public AbstractSecurityException(@Nullable final String message,
                                   @Nullable final Throwable cause) {
    super(message, cause);
  }
  /**
   * Constructs a new {@code AbstractCryptException} with the specified cause and a detail message of
   * {@code (cause==null ? null : cause.toString())} (which typically contains the class and detail message of
   * cause). This constructor is useful for exceptions that are little more than wrappers for other throwables.
   *
   * @param cause The cause. Can be {@code null}.
   */
  public AbstractSecurityException(@Nullable final Throwable cause) {
    super(cause);
  }
  /**
   * Constructs a new {@code AbstractCryptException} with the specified detail message, cause, suppression enabled
   * or disabled, and writable stack trace enabled or disabled.
   *
   * @param message            The detail message. Can be {@code null}.
   * @param cause              The cause. Can be {@code null}.
   * @param enableSuppression  Whether or not suppression is enabled or disabled.
   * @param writableStackTrace Whether or not the stack trace should be writable.
   */
  public AbstractSecurityException(@Nullable final String message,
                                   @Nullable final Throwable cause,
                                   final boolean enableSuppression,
                                   final boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}

