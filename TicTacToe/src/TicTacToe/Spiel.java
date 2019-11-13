package TicTacToe;

import java.util.Scanner;

public class Spiel {

	public static void main(String[] args) {

		Spieler spieler1 = new Spieler("Lisa", "1", "X");
		Spieler spieler2 = new Spieler("Marie", "2", "O");
		Spielfeld spielfeld = new Spielfeld();
		
		spielfeld.spielzugAusfuehren(spieler1, spieler2);
		//System.out.println("Spieler1: " +spieler1.name + "  Spieler2: " +spieler2.name + spielfeld.spielRaster);
	}
}