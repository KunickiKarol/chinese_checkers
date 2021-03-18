package Client.Frame;

import java.awt.*;

/**
 * Interface tworzacy poszczegolne Pole ktory
 * nadaje mu ksztalt, kolor i umozliwia uzycie go w planszy
 */
public interface Land extends Shape{
	void setColor(Color color);
	Color getColor();
	boolean isHIt(Point starDrag);
	void changeShape(float x,float  y , float x1, float y1);
}
