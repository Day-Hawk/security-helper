package dev.dotspace.dayhawk.security.hash.entity;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Objects;


public abstract class AbstractHashValue implements IHashValue {

  private final @NotNull String algorithm;
  private final byte @NotNull [] value;

  protected AbstractHashValue(@Nullable final String algorithm,
                              final byte @Nullable [] value) {
    //Null check
    Objects.requireNonNull(algorithm);
    Objects.requireNonNull(value);

    this.algorithm = algorithm;
    this.value = value;
  }

  @Override
  public int compareTo(byte @Nullable [] o) {
    return Arrays.compare(this.value, o);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    return obj instanceof IHashValue array &&
        this.algorithm.equals(array.algorithm()) &&
        Arrays.equals(this.value, array.get());
  }

  @Override
  public @NotNull String algorithm() {
    return this.algorithm;
  }

  @Override
  public byte @NotNull [] get() {
    return this.value;
  }

  @Override
  public @NotNull String getAsString() {
    return new String(this.value, StandardCharsets.UTF_8);
  }
}
