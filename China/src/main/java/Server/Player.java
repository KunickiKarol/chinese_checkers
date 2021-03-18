package Server;


import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * all info about players, sockets start, communication etc
 */
public class Player implements Runnable {
    private Socket socket;
    private String color;
    private ServerHead head;

    private Scanner input;
    private PrintWriter output;

    public Player(Socket socket, String color, ServerHead head) {
        this.socket = socket;
        this.color = color;
        this.head = head;
    }

    /**
     * when client starts exitng done this
     */
    @Override
    public void run() {
        try {
            setup();
            listenClient();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            head.newMessageRead(this, "LEFT");
            try {
                socket.close();
            } catch (IOException e) {
            }
        }
    }

    /**
     * cannals to communicat and say hello
     * @throws IOException
     */
    public void setup() throws IOException {
        input = new Scanner(socket.getInputStream());
        output = new PrintWriter(socket.getOutputStream(), true);
        output.println("WELCOME " + color);
    }

    /**
     * always wait for new message
     */
    private void listenClient() {
        while (input.hasNextLine()) {
            var command = input.nextLine();
            head.newMessageRead(this, command);
        }
    }

    /**
     * send message to client whom is a player
     * @param message message to deliver
     */
    public void sendMessage(String message){
        output.println(message);
    }

    /**
     * players color getter
     * @return players color
     */
    public String getColor() {
        return color;
    }

}
