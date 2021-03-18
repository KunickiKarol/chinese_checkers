package Server.Board;

/**
 * star board for 3 players
 */
public class LogicBoardClassical3P extends LogicBoardClassical {

    public LogicBoardClassical3P(){
        super();
        decoder(houseUp, "red", null);
        decoder(houseDownLeft, "yellow", null);
        decoder(houseDownRight, "blue", null);
        decoder(houseUpLeft, "white", "blue");
        decoder(houseUpRight, "white", "yellow");
        decoder(houseDown, "white", "red");
    }
    /**
     * check winning statment for 3 players
     * @return true if sb win, else false
     */
    @Override
    public String hasSbWon() {
        if(checker(houseUpRight, "yellow", 10)){
            return "yellow";
        } else if(checker(houseDown, "red", 10)){
            return "red";
        } else if(checker(houseUpLeft, "blue", 10)){
            return "blue";
        }
        return null;
    }
}
