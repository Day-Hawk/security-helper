package dev.dotspace.dayhawk.security.hash.entiy;

import dev.dotspace.dayhawk.security.hash.HashManager;
import dev.dotspace.dayhawk.security.hash.entity.IHashValue;
import dev.dotspace.dayhawk.security.hash.entity.ImmutableHashValue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;


public final class HashValueTest {

  @Test
  @DisplayName("Test HashValue")
  public void testHashValue() {
    //Positive
    final IHashValue value = new ImmutableHashValue("1", "2".getBytes(StandardCharsets.UTF_8));

    Assertions.assertNotNull(value);
    Assertions.assertEquals(value.algorithm(), "1");
    Assertions.assertArrayEquals(value.get(), "2".getBytes(StandardCharsets.UTF_8));
    Assertions.assertEquals(value.getAsString(), "2");

    //Negative
    Assertions.assertThrows(NullPointerException.class, () -> new ImmutableHashValue(null, null));
  }

}
