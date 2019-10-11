
public class Player {
	
	//data fields to store all the player stats
	private String playerFirstName;
	private String playerLastName;
	private double playerNumber;
	private double gp;
	private double gs;
	private double totalMins;
	private double totalFG;
	private double totalFGA;
	private double threeFG;
	private double threeFGA;
	private double FT;
	private double FTA;
	private double offReb;
	private double defReb;
	private double PF;
	private double assists;
	private double TO;
	private double Stl;
	private double Blk;
	private double totalPts;
	
	//A noArgs constructor that sets all the values to zero
	public Player()
	{
		playerNumber = 0;
	playerLastName = "null";
	playerFirstName = "null";
	gp =0;
	gs =0;
	totalMins =0;
	totalFG =0;
	totalFGA =0;
	threeFG =0;
	threeFGA =0;
	FT =0;
	FTA =0;
	offReb =0;
	defReb =0;
	PF =0;
	assists =0;
	TO =0;
	Stl =0;
	Blk =0;
	totalPts =0;
	}
	
	//A constructor that sets a player object with all the input data
	public Player(Double IplayerNumber,String lastName,String firstName, double Igp, double Igs,double ItotalMins,double ItotalFG,
			double ItotalFGA,double IthreeFG,double IthreeFGA,double IFT, double IFTA, double IoffReb,double IdefReb, double IPF, 
			double Iassists, double ITO, double IStl, double IBlk, double ITotalPts)
	{
		playerNumber = IplayerNumber;
		playerLastName = lastName;
		playerFirstName = firstName;
		gp =Igp;
		gs =Igs;
		totalMins =ItotalMins;
		totalFG =ItotalFG;
		totalFGA =ItotalFGA;
		threeFG =IthreeFG;
		threeFGA =IthreeFGA;
		FT =IFT;
		FTA =IFTA;
		offReb =IoffReb;
		defReb =IdefReb;
		PF =IPF;
		assists =Iassists;
		TO =ITO;
		Stl =IStl;
		Blk =IBlk;
		totalPts =ITotalPts;
	}
	
	//a bunch of getter methods to return the private field values
	public double getplayerNumber() {return playerNumber;}
	public String getFirstName(){return playerFirstName;}
	public String getLastName(){return playerLastName;}
	public double getGP(){return gp;}
	public double getGS(){return gs;}
	public double gettotalMins(){return totalMins;}
	public double gettotalFG(){return totalFG;}
	public double gettotalFGA(){return totalFGA;}
	public double getthreeFG(){return threeFG;}
	public double getthreeFGA(){return threeFGA;}
	public double getFT(){return FT;}
	public double getFTA(){return FTA;}
	public double getoffReb(){return offReb;}
	public double getdefReb(){return defReb;}
	public double getPF(){return PF;}
	public double getAssists(){return assists;}
	public double getTO(){return TO;}
	public double getStl(){return Stl;}
	public double getBlk(){return Blk;}
	public double getTotalPts(){return totalPts;}
	
	
	//a method that calculates and returns a players average minutes per game
	public double AverageMinutesPlayed() {return (totalMins/gp);}
	
	//a method that calculates and returns a players field goal percentage
	public double fieldGoalPercentage() {return (totalFG/totalFGA);}
	
	//a method that calculates and returns a players three field goal percentage
	public double threeFieldGoalPercentage(){return (threeFG/threeFGA);}
	
	//a method that calculates and returns a players field throw percentage
	public double fieldThrowPercentage() {return(FT/FTA);}
	
	//a method that calculates and returns a players rebound average
	public double reboundAverage(){return((offReb+defReb)/2);}
	
	
}
