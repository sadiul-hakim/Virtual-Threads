//import com.sun.net.httpserver.HttpServer;
//import java.net.InetSocketAddress;
//import java.nio.charset.StandardCharsets;
//
//void main() throws IOException {
//    var port = Integer.parseInt(readln("Enter port number: "));
//    var httpServer = HttpServer.create(new InetSocketAddress(port),0);
//    var pingContext = httpServer.createContext("/ping");
//    pingContext.setHandler(exchange -> {
//        try {
//            byte[] bytes = "Pong".getBytes(StandardCharsets.UTF_8);
//            exchange.sendResponseHeaders(200, bytes.length);
//            exchange.getResponseHeaders().add("Content-Type", "text/plain");
//
//            var response = exchange.getResponseBody();
//            response.write(bytes);
//        } catch (IOException e) {
//
//            System.err.println("Error handling /ping request: " + e);
//            exchange.sendResponseHeaders(500, 0); // Respond with 500 on error
//        } finally {
//            exchange.close(); // Ensure resources are closed
//        }
//    });
//
//}