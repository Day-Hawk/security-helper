package dev.dotspace.dayhawk.security.hash;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.security.Security;
import java.util.ArrayList;
import java.util.List;


public final class HashManager {

  public static @NotNull List<String> algorithmList() {
    return new ArrayList<>(Security.getAlgorithms("MessageDigest"));
  }

  public static @NotNull IHashProcessor processor(@Nullable final String algorithm) {
    return new HashProcessor(algorithm);
  }

}
