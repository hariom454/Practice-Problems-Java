package com.shashtra.socket.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class EchoClient {

  private DatagramSocket datagramSocket;
  private InetAddress address;

  private byte[] buf;

  public EchoClient() throws SocketException, UnknownHostException {
    datagramSocket = new DatagramSocket();
    address = InetAddress.getByName("localhost");

  }

  public String sendEcho(String msg) throws IOException {
    buf = msg.getBytes();
    DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 4445);
    datagramSocket.send(packet);
    packet = new DatagramPacket(buf, buf.length);
    datagramSocket.receive(packet);
    return new String(packet.getData(), 0, packet.getLength());
  }

  public void close() {
    System.out.println("socket closed");
    datagramSocket.close();
  }
}
