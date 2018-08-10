package com.io.patterns.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Set;

public class Server {
	private final static int DEFAULT_PORT = 12341;
	
	private SocketHandler socketHandler;
	
	public void start() {
		start(DEFAULT_PORT);
	}
	
	public void start(int port) {
		try {
			socketHandler = new SocketHandler(port);
			new Thread(socketHandler).start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class SocketHandler implements Runnable{
	private boolean started = false;
	private Selector selector;
	private ServerSocketChannel serverSocketChannel;
	
	public SocketHandler(int port) throws IOException {
		selector = Selector.open();
		serverSocketChannel = ServerSocketChannel.open();
		serverSocketChannel.configureBlocking(false);
		serverSocketChannel.socket().bind(new InetSocketAddress(port),1024);
		serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
		started = true;
		System.out.println("server start ....");
		
	}

	@Override
	public void run() {
		while (started) {
			try {
				selector.select(1000);
				Set<SelectionKey> keys =  selector.selectedKeys();
				for(SelectionKey key : keys) {
					handleInput(key);
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		}
		
	}

	private void handleInput(SelectionKey key) throws IOException {
		if(key.isValid()) {
			if(key.isAcceptable()) {
				ServerSocketChannel serverSocketChannel0 =  (ServerSocketChannel) key.channel();
				SocketChannel channel =  serverSocketChannel0.accept();
				if(channel!=null) {
				channel.configureBlocking(false);
				channel.register(selector, SelectionKey.OP_READ);
				}
			}
			if(key.isReadable()) {
				SocketChannel channel = (SocketChannel) key.channel();
				ByteBuffer buffer = ByteBuffer.allocate(2048);
				int readBytes = channel.read(buffer);
				if(readBytes>0) {
					buffer.flip();
					byte[] datas = new byte[buffer.remaining()];
					buffer.get(datas);
					String receive = new String(datas,"utf8");
					System.out.println("nio recuve:" + receive);
					
					write(channel, "server get:"+receive);
				}else {
					key.cancel();
					channel.close();
				}
			}
			
		}
		
	}
	
	private void write(SocketChannel channel, String content) throws IOException {
		System.out.println("send to client...");
		byte[] datas = content.getBytes();
		ByteBuffer buffer = ByteBuffer.allocate(datas.length);
		buffer.put(datas);
		buffer.flip();
		channel.write(buffer);
		
	}
	
}