package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReceiveThread extends Thread{

	private Socket m_Socket;
	
	@Override
	public void run() {

		super.run();
		
		try {

			BufferedReader tmpbuf = new BufferedReader(new InputStreamReader(m_Socket.getInputStream()));
			
			String receiveString;
			String[] split;
			
			while(true) {

				receiveString = tmpbuf.readLine();
				
				split = receiveString.split(">");
				
				if(split.length >= 2 && split[0].equals(ChatClient.UserID))
					continue;
					
				System.out.println(receiveString);
			}

		}catch (IOException e) {
			
		}
	}
	
	public void setSocket(Socket _socket) {

		m_Socket = _socket;
	}

}
