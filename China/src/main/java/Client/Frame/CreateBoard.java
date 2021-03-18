package Client.Frame;

/**
 * Klasa CreateBoard uzywa factory pattern
 */
public class CreateBoard {
	
	/**
	 * Metoda boardProperties na podstawie
	 * @param name nazwa planszy
	 * @return zwraca gotowa plansze (wraz z Polami oraz Domkami)
	 */

	 public static BoardMethods boardProperties(String name){
		
		if(name.equals("Classical")){
			return new Classical(13,17);
		}
		
		else if( name.equals("Square")){
			return new RectangleBoard(10,10);
		}
		else {
			throw new IllegalArgumentException("Unknown board " + name);
		}
	}
}
