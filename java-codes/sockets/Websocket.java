import java.net.http.WebSocket;
import java.net.http.HttpClient;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.ProxySelector;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public class Websocket{
        static WebSocket.Listener listener = new WebSocket.Listener() {

            List<CharSequence> parts = new ArrayList<>();
            CompletableFuture<?> accumulatedMessage = new CompletableFuture<>();

            public CompletionStage<?> onText(WebSocket webSocket,
                                             CharSequence message,
                                             boolean last) {
                parts.add(message);
		System.out.println("message ");
                webSocket.request(1);
                if (last) {
                    //processWholeText(parts);
                    parts = new ArrayList<>();
                    accumulatedMessage.complete(null);
                    CompletionStage<?> cf = accumulatedMessage;
                    accumulatedMessage = new CompletableFuture<>();
                    return cf;
                }
                return accumulatedMessage;
            }
        };
    public static void main(final String ... args) throws URISyntaxException{
	final String host  = "localhost";
	final int port = 9000;
	final URI uri = new URI("ws://"+ host + ":" + port);
	InetSocketAddress addr = new InetSocketAddress(host, port);
	WebSocket webSocket = HttpClient.newHttpClient()
	                                .newWebSocketBuilder()
                                        .buildAsync(uri,listener)
                                        .join();

	//ByteBuffer data = ByteBuffer.allocate(125);
	webSocket.abort();

    }
}
