package br.com.rafaellino.avro;

import br.com.rafaellino.ClientIdentifier;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.io.Decoder;
import org.apache.avro.io.DecoderFactory;
import org.apache.avro.io.Encoder;
import org.apache.avro.io.EncoderFactory;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificDatumWriter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class SpecificConversor {

  public static byte[] serializeClientIdentifier(ClientIdentifier request) {
    DatumWriter<ClientIdentifier> writer = new SpecificDatumWriter<>(ClientIdentifier.class);
    byte[] data = new byte[0];
    ByteArrayOutputStream stream = new ByteArrayOutputStream();
    Encoder encoder;
    try {
      encoder = EncoderFactory.get().binaryEncoder(stream, null);
      writer.write(request, encoder);
      encoder.flush();
      data = stream.toByteArray();
    } catch (IOException e) {
      System.out.println("Serialization error:" + e.getMessage());
    }
    return data;
  }

  public static ClientIdentifier deSerializeClientIdentifier(byte[] data) {
    DatumReader<ClientIdentifier> reader = new SpecificDatumReader<>(ClientIdentifier.class);
    Decoder decoder;
    try {
      decoder = DecoderFactory.get().binaryDecoder(data, null);
      return reader.read(null, decoder);
    } catch (IOException e) {
      System.out.println("Deserialization error:" + e.getMessage());
    }
    return null;
  }

  public static ClientIdentifier deSerializeClientIdentifier(String data) {
    DatumReader<ClientIdentifier> reader = new SpecificDatumReader<>(ClientIdentifier.class);
    Decoder decoder;
    try {
      decoder = DecoderFactory.get().jsonDecoder(ClientIdentifier.getClassSchema(), data);
      return reader.read(null, decoder);
    } catch (IOException e) {
      System.out.println("Deserialization error:" + e.getMessage());
    }
    return null;
  }
}
