package server;

import java.io.Closeable;
import java.io.IOException;
import java.net.ServerSocket;

public class Server implements Closeable {
    private static final int port = 9087;

    private final ServerSocket serverSocket;

    public Server() throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public ConnectionHandler acceptConnection(int id) throws IOException {
        return new ConnectionHandler(serverSocket.accept(), id);
    }

    @Override
    public void close() throws IOException {
        serverSocket.close();
    }
}