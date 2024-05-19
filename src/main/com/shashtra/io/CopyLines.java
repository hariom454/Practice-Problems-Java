package com.shashtra.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CopyLines {

  public static void main(String[] args) throws IOException {
    BufferedReader inputStream = null;
    BufferedWriter outStream = null;
    try {
      inputStream = new BufferedReader(new FileReader("simple.txt"));
      outStream = new BufferedWriter(new FileWriter("copylines.txt"));
      String line;
      while ((line = inputStream.readLine()) != null) {
        outStream.write(line);
        outStream.newLine();
      }
    } finally {
      if (inputStream != null) {
        inputStream.close();
      }
      if (outStream != null) {
        outStream.close();
      }
    }
  }

}
