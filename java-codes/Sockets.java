import java .io  .BufferedReader;
import java .io  .InputStreamReader;
import java .io  .OutputStreamWriter;
import java .io  .PrintWriter;

import java .net .Socket;

public class Sockets{
    public static void main(final String[] args){
        final String hostName = args[0];
	int portNumber = Integer.parseInt(args[1]);

	try(
	       Socket         socket         = new Socket(hostName, portNumber);
	       PrintWriter    socketWriter   = new PrintWriter(socket.getOutputStream(), true);
	       BufferedReader socketReader   = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	       BufferedReader consoleReader  = new BufferedReader(new InputStreamReader(System.in));
	       PrintWriter    consoleWriter  = new PrintWriter(System.out, true);
	   ){

	       String inputLine;
	       while((inputLine = consoleReader.readLine()) != null){
	           socketWriter.println(inputLine);
		   consoleWriter.printf("%100s.%n", socketReader.readLine());
	       }

	}catch(Exception ex){
	    ex.printStackTrace();
	}
    }
}
