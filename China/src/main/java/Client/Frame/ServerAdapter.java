package Client.Frame;

import javax.swing.*;
import java.awt.*;

/**
 * ServerAdapter wykorzystuje pattern Adapter
 */
public abstract class ServerAdapter {
	
	/**
	 * Change przesyla iformacje do GUI
	 * @param x - wspolrzedna X
	 * @param y - wsporlzedna Y
	 * @param color - nazwa koloru
	 */
	public void change(int x, int y, String color){
	}
	
	/**
	 * Przeslij informacje do serwera
	 * @param x - wspolrzedna X
	 * @param y - wsporlzedna Y
	 */
	public void sendInfo(int x, int y){
	}
	
	/**
	 * Zmien ture gracza
	 * @param color - nazwa koloru
	 */
	public void changePlayer(String color){
	}
	
	public void changeButton(){
	}
	
	/**
	 * Zwroc ramke
	 * @return Component
	 */
	public Component returnFrame() {
		return null;
	}
	
	/**
	 * Wyswietla sie MessageDialog z infromacja o wygranej i konczy program
	 */
	public void winner() {
		JOptionPane.showMessageDialog(returnFrame(),"Gracz"+" wygral gre", "End", JOptionPane.PLAIN_MESSAGE);
		System.exit(0);
	}
	
	/**
	 * Wyswietla sie MessageDialog z infromacja o wyjsciu gracza i konczy program
	 */
	public void left() {
		JOptionPane.showMessageDialog(returnFrame(),"Gracz"+" opuscil gre. Koncze gre", "Error", JOptionPane.PLAIN_MESSAGE);
		System.exit(0);
	}
	
	/**
	 * Wyswietla sie MessageDialog z infromacja o poczekaniu na reszte graczy
	 */
	public void waitForMove(){
		JOptionPane.showMessageDialog(returnFrame(),"Poczekaj na wszystkich!", "Error", JOptionPane.PLAIN_MESSAGE);
	}
	
	/**
	 * Wyswietla sie MessageDialog z infromacja o poczekaniu na swoja ture
	 */
	public void notYou() {
		JOptionPane.showMessageDialog(returnFrame(),"Poczekaj na swoja ture!", "Error", JOptionPane.PLAIN_MESSAGE);
	}
	
	/**
	 * Wyswietla sie MessageDialog z infromacja o nie ruszaniu nie swoim pionkiem
	 */
	public void notChecker() {
		JOptionPane.showMessageDialog(returnFrame(),"Nie twoj pionek!", "Error", JOptionPane.PLAIN_MESSAGE);
	}
}
