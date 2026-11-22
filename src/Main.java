//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

public class Main {
    // throws IOException: sunucu açılamazsa hata fırlatabilir (konusu Faz 2)
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);  // 8080 portunu dinler

        // createContext: bu yola gelen istekleri bu koda yönlendirir. Spring'deki @GetMapping("/saglik") gibi.
        // exchange -> { ... } bir lambda (konusu Faz 4). Şimdilik hazır kalıp olarak kullan.
        server.createContext("/saglik", exchange -> {
            byte[] cevap = "UP".getBytes(StandardCharsets.UTF_8);
            exchange.sendResponseHeaders(200, cevap.length);   // durum kodu ve gövdenin byte cinsinden uzunluğu
            try (OutputStream os = exchange.getResponseBody()) {   // try-with-resources (Faz 2): akışı otomatik kapatır
                os.write(cevap);
            }
        });

        server.start();
        System.out.println("CuzdanLab 8080 portunda baslatildi");
    }