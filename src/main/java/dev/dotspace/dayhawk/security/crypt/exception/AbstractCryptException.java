package dev.dotspace.dayhawk.security.crypt.exception;


import dev.dotspace.dayhawk.security.exception.AbstractSecurityException;
import org.jetbrains.annotations.Nullable;


/**
 * The {@code AbstractCryptException} class is an abstract base class for cryptographic exceptions,
 * extending {@code AbstractSecurityException}.
 *
 * <p>This class provides constructors to create instances of cryptographic exceptions with different parameters,
 * including messages and causes. It extends the standard Java {@code AbstractSecurityException} class.</p>
 *
 * <p>Subclasses may be created to represent specific cryptographic exception scenarios.</p>
 *
 * <p>Usage example:</p>
 * <pre>
 * {@code
 * try {
 *     // Perform cryptographic operation
 * } catch (AbstractCryptException e) {
 *     // Handle cryptographic exception
 *     System.err.println("Cryptographic Exception: " + e.getMessage());
 * }
 * }
 * </pre>
 *
 * <p>It is recommended to create concrete subclasses for specific cryptographic exception scenarios.</p>
 *
 * @author Day-Hawk
 */
public abstract class AbstractCryptException extends AbstractSecurityException {
  /**
   * Constructs an {@code AbstractCryptException} with no detail message.
   */
  public AbstractCryptException() {
  }

  /**
   * Constructs an {@code AbstractCryptException} with the specified detail message.
   *
   * @param message The detail message (which is saved for later retrieval by the {@link #getMessage()} method).
   */
  public AbstractCryptException(@Nullable String message) {
    super(message);
  }

  /**
   * Constructs an {@code AbstractCryptException} with the specified detail message and cause.
   *
   * @param message The detail message (which is saved for later retrieval by the {@link #getMessage()} method).
   * @param cause   The cause (which is saved for later retrieval by the {@link #getCause()} method).
   */
  public AbstractCryptException(@Nullable String message,
                                @Nullable Throwable cause) {
    super(message, cause);
  }

  /**
   * Constructs an {@code AbstractCryptException} with the specified cause and a detail message of
   * {@code (cause==null ? null : cause.toString())} (which typically contains the class and detail message
   * of {@code cause}). This constructor is useful for exceptions that are little more than wrappers for
   * other throwables.
   *
   * @param cause The cause (which is saved for later retrieval by the {@link #getCause()} method).
   */
  public AbstractCryptException(@Nullable Throwable cause) {
    super(cause);
  }

  /**
   * Constructs an {@code AbstractCryptException} with the specified detail message,
   * cause, suppression enabled or disabled, and writable stack trace enabled or disabled.
   *
   * @param message            The detail message (which is saved for later retrieval by the {@link #getMessage()} method).
   * @param cause              The cause (which is saved for later retrieval by the {@link #getCause()} method).
   * @param enableSuppression  Whether or not suppression is enabled or disabled.
   * @param writableStackTrace Whether or not the stack trace should be writable.
   */
  public AbstractCryptException(@Nullable String message,
                                @Nullable Throwable cause,
                                boolean enableSuppression,
                                boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}

