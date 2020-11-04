package Program;

import java.util.*;
import java.security.*;

    public class SHA256 {
        public static void main(String[] args) {
            //Reading the data from user
            Scanner in = new Scanner(System.in);
            System.out.println("Enter the message");
            String message = in.nextLine();
            in.close();

            try {
                //Creating the MessageDigest object
                MessageDigest messageDigest
                        = MessageDigest.getInstance("SHA-256");

                //Passing data to the created MessageDigest Object
                messageDigest.update(message.getBytes());

                //Compute the message digest
                byte[] hash = messageDigest.digest();

                //convert byte to Hexadecimal
                for (byte b : hash) {
                    //print its SHA-256 encryption value
                    System.out.printf("%02x", b);
                }
            } catch (Exception e) {
            }
        }
    }

