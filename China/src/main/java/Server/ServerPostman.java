package Server;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.Executors;

/**
 * listener on socket for new players
 */
public class ServerPostman {


    static ServerSocket listener;
    /**
     * listen on socket for new players
     * @param amountPlayers how many should be welcomed
     * @param head whats server wants to talk
     * @throws Exception if sth wrong
     * in while strange condition to run only on tests, where hard to stop
     */
    public static void start( int amountPlayers, ServerHead head) {

        try {
            listener = new ServerSocket(58901);
        } catch (IOException e) {
            System.out.println("Zajete");
            System.exit(-1);
        }
        System.out.println("Cheese Cheeckers Server is Running...");
            var pool = Executors.newFixedThreadPool(200);

            while (amountPlayers>0) {
                for(int x = 0; x<amountPlayers; x++){

                    try {
                        if(head.players.size() < amountPlayers) {
                            pool.execute(head.newPlayer(listener.accept()));
                        }
                    } catch (IOException e) {
                        System.out.println("Zabawa skonczona");
                        try {
                            stop();
                        } catch (Exception exception) {
                            exception.printStackTrace();
                        }
                        System.exit(0);
                    }

                }
            }
    }

    public static void stop() throws Exception {
        listener.close();
    }
}
