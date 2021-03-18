package Client.Frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Draw dziedzi po JFrame
 * Drawspace panel - obiekt JPanel
 * createTables - wszystkie komendy (tablice int z info o domkach oraz polach neutralnych)
 * button2 - pokazuje kogo tura za pomoca koloru
 * Height - dlugosc
 * Width - szerokosc
 * sizeBoard - wszytskie Pola na planszy
 * filedOfCommand - ilosc komend tworzacych pola neutralne (biale)
 */
public class Draw extends JFrame implements ActionListener {
	private final DrawSpace panel;
	private final ArrayList<int[]> createTables = new ArrayList<>();
	private final JButton button = new JButton();
	private final JButton button2 = new JButton();
	private final JLabel writing = new JLabel("Gracz:");
	private final JLabel turn = new JLabel("Tura:");
	private int Height;
	private int Width;
	private Land[][] sizeBoard;
	private int filedOfCommand = 0;
	private GUI gui;
	private enum Actions{
		Push,Back
	}
	/**
	 * Konstruktor ramki tworzy ramke i dodaje do niej wlasciwosci
	 *
	 * @param boardName     - nazwa planszy
	 * @param typeOfFigures - typ pol (figura)
	 * @param myColor       - kolor gracza
	 * @param Players       - ilosc graczy
	 * @param gui           - obiekt GUI
	 */
	public Draw(String boardName, String typeOfFigures, String myColor, int Players, GUI gui) {
		
		setSizes(); // ustawiam rozmiar ramki
		prepareData(boardName, typeOfFigures); // ustawiam typ planszy oraz typ pol (figura)
		this.gui=gui;
		
		setLocationByPlatform(true);
		setResizable(true);
		setTitle("Plansza");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ustawienia ramki
		
		
		panel = new DrawSpace(this.sizeBoard, this.createTables, Players, filedOfCommand, gui);
		panel.setBackground(Color.WHITE); // tworzy panel
		
		button.setBackground(panel.colorDecoder(myColor));
		button.setBounds(Width, Height, Width, Height);
		button.setOpaque(true);
		
		writing.setBounds(Width, Height, 50, 20); // Umożliwia pokazanie koloru gracza
		
		button2.setBackground(panel.colorDecoder("red"));
		button2.setBounds(Width, Height, Width, Height);
		button2.setOpaque(true);
		turn.setBounds(Width, Height, 50, 20); // Umożliwia pokazanie czyja jest tura
		
		panel.add(writing);
		panel.add(button);
		panel.add(turn);
		panel.add(button2); //Dodaje wszytskie napisy
		add(panel, BorderLayout.CENTER); // Dodaje panel
	}
	
	
	/**
	 * Ustawiam rozmiar ramki
	 * zmienne przypisuje do
	 * Height i Width
	 */
	private void setSizes() {
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		this.Height = (3 * screenSize.height / 4);
		this.Width = (3 * screenSize.width / 4);
		setSize(Width, Height);
	}
	
	
	/**
	 * Pobieram gotowe juz pola z CreateBoard
	 * uzupelniam polami o konkretnej figurze
	 *
	 * @param boardName     - nazwa planszy
	 * @param typeOfFigures - typ pol (figury / ksztalt)
	 * nastepnie pobieram informacje o domkach i polach neutralnych
	 */
	private void prepareData(String boardName, String typeOfFigures) {
		
		this.sizeBoard = CreateBoard.boardProperties(boardName).giveSize();
		this.sizeBoard = fillArray(typeOfFigures);
		
		this.createTables.addAll(SetBoardShape.returnBoardShape(boardName).returnTables()); // Pola neutralne
		filedOfCommand = this.createTables.size();
		this.createTables.addAll(CreateBoard.boardProperties(boardName).giveHouses()); // Domki
	}
	
	/**
	 * Na podstawie typy tworze pole o danych wlasciwosciach
	 * @param type - typ figury
	 * @return zwracam gotowe figury
	 */
	private Land[][] fillArray(String type){
		for (int i = 0; i < sizeBoard.length; i++) {
			for (int j = 0; j < sizeBoard[i].length; j++) {
				if ((i + 1) % 2 == 0)
					sizeBoard[i][j] = SetShapes.returnShape(type, (float) Width / 7 + (float) j * Width / 19, (float) Height / 20 + (float) i * Height / 20, (float) Width / 21, (float) Height / 20);
				else
					sizeBoard[i][j] = SetShapes.returnShape(type, (float) (Width / 6) + (float) j * Width / 19, (float) Height / 20 + (float) i * Height / 20, (float) Width / 21, (float) Height / 20);
			}
		}
		return sizeBoard;
	}
	
	/**
	 * Zmieniam rozmiar ramki
	 * w wyniku czego zmieniam rozmiar Pol
	 */
	public void changeSizeFrame(){
		this.Height = getHeight();
		this.Width = getWidth();
		for (int i = 0; i < sizeBoard.length; i++) {
			for (int j = 0; j < sizeBoard[i].length; j++) {
				if ((i + 1) % 2 == 0)
					sizeBoard[i][j].changeShape((float) Width / 7 + (float) j * Width / 19, (float) Height / 20 + (float) i * Height / 20, (float) Width / 21, (float) Height / 20);
				else
					sizeBoard[i][j].changeShape((float) (Width / 6) + (float) j * Width / 19, (float) Height / 20 + (float) i * Height / 20, (float) Width / 21, (float) Height / 20);
			}
		}
		
	}
	
	/**
	 * Przesylam informacje do Panelu aby zmienil dane Pole (jego kolor)
	 * @param x - wspolrzedna X
	 * @param y - wspolrzedna Y
	 * @param color - nazwa koloru
	 */
	public void change(int x, int y, String color){
		panel.change(x, y, color);
	}
	
	/**
	 * Zmieniam kolor w turach
	 * @param color - nazwa koloru
	 */
	public void changePlayer(String color){
		button2.setBackground(panel.colorDecoder(color));
	}
	
	public void changeButtons(){
		writing.setText("Powrot");
		turn.setText("Naprzod");
		button.setBackground(panel.colorDecoder("white"));
		button2.setBackground(panel.colorDecoder("white"));
		button.setActionCommand(Actions.Back.name());
		button.addActionListener(this);
		button2.setActionCommand(Actions.Push.name());
		button2.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals(Actions.Push.name())){
			gui.sendInfo(1,1);
		}
		else{
			gui.sendInfo(-1,-1);
		}
	}
}
