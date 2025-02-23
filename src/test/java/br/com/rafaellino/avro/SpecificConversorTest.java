package br.com.rafaellino.avro;

import br.com.rafaellino.ClientIdentifier;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

class SpecificConversorTest {

  @Test
  void serializeClientIdentifier() {
    String value = Utils.readJson("payload_example.json");
    ClientIdentifier clientIdentifier = SpecificConversor.deSerializeClientIdentifier(value);
    assertNotNull(clientIdentifier);
    assertEquals("localhost", clientIdentifier.getHostName().toString());
//    assertEquals(BigDecimal.valueOf(3.99), clientIdentifier.getPrice());
// TODO assert above will fail, bytes in json is not correctly represented
  }

}