package de.pi.infodisplay.client.gui;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import de.pi.infodisplay.client.Client;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.TextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow {

	private Client parent;
	private JFrame frmInformationdisplay;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MainWindow window = new MainWindow();
//					window.frmInformationdisplay.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public MainWindow(Client parent) {
		this.parent = parent;
		initialize();
		this.frmInformationdisplay.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmInformationdisplay = new JFrame();
		frmInformationdisplay.setTitle("InformationDisplay");
		frmInformationdisplay.setBounds(100, 100, 678, 717);
		frmInformationdisplay.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmInformationdisplay.setJMenuBar(menuBar);
		
		JMenu mnDatei = new JMenu("Datei");
		menuBar.add(mnDatei);
		
		JMenuItem mntmVerbinden = new JMenuItem("Verbinden...");
		mntmVerbinden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConnectDialog dialog = new ConnectDialog(parent);
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			}
		});
		mnDatei.add(mntmVerbinden);
		
		JMenuItem mntmDatenstandAktuallisieren = new JMenuItem("Datenstand aktualisieren");
		mnDatei.add(mntmDatenstandAktuallisieren);
		
		JMenuItem mntmBeenden = new JMenuItem("Beenden");
		mnDatei.add(mntmBeenden);
		
		JMenu mnBearbeiten = new JMenu("Bearbeiten");
		menuBar.add(mnBearbeiten);
		
		JMenuItem mntmEinstellungen = new JMenuItem("Einstellungen");
		mnBearbeiten.add(mntmEinstellungen);
		frmInformationdisplay.getContentPane().setLayout(null);
		
		TextArea infoBoard = new TextArea();
		infoBoard.setBounds(0, 0, 662, 658);
		frmInformationdisplay.getContentPane().add(infoBoard);
	}

}
