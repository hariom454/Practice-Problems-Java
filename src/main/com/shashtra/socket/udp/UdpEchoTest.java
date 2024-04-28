package com.shashtra.socket.udp;

import java.io.IOException;
import java.util.Objects;

public class UdpEchoTest {

  public static void main(String[] args) throws IOException {
    EchoClient echoClient = new EchoClient();
    Thread thread = new Thread(new EchoServer());
    thread.start();
    String msg = echoClient.sendEcho("Hello there!");
    System.out.println("message 1: " + msg);
    assert (Objects.equals(msg, "Hello there!"));
    msg = echoClient.sendEcho("Another message");
    System.out.println("message 2:" + msg);
    assert (Objects.equals(msg, "Another message"));
    echoClient.sendEcho("end");
    echoClient.close();

  }

}
