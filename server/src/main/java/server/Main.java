package server;

public final class Main {
    private Main() {

    }

    public static void main(String[] args) {
        try(final Server server = new Server()) {
            System.out.println("Server started");
            while(true) {
                for(int id = Integer.MIN_VALUE; id < Integer.MAX_VALUE; ++id) {
                    final ConnectionHandler handler = server.acceptConnection(id);
                    handler.start();
                }
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
