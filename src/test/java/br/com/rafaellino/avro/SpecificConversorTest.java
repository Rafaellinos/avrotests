package br.com.rafaellino.avro;

import br.com.rafaellino.ClientIdentifier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpecificConversorTest {

  @Test
  void serializeClientIdentifier() {
    String value = Utils.readJson("payload_example.json");
    ClientIdentifier clientIdentifier = SpecificConversor.deSerializeClientIdentifier(value);
    assertNotNull(clientIdentifier);
    assertEquals("localhost", clientIdentifier.getHostName().toString());
  }

}