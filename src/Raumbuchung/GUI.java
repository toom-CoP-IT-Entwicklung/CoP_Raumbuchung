package Raumbuchung;

import java.io.File;
import java.io.IOException;

import javax.swing.*;
//import javax.swing.filechooser.*;

public class GUI {
	
	public void createFrame() {
		
		//create new frame
		JFrame frame1 = new JFrame("Einfügen & Änderungen der Datenbank");
		frame1.setSize(400,400);
		frame1.setVisible(true);
		
		//show the frame
		frame1.setVisible(true);
		
		//create new dialog
		JDialog dialog1 = new JDialog();
		dialog1.setTitle("Menü");
		//create menubar
		JMenuBar bar1 = new JMenuBar();
		dialog1.setJMenuBar(bar1);
		dialog1.setVisible(true);
	}
	
	public void createFile() {
		
		File file1 = new File("C:/Beispiel.mdb");
		
		//check, if the file already exists
		if(!file1.exists()) {
			
			try 
			{
				//create file
				boolean wasCreated = file1.createNewFile();
			
				if(wasCreated) {
					System.out.println(file1.getName() +" wurde erfolgreich auf dem Laufwerk c erstellt!");
				} else {
					System.out.println(file1.getName() +" wurde nicht erfolgreich auf dem Laufwerk c erstellt!");
				}
			}
			
			catch (IOException ex) {
			ex.printStackTrace();
			}
		}
	}
	
	public void setData() {
		JOptionPane.showInputDialog("MitarbeiterID: ");
		JOptionPane.showInputDialog("RaumID: ");
		JOptionPane.showInputDialog("Buchungsdatum: ");
	}
	
	public void openFile() {
		//file-explorer with buttons to open, save and exit
		JFileChooser chooser = new JFileChooser();
		
		JFrame fileFrame = new JFrame("Dateiauswahl");
		fileFrame.setSize(250,250);
		
		//Dialoge to open the file
		int i = chooser.showOpenDialog(null);
		
		//check, if 'open' or 'sve' was clicked
		if(i == JFileChooser.APPROVE_OPTION) {
			System.out.println("Die zu öffnende Datei ist: "+ chooser.getSelectedFile().getName());
		} 
	}
	
	public void saveFile() {
		
		JFileChooser chooser = new JFileChooser();
		//Dialoge to save the file
		chooser.showSaveDialog(null);
	}

}