package Server.Rule;

import Server.Player;
import Server.ServerHead;

import static java.lang.Math.abs;

/**
 * checking players wants to move to close field
 */
public class RuleMoveSimpleWalk extends RuleMove{

    public RuleMoveSimpleWalk(ServerHead head) {
        super(head);
    }


    /**
     * if clicked field is next to current active field
     * @param player who done sth
     * @return true if fields are close
     */
    @Override
    protected boolean canDo(Player player) {
        System.out.println("Try " + this.getClass().getSimpleName());
        if(board.getFieldColor(new_x, new_y).equals("white")){
            if(head.getCurrentX() % 2 == 0){
                if(new_x == head.getCurrentX()){
                    if(Math.abs(head.getCurrentY()-new_y) == 1){
                        System.out.println("Done " + this.getClass().getSimpleName());
                        doMove();
                        head.nextPlayer();
                        return true;
                    }
                }else if(head.getCurrentX()-new_x == 1 && (head.getCurrentY()-new_y == 0 || head.getCurrentY()-new_y == -1 )){
                        System.out.println("Done " + this.getClass().getSimpleName());
                        doMove();
                        head.nextPlayer();
                        return true;
                }else if(head.getCurrentX()-new_x == -1 && (head.getCurrentY()-new_y == 0 || head.getCurrentY()-new_y == -1 )){
                        System.out.println("Done " + this.getClass().getSimpleName());
                        doMove();
                        head.nextPlayer();
                        return true;
                }
            }else {
                if(new_x == head.getCurrentX()){
                    if(Math.abs(head.getCurrentY()-new_y) == 1){
                        System.out.println("Done " + this.getClass().getSimpleName());
                        doMove();
                        head.nextPlayer();
                        return true;
                    }
                }else if(head.getCurrentX()-new_x == 1 && (head.getCurrentY()-new_y == 0 || head.getCurrentY()-new_y == 1 )){
                    System.out.println("Done " + this.getClass().getSimpleName());
                    doMove();
                    head.nextPlayer();
                    return true;
                }else if(head.getCurrentX()-new_x == -1 && (head.getCurrentY()-new_y == 0 || head.getCurrentY()-new_y == 1 )){
                    System.out.println("Done " + this.getClass().getSimpleName());
                    doMove();
                    head.nextPlayer();
                    return true;
                }
            }
        }

        System.out.println("Failed " + this.getClass().getSimpleName());
        return false;
        }
}





