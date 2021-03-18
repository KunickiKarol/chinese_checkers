package Server.Rule;

import Server.Player;
import Server.ServerHead;

/**
 * if active palyers clicked second time on active cheeceker skip his turn
 */
public class RuleMoveSkipTurn extends RuleMove {


    public RuleMoveSkipTurn(ServerHead head) {
        super(head);
    }

    /**
     * if active palyers clicked second time on active cheeceker skip his turn
     * @param player who done sth
     * @return true if players wants to skip
     */
    @Override
    protected boolean canDo(Player player) {
        System.out.println("Try " + this.getClass().getSimpleName());
        if(head.getCurrentX() == new_x && new_y == head.getCurrentY()){
            System.out.println("Done " + this.getClass().getSimpleName());
            head.newMessageWrite("CHANGE " + head.currentX + ";" + head.currentY + ";" + head.currentPlayer.getColor(), player);
            head.nextPlayer();
            head.setCurrentX(-1);
            head.setCurrentY(-1);
            return true;
        }
        return false;
    }
}
