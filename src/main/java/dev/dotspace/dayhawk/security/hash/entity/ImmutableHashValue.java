package dev.dotspace.dayhawk.security.hash.entity;

import org.jetbrains.annotations.Nullable;


public final class ImmutableHashValue extends AbstractHashValue {

  public ImmutableHashValue(@Nullable String algorithm,
                            byte @Nullable [] value) {
    super(algorithm, value);
  }
}
