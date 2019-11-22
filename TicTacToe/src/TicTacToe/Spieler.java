package TicTacToe;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Spieler {
	String name = null;
	String id = null;
	String form = null;
	
	public Spieler(String id, String form) {
		this.id = id;
		this.form = form;		
	}
	
	
	public void namenEingeben(Spieler spieler) {
//		spieler.setName(JOptionPane.showInputDialog("Spieler" + spieler.id + " Name: "));
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getForm() {
		return form;
	}

	public void setForm(String form) {
		this.form = form;
	}
}
