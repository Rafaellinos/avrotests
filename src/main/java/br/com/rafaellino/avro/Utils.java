package br.com.rafaellino.avro;

import org.apache.avro.LogicalTypes;
import org.apache.avro.Schema;
import org.apache.avro.SchemaBuilder;

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
}
