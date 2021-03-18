package Client.Frame;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Klasa MyMouseAdapter odpowiada za obsluge myszki
 * zawiera obiekt DrawSpace (JPanel)
 * oraz wszytskie pola
 */
public class MyMouseAdapter extends MouseAdapter {
	private final Land[][] lands;
	private final DrawSpace drawSpace;
	
	/**
	 * Ustawiamy wartosci
	 * @param lands - Pola na planszy
	 * @param drawSpace - JPanel
	 */
	MyMouseAdapter(Land[][]lands, DrawSpace drawSpace){
		this.lands=lands;
		this.drawSpace=drawSpace;
	}
	
	/**
	 * Metoda mousePressed wysyla informacje do DrawSpace jakie Pole zostalo naklikniete
	 * @param e - naklikniecie myszki
	 */
	public void mousePressed(MouseEvent e) {
		Point point = new Point(e.getX(), e.getY());
		
		for (int i = 0; i < lands.length; i++) {
			for(int j = 0; j< lands[i].length; j++) {
				if (lands[i][j].isHIt(point)) {
					drawSpace.sendInfo(i, j);
				}
			}
		}
	}
}

