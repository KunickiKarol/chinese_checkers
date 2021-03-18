package Server;

import Server.Board.*;
import Server.Rule.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import static java.lang.Thread.sleep;

/**
 * gui to choose rulers
 */
public class Menu extends JFrame implements ActionListener{
	private ArrayList<String> commonAnswers = new ArrayList<>();
	JLabel rul, play, boar,shape,mov,loa;
	JCheckBox rules;
	JCheckBox player,player2,player3,player4;
	JCheckBox board1;
	JCheckBox shapes1,shapes2;
	JCheckBox move1;
	JCheckBox load1,load2,load3;
	JButton b;
	ServerHead game;

	Menu(ServerHead game){
		this.game = game;
		rul=new JLabel("Zasady:");
		rul.setBounds(40,100,100,20);
		rules=new JCheckBox("Podstawowy");
		rules.setBounds(200,100,150,20);
		
		play=new JLabel("Gracze:");
		play.setBounds(40,200,100,20);
		player=new JCheckBox("2");
		player.setBounds(200,200,150,20);
		player2=new JCheckBox("3");
		player2.setBounds(400,200,150,20);
		player3=new JCheckBox("4");
		player3.setBounds(600,200,150,20);
		player4=new JCheckBox("6");
		player4.setBounds(800,200,150,20);
		
		boar=new JLabel("Plansza:");
		boar.setBounds(40,300,100,20);
		board1=new JCheckBox("Classical");
		board1.setBounds(200,300,150,20);
		
		shape=new JLabel("Ksztalt pol:");
		shape.setBounds(40,400,100,20);
		shapes1=new JCheckBox("Kolo");
		shapes1.setBounds(200,400,150,20);
		shapes2=new JCheckBox("Prostokat");
		shapes2.setBounds(400,400,150,20);
		
		mov=new JLabel("Ruch:");
		mov.setBounds(40,500,100,20);
		move1=new JCheckBox("Ruchy podstawowe");
		move1.setBounds(200,500,150,20);
		
		loa = new JLabel("Wczytaj");
		loa.setBounds(40,600,100,20);
		load1=new JCheckBox("Tryb normalny");
		load1.setBounds(200,600,150,20);
		load2=new JCheckBox("Tryb nagrywania");
		load2.setBounds(400,600,150,20);
		load3=new JCheckBox("Tryb wczytwania");
		load3.setBounds(600,600,150,20);
		
		b=new JButton("Utworz");
		b.setBounds(500,700,80,30);
		b.addActionListener(this);
		
		add(rul);add(rules);
		add(play);add(player);add(player2);add(player3);add(player4);
		add(boar);add(board1);
		add(shape);add(shapes1);add(shapes2);
		add(mov);add(move1);
		add(loa);add(load1);add(load2);add(load3);
		add(b);
		
		setSize(1000,800);
		setLayout(null);
		setVisible(true);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}


	/**
	 * set rulers and check correctness
	 * @param e event
	 */
	public void actionPerformed(ActionEvent e){
		
		ArrayList<Rule> listRule = new ArrayList<>();
		int howManyPlayers = 0;
		ArrayList<LogicBoard> whatsBoard = new ArrayList<>();
		ArrayList<String> shape = new ArrayList<>();
		ArrayList<RuleMove> listMove = new ArrayList<>();
		int activ = -1;
		
		if(rules.isSelected()){
			listRule.add(new RuleSayHello(game));
			listRule.add(new RuleSBLeft(game));
			listRule.add(new RuleWaitForAll(game));
			listRule.add(new RuleOnlyCurrentPlayer(game));
		}
		
		if(player.isSelected()){
			howManyPlayers = 2;
		}
		if(player2.isSelected()){
			howManyPlayers = 3;
		}
		if(player3.isSelected()){
			howManyPlayers = 4;
		}
		if(player4.isSelected()){
			howManyPlayers = 6;;
		}
		
		if(board1.isSelected()){
			switch (howManyPlayers){
				case 2:
					whatsBoard.add(new LogicBoardClassical2P());
					break;
				case 3:
					whatsBoard.add(new LogicBoardClassical3P());
					break;
				case 4:
					whatsBoard.add(new LogicBoardClassical4P());
					break;
				case 6:
					whatsBoard.add(new LogicBoardClassical6P());
					break;
			}
		}
		
		if(shapes1.isSelected()){
			shape.add("Circle");
		}
		if(shapes2.isSelected()){
			shape.add("Rectangle");
		}
		
		if(move1.isSelected()){
			listMove.add(new RuleMoveNoActiveField(game));
			listMove.add(new RuleMoveSkipTurn(game));
			listMove.add(new RuleMoveSimpleWalk(game));
			listMove.add(new RuleMoveSimpleJump(game));
			listMove.add(new RuleMoveToHause(game));
		}
		
		if(load1.isSelected()){
			activ = 0;
		}
		if(load2.isSelected()){
			activ = 1;
		}
		if(load3.isSelected()){
			activ = 2;
		}

		
		switch(activ){
			case 1:
				game.state = 1;
				break;
			case 2:
					JPanel jPanel = new JPanel(new GridLayout(1,1));
					JLabel jLabel = new JLabel("Podaj ID gry:");
					JTextField jTextField = new JTextField();
					jPanel.add(jLabel);
					jPanel.add(jTextField);
					while(jTextField.getText().isEmpty()){
						try{
							JOptionPane.showMessageDialog(this, jPanel, "Logowanie", JOptionPane.PLAIN_MESSAGE );
							DataBase.getInstance().setGameID(Integer.parseInt(jTextField.getText()));
						}catch (NumberFormatException en){
							System.out.println("Bat data");
							System.exit(0);
						}
					}
					//****************************************************
				listMove.clear();
				listRule.clear();
				listRule.add(new RuleSayHello(game));
				listRule.add(new RuleReplay(game));
				listRule.add(new RuleSBLeft(game));
				game.state = 2;
				try {
					sleep(1000);
				} catch (InterruptedException interruptedException) {
					interruptedException.printStackTrace();
				}
				DataBase.getInstance().prepare();
				DataBase.getInstance().setter();
				listRule.addAll(listMove);
				LogicBoard tmp0 = null;
				int tmp1;
				String tmp2;
				if(DataBase.getInstance().dataArrayList.get(0).equals("LogicBoardClassical2P") ){
					tmp0 = new LogicBoardClassical2P();
				}else if(DataBase.getInstance().dataArrayList.get(0).equals("LogicBoardClassical3P") ){
					tmp0 = new LogicBoardClassical3P();
				}else if(DataBase.getInstance().dataArrayList.get(0).equals("LogicBoardClassical4P") ){
					tmp0 = new LogicBoardClassical4P();
				}else if(DataBase.getInstance().dataArrayList.get(0).equals("LogicBoardClassical6P") ){
					tmp0 = new LogicBoardClassical6P();
				}
				tmp1 = Integer.parseInt(DataBase.getInstance().dataArrayList.get(1));
				tmp2 = DataBase.getInstance().dataArrayList.get(2);

				dispose();
				SetUpServer.createNewGame(tmp0, tmp1, tmp2, listRule, listMove);
				break;
		}

		if(listRule.isEmpty()) System.exit(0);
		if(listMove.isEmpty()) System.exit(0);
		if(whatsBoard.size()!=1) System.exit(0);
		if(shape.size()!=1) System.exit(0);
		if(activ == -1) System.exit(0); // PAMIETAJ ZEBY ZAZNACZYC TO POLE

		listRule.addAll(listMove);
		dispose();
		SetUpServer.createNewGame(whatsBoard.get(0), howManyPlayers, shape.get(0), listRule, listMove); // DODAJ SOBIE DO SERWERA
		//ZMIENA ACTIVE 0,1,2            gdy zmienna == -1 program sie wylaczy
	}
}
