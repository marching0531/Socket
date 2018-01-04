package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReceiveThread extends Thread {

	private Socket m_Socket;
	
	@Override
	public void run() {
	
		super.run();
		
		try {
			BufferedReader tmpbuf = new BufferedReader(new InputStreamReader(m_Socket.getInputStream())); 
			
			String receiveString;
			
			while(true) {
		
				receiveString = tmpbuf.readLine(); 
				
				if(receiveString == null) {
					System.out.println("Connection Closed");
					break;
				}
				else { 
					System.out.println("Client : " + receiveString);
				}
			}
			
			tmpbuf.close();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void setSocket(Socket _socket) {
		m_Socket = _socket;
	}
	
}
