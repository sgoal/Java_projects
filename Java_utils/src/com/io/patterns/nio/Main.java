package com.io.patterns.nio;

public class Main {
	public static void main(String[] args) {
		
		Server server = new Server();
		server.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Client client = new Client();
		String[] msgs = {"what","a msg from out space","holy shit"};
	
		for (String string : msgs) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			client.sendMsg(string);
		}
	}
}
