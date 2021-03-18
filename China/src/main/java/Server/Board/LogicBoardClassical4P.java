package Server.Board;

/**
 * star board for 4 players
 */
public class LogicBoardClassical4P extends LogicBoardClassical {

    public LogicBoardClassical4P(){
        super();
        decoder(houseUpLeft, "yellow", "red");
        decoder(houseUpRight, "black", "blue");
        decoder(houseDownLeft, "blue", "black");
        decoder(houseDownRight, "red", "yellow");
    }

    /**
     * check winning statment for 4 players
     * @return true if sb win, else false
     */
    @Override
    public String hasSbWon() {
        if(checker(houseDownRight, "yellow", 10)){
            return "yellow";
        } else if(checker(houseUpLeft, "red", 10)){
            return "red";
        } else if(checker(houseUpRight, "blue", 10)){
            return "blue";
        } else if(checker(houseDownLeft, "black", 10)){
            return "black";
        }
        return null;
    }
}
