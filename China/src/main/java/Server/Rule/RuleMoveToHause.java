package Server.Rule;


import Server.Player;
import Server.ServerHead;

import static java.lang.Math.abs;

/**
 * rule anty-blocking-base
 */
public class RuleMoveToHause extends RuleMove{

    public RuleMoveToHause(ServerHead head) {
        super(head);
    }


    /**
     * when enemy block hause can swich cheeckers when close hause
     * @param player who done sth
     * @return true if cheeckers swiched
     */
    @Override
    protected boolean canDo(Player player) {
        System.out.println("Try " + this.getClass().getSimpleName());

        if(Math.abs(head.currentX-new_x) <=1 && Math.abs(head.currentY-new_y) <= 1 && board.getFieldHause(new_x, new_y).equals(player.getColor()) && !board.getFieldColor(new_x, new_y).equals("white") && !board.getFieldColor(new_x, new_y).equals(player.getColor())){
            System.out.println("Done " + this.getClass().getSimpleName());
            switchFields();
            head.nextPlayer();
            return true;
        }

        System.out.println("Failed " + this.getClass().getSimpleName());
        return false;
    }

}





