package server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import ca.pfv.spmf.input.transaction_database_list_integers.TransactionDatabase;
import ca.pfv.spmf.algorithms.frequentpatterns.aprioriTIDClose.AlgoAprioriTIDClose;

public class ConnectionHandler extends Thread {
    private final Socket socket;
    private final File tempFile;
    private final int id;

    private double readRequest() throws IOException {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        final double minSupp = Double.parseDouble(reader.readLine());
        final BufferedWriter tempWriter = new BufferedWriter(new FileWriter(tempFile));
        String line = reader.readLine();
        while(line != null) {
            tempWriter.write(line);
            tempWriter.newLine();
            line = reader.readLine();
        }
        tempWriter.flush();
        tempWriter.close();
        socket.shutdownInput();
        return minSupp;
    }

    private void runAlgorithm(double minSupport) throws IOException {
        final TransactionDatabase database = new TransactionDatabase();
        final String pathName = tempFile.getCanonicalPath();
        database.loadFile(pathName);
        AlgoAprioriTIDClose alg = new AlgoAprioriTIDClose();
        alg.runAlgorithm(database, minSupport, pathName);
    }

    private void sendResponce() throws IOException {
        final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        final BufferedReader resultReader = new BufferedReader(new FileReader(tempFile));
        String line = resultReader.readLine();
        while(line != null) {
            writer.write(line);
            writer.newLine();
            line = resultReader.readLine();
        }
        resultReader.close();
        tempFile.delete();
        writer.flush();
        socket.shutdownOutput();
    }

    public ConnectionHandler(Socket socket, int id) throws IllegalArgumentException, IOException {
        this.socket = socket;
        this.tempFile = File.createTempFile("ConnectionHandler-" + Integer.toString(id), ".txt");
        this.id = id;
        System.out.println("Starting thread for id: " + id);
    }

    @Override
    public void run() {
        try {
            final double minSupport = readRequest();
            runAlgorithm(minSupport);
            sendResponce();
            socket.close();
            System.out.println("Thread with id: " + id + " successfully finished.");
        } catch(Exception e) {
            System.out.println("Exception in thread with id: " + id);
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}