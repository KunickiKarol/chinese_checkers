package Server.Board;

/**
 * star board for 2 players
 */
public class LogicBoardClassical2P extends LogicBoardClassical {

    public LogicBoardClassical2P(){
        super();
        decoder(houseUp, "red", "yellow");
        decoder(houseDown, "yellow", "red");
    }

    /**
     * check winning statment for 2 players
     * @return true if sb win, else false
     */
    @Override
    public String hasSbWon() {
        if(checker(houseUp, "yellow", 10)){
            return "yellow";
        } else if(checker(houseDown, "red", 10)){
            return "red";
        }
        return null;
    }
}
