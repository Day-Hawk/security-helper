package dev.dotspace.dayhawk.security.hash.entiy;

import dev.dotspace.dayhawk.security.hash.entity.IHashValue;
import dev.dotspace.dayhawk.security.hash.entity.ImmutableHashValue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;


public final class HashValueTest {

  private final byte[] VALUE_1 = "1".getBytes();

  @Test
  @DisplayName("Test HashValue")
  public void testHashValue() {
    //Positive
    final IHashValue value = new ImmutableHashValue("ALGO", VALUE_1);

    Assertions.assertNotNull(value);
    Assertions.assertEquals(value.algorithm(), "ALGO");
    Assertions.assertArrayEquals(value.digest(), VALUE_1);

    //Negative
    Assertions.assertThrows(NullPointerException.class, () -> new ImmutableHashValue(null, null));
  }

}
