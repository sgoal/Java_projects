package com.io.patterns.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

public class Client {
	private final static String HOST = "127.0.0.1";
	private final static int PORT = 12341;
	
	private ClientHandler clientHandler;
	
	public Client() {
		try {
			clientHandler = new ClientHandler(HOST, PORT);
			new Thread(clientHandler).start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void sendMsg(String content) {
		try {
			clientHandler.writeMsg(content);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

class ClientHandler implements Runnable{

	
	private Selector selector;
	private SocketChannel socketChannel;
	private boolean stated;
	private String host;
	private int port;
	public ClientHandler(String host, int port) throws IOException {
		this.host = host;
		this.port = port;
		selector = Selector.open();
		socketChannel = SocketChannel.open();
		socketChannel.configureBlocking(false);
		stated = true;
		
	}

	@Override
	public void run() {
		try {
			if(socketChannel.connect(new InetSocketAddress(this.host, this.port))) {
				
			}
			else{
				socketChannel.register(selector, SelectionKey.OP_CONNECT);	
			}
			while (stated) {
				selector.select(1000);
				for(SelectionKey key : selector.selectedKeys()) {
					handleKey(key);
				}
			}
		} catch (ClosedChannelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	private void handleKey(SelectionKey key) throws Exception {
		if(key.isValid()) {
			if(key.isConnectable()) {
				SocketChannel sChannel = (SocketChannel) key.channel();
				if(sChannel.finishConnect());
				else {
					throw new Exception("connect error");
				}
			}
			if(key.isReadable()) {
				ByteBuffer buffer = ByteBuffer.allocate(2048);
				SocketChannel sChannel = (SocketChannel) key.channel();
				int byteSize = sChannel.read(buffer);
				if(byteSize>0) {
					buffer.flip();
					byte[] data = new byte[buffer.remaining()];
					buffer.get(data);
					String content = new String(data);
					System.out.println("recieve server:"+content);
				}else {
					key.cancel();
					sChannel.close();
				}
			}
			
		}
		
	}
	
	public void writeMsg(String content) throws IOException {
		socketChannel.register(selector, SelectionKey.OP_READ);
		byte[] datas = content.getBytes();
		ByteBuffer buffer = ByteBuffer.allocate(datas.length);
		buffer.put(datas);
		buffer.flip();
		socketChannel.write(buffer);

	}
}