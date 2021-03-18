package Server.Rule;

import Server.Player;
import Server.ServerHead;

/**
 * checking server know whats to move
 */
public class RuleMoveNoActiveField extends RuleMove {

    public RuleMoveNoActiveField(ServerHead head) {
        super(head);
    }

    /**
     * checking server know whats to move
     * @param player who done sth
     * @return true if theres no active field
     */
    @Override
    protected boolean canDo(Player player) {
        System.out.println("Try " + this.getClass().getSimpleName());
        if (head.getCurrentX() == -1 && head.getCurrentY() == -1) {
            if(isActivePlayerCheecker(player)){
                return true;
            } else if (board.getFieldColor(new_x, new_y) == "white"){
                System.out.println("Done " + "Cliced white without active");
            } else {
                System.out.println("Done " + this.getClass().getSimpleName());
                head.setCurrentX(new_x);
                head.setCurrentY(new_y);
                head.newMessageWrite("ACTIVE " + head.getCurrentX() + ";" + head.getCurrentY(), player);
            }
            return true;
        }
        return false;
    }
    /**
     * to make sure player whats to do correct move
     * @param player
     * @return
     */
    private boolean isActivePlayerCheecker(Player player) {

        if(head.currentX == -1 && board.getFieldColor(new_x, new_y) != player.getColor() && board.getFieldColor(new_x, new_y) != "white"){
            head.newMessageWrite("NOT_YOUR_CHECKER", player);
            return true;
        }
        return false;
    }
}
