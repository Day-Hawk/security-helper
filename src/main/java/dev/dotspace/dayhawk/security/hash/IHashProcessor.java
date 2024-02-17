package dev.dotspace.dayhawk.security.hash;

import dev.dotspace.dayhawk.security.hash.entity.IHashValue;
import dev.dotspace.dayhawk.security.hash.exception.HashException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


public interface IHashProcessor {

  @NotNull IHashValue hash(final byte @Nullable [] secret) throws HashException;

  @NotNull IHashValue hash(@Nullable final String secret) throws HashException;
}
