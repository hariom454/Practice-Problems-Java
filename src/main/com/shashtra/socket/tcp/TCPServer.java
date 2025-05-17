package com.shashtra.socket.tcp;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

  public static void main(String[] args) throws IOException {
    String clientSentence;
    String modifiedSentence;

    try (ServerSocket welcomeSocket = new ServerSocket(6789)) {
      System.out.println("Server started!!!");

      System.out.println("Waiting for client to connect?");
      Socket connectionSocket = welcomeSocket.accept();
      System.out.println("Connected to a client application");

      //buffer reader to read incoming message
      BufferedReader inFromClient = new BufferedReader(
          new InputStreamReader(connectionSocket.getInputStream()));
      //output stream to write data from server for client
      DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      do {
        clientSentence = inFromClient.readLine();
        System.out.println("client sentence: " + clientSentence);

        System.out.println("type your message for client: ");
        String sentence = reader.readLine();
        //System.out.println("user input: " + sentence);
        outToClient.writeBytes(sentence + '\n');
      } while (!clientSentence.equals("bye"));
      connectionSocket.close();

    }
  }

}
