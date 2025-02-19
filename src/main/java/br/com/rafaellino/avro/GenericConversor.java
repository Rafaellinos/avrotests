package br.com.rafaellino.avro;

import org.apache.avro.Schema;
import org.apache.avro.generic.GenericDatumReader;
import org.apache.avro.generic.GenericDatumWriter;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.BinaryDecoder;
import org.apache.avro.io.BinaryEncoder;
import org.apache.avro.io.DecoderFactory;
import org.apache.avro.io.EncoderFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class GenericConversor {
  public static byte[] serializeAvro(GenericRecord record, Schema schema) throws IOException {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    BinaryEncoder encoder = EncoderFactory.get().binaryEncoder(outputStream, null);
    GenericDatumWriter<GenericRecord> datumWriter = new GenericDatumWriter<>(schema);
    datumWriter.write(record, encoder);
    encoder.flush();
    outputStream.close();
    return outputStream.toByteArray();
  }

  // Method to deserialize Avro data
  public static GenericRecord deserializeAvro(byte[] data, Schema schema) throws IOException {
    ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
    BinaryDecoder decoder = DecoderFactory.get().binaryDecoder(inputStream, null);
    GenericDatumReader<GenericRecord> datumReader = new GenericDatumReader<>(schema);
    return datumReader.read(null, decoder);
  }
}
