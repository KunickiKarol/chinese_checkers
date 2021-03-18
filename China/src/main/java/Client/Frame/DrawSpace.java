package Client.Frame;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Klasa DrawSpace dziedziczy po JPanel
 * lands - wszystkie pola na planszy (maja juz podany rozmiar i ksztalt)
 * createTables - wszystkie komendy (tablice int z info o domkach oraz polach neutralnych)
 * Players - ilosc graczy
 * sizeOfFieldCommands - ilsoc kommend tworzacych pola neutralne
 * GUI gui - obiekt GUI
 * array - tablica int[]
 */
public class DrawSpace extends JPanel {
	
	private final Land[][] lands ;
	private final ArrayList<int[]> createTables;
	private final int Players;
	private final int sizeOfFieldCommands;
	private final GUI gui;
	private int[] array;
	
	/**
	 * Konstruktor pobiera dane od ramki
	 * @param lands - Pola na planszy
	 * @param Poles - zbior tablic int (zarowno domkow i jak i pol neuralnyhc)
	 * @param Players - ilsoc graczy
	 * @param sizeFieldCommand - ilosc tablic int opisujacych pola neutralne
	 * @param gui - GUI gui
	 */
	public DrawSpace(Land[][] lands, ArrayList<int[]> Poles, int Players, int sizeFieldCommand, GUI gui) {
		this.gui = gui;
		this.lands = lands;
		this.createTables = Poles;
		this.sizeOfFieldCommands = sizeFieldCommand;
		this.Players = Players;
		setColor(); // ustawiam kolory dla domkow
		this.addMouseListener(new MyMouseAdapter (lands,this)); //dodaje MouseListener do panelu
	}
	
	/**
	 * Rysuje component
	 * @param g Graphics
	 */
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawing(g);
	}
	
	/**
	 * Maluje plansze
	 * @param g Graphics
	 */
	private void drawing(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setStroke(new BasicStroke(2));
		
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.50f));
		
		for (int[] createTable : createTables) {
			array = createTable;
			
			if (array[0] == 1) {
				for (int h = 3; h <= array.length - 1; h = h + 2) {
					for (int i = array[h]; i < array[2]; i++) {
						
						g2.setPaint(lands[i][array[h + 1]].getColor());
						g2.fill(lands[i][array[h + 1]]);
						g2.setPaint(Color.RED);
						g2.draw(lands[i][array[h + 1]]);
					}
					
				}
			} else {
				for (int h = 3; h <= array.length - 1; h = h + 2) {
					for (int i = array[h]; i >= array[2]; i--) {
						
						g2.setPaint(lands[i][array[h + 1]].getColor());
						g2.fill(lands[i][array[h + 1]]);
						g2.setPaint(Color.RED);
						g2.draw(lands[i][array[h + 1]]);
					}
				}
			}
		}
	}
	
	/**
	 * Ustawia kolory domkow w zależności od ilosci graczy
	 */
	void setColor(){
		ArrayList<Color> colors = new ArrayList<>();
		ArrayList<int[]> houses = new ArrayList<>();
		int number=0;
		colors.add(Color.RED);
		colors.add(Color.YELLOW);
		colors.add(Color.BLUE);
		colors.add(Color.BLACK);
		colors.add(Color.PINK);
		colors.add(Color.GREEN);
		
		if(Players==2){
			houses.add(createTables.get(sizeOfFieldCommands));
			houses.add(createTables.get(sizeOfFieldCommands +1));
		}
		else if(Players==3){
			houses.add(createTables.get(sizeOfFieldCommands));
			houses.add(createTables.get(sizeOfFieldCommands +4));
			houses.add(createTables.get(sizeOfFieldCommands +5));
		}
		else if(Players==4){
			houses.add(createTables.get(sizeOfFieldCommands +5));
			houses.add(createTables.get(sizeOfFieldCommands +2));
			houses.add(createTables.get(sizeOfFieldCommands +4));
			houses.add(createTables.get(sizeOfFieldCommands +3));
		}
		else{
			houses.add(createTables.get(sizeOfFieldCommands +5));
			houses.add(createTables.get(sizeOfFieldCommands +2));
			houses.add(createTables.get(sizeOfFieldCommands +4));
			houses.add(createTables.get(sizeOfFieldCommands +3));
			houses.add(createTables.get(sizeOfFieldCommands));
			houses.add(createTables.get(sizeOfFieldCommands +1));
		}
		
		for (int[] house : houses) {
			array = house;
			
			if (array[0] == 1) {
				for (int h = 3; h <= array.length - 1; h = h + 2) {
					for (int i = array[h]; i < array[2]; i++) {
						lands[i][array[h + 1]].setColor(colors.get(number));
					}
				}
			} else {
				for (int h = 3; h <= array.length - 1; h = h + 2) {
					for (int i = array[h]; i >= array[2]; i--) {
						lands[i][array[h + 1]].setColor(colors.get(number));
					}
				}
			}
			number++;
		}
	}
	
	/**
	 * Zwraca wartosc w zmiennej Color
	 * @param color - nazwa koloru (String)
	 * @return - zmienna Color
	 */
	public Color colorDecoder(String color) {
		
		switch (color) {
			case "red":
				return Color.RED;
			case "blue":
				return Color.BLUE;
			case "black":
				return Color.BLACK;
			case "yellow":
				return Color.YELLOW;
			case "green":
				return Color.GREEN;
			case "purple":
				return Color.PINK;
			case "white":
				return Color.WHITE;
			case "orange":
				return Color.orange;
		}
		return Color.WHITE;
	}
	
	/**
	 * Przesyla informacje do gui o kliknietym Polu
	 * @param x - wspolrzedna X
	 * @param y - wspolrzedna Y
	 */
	public void sendInfo(int x, int y){
		gui.sendInfo(x,y);
	}
	
	/**
	 * Zmienia kolor na danym Polu
	 * @param x - wspolrzedna X
	 * @param y - wspolrzedna Y
	 * @param color - nazwa koloru (String)
	 */
	public void change(int x, int y, String color){
		lands[x][y].setColor(colorDecoder(color));
		repaint();
	}
}
	
	

