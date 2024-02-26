package dev.dotspace.dayhawk.security.hash;

import dev.dotspace.dayhawk.security.AbstractSecurityTest;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public final class HashManagerTest extends AbstractSecurityTest {

  @Test
  @DisplayName("Test HashManager")
  public void testManager() {
    //Positive
    Assertions.assertNotNull(HashManager.instance());
    Assertions.assertInstanceOf(IHashManager.class, HashManager.instance());

    //Negative
    Assertions.assertThrows(NullPointerException.class, () -> HashManager.instance().processor(null));
  }

  //Test available algorithms.
  @ParameterizedTest
  @MethodSource("algorithmList")
  @DisplayName("Specific hash algorithm test")
  void testHashAlgorithm(@NotNull final String algorithm) {
    Assertions.assertDoesNotThrow(() -> HashManager.instance().processor(algorithm));
  }

  @Override
  protected @NotNull List<String> algorithmList() {
    return HashManager.instance().algorithmList();
  }
}
