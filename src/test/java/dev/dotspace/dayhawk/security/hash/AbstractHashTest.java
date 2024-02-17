package dev.dotspace.dayhawk.security.hash;

import org.jetbrains.annotations.NotNull;

import java.util.List;


public abstract class AbstractHashTest {

  private  @NotNull List<String> algorithmList() {
    return HashManager.algorithmList();
  }

}
