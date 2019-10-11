
import java.io.*;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Roster {
	
	Player[] roster;
	//the no args constructor that asks for a database file
	public Roster() throws FileNotFoundException {createRosterfromFile();}
	//a constructor that accepts a pre-made array
	public Roster(Player[] roster) {this.roster = roster;}
	
	//the method that creates the roster from a database file
	private void createRosterfromFile() throws FileNotFoundException
	{
		//Create a File Chooser for the user to select the list file with
		File listFile = null;
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Please select the list you want to import");
			if(fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) 
			{
				listFile = fileChooser.getSelectedFile();
			}
		//if the User hits cancel, the program exits
		else{System.exit(0);}
				
		//Count the number of lines in the file and create the appropriate sized array 
		int lineCount = 0;
		Scanner fileScanner1 = new Scanner(listFile);
		//skip the first header line
		try {fileScanner1.nextLine();
			while(fileScanner1.hasNextLine()) {lineCount++; fileScanner1.nextLine();}
		fileScanner1.close();
		Player[] playerList =  new Player[lineCount];
		System.out.println("Created Array with "+lineCount+" lines");
		
		//Open up the file and fill the array with Player Objects from it's data
		Scanner fileScanner2 = new Scanner(listFile);
		fileScanner2.nextLine();
		String playerName;
		String playerFirstName;
		String playerLastName;
		double playerNumber;
		double gp;
		double gs;
		double totalMins;
		double totalFG;
		double totalFGA;
		double threeFG;
		double threeFGA;
		double FT;
		double FTA;
		double offReb;
		double defReb;
		double PF;
		double assists;
		double TO;
		double Stl;
		double Blk;
		double TotalPts;
		int count = 0;
		while(fileScanner2.hasNextLine()) 
		{
			//Grab the next line and save it as a string
			String line = fileScanner2.nextLine();
			//Create a scanner to scan the individual line, parsing it into tokens by tab spaces
			Scanner linescanner = new Scanner(line);
			linescanner.useDelimiter("\t");
			while(linescanner.hasNext()){
			//check to make sure the line has all the data we expect
			if(line.matches("(.*)(\t)(\")(.*)(\")(\t)(.*)(\t)(.*)(\t)(.*)(\t)(.*)(\t)(.*)(\t)(.*)(\t)(.*)(\t)(.*)(\t)(.*)(\t)(.*)(\t)(.*)(\t)(.*)(\t)(.*)(\t)(.*)(\t)(.*)(\t)(.*)(\t)(.*)")) 
			{
			//have the scanner dump the data into memory for use as a player object
			playerNumber = linescanner.nextDouble();
 			playerName = linescanner.next();
 			//We split the Name up using Quotation Marks and Commas as reference
 			playerLastName = playerName.substring(playerName.indexOf("\""), playerName.indexOf(","));
 			playerFirstName = playerName.substring(playerName.indexOf(","), playerName.indexOf("\"",playerName.indexOf(",")));
 			playerLastName = playerLastName.substring(1, playerLastName.length());
 			playerFirstName = playerFirstName.substring(2, playerFirstName.length());
			gp = linescanner.nextDouble();
			gs = linescanner.nextDouble();
			totalMins = linescanner.nextDouble();
			totalFG = linescanner.nextDouble();
			totalFGA = linescanner.nextDouble();
			threeFG = linescanner.nextDouble();
			threeFGA = linescanner.nextDouble();
			FT = linescanner.nextDouble();
			FTA = linescanner.nextDouble();
			offReb = linescanner.nextDouble();
			defReb = linescanner.nextDouble();
			PF = linescanner.nextDouble();
			assists = linescanner.nextDouble();
			TO = linescanner.nextDouble();
			Stl = linescanner.nextDouble();
			Blk = linescanner.nextDouble();
			TotalPts = linescanner.nextDouble();
			//create a player object with the line data and add it too the roster
			playerList[count] = new Player( playerNumber,playerLastName,playerFirstName,  gp,  gs, totalMins, totalFG,
					 totalFGA, threeFG, threeFGA, FT,  FTA,  offReb, defReb,  PF, 
					 assists,  TO,  Stl,  Blk,  TotalPts);
			System.out.println("player"+(count+1)+" has been created!");
			}
			//the line does not have the data we need, we input a Player with zero values
			else{playerList[count] = new Player(); break;}
			count++;
			}
			//finally we set the roster to point to the array of player files we created and close the scanners
			roster = playerList;
			linescanner.close();
		}	
		fileScanner2.close();
		}
		//if something goes wrong, we send the user an error message and close 
		catch(Exception e) { JOptionPane.showMessageDialog(null, "Something went wrong with the file, is it missing data?\n The program will now close");System.exit(0);}
	}
	
	//a method that sorts the roster array by total points and returns the player with the highest
	public Player mostPoints()
	{
		try {for(int i=0; i <(this.roster.length); i++) 
		{
			for(int c=0; c <(this.roster.length-1); c++) 
			{
				if(this.roster[i].getTotalPts() < this.roster[c].getTotalPts()) 
				{
					Player temp = this.roster[i];
					this.roster[i] = this.roster[c];
					this.roster[c] = temp;
				}
			}
		
		
		}
		Player high = this.roster[roster.length-1];
		return high;	
		}
		catch(Exception e) {JOptionPane.showMessageDialog(null, "Something went wrong trying to get the top scoring player, \nAre there empty lines in the database? \nAre there fewer than 5 players in the database?\nThe program will now close"); System.exit(0); return new Player();}
	}
	//a method that sorts the roster array by total points and returns an array with the top 5 player objects
	public Player[] getTop5Scores()
	{
	try{mostPoints();
	Player[] top5Pts = new Player[5];
	top5Pts[4] = roster[roster.length-5];
	top5Pts[3] =roster[roster.length-4];
	top5Pts[2] =roster[roster.length-3];
	top5Pts[1] =roster[roster.length-2];
	top5Pts[0] =roster[roster.length-1];
	return top5Pts;
	}
	catch(Exception e) {JOptionPane.showMessageDialog(null, "Somethign went wrong getting the top 5 scores, are there less than 5 players on the roster? \nThe program will now close"); System.exit(0); Player[] top5 = new Player[5]; return top5;}
	}
	//a method that sorts the roster array by assists and returns an array with the top 5 player objects
	public Player[] getTopAssist() 
	{
		try{
		for(int i=0; i<(this.roster.length); i++) 
		{
			for(int c=0; c<(this.roster.length); c++) 
			{
				if(this.roster[i].getAssists() < this.roster[c].getAssists()) 
				{
					Player temp = this.roster[i];
					this.roster[i] = this.roster[c];
					this.roster[c] = temp;
				}
			}
		}
		Player[] top5Pts = new Player[5];
		top5Pts[4] = roster[roster.length-5];
		top5Pts[3] =roster[roster.length-4];
		top5Pts[2] =roster[roster.length-3];
		top5Pts[1] =roster[roster.length-2];
		top5Pts[0] =roster[roster.length-1];
		return top5Pts;
		}
		catch(Exception e) {JOptionPane.showMessageDialog(null, "Somethign went wrong getting the top 5 assists, are there less than 5 players on the roster? \nThe program will now close"); System.exit(0); Player[] top5 = new Player[5]; return top5;}
	}
	//a method that sorts the array by personal fouls and returns an array with the top 5 fewest player objects
	public Player[] getLeastPF() 
	{
		try{
		for(int i=0; i<(this.roster.length); i++) 
		{
			for(int c=0; c<(this.roster.length); c++) 
			{
				if(this.roster[i].getPF() > this.roster[c].getPF()) 
				{
					Player temp = this.roster[i];
					this.roster[i] = this.roster[c];
					this.roster[c] = temp;
				}
			}
		}
		Player[] top5Pts = new Player[5];
		top5Pts[4] = roster[roster.length-5];
		top5Pts[3] =roster[roster.length-4];
		top5Pts[2] =roster[roster.length-3];
		top5Pts[1] =roster[roster.length-2];
		top5Pts[0] =roster[roster.length-1];
		return top5Pts;
		}
		catch(Exception e) {JOptionPane.showMessageDialog(null, "Somethign went wrong getting the top 5 fewest persona, are there less than 5 players on the roster? \nThe program will now close"); System.exit(0); Player[] top5 = new Player[5]; return top5;}
	}
}
