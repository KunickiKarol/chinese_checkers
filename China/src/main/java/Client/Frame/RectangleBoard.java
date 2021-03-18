package Client.Frame;

import java.util.ArrayList;

/**
 * Klasa Clasical rozszerza Board
 */
public class RectangleBoard extends Board {
	
	/**
	 * W konstruktorze wywoluje metody odpowiedzialne na "zbudowanie planszy"
	 * @param sizeX - dlugosc planszy
	 * @param sizeY - szerokosc planszy
	 */
	public RectangleBoard(int sizeX, int sizeY){
		setSizeBoard(sizeX,sizeY);
		addHouses();
	}
	
	/**
	 * Dodaje domki do jeden wspolnej Arraylist
	 * @param house ulokowane domki w tablicy int
	 */
	@Override
	public void setHouses(int[] house) {
		houses.add(house);
	}
	
	/**
	 * Na podstawie x i y tworze tyle pol i zapisuje w sizeBoard
	 * @param x dlugosc
	 * @param y szerokosc
	 */
	@Override
	public void setSizeBoard(int x, int y){
		sizeBoard = new Land[y][x];
	}
	
	/**
	 * Dodaje domki
	 * inicjalizuje Arryliste
	 */
	@Override
	public void addHouses() {
		houses = new ArrayList<>();
	}
}
