package br.com.rafaellino.avro;

import org.apache.avro.LogicalTypes;
import org.apache.avro.Schema;
import org.apache.avro.SchemaBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Utils {

  public Schema generateSchema() {
    return SchemaBuilder.record("AvroEvent")
            .namespace("com.example.avro")
            .fields()
            .name("eventTime")
            .type(Schema.createUnion(
                    Schema.create(Schema.Type.NULL), // Allows null values
                    LogicalTypes.timestampMillis().addToSchema(Schema.create(Schema.Type.LONG))
            ))
            .withDefault(null) // Default value is null
            .endRecord();
  }

  public static String readJson(final String fileName) {
    try (InputStream in = Utils.class.getClassLoader().getResourceAsStream(fileName)) {
      if (in != null) {
        return new String(in.readAllBytes());
      }
    } catch (IOException ignored) {
    }
    return null;
  }

}
