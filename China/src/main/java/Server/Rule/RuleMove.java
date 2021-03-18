package Server.Rule;

import Server.Board.LogicBoard;
import Server.DataBase;
import Server.Player;
import Server.ServerHead;

/**
 * abstract for all rules thining about fields
 */
public abstract class RuleMove extends Rule {

    protected int new_x;
    protected int new_y;
    protected LogicBoard board;

    RuleMove(ServerHead head) {
        super(head);
    }

    /**
     * to set about what board should rule think
     * @param board board to think
     */
    public void init(LogicBoard board){
        this.board = board;
    }


    /**
     * if player try to move and good data think can i done sth
     * @param player who done action
     * @param command what action
     * @return
     */
    @Override
    protected boolean check(Player player, String command){
        if (command.startsWith("MOVE")) {
            try {
                new_x = Integer.parseInt(command.substring(5).split(";")[0]);
                new_y = Integer.parseInt(command.substring(5).split(";")[1]);
                if (canDo(player)){
                    return true;
                }
            }catch (Exception e){
                head.newMessageWrite("BAD_DATA", player);
            }
        }
        return false;

    }

    /**
     * specifc thinnking about claiming for a rule
     * @param player who done sth
     * @return true if rule needs to stop chain
     */
    protected abstract boolean canDo(Player player);

    /**
     * simple cheecker move, wheren old field is white, new have players color
     */
    protected void doMove(){
        board.setFieldColor(new_x, new_y, head.currentPlayer.getColor());
        board.setFieldColor(head.currentX, head.currentY, "white");
        if(head.state == 1){
            DataBase.getInstance().saveToSql("CHANGE " + new_x + ";" + new_y + ";" + head.currentPlayer.getColor() + "|" + "CHANGE " + head.currentX + ";" + head.currentY + ";" + "white");

        }
        for (Player player: head.getPlayers()) {
            head.newMessageWrite("CHANGE " + new_x + ";" + new_y + ";" + head.currentPlayer.getColor(), player);
            head.newMessageWrite("CHANGE " + head.currentX + ";" + head.currentY + ";" + "white", player);
        }

        head.setCurrentX(new_x);
        head.setCurrentY(new_y);

        if(board.hasSbWon() != null) {
            for(Player player: head.getPlayers()){
                head.newMessageWrite("WON " + board.hasSbWon(), player);
            }
        }
    }

    /**
     * specific move where neeeds to swich fields color
     */
    protected void switchFields(){
        String tmpColor = board.getFieldColor(new_x, new_y);
        board.setFieldColor(head.currentX, head.currentY, board.getFieldColor(new_x, new_y));
        board.setFieldColor(new_x, new_y, head.currentPlayer.getColor());

        if(head.state == 1){
            DataBase.getInstance().saveToSql("CHANGE " + new_x + ";" + new_y + ";" + head.currentPlayer.getColor() + "|" + "CHANGE " + head.currentX + ";" + head.currentY + ";" + tmpColor);
        }

        for (Player player: head.getPlayers()) {
            head.newMessageWrite("CHANGE " + new_x + ";" + new_y + ";" + head.currentPlayer.getColor(), player);
            head.newMessageWrite("CHANGE " + head.currentX + ";" + head.currentY + ";" + tmpColor, player);
        }

        head.setCurrentX(new_x);
        head.setCurrentY(new_y);

        if(board.hasSbWon() != null) {
            for(Player player: head.getPlayers()){
                head.newMessageWrite("WON " + board.hasSbWon(), player);
            }
            head.stop();
        }
    }

    public LogicBoard getBoard(){
        return board;
    }

}
