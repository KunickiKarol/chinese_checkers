package Server.Rule;

import Server.Player;
import Server.ServerHead;

/**
 * if sb left game say to everybody
 */
public class RuleSBLeft extends Rule {
    public RuleSBLeft(ServerHead head) {
        super(head);
    }

    /**
     * if sb left game say to everybody
     * @param player who done action
     * @param command what action
     * @return true if sb left
     */
    @Override
    protected boolean check(Player player, String command) {
        System.out.println("Try " + this.getClass().getSimpleName());
        if (command.startsWith("LEFT")){
            System.out.println("Done " + this.getClass().getSimpleName());
            for (Player x : head.players){
                head.newMessageWrite("SB_LEFT", x);

            }
            head.stop();
            return true;
        }
        return false;
    }
}
