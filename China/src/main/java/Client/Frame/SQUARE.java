package Client.Frame;

import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * Klasa SQUARE dziedziczy po Rectangle2D.Float
 * oraz implementuje interface Land
 * zmienna myColor okresla jaki kolor ma dane pole
 */
public class SQUARE extends Rectangle2D.Float implements Land
{
	private Color myColor = Color.WHITE;
	
	/**
	 * Ustawiamy rozmiary danego Pola w konstuktorze
	 * @param x - pierwszy punkt (xo)
	 * @param y - pierwszy punkt (yo)
	 * @param x1 - koncowy punkt (x1)
	 * @param y1 - koncowy punkt (y1)
	 */
	public SQUARE(float x, float y , float x1, float y1) {
		this.x=x;
		this.y=y;
		this.width=x1;
		this.height=y1;
		
	}
	
	/**
	 * Na podstawie punkty sprawdzamy czy dane Pole zostalo naklikniete
	 * @param dragStart punkt ktory uzytkownik nakliknal
	 * @return true or false
	 */
	@Override
	public boolean isHIt(Point dragStart) {
		return this.contains(dragStart);
	}
	
	/**
	 * Zmieniamy ksztalt Pola
	 * @param x - pierwszy punkt (xo)
	 * @param y - pierwszy punkt (yo)
	 * @param x1 - koncowy punkt (x1)
	 * @param y1 - koncowy punkt (y1)
	 */
	@Override
	public void changeShape(float x, float y, float x1, float y1) {
		this.x=x;
		this.y=y;
		this.width=x1;
		this.height=y1;
	}
	
	/**
	 * Zmieniamy myColor na inny kolor
	 * @param color dany kolor
	 */
	@Override
	public void setColor(Color color) {
		this.myColor =color;
	}
	
	/**
	 * Zwracamy myColor
	 * @return myColor
	 */
	@Override
	public Color getColor() {
		return myColor;
	}
}
