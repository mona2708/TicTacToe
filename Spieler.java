package TicTacToe;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Spieler { 
	String name = null;
	String id = null;
	
	public Spieler(String name, String id) {
		this.name = name;
		this.id = id;
		//id zu int abändern 
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
}
