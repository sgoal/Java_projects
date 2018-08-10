package com.io.patterns.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Server{
	
	protected ServerSocket serverSocket;
	private final static int DEFALUT_PORT = 1234;
	
	public void start() throws IOException {
		start(DEFALUT_PORT);
	}
	
	public void start(int port) throws IOException {
		if(serverSocket!=null)
			return;
		System.out.println("nomal Server start....");
		try {
			serverSocket = new ServerSocket(port);
			Socket socket;
			
			while (true) {
				socket = serverSocket.accept();
				new Thread(new SocketHandler(socket)).start();
			}
		} finally {
			serverSocket.close();
			serverSocket = null;
		}
		
	}
	
}

class TheadPoolServer extends Server{
	private ExecutorService pool = Executors.newFixedThreadPool(60);
	
	
	@Override
	public void start(int port) throws IOException {
		if(serverSocket!=null)return;
		Socket socket;
		System.out.println("TheadPoolServer start....");
		try {
			serverSocket = new ServerSocket(port);
			while (true) {
				socket = serverSocket.accept();
				pool.execute(new SocketHandler(socket));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			serverSocket.close();
			pool.shutdown();
		}
	}
	
}


class SocketHandler implements Runnable{
	private Socket socket;
	
	public SocketHandler(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		BufferedReader reader = null;
		PrintWriter writer = null;
		try {
			reader = new BufferedReader( new InputStreamReader(
					socket.getInputStream()));
			writer =  new PrintWriter( socket.getOutputStream(),true);
			String inString = null;
			while (true) {
				inString = reader.readLine();
				if(inString==null)break;
				System.out.println(String.format("in string is {%s}", inString) );
				writer.println("server get : " + inString);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(reader!=null)
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			if(writer != null)
				writer.close();
			if(socket != null)
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			socket = null;
		}
	}
}
