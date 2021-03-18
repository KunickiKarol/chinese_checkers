package Server.Rule;

import Server.Player;
import Server.ServerHead;

import static java.lang.Math.abs;

/**
 * if players wants to jump above sb's cheecker
 */
public class RuleMoveSimpleJump extends RuleMove{


    public RuleMoveSimpleJump(ServerHead head) {
        super(head);
    }

    /**
     * checking if is sb's cheecker in concerete field
     * @param closeToCheck
     * @return
     */
    private boolean isBeetwen(int closeToCheck){
        for(String color: head.colors){
            if(color.equals(board.getFieldColor(head.getCurrentX()-(head.getCurrentX()-new_x)/2,closeToCheck))){
                System.out.println("Done " + this.getClass().getSimpleName());
                doMove();
                return true;
            }
        }
        System.out.println("Failed " + this.getClass().getSimpleName());
        return false;
    }

    /**
     * magic checking is good field clicked
     * @param player who done sth
     * @return true if good field clicked
     */
    @Override
    protected boolean canDo(Player player) {
        System.out.println("Try " + this.getClass().getSimpleName());

        if(board.getFieldColor(new_x, new_y).equals("white")){
            if(head.getCurrentX() % 2 == 0){
                if(new_x == head.getCurrentX()) {
                    if (head.getCurrentY() - new_y == 2) {
                        return isBeetwen(head.getCurrentY() - 1);
                    } else if (head.getCurrentY() - new_y == -2) {
                        return isBeetwen(head.getCurrentY() + 1);
                    }
                } else if (head.getCurrentX() - new_x == 2 || head.getCurrentX() - new_x == -2) {
                    if(head.getCurrentY() - new_y == 1){
                        return isBeetwen(head.getCurrentY());
                    }else if(head.getCurrentY() - new_y == -1){
                        return isBeetwen(head.getCurrentY()+1);
                    }
                }
            } else {
                if(new_x == head.getCurrentX()) {
                    if (head.getCurrentY() - new_y == 2) {
                        return isBeetwen(head.getCurrentY() );
                    } else if (head.getCurrentY() - new_y == -2) {
                        return isBeetwen(head.getCurrentY());
                    }
                } else if (head.getCurrentX() - new_x == 2 || head.getCurrentX() - new_x == -2) {
                    if (head.getCurrentY() - new_y == 1) {
                        return isBeetwen(head.getCurrentY() - 1);
                    } else if (head.getCurrentY() - new_y == -1) {
                        return isBeetwen(head.getCurrentY());
                    }
                }
            }
        }
        System.out.println("Failed " + this.getClass().getSimpleName());
        return false;
    }
}



