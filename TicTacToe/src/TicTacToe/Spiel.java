package TicTacToe;

import java.util.Scanner;

public class Spiel {

	public static void main(String[] args) {

		Spieler spieler1 = new Spieler("1", "X");
		Spieler spieler2 = new Spieler("2", "O");
		
		Spielfeld spielfeld = new Spielfeld(spieler1, spieler2);
		
//		spieler1.namenEingeben(spieler1);
//		
//		if(spielfeld.getModus()==0) {
//		spieler2.namenEingeben(spieler2);
//		}
		
	}
}