package TicTacToe;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Spielfeld {
	public JButton[] button = new JButton[9];
	public String[] wertRaster = new String[9];
	Scanner scan = new java.util.Scanner(System.in);
	int spielzuege = 0;
	String modus = "1 Gegen 1";
	Computer computergegner = new Computer();
	Spieler spieler1 = new Spieler("", "1");
	Spieler spieler2 = new Spieler("", "2");
	boolean neuesSpiel = false;

	public Spielfeld(JFrame spielfeld) {

		final JFrame startseite = new JFrame();
		startseite.setSize(300, 350);

		if (neuesSpiel) {
			spielfeld.dispose();
			final JFrame neuesSpielfeld = new JFrame();
			neuesSpielfeld.setSize(400, 400);
			spielOptionenAuslesen(startseite, neuesSpielfeld);
		} else {
			spielfeld.setSize(400, 400);
			spielOptionenAuslesen(startseite, spielfeld);
		}

	}

	public void erstelleSpielfeld(JFrame spielfeld) {
		spielfeld.setLayout(new GridLayout(3, 3, 5, 5));
		spielfeld.getContentPane().setBackground(Color.black);
		spielfeld.setLocationRelativeTo(null);
		ButtonListener bl = new ButtonListener();
		for (int i = 0; i < 9; i++) {
			button[i] = new JButton();
			button[i].addActionListener(bl);
			button[i].setBackground(Color.white);
			spielfeld.add(button[i]);
		}
	}

//	
//	public void erstelleStartseite(JFrame startseite, JFrame spielfeld) {
//		final WindowEventHandler handler = new WindowEventHandler(startseite, spielfeld);
//		final JButton startButton = new JButton("Start");
//		startseite.setLayout(new java.awt.GridLayout(2, 3));
//		startseite.setLocationRelativeTo(null);
//		startseite.setSize(400, 400);
//		BoxLayout boxLayout = new BoxLayout(startseite.getContentPane(), BoxLayout.Y_AXIS);
//		startseite.setLayout(boxLayout);
//		
//		JPanel panel = new JPanel();
//		panel.setLayout(new GridLayout(4, 2, 5, 20));
//
//		JLabel name1 = new JLabel("X Name Spieler1");
//		JLabel name2 = new JLabel("O Name Spieler2");
//
//		JTextField nameSpieler1 = new JTextField();
//		JTextField nameSpieler2 = new JTextField();
//		
//		JLabel modusBeschriftung = new JLabel("Modus:");
//		String modusMoeglichkeiten[] = { "1 Gegen 1", "Computer" };
//		JComboBox modusAuswahl = new JComboBox(modusMoeglichkeiten);
//	}

	public void spielOptionenAuslesen(JFrame startseite, JFrame spielfeld) {
//		final WindowEventHandler handler = new WindowEventHandler(startseite, spielfeld);
		final JButton startButton = new JButton("Start");
//		spielfeld.addWindowListener(handler);
//		startseite.setLayout(new java.awt.GridLayout(1, 7));
		startseite.setLocationRelativeTo(null);
		spielfeld.setLocationRelativeTo(null);
		BoxLayout boxLayout = new BoxLayout(startseite.getContentPane(), BoxLayout.Y_AXIS);
		startseite.setLayout(boxLayout);

		JPanel panel = new JPanel();

		panel.setLayout(new GridLayout(8, 1, 5, 10));

		EmptyBorder border = new EmptyBorder(0, 15, 0, 15);

		JLabel name1 = new JLabel("X Name Spieler1", SwingConstants.CENTER);
		JLabel name2 = new JLabel("O Name Spieler2", SwingConstants.CENTER);

		JTextField nameSpieler1 = new JTextField();
		nameSpieler1.setBorder(border);
		JTextField nameSpieler2 = new JTextField();
		nameSpieler2.setBorder(border);
//		Dimension d = new Dimension(20,20);
//		nameSpieler2.setPreferredSize(d);
//		nameSpieler2.setBorder(border);
		// Vllt später überprüfen, ob überhaupt Name eingegeben wurde
		JLabel modusBeschriftung = new JLabel("Modus:", SwingConstants.CENTER);
		JLabel freiraum = new JLabel(" ");
		String modusMoeglichkeiten[] = { "1 Gegen 1", "Computer" };
		JComboBox modusAuswahl = new JComboBox(modusMoeglichkeiten);
		modusAuswahl.setBorder(border);

		modusAuswahl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modus = (modusAuswahl.getSelectedItem().toString());
				if (modus.equals("Computer")) {
					name2.setVisible(false);
					nameSpieler2.setVisible(false);

				} else {
					name2.setVisible(true);
					nameSpieler2.setVisible(true);
				}
			}
		});
//		startseite.setSize(400, 400);

//		Object[] message = { modusBeschriftung, modusAuswahl, name1, nameSpieler1, name2, nameSpieler2, startButton };
//		JOptionPane pane = new JOptionPane(message, JOptionPane.OK_CANCEL_OPTION);
		panel.add(modusBeschriftung);
		panel.add(modusAuswahl);
		panel.add(name1);
		panel.add(nameSpieler1);
		panel.add(name2);
		panel.add(nameSpieler2);
		panel.add(freiraum);
		panel.add(startButton);
//		panel.add(pane);
		startseite.add(panel);
		startseite.setVisible(true);

		startButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent test) {
				spieler1.setName(nameSpieler1.getText());
				if (!modus.equals("Computer")) {
					spieler2.setName(nameSpieler2.getText());
				}
				startseite.setVisible(false);
				spielfeld.setVisible(true);
				erstelleSpielfeld(spielfeld); 
			}
		});
	}

	class ButtonListener implements java.awt.event.ActionListener {
		ImageIcon kreuz = new ImageIcon("C:/CvD/1. Semester/Informatik/Projekt/kreis.png");
		ImageIcon kreis = new ImageIcon("C:/CvD/1. Semester/Informatik/Projekt/kreuz.png");

		public void actionPerformed(java.awt.event.ActionEvent e) {

			for (int i = 0; i < 9; i++) {
				if (e.getSource() == button[i]) {
					spielzuege++;
					if (modus.equals("Computer") && spielerIstDran(spielzuege).equals("O")) {
						computergegner.zugAusfuehren();
					} else {
						wertRaster[i] = spielerIstDran(spielzuege);
						if (spielerIstDran(spielzuege).equals("X")) {
							button[i].setIcon(kreis);
						} else {
							button[i].setIcon(kreuz);
						}
						button[i].removeActionListener(this);
					}
					if (spielzuege > 0) {
						// if-Abfrage abändern
						if (logikAuswerten(wertRaster)) {
							System.out.println("ENDE");
							neuesSpielAbfragen(spieler1);
							break;

						}
					}
				}
			}
			arrayAusgeben(wertRaster);
			// Überprüfung, welche Felder gesetzt wurden. Muss später rausgenommen werden.
		}
	}

	public String spielerIstDran(int spielzuege) {
		if (spielzuege % 2 == 0) {
			return "O";
		}
		return "X";
	}

	public void neuesSpielAbfragen(Spieler gewinner) {
		// Neues Fenster , mit Spielerabfrage, ob erneut gespielt werden soll
		// Aufruf der Startseite
		// Möglichkeit zum Beenden?
		final JFrame erneutSpielen = new JFrame();
		final JButton neustart = new JButton("Erneut Spielen");
		final JButton beenden = new JButton("Spiel Beenden");
		final JLabel gewinnerText = new JLabel("Der Gewinner ist: ", SwingConstants.CENTER);
		final JLabel gewinnerName = new JLabel(gewinner.getName(), SwingConstants.CENTER);
		final JLabel freiraum = new JLabel(" ");
		erneutSpielen.setSize(300, 300);
		erneutSpielen.setVisible(true);
		erneutSpielen.setLocationRelativeTo(null);
//		erneutSpielen.setLayout(new GridLayout(4, 1, 5, 5));
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(5, 1, 30, 10));
		panel.add(gewinnerText);
		panel.add(gewinnerName);
		panel.add(freiraum);
		panel.add(neustart);
		panel.add(beenden);
		panel.setVisible(true);
		erneutSpielen.add(panel);

		neustart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				neuesSpiel = true;
				JFrame neuesSpielfeld = new JFrame();
				Spielfeld spielfeld = new Spielfeld(neuesSpielfeld);
//				erstelleSpielfeld(spielfeld);
//				Arrays.fill(wertRaster, "");
				erneutSpielen.setVisible(false);
			}
		});
		System.out.println("Spieler " + gewinner.getName());
	}

	public boolean logikAuswerten(String[] wertRaster) {
		// Zeilenabfrage
		for (int i = 0; i <= 6; i += 3) {
			if (wertRaster[i] != null && wertRaster[i + 1] != null && wertRaster[i + 2] != null) {
				if (wertRaster[i].equals(wertRaster[i + 1]) && wertRaster[i + 1].equals(wertRaster[i + 2])) {
					return true;
				}
			}
		}
		// Spaltenabfrage
		for (int j = 0; j <= 2; j++) {
			if (wertRaster[j] != null && wertRaster[j + 3] != null && wertRaster[j + 6] != null) {
				if (wertRaster[j].equals(wertRaster[j + 3]) && wertRaster[j + 3].equals(wertRaster[j + 6])) {
					return true;
				}
			}
		}
		// Diagonale
		if (wertRaster[0] != null && wertRaster[4] != null) {
			if (wertRaster[0].equals(wertRaster[8]) && wertRaster[4].equals(wertRaster[8])) {
				return true;
			}
		}

		// Diagonale
		if (wertRaster[2] != null && wertRaster[4] != null) {
			if (wertRaster[2].equals(wertRaster[6]) && wertRaster[4].equals(wertRaster[6])) {
				return true;
			}
		}
		return false;

	}

//	class WindowEventHandler extends WindowAdapter {
//		private JFrame startseite;
//		private JFrame spielfeld;
//
//		public WindowEventHandler(JFrame startseite, JFrame spielfeld) {
//			this.startseite = startseite;
//			this.spielfeld = spielfeld;
//		}
//	}

	public void arrayAusgeben(String[] array) {
//		for (int i = 0; i < array.length; i++) {
//			System.out.println(array[i]);
//		}
//		System.out.println("________________________________________");
	}
}
