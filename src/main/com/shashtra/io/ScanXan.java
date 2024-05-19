package com.shashtra.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ScanXan {

  public static void main(String[] args) throws FileNotFoundException {
    Scanner in = null;
    try {
      in = new Scanner(new BufferedReader(new FileReader("simple.txt")));
      while (in.hasNext()) {
        System.out.println(in.next());
      }
    } finally {
      if (in != null) {
        in.close();
      }
    }
  }

}
