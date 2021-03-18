package Client;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientPostman {

    private final Socket socket;
    private final Scanner in;
    private final PrintWriter out;
    private final Client client;

    public ClientPostman(String serverAddress, Client client) throws Exception {

        socket = new Socket(serverAddress, 58901);
        in = new Scanner(socket.getInputStream());
        out = new PrintWriter(socket.getOutputStream(), true);
        this.client = client;
    }

    public void takeWelcomeMessage() throws Exception {
        try {
            var responseSetUP = in.nextLine();
            out.println("WAITING");
            while (in.hasNextLine()) {
                responseSetUP = in.nextLine();
                System.out.println(responseSetUP);
                if(client.WelcomeMassageRead(responseSetUP)){
                    break;
                }
                }
            } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitForNewMessage() throws Exception {

        try {

            while (in.hasNextLine()) {
                var response = in.nextLine();
                client.getResponse(response);
            }
            out.println("QUIT");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            socket.close();

        }
    }
    
    /**
     * Wyslij wiadomosc do sewera
     * @param message - message
     */
    public void sendMessage(String message){
        System.out.println("TO SERVER: " + message);
        out.println(message);
    }

}
