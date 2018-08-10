package com.io.patterns.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.Charset;

public class Client {
	private final static String DEFAULT_SERVER_IP = "127.0.0.1";
	private final static int DEFAULT_PORT = 1234;
	
	public void send(String content) {
		send(DEFAULT_PORT, content);
	}

	public void send(int defaultPort, String content) {
		Socket socket;
		BufferedReader reader;
		PrintWriter writer;
		try {
			socket = new Socket(DEFAULT_SERVER_IP, defaultPort);
			writer = new PrintWriter(socket.getOutputStream(),true);
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), Charset.forName("utf8")));
			writer.println(content);
			System.out.println("client get response {"+ reader.readLine()+"}");
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
