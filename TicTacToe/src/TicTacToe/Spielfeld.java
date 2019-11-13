package TicTacToe;

import java.util.Scanner;

public class Spielfeld {
	
	String[][] spielRaster = new String[3][3];
	Scanner scan = new java.util.Scanner(System.in);
	
//	public Spielfeld() {
//		this.spielRaster = spielRaster;
//	}
	
	public void spielzugAusfuehren(Spieler spieler1, Spieler spieler2) {
		
		System.out.println("Geben Sie die Zeile (1-3) an:");
		int zeile = scan.nextInt();
		System.out.println("Geben Sie die Spalte (1-3) an:");
		int spalte = scan.nextInt();
		spielRaster[zeile-1][spalte-1] = spieler1.form;
		
		for(int i = 0; i<spielRaster.length; i++) {
			for(int j = 0; j < spielRaster[i].length; j++) {
				System.out.print(spielRaster[i][j]);
			}
			System.out.println();
		}
	}
}
