package Server.Rule;

import Server.Player;
import Server.ServerHead;

/**
 * rule when sb try to clic but not a current
 */
public class RuleOnlyCurrentPlayer extends Rule {


    public RuleOnlyCurrentPlayer(ServerHead head) {
        super(head);
    }

    /**
     * rule when sb try to clic but not a current
     * @param player who done action
     * @param command what action
     * @return true if player not current
     */
    @Override
    protected boolean check(Player player, String command) {
        System.out.println("Try " + this.getClass().getSimpleName());
        if (!head.currentPlayer.equals(player)) {
            System.out.println("Done " + this.getClass().getSimpleName());
            head.newMessageWrite("NOT_YOU", player);
            return true;
        }
        return false;
    }
}
