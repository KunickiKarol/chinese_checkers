package Client.Frame;

import java.util.ArrayList;

/**
 * Klasa StarBoard implemetnuje interface DrawNeutralBoard
 */
public class StarBoard implements DrawNeutralBoard {
	/**
	 * Metoda return tables zwraca Arrayliste z tablicami int
	 * ktore konfiguruja pola neutralne
	 * @return zwraca Arrayliste z ukladem pol neutralnych
	 */
	@Override
	public ArrayList<int []> returnTables() {
		ArrayList<int[]> createdTables = new ArrayList<>();
		int[] array ={1,4,9, 4,4, 4,5, 4,6, 4,7, 4,8, 5,9, 6,3, 7,10, 8,2};
		int[] array2={0,12,9, 12,4, 12,5, 12,6, 12,7, 12,8, 11,9, 10,3, 9,10};
		
		// Konstrukcja pol neutralnych jest identyczna jak domkow
		// {1,4,9, 4,4, 4,5, 4,6, 4,7, 4,8, 5,9, 6,3, 7,10, 8,2};
		// gdzie pierwsza liczba (tutaj 1) oznacza czy mamy do czynenia z odwrotonoscia
		// 1 znaczy nieodwrotna a 0 oznacza odwrotna (patrz array2 )
		
		// nastepna para liczb oznacza zakres ( tutaj "4,9" )
		// w przypadku nieodwrotnosci liczby od pierwszej liczby (wlacznie) do ostatniej (bez niej)
		// w przypadku odwrotnosci liczby od pierwszej liczby (wlacznie) do ostatniej (wlacznie) (array2 "12,9")
		
		// kolejne pary liczby oznaczaja  (w przypadku nieodwrotnosci)
		// "4,4"
		// 4 - linijka od ktorej zaczac (zacznamy od 4 i konczy na 8 (bez 9)), 4 - jaki numer pola pojawia sie w danej linijce (pojawi sie w kazdej od 4 - 8)
		// to samo z kazda kolejna para liczb
		
		// kolejne liczby oznaczaja  (w przypadku odwrotnosci)
		// np "12,4" - array2
		// 12 - linijka od ktorej zaczac (najpierw ta wieksza i konczymy na ostatniej liczbie przedzialu czyli 9 (liczba ustawiona w przedziale "12,9")), 4 - jaki numer pola pojawia sie w danej linijce
		// to samo z kazda kolejna para liczb
		createdTables.add(array);
		createdTables.add(array2);
		return createdTables;
	}
}
