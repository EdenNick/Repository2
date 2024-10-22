//Project Name: fun square Game
//Purpose: create a project prototype
//Created by Nicholas Edenfield
//Date: 10/21/2024
package main;


//imported packages
import java.util.*;
import java.awt.*;
import java.awt.event.*;  

import data2.WindowConstructor;

public class Main extends WindowAdapter{
	
	private Panel Background;
	private Color BackGroundColor;
	
	WindowConstructor xyz = new WindowConstructor();
	// object of Frame  
    Frame GameWindow;
    // class constructor  
    Main() {    
    	// creating the frame  
    	GameWindow = new Frame();    
    	// adding  WindowListener to the frame  
    	GameWindow.addWindowListener (this);    
        
    	// setting the size, layout and visibility of frame  
    	GameWindow.setSize (1000, 800);    
    	
    	GameWindow.setLayout(null);    
    	GameWindow.setVisible (true);   
        
    	// sets BackGround color to greyblue
    	BackGroundColor = xyz.getColor(115, 147, 179);
    	// Creates The background (a panel)
    	BackgroundPanel();
    	
        // Add title (a label) 
        Label Title;
        Title = new Label ("Fun Square Game");
        Font TitleFont = new Font("Times New Roman", Font.BOLD, 24);
        Title.setFont(TitleFont);
        Title.setBounds(285,250,220,24);
        Background.add(Title);
        
        
        //adds the close game and start game button
        TransferButton(Background,350,550,100,50,"Close Game", 0);
        TransferButton(Background,350,500,100,50,"Start", 1);
        
    } 
    
    public void windowClosing (WindowEvent e) {    
    	GameWindow.dispose();    
    	
    	
    	//Creates new background
    	Panel Background2 = new Panel();
        Background2.setBounds(50,50,800,700);   
        Background2.setBackground(BackGroundColor);
        GameWindow.add(Background2);
    } 
	
	
	public void TransferButton(Panel BackGround, int a, int b, int c, int d, String x, int y) {
		
		// Creates Button and sets its position
		
		Button Transfer = new Button(x);
		Transfer.setBounds(a,b,c,d); 
        Background.add(Transfer);
        
        
        //Determines the action of the button
        if (y == 0) {
        		Transfer.addActionListener(new ActionListener() {
        			public void actionPerformed(ActionEvent e){
        				GameWindow.dispose();
        			}
        		});
        // Calls the gameScreen function, starting the actual game
        } else if (y == 1) {
        		Transfer.addActionListener(new ActionListener() {
        			public void actionPerformed(ActionEvent e){
        				GameScreen();
        			}
        		});
        	
        } else {
        	//closes program to avoid error
        	GameWindow.dispose();
        }
		
	}
	
	public void GameScreen() {
		
		//Creates new panel for game
		GameWindow.remove(Background);
		BackGroundColor = xyz.getColor(162, 173, 156);
		BackgroundPanel();
		
		
		Background.setLayout(new BorderLayout());
		xyz.GameScreen(Background); // < -- creates button layout from processing
		
	}
	
	//Creats a panel used for the background of the game
	public void BackgroundPanel() {
		
		Panel BackgroundInitialize = new Panel();
		BackgroundInitialize.setBounds(50,50,800,700);   
		BackgroundInitialize.setBackground(BackGroundColor);
        GameWindow.add(BackgroundInitialize);
		
		Background = BackgroundInitialize;
	}
	
	public static void main (String[] args) {
		
		 new Main(); 
		//code	
	}
	
	
	
}