package com.io.patterns.bio;

import java.io.IOException;

public class Main {
	public static void main(String[] args) {
//		final Server server = new Server();
		final Server server = new TheadPoolServer();
		Client client = new Client();
		
		String[] outs = {"hello","are you there","test","you shit!"};
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					server.start();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}).start();
		
		for (String content : outs) {
			client.send(content);
			
		}	
		
		
	}
}
