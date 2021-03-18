package Client.Frame;

import java.util.ArrayList;

/**
 * Klasa Clasical rozszerza Board
 */
public class Classical extends Board{
	
	/**
	 * W konstruktorze wywoluje metody odpowiedzialne na "zbudowanie planszy"
	 * @param sizeX - dlugosc planszy
	 * @param sizeY - szerokosc planszy
	 */
	public Classical(int sizeX, int sizeY){
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
		int[] house1 ={1,0,4, 0,6, 1,7, 2,5, 3,8};          //1
		int[] house2 ={0,16,13, 16,6, 15,7, 14,5, 13,8};    //2
		int[] house3 ={0,7,4, 7,2, 6,1, 5,3, 4,0};          //3
		int[] house4 ={0,7,4, 7,11, 6,10, 5,12, 4,9};       //4
		int[] house5 ={1,9,13, 9,2, 10,1, 11,3, 12,0};      //5
		int[] house6 ={1,9,13, 9,11 ,10,10, 11,12, 12,9};   //6
		
		// Konstrukcja domkow oparte na na algorytmie polegającym na
		// {1,0,4, 0,6, 1,7, 2,5, 3,8}
		// gdzie pierwsza liczba (tutaj 1) oznacza czy mamy do czynenia z odwrotonoscia
		// 1 znaczy nieodwrotna a 0 oznacza odwrotna (patrz domek nr 2)
		
		// nastepna para liczb oznacza zakres ( tutaj "0,4" )
		// w przypadku nieodwrotnosci liczby od pierwszej liczby (wlacznie) do ostatniej (bez niej)
		// w przypadku odwrotnosci liczby od pierwszej liczby (wlacznie) do ostatniej (wlacznie) (patrz domek nr 2 "16,13")
		
		// kolejne pary liczby oznaczaja  (w przypadku nieodwrotnosci)
		// "0,6"
		// 0 - linijka od ktorej zaczac (zacznamy od lini zero [indeksowane wedlug tablic] i konczy na 3 (bez 4)), 6 - jaki numer pola pojawia sie w danej linijce
		// to samo z kazda kolejna para liczb
		
		// kolejne liczby oznaczaja  (w przypadku odwrotnosci)
		// np "16,6" - domek nr 2
		// 16 - linijka od ktorej zaczac (najpierw ta wieksza i konczymy na ostatniej liczbie przedzialu (liczba ustawiona w przedziale "16,13")), 6 - jaki numer pola pojawia sie w danej linijce
		// to samo z kazda kolejna para liczb
		
		setHouses(house1);
		setHouses(house2);
		setHouses(house3);
		setHouses(house4);
		setHouses(house5);
		setHouses(house6);
	}
}
