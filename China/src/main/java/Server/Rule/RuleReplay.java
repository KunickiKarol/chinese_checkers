package Server.Rule;

import Server.DataBase;
import Server.Player;
import Server.ServerHead;

public class RuleReplay extends Rule {
    public RuleReplay(ServerHead head) {
        super(head);
    }
    @Override
    protected boolean check(Player player, String command) {
        if(command.startsWith("MOVE -1;-1")){
            String tmp = DataBase.getInstance().backMove();
            if(tmp.equals("None")) {
                head.newMessageWrite("BEGIN" ,player);
                return true;
            }
            String[] a = tmp.split("\\|");
            String[] b= a[0].split("\\;");
            String[] c= a[1].split("\\;");
            for(Player plr: head.players){
                head.newMessageWrite(b[0] + ";" + b[1] + ";" + c[2] ,player);
                head.newMessageWrite(c[0] + ";" + c[1] + ";" + b[2] ,player);
            }
        }else if(command.startsWith("MOVE 1;1")){
            String tmp = DataBase.getInstance().nextMove();
            if(tmp.equals("None")) {
                head.newMessageWrite("END" ,player);
                return true;
            }
            for (String order: tmp.split("\\|")){
                for(Player plr: head.players){
                    head.newMessageWrite(order ,plr);
                }

            }
        }
        return true;
    }
}
