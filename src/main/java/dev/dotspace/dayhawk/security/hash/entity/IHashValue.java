package dev.dotspace.dayhawk.security.hash.entity;

import org.jetbrains.annotations.NotNull;


public interface IHashValue extends Comparable<byte[]> {

  byte @NotNull [] get();

  @NotNull String getAsString();

  @NotNull String algorithm();

}
