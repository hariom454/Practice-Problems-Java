package com.shashtra.socket.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class EchoServer implements Runnable {

  private DatagramSocket socket;
  private boolean running;
  private byte[] buffer = new byte[256];

  public EchoServer() throws SocketException {
    socket = new DatagramSocket(4445);
  }

  @Override
  public void run() {
    running = true;
    while (running) {
      DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
      try {
        socket.receive(packet);
        InetAddress address = packet.getAddress();
        int port = packet.getPort();
        packet = new DatagramPacket(buffer, buffer.length, address, port);
        String received = new String(packet.getData(), 0, packet.getLength());
        System.out.println(received);
        if (received.contains("end")) {
          System.out.println("received to terminate");
          running = false;
          continue;
        }
        socket.send(packet);
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }
    socket.close();
  }
}
