package br.com.rafaellino.avro;

import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecord;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;


class UtilsTest {

  @Test
  void generateSchema() {

    Utils utils = new Utils();

    Schema schema = utils.generateSchema();

    GenericRecord genericRecord = new GenericData.Record(schema);

    genericRecord.put("eventTime", Instant.now().toEpochMilli());

    assertEquals(Long.class, genericRecord.get("eventTime").getClass());

  }
}