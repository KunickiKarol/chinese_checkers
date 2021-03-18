package Client.Frame;

import java.util.ArrayList;

/**
 * Interface BoardMethods
 * odpowiada za ustawienie domkow
 * i rozmiaru pol na planszy
 * oraz za zwrocenie tych danych
 */
public interface BoardMethods {
	void setHouses(int[] house);
	void setSizeBoard(int x, int y);
	void addHouses();
	Land[][] giveSize();
	ArrayList<int[]> giveHouses();
}
