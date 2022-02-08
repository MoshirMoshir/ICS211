package edu.ics211.h01;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * Represents a Translator. 
 * @author Alexander Moshir
 */
public class Translator implements Translate {

  
  /**
   * Converts and returns InputStream as Binary String.
   * @param in InputStream
   * @return Binary String
   * @exception IOException for InputStream
   */
  @Override
  public String asBinaryString(InputStream in) {
    try {
      // create BitReader from InputStream
      BitReader bitReader = new BitReader(in);
      // create StringBuilder
      StringBuilder builder = new StringBuilder();
      
      // loop until BitReader is done
      while (!bitReader.isDone()) {
        // append 0 or 1 from BitReader to StringBuilder
        builder.append(bitReader.readAsInt());
      }
      
      bitReader.close();
      
      // return String or StringBuilder.toString
      return builder.toString();
    } catch (IOException e) {
      e.printStackTrace();
    }
    
    return null;
  }


  /**
   * Converts and returns InputStream as a Hexadecimal String.
   * @param in InputStream
   * @return Hexadecimal String
   * @exception IOException for InputStream
   */
  @Override
  public String asHexadecimalString(InputStream in) {
    try {
      // create StringBuilder
      StringBuilder builder = new StringBuilder();
      // read InputStream into array Bytes
      byte[] bytes = new byte[in.available()];
      // fill array from InputStream
      // found at https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/io/InputStream.html
      // & http://tutorials.jenkov.com/java-io/inputstream.html
      in.read(bytes);
      
      // convert bytes to hexadecimal String + leading 0
      for (int i = 0; i < bytes.length; i++) {
        // Found at https://stackoverflow.com/questions/45495981/how-to-convert-an-int-to-hex-with-leading-zeros-in-java
        builder.append(String.format("%02x", bytes[i]));
      }
      
      // return hexadecimal String
      return builder.toString();
    } catch (IOException e) {
      e.printStackTrace();
    }
    
    return null;
  }


  /**
   * Converts and returns InputStream as a UTF-8 String.
   * @param in InputStream
   * @return UTF8 String
   * @exception IOException for InputStream
   */
  @Override
  public String asUtf8String(InputStream in) {

    try {
      // create array of bytes
      byte[] bytes = new byte[in.available()];
      // fill array from InputStream
      // found at https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/io/InputStream.html
      // & http://tutorials.jenkov.com/java-io/inputstream.html
      in.read(bytes);
      
      // return as Utf8 String
      // found at https://rules.sonarsource.com/java/RSPEC-4719 with SonarLint
      return new String(bytes, StandardCharsets.UTF_8);
    } catch (IOException e) {
      e.printStackTrace();
    }
    
    return null;
  }
  
}
