package edu.ics211.h03;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Represents a ReadFile.
 * .
 * @author Alexander Moshir
 *
 */
public class ReadFile implements IReadFile {

  /**
   * Reads in file and converts to appropriate String standard.
   * @param fileName name of String
   * @return newString returns new String converted to appropriate standard
   */
  @Override
  public String readFile(String fileName) throws IOException {
    // Wrap a FileInputStream with a dataInputStream
    try (DataInputStream in = new DataInputStream(new FileInputStream(fileName))) {
      // read in the number of bytes
      int numBytes = in.readInt();
      // read in the encoding
      byte encoding = in.readByte();
      // create a byte[] of the right size
      byte[] byteArray = new byte[numBytes];
      // fill the byte[]
      byteArray = in.readAllBytes();
      // depending on the encoding return a new String
      switch (encoding) {
        case 1: return new String(byteArray, StandardCharsets.US_ASCII);
        case 2: return new String(byteArray, StandardCharsets.UTF_16LE);
        case 3: return new String(byteArray, StandardCharsets.UTF_8);
        case 4: return new String(byteArray, StandardCharsets.UTF_16);
        default: return fileName;
      }
    }
  }

}
