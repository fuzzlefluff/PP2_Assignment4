import java.io.FileNotFoundException;
import javax.swing.*;
public class Assignment4Test 
{

	public static void main(String[] args) throws FileNotFoundException
	{
		//create a playerroster object with the default constructor that demands a file for input
		Roster playerRoster = new Roster();
		
		//call the method that returns the player with the most points and then print the information 
		Player mostPointsPlayer = playerRoster.mostPoints();
		JOptionPane.showMessageDialog(null,"The Player with the most points is "+mostPointsPlayer.getFirstName()+" "
		+mostPointsPlayer.getLastName()+"\nwith "+mostPointsPlayer.getTotalPts()+" points");
		
		//call the method that returns the top 5 scoring players and then iterate through them to build a string with all the information to print
		Player[] top5 = playerRoster.getTop5Scores();
		String top5Message ="";
		for(int i=0; i<top5.length; i++) 
		{
		 top5Message += ("\nThe #"+(i+1)+" top scoring player is "+top5[i].getFirstName()+" "+top5[i].getLastName()+" with "
		+top5[i].getTotalPts()+" Points");
		}
		JOptionPane.showMessageDialog(null, top5Message);
		
		//call the method that returns the top 5 assisting players and then iterate through them to build a string with all the information to print
		top5 = playerRoster.getTopAssist();
		top5Message = "";
		for(int i=0; i<top5.length; i++) 
		{
		 top5Message += ("\nThe #"+(i+1)+" top assisting player is "+top5[i].getFirstName()+" "+top5[i].getLastName()+" with "
		+top5[i].getAssists()+" assists");
		}
		JOptionPane.showMessageDialog(null, top5Message);
		
		//call the method that returns the top 5 fewest personal foul players and then iterate through them to build a string with all the information to print
		top5 = playerRoster.getLeastPF();
		top5Message = "";
		for(int i=0; i<top5.length; i++) 
		{
			top5Message += ("\nThe #"+(i+1)+" least personal fouls player is "+top5[i].getFirstName()+" "+top5[i].getLastName()+" with "
				+top5[i].getAssists()+" personal fouls");
		}
		JOptionPane.showMessageDialog(null, top5Message);
		
		//close the program
		System.exit(0);
//end of class	
	}
}
