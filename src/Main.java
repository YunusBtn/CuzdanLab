//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        server.createContext("/saglik", exchange -> {
            byte[] cevap = "UP".getBytes(StandardCharsets.UTF_8);
            exchange.sendResponseHeaders(200, cevap.length);
            try (OutputStream os = exchange.getResponseBody()) {   
                os.write(cevap);
            }
        });

        server.start();
        System.out.println("CuzdanLab 8080 portunda baslatildi");
    }
}