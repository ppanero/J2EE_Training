import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {
            DatagramSocket socket  = new DatagramSocket(6788);
            byte[] request_buffer = new byte[100];
            System.out.println("Server: running...");

            while (true) {
                //Receive request
                DatagramPacket request = new DatagramPacket(request_buffer, request_buffer.length);
                socket.receive(request);

                //Process request
                System.out.println("Server: request received");
                ByteArrayInputStream bais = new ByteArrayInputStream(request.getData());
                ObjectInputStream ois = new ObjectInputStream(bais);
                Message request_msg = (Message)(ois.readObject());
                System.out.println("Server: request message - " + request_msg.getBody());

                //Generate reply
                Message reply_msg = new Message("test request");
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(baos);
                oos.writeObject(reply_msg);
                byte[] byte_msg = baos.toByteArray();

                //Send reply
                DatagramPacket reply = new DatagramPacket(byte_msg, byte_msg.length, request.getAddress(), request.getPort());
                socket.send(reply);
                System.out.println("Server: reply sent");

            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
