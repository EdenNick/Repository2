package data2;

import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class WindowConstructor extends WindowAdapter{
	
	private Color BackGroundColorB;
	private Panel Button;
	
	//creates a color based of rgb color scale and returns it
	public Color getColor( int x, int y, int z) {
		
		Color ColorSet = new Color(x, y, z);
		
		BackGroundColorB = ColorSet;
		
		return BackGroundColorB;
		
	}
	
	// creates a panel with a single button
	public Panel GameScreen(Panel setpanel) {

		Panel gameControl = new Panel();
		gameControl.setBackground(Color.darkGray);
	    
		gameControl.setBounds(100,150,600,200);
		     
		
		Button square1 = new Button("1");
		square1.setBounds(10,10,30,30); 
		square1.setBackground(Color.GREEN);
		gameControl.add(square1);
		
		// button to test saving data to FunSquareGameData.txt file.
		square1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				
				try {
				FileWriter F1 = new FileWriter("src/data2/FunSquareGameData.txt"); 
				
				
				String test = "Testing buttons \n";
				F1.write(test);
				F1.close();
				} catch (IOException e1) {
			      System.out.println("An error occurred.");
		
			    }

			}
		});
		
		// attaches button to panel
		setpanel.add(gameControl);
		
		return gameControl;//returns pannel to UI to be attached
	}
}
