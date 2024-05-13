package com.shashtra.socket.tcp;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient {

  public static void main(String[] args) throws IOException {
    String sentence;
    String modifiedSentence;
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    Socket clientSocket = new Socket("hostname", 6789);
    DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
    BufferedReader inFromServer = new BufferedReader(
        new InputStreamReader(clientSocket.getInputStream()));
    sentence = inFromServer.readLine();
    outToServer.writeBytes(sentence + '\n');
    modifiedSentence = inFromServer.readLine();
    System.out.println("From server: " + modifiedSentence);
    clientSocket.close();
  }

}
