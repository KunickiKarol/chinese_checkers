package Client.Frame;

/**
 * Klasa Setshapes wykorzystuje factory pattern
 */
public class SetShapes {
	
	/**
	 * Metoda Land zwraca obiekt interface'u Land
	 * @param type - typ figury jakim ma byc pole
	 * @param x - pierwszy punkt (xo)
	 * @param y - pierwszy punkt (yo)
	 * @param x1 - koncowy punkt (x1)
	 * @param y1 - koncowy punkt (y1)
	 * @return - zwraca gotowe pole o danym ksztalcie itp
	 */

	public static Land returnShape(String type, float x, float y, float x1, float y1){

		if(type.equals("Circle")) {
			return new CIRCLE(x, y, x1, y1);
		}
		 else if(type.equals("Rectangle")){
		 	return new SQUARE(x, y, x1, y1);
		}
		 else {
			throw new IllegalArgumentException("Unknown type " + type);
		}
	}
}
