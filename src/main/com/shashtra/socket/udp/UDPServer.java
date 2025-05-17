package com.shashtra.socket.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {

  public static void main(String[] args) throws IOException {
    try (DatagramSocket serverSocket = new DatagramSocket(9876)) {
      byte[] receivedData = new byte[1024];
      byte[] sendData;
      while (true) {
        DatagramPacket receivePacket = new DatagramPacket(receivedData, receivedData.length);
        serverSocket.receive(receivePacket);
        String sentence = new String(receivePacket.getData());
        InetAddress IPAddress = receivePacket.getAddress();
        int port = receivePacket.getPort();
        String modifiedSentence = sentence.toUpperCase();
        sendData = modifiedSentence.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
        serverSocket.send(sendPacket);
      }
    }

  }

}
