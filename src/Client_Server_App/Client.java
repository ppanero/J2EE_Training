package Client_Server_App;

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args){
        try {
            DatagramSocket socket = new DatagramSocket();

            //Generate request
            Message request_msg = new Message("test request");
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(request_msg);
            byte [] byte_msg = baos.toByteArray();

            //Send request
            InetAddress host = InetAddress.getByName("localhost");
            int serverSocket = 6788;
            DatagramPacket request = new DatagramPacket(byte_msg, byte_msg.length, host, serverSocket);
            socket.send(request);
            System.out.println("Client_Server_App.Client: request sent");

            //Receive reply
            byte [] reply_buffer = new byte[100];
            DatagramPacket reply = new DatagramPacket(reply_buffer, reply_buffer.length);
            socket.receive(reply);

            //Process reply
            //Process request
            System.out.println("Client_Server_App.Client: reply received");
            ByteArrayInputStream bais = new ByteArrayInputStream(reply.getData());
            ObjectInputStream ois = new ObjectInputStream(bais);
            Message reply_msg = (Message)(ois.readObject());
            System.out.println("Client_Server_App.Client: reply message - " + reply_msg.getBody());
            socket.close();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
