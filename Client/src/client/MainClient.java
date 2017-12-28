package client;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class MainClient {
	
	public static void main(String[] args) throws IOException {
	Socket c_socket = new Socket("127.0.0.1",8888);
	
	InputStream input_data = c_socket.getInputStream();
	
	byte[] receiveBuffer = new byte[100];
	input_data.read(receiveBuffer);
	
	System.out.println(new String(receiveBuffer));
	
	c_socket.close();
	}
}
