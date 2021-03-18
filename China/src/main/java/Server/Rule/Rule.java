package Server.Rule;

import Server.Player;
import Server.ServerHead;

/**
 *
 */
public abstract class Rule {
    protected ServerHead head;
    protected Rule nextRule;
    Rule(ServerHead head) {
        this.head = head;
    }

    /**
     * checking rule is good for concret action
     * @param player who done sth
     * @param command what he said
     * @return true needs to stop
     */
     public boolean tryCheck(Player player, String command){
        if (head.bannedRules.contains(this)){
            return nextRule.tryCheck(player, command);
        }
        if(check(player, command)){
            return true;
        }else{
            if(nextRule != null) {
                return nextRule.tryCheck(player, command);
            }else{
                return false;
            }
        }
    }

    /**
     * specific whats action rule can claim
     * @param player who done action
     * @param command what action
     * @return true if rule whats to stop chain
     */
    protected abstract boolean check(Player player, String command);

    /**
     * set nesxt Rule
     * @param nextRule next rule in chain
     */
    public void setNextRule(Rule nextRule){
        this.nextRule = nextRule;
    }

    public Rule getNextRule(){
        return nextRule;
    }
}
