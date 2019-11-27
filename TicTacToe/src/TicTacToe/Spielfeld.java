package TicTacToe;

import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Spielfeld extends JFrame {
	private JPanel raster = new javax.swing.JPanel();
	public JButton[] button = new javax.swing.JButton[9];
	public String[] wertRaster = new String[9];
	Scanner scan = new java.util.Scanner(System.in);
	int modus = 0;
	int spielzuege = 0;
//	spielfeld.setSize(500, 500);
//	spielfeld.setLocationRelativeTo(null);
//	spielfeld.setVisible(true);  

	public Spielfeld(Spieler spieler1, Spieler spieler2) {
		modus = JOptionPane.showOptionDialog(null, "Modus", "Gegner wählen", JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.INFORMATION_MESSAGE, null, new String[] { "1 gegen 1", " 1 gegen Computer" }, "1 gegen 1");
		spieler1.setName(JOptionPane.showInputDialog("Spieler" + spieler1.id + " Name: "));
		if (modus == 0) {
			spieler2.setName(JOptionPane.showInputDialog("Spieler" + spieler2.id + " Name: "));
		}
		erstelleSpielfeld();
		setSize(500, 500);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public int getModus() {
		return modus;
	}

	public void setModus(int modus) {
		this.modus = modus;
	}

	public void erstelleSpielfeld() {
		raster.setLayout(new java.awt.GridLayout(3, 3));
		ButtonListener bl = new ButtonListener();
		for (int i = 0; i < 9; i++) {
			button[i] = new JButton();
			button[i].addActionListener(bl);
			raster.add(button[i]);
		}
		this.getContentPane().add(raster);

	}

	class ButtonListener implements java.awt.event.ActionListener {
		ImageIcon kreis = new ImageIcon("C:/CvD/1. Semester/Informatik/Projekt/O.jpg");
		ImageIcon kreuz = new ImageIcon("C:/CvD/1. Semester/Informatik/Projekt/X.jpg");

		public void actionPerformed(java.awt.event.ActionEvent e) {
			for (int i = 0; i < 9; i++) {
				if (e.getSource() == button[i]) {
					wertRaster[i] = "X";
					// An dieser Stelle muss der Methodenaufruf hin, der überprüft welcher Spieler
					// am Zug ist
					// Wichtig: Am besten wird "X" oder "O" übergeben, je nachdem
					button[i].setIcon(kreuz);
					button[i].setEnabled(false);
					spielzuege++;
					// Alternative finden, die nicht ausgraut
				}
			}
			arrayAusgeben(wertRaster);
			// Überprüfung, welche Felder gesetzt wurden. Muss später rausgenommen werden.
			
		}
	}

	public void arrayAusgeben(String[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}

	}
}
