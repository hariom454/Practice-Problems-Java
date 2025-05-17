package com.shashtra.socket.tcp;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class TCPClient {

  public static void main(String[] args) throws IOException {
    String sentence;
    String modifiedSentence;
    //buffer reader to read human input
    BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
    Socket clientSocket = new Socket("localhost", 6789);
    //output stream to write data into server channel
    DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
    //buffer reader to read the data from server
    BufferedReader inFromServer = new BufferedReader(
        new InputStreamReader(clientSocket.getInputStream()));
    do {
      //get human input
      System.out.println("type your message for server: ");
      sentence = inFromUser.readLine();

      //write data to server
      outToServer.writeBytes(sentence + '\n');
      modifiedSentence = inFromServer.readLine();
      System.out.println("From server: " + modifiedSentence);
    } while (!sentence.equals("bye"));
    clientSocket.close();

  }

}
