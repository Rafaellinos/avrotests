package br.com.rafaellino.avro;

import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecord;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GenericConversorTest {

  @Test
  @DisplayName("Serializar e deserializar timestamp deve ter o mesmo valor")
  void serializeDeserializeAvro() throws IOException {

    Schema schema = new Utils().generateSchema();

    GenericRecord genericRecord = new GenericData.Record(schema);

    genericRecord.put("eventTime", Instant.now().toEpochMilli());

    byte[] res = GenericConversor.serializeAvro(genericRecord, schema);

    GenericRecord genericRecordResponse = GenericConversor.deserializeAvro(res, schema);

    assertEquals(genericRecord.get("eventTime"), genericRecordResponse.get("eventTime"));
  }

}