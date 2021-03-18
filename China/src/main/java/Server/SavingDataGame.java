package Server;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;


public class SavingDataGame {
	private int ID;
	private int NrGry;
	private int NrRuchu;
	private String info;
	public SavingDataGame() {

	}

	public int getID() {
		return ID;
	}
	
	public void setID(int ID) {
		this.ID = ID;
	}
	
	public int getNrGry() {
		return NrGry;
	}
	public void setNrGry(int nrGry) {
		NrGry = nrGry;
	}
	
	public int getNrRuchu() {
		return NrRuchu;
	}
	public void setNrRuchu(int nrRuchu) {
		NrRuchu = nrRuchu;
	}
	
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
}
