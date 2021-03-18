package Client;

import Client.Frame.GUI;

/**
 * Klasa Client uczestniczy w komunikacji z serwerem
 * GUI gui - klasa GUI
 * ClientPostman postman -
 */
public class Client {
    
    private GUI gui;
    private final ClientPostman postman;
    
    /**
     * Metoda wysyla
     * @param serverAddress adres Sewera
     * @throws OutOfMemoryError
     */
    public Client(String serverAddress) throws Exception {
        postman = new ClientPostman(serverAddress, this);
        postman.takeWelcomeMessage();
        postman.waitForNewMessage();
    }
    
    
    /**
     * Metoda przekazue odpowiedz serwera
     * @param response - odpowiedz serwera
     */
    public void getResponse(String response) {
        String[] tmp;
        System.out.println("FROM SERVER: " + response);
        
        if (response.equals("WAIT_FOR_ALL")) {
            
            gui.waitForMove(); // Zaczekaj na wszytskich graczy
        } else if (response.equals("NOT_YOU")) {
            gui.notYou(); // Nie twoja Tura
        } else if (response.equals("SB_LEFT")) {
            gui.left(); // Ktos wyszedl
        } else if (response.startsWith("WON")) {
            gui.winner(); // Wygrana
        } else if (response.startsWith("NOT_YOUR")) {
            gui.notChecker(); // Nie twoj Pionek
        }
        else if (response.startsWith("LOOKING")) {
            gui.changeButton(); //uruchamia tryb
        } else if (response.startsWith("CHANGE")) {
            tmp = response.substring(7).split(";");
            try {
                gui.change(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]), tmp[2]); // Zmien konkretny pionek na dany kolor
            } catch (Exception e) {
                System.out.println("BAD_DATA");
            }
        } else if (response.startsWith("ACTIVE")) {
            tmp = response.substring(7).split(";");
            try {
                gui.change(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]), "orange"); // Pionek jest aktywny
            } catch (Exception e) {
                System.out.println("BAD_DATA");
            }
        } else if (response.startsWith("NOW")) {
            tmp = response.substring(3).split(" ");
            gui.changePlayer(tmp[1]); // Czyja tura
        }
        
    }
    
    /**
     * Przeslij wiadomosc do serwera
     * @param message - informacja od GUI
     */
    public void writeMessage(String message){
        postman.sendMessage(message);
    }
    
    /**
     * Metoda tworzy GUI
     * @param responseSetUP - Setup
     * @return - true/false
     */
    public boolean WelcomeMassageRead(String responseSetUP) {
        if (responseSetUP.startsWith("HELLO")) {
            String[] tmp = responseSetUP.substring(6).split(";");
            System.out.println(tmp[0]+  tmp[1] + tmp[2] + tmp[3]);
            gui = new GUI("Classical", tmp[1], tmp[2], tmp[3], this);
            return true;
        }
        return false;
    }
}