package com.shashtra.io;

import java.io.Console;
import java.util.Arrays;

public class Password {

  public static void main(String[] args) {
    Console c = System.console();
    if (c == null) {
      System.err.println("Console is not available!");
      System.exit(0);
    }
    String login = c.readLine("Enter user login: ");
    char[] oldPassword = c.readPassword("Please enter your password: ");
    //dummy verify if login is valid or not
    //change password
    boolean isValid;

    do {
      char[] newPassword1 = c.readPassword("Enter your new password: ");
      char[] newPassword2 = c.readPassword("Please enter your password again: ");
      isValid = Arrays.equals(newPassword1, newPassword2);
      if (isValid) {
        //change password
        System.out.println("Password changed successfully!");
      } else {
        //password didn't match try again
        System.err.println("Passwords didn't match, try again!");
      }
      Arrays.fill(newPassword1, ' ');
      Arrays.fill(newPassword2, ' ');
    }
    while (!isValid);
    Arrays.fill(oldPassword, ' ');

  }

}
