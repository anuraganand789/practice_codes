import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

import java.nio.charset.CharacterCodingException;
import java.net.http.HttpRequest;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.StandardSocketOptions;
import java.net.Socket;
import java.net.ServerSocket;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Base64;
import java.util.stream.Collectors;
import java.util.List;

import static java.nio.charset.StandardCharsets.ISO_8859_1;

public class SocketServer{
    private static final String magicKey = "258EAFA5-E914-47DA-95CA-C5AB0DC85B11"; 
    private class SocketHandler implements Runnable{

	private final Socket socket;

	public SocketHandler(final Socket socket){
	    this.socket = socket;
	}

        @Override
	public void run(){
	    MessageDigest sha1 = null;
	    try{
	        sha1 = MessageDigest.getInstance("SHA-1");
	    }catch(NoSuchAlgorithmException ex){
		ex.printStackTrace();
	        return;
	    }
	    try(
	        final InputStream socketInputStream  = socket.getInputStream();    
	        final OutputStream socketOutputStream = socket.getOutputStream();    
	        final BufferedReader socketReader     = new BufferedReader(new InputStreamReader(socketInputStream));
	        final BufferedWriter socketWriter    = new BufferedWriter(new OutputStreamWriter(socketOutputStream));
	    ){
		boolean handshakeCompleted = false;
		List<String> strings = new ArrayList<>(); 
		String line;
		StringBuilder requestString = new StringBuilder(100);
		byte[] request = new byte[1024];
		int c;
		while((c = socketInputStream.read()) != 1){
		    System.out.print(c);
		}
		List<String> headerList = Arrays.asList(requestString.toString().split("\r\r"));
		if(!headerList.isEmpty()){
		    String webSocketKey = headerList.stream().filter(str -> str.startsWith("Sec-WebSocket-Key")).findFirst().get().trim();
		    socketWriter.write("HTTP/1.1 101 Switching Protocols");
		    socketWriter.write("\r\n");
                    socketWriter.write("Upgrade: websocket");
		    socketWriter.write("\r\n");
                    socketWriter.write("Connection: Upgrade");
		    socketWriter.write("\r\n");
		    webSocketKey += magicKey;
		    sha1.reset();
		    sha1.update(webSocketKey.getBytes(ISO_8859_1));
		    webSocketKey = Base64.getEncoder().encodeToString(sha1.digest());
                    socketWriter.write("Sec-WebSocket-Accept:" + webSocketKey);
		    socketWriter.write("\r\n");
		    socketWriter.write("\r\n");
		    System.out.println("handshake completed");
		    socketWriter.flush();
		}
		line = null;
	        socketWriter.write("hello");
		socketWriter.write("\r\n");
		socketWriter.flush();
	    }catch(IOException ex){
	        ex.printStackTrace();
	    }
	}
    }
    public static void main(final String ... args) throws IOException{
	final SocketServer obj = new SocketServer();
        final ServerSocket server = new ServerSocket(9000, 10, InetAddress.getLoopbackAddress());
        
	while(true){
	    new Thread(obj.new SocketHandler(server.accept())).start();  
	}
    }
}
