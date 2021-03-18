package Client.Frame;

import Client.Client;

import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;


/**
 * Klasa GUI
 * Players - ilosc graczy
 * Client Client - obiekt Client
 * Draw draw - ramka
 */

public class GUI extends ServerAdapter{
	
	private final int Players;
	private final Client Client;
	private Draw draw;
	
	
	/**
	 * Tworze ramke i dodaje do niej ComponentListener
	 * @param boardName nazwa planszy
	 * @param typeOfFigures ksztalt pol
	 * @param mycolor kolro gracza
	 * @param Players ilosc graczy
	 * @param client Client
	 * Zeby w przypadku zmiany rozmiaru zmienic rozmiar Pol
	 */
	public GUI (String boardName, String typeOfFigures, String mycolor, String Players,Client client)  {
		this.Players=Integer.parseInt(Players);
		this.Client=client;
		EventQueue.invokeLater(() ->
		{
			
			draw = new Draw(boardName, typeOfFigures, mycolor, this.Players,this); //Ramka
			draw.addComponentListener(new ComponentAdapter() {
				public void componentResized(ComponentEvent componentEvent) {
					draw.changeSizeFrame(); // Zmien rozmiar pol
				}
			});
			draw.setVisible(true); // widocznosc
		});
	}
	
	
	/**
	 * Przekaz informacje to serwera
	 * @param x - wspolrzedna X
	 * @param y - wsporlzedna Y
	 */
	@Override
	public void sendInfo(int x, int y){
		String Data="MOVE "+x+";"+y;
		Client.writeMessage(Data);
	}
	
	/**
	 * Zmien u siebie
	 * @param x - wspolrzedna X
	 * @param y - wsporlzedna Y
	 * @param color - nazwa koloru
	 */
	@Override
	public void change(int x, int y, String color){
		draw.change(x, y, color);
	}
	
	/**
	 * Zmien ture u gracza
	 * @param color - nazwa koloru
	 */
	@Override
	public void changePlayer(String color){
		draw.changePlayer(color);
	}
	
	@Override
	public void changeButton(){
		draw.changeButtons();
	}
	
	/**
	 * Przeslij ramke
	 * @return Draw
	 */
	@Override
	public Component returnFrame(){
		return draw;
	}
	
}
