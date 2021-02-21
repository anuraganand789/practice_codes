import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.net.Socket;
import java.net.ServerSocket;

public class Server{
    public static void main(final String[] args){
        
	try(ServerSocket   server   = new ServerSocket(Integer.parseInt(args[0]));
	    Socket         socket   = server.accept();
	    PrintWriter    out      = new PrintWriter(socket.getOutputStream(), true);
	    BufferedReader reader   = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	    PrintWriter    consoleWriter = new PrintWriter(System.out, true);
	   ){
	       String line;
	       while(!(line = reader.readLine()).equals("bye")){
		   out.println(line);
		   consoleWriter.printf("%100s.%n" , line);

	       }
	   }catch(Exception ext){
	       ext.printStackTrace();
	   }
    }
}
