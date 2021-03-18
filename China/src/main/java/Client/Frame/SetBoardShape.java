package Client.Frame;

/**
 * Klasa SetBoardShape wykorzystuje factory pattern
 */
public class SetBoardShape {
	
	/**
	 * Metoda drawBoard "zwraca pola neutralne na planszy"
	 * @param type - typ planszy
	 * @return - gotowy obiekt zawierajacy pola neutralne
	 */
	public static DrawNeutralBoard returnBoardShape(String type){
		
		if(type.equals("Classical")) {
			return new StarBoard();
		}
		else if(type.equals("Square")){
			return new SquareBoard();
		}
		else {
			throw new IllegalArgumentException("Unknown type " + type);
		}
	}
}
