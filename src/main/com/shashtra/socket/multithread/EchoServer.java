package com.shashtra.socket.multithread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

  public static void main(String[] args) throws IOException {
    int port = 8086;
    try (ServerSocket socket = new ServerSocket(port)) {
      while (true) {
        Socket clientSocket = socket.accept();
        Thread.ofVirtual().start(() -> {
          try (
              PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
              BufferedReader in = new BufferedReader(
                  new InputStreamReader(clientSocket.getInputStream()))) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
              System.out.println(inputLine);
              out.println(inputLine.toUpperCase());
            }
          } catch (IOException ex) {
            ex.printStackTrace();
          }
        });
      }
    } catch (IOException ex) {
      System.out.println("Exception while listening to port " + port);
      System.err.println(ex.getMessage());
    }

  }
}
