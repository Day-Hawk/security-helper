package dev.dotspace.dayhawk.security.hash;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;



@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public final class HashManagerTest extends AbstractHashTest {

  @Test
  @DisplayName("Test HashManager")
  public void testManager() {
    //Positive
    Assertions.assertFalse(HashManager.algorithmList().isEmpty());

    //Negative
    Assertions.assertThrows(NullPointerException.class, () -> HashManager.processor(null));
  }

  //Test available algorithms.
  @ParameterizedTest
  @MethodSource("algorithmList")
  @DisplayName("Specific hash algorithm test")
  void testHashAlgorithm(@NotNull final String algorithm) {
    Assertions.assertDoesNotThrow(() -> HashManager.processor(algorithm));
  }
}
