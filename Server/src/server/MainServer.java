package server;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServer {

	public static void main(String[] args) throws IOException {
		
		ServerSocket s_socket = new ServerSocket(8888);
		
		Socket c_socket = s_socket.accept();
		
		OutputStream output_data = c_socket.getOutputStream();

		String sendDataString = "Connection Test";
		output_data.write(sendDataString.getBytes());
		
		s_socket.close();
		c_socket.close();
	}
	
}
