package Server;

import Server.Board.LogicBoard;
import Server.Rule.Rule;
import Server.Rule.RuleMove;

import java.util.ArrayList;

/**
 * allow to set game setting, prepare settings and open server for game
 *
 */
public class SetUpServer {

	private static ServerHead game = new ServerHead();
	public static void createNewGame(LogicBoard board, int howManyPlayers, String shape, ArrayList<Rule> listRule, ArrayList<RuleMove> listMove){
		
		if(game.state==1) DataBase.getInstance().createSQl(board.getClass().getSimpleName(),howManyPlayers,shape);
		for(RuleMove ruleMove: listMove){
			ruleMove.init(board);
		}

		try {
			game.start(board, howManyPlayers, listRule, shape);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public static void openMenuWindow(){
		new Menu(game);
	}
}
