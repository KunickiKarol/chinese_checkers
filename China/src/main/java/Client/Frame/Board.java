package Client.Frame;

import java.util.ArrayList;

/**
 * Abstrakcyjna klasa Board zawiera
 * zmienne Land[][] sizeBoard (okresla ilosc pol na planszy)
 * zmienna ArrayList<int[]> houses (okresla ulozenie domkow na planszy)
 * oraz dziedzidzy metody  giveSize() i ArrayList<int[]> giveHouses() z interface BoardMethods
 */
public abstract class Board implements BoardMethods{
	public Land[][] sizeBoard;
	public ArrayList<int[]> houses;
	
	public Land[][] giveSize(){
		return sizeBoard;
	}
	
	public ArrayList<int[]> giveHouses(){
		return houses;
	}
}
