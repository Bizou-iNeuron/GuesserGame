import java.util.*;

class Giver 
{
	int giveNum;
	int giveNum()
	{
		Random rand = new Random(); // get a random number between 0 and 9
		giveNum = 3;//rand.nextInt(10);
		return giveNum;
	}
}

class Player
{
	String name; // store the player's name
	int guessNum; // store the number guessed by players

	String name(int player)
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("Player "+ player+" enter your name "); // players input their guessed number
		name=scan.nextLine();
		return name;
	}
	
	int guessNum(String name)
	{
		Scanner scan = new Scanner(System.in);
		System.out.print(name+"'s guess: "); // players input their guessed number
		guessNum=scan.nextInt();
		if (guessNum >=0 && guessNum<=9)
			return guessNum;
		else
		{
			System.out.println("Your number is not between 0 and 9, please enter again");
			guessNum(name);
		}
		return guessNum;
		
	}
	
}

class Computer 
{
	int CompNum;
	int CompNum()
	{
		Random rand = new Random(); // get a random number between 0 and 9
		CompNum = rand.nextInt(10);
		return CompNum;
	}
}

class Umpire
{
	static String Player1;
	static String Player2;
	static String Player3;
	
	int numFromGiver; // store the random number to guess
	int numFromPlayer1; // store the number from player 1
	int numFromPlayer2; // store the number from player 2
	int numFromPlayer3; // store the number from player 3
	int numFromComputer1; // store the number from Computer 1
	int numFromComputer2; // store the number from Computer 2
	
	boolean allPlayers = false;
	boolean allComputers = false;
	
	int countPlayer1 = 0;
	int countPlayer2 = 0;
	int countPlayer3 = 0;
	int countComputer1 = 0;
	int countComputer2 = 0;
	
	int round = 1;
	
	String playAgain ;
	
	void getTheNames()
	{
		Player p1= new Player(); // create the object of player 1
		Player p2= new Player(); // create the object of player 2
		Player p3= new Player(); // create the object of player 3
		
		Player1 = p1.name(1);
		Player2 = p2.name(2);
		Player3 = p3.name(3);
		
		System.out.println();
		System.out.println("Welcome "+Player1+", "+Player2+" and "+Player3+" ! You will play against 2 computers\nMay the best Guesser win !\n\n");
	}
	
	void collectNums()
	{
		System.out.println("ROUND "+round+"\n");
		Giver g = new Giver(); // create the object of Giver
		numFromGiver=g.giveNum(); // call the method to get the random number
	
		Player p1= new Player(); // create the object of player 1
		Player p2= new Player(); // create the object of player 2
		Player p3= new Player(); // create the object of player 3
		
		numFromPlayer1 = p1.guessNum(Player1); // store the guessed number of player 1 in the variable numFromPlayer1
		numFromPlayer2 = p2.guessNum(Player2); // store the guessed number of player 2 in the variable numFromPlayer2
		numFromPlayer3 = p3.guessNum(Player3); // store the guessed number of player 3 in the variable numFromPlayer3
	
		Computer c1= new Computer(); // create the object of Computer 1
		Computer c2= new Computer(); // create the object of Computer 2
		
		numFromComputer1 = c1.CompNum(); // store the guessed number of player 1 in the variable numFromPlayer1
		numFromComputer2 = c2.CompNum(); // store the guessed number of player 2 in the variable numFromPlayer2
	}
	
	void compare()
	{
		System.out.println("\nComputer 1's guess: "+numFromComputer1);
		System.out.println("Computer 2's guess: "+numFromComputer2+"");
		
		System.out.println("\n\nTHE RANDOM NUMBER TO GUESS WAS *** "+numFromGiver+" *** ");
		
		if(numFromGiver == numFromPlayer1)
		{
			if(numFromGiver == numFromPlayer2 && numFromGiver == numFromPlayer3)
			{
				allPlayers = true;
				countPlayer1 ++;
				countPlayer2 ++;
				countPlayer3 ++;
				System.out.println("=> All players won this round !");
			}
			else if (numFromGiver == numFromPlayer2)
			{
				countPlayer1 ++;
				countPlayer2 ++;
				System.out.println("=> "+Player1+" and "+Player2+" won this round !");
			}
			else if (numFromGiver == numFromPlayer3)
			{
				countPlayer1 ++;
				countPlayer3 ++;
				System.out.println("=> "+Player1+" and "+Player3+" won this round !");
			}
			else 
			{
				countPlayer1 ++;
				System.out.println("=> "+Player1+" won this round !");
			}
		}
		else if (numFromGiver == numFromPlayer2)
		{
			if (numFromGiver == numFromPlayer3)
			{
				countPlayer3 ++;
				countPlayer2 ++;
				System.out.println("=> "+Player2+" and "+Player3+" won this round !");
			}
			else 
			{
				countPlayer2 ++;
				System.out.println("=> "+Player2+" won this round !");
			}
		}
		else if (numFromGiver == numFromPlayer3)
		{
			countPlayer3 ++;
			System.out.println("=> "+Player3+" won this round !");
		}
		else 
		{
			System.out.println("=> No player won");
		}
		
		// comparing computers
		
		if (numFromGiver == numFromComputer1)
		{
			if (numFromGiver == numFromComputer2)
			{
				allComputers = true;
				countComputer1 ++;
				countComputer2 ++;
				System.out.println("=> Computer 1 and 2 won this round !");
			}
			else
			{
				countComputer1 ++;
				System.out.println("=> Computer 1 won this round !");
			}
				
		}
		else if (numFromGiver == numFromComputer2)
		{
			countComputer2 ++;
			System.out.println("=> Computer 2 won this round !");
		}
		else
			System.out.println("=> No Computer won");
		
		if (allPlayers && allComputers)
			System.out.println("HURRAYYY !! EVERYBODY FOUND THE RANDOM NUMBER ON THIS ROUND!!!");
		
	}
	
	void countResult ()
	{
		System.out.println("\n\nROUNDS WON");
		System.out.println("----------");
		System.out.println(Player1+": "+countPlayer1);
		System.out.println(Player2+": "+countPlayer2);
		System.out.println(Player3+": "+countPlayer3);
		System.out.println("Computer 1: "+countComputer1);
		System.out.println("Computer 2: "+countComputer2+"\n\n");
		
		
	}
	
	void declareWinner ()
	{
		while (countPlayer1 < 3 && countPlayer2 < 3 && countPlayer3 < 3 && countComputer1 < 3 && countComputer2 < 3) 
		{
			round++;
			collectNums(); // Umpire collects the random mumber to guess
			compare(); // Umpire compares all the number and declares a winner
			countResult(); // displays the result
		} 
		
		int [] results = new int [5];
		results[0] = countPlayer1;
		results[1] = countPlayer2;
		results[2] = countPlayer3;
		results[3] = countComputer1;
		results[4] = countComputer2;
		
		
		for (int i = 0; i<results.length;i++)
		{
			if(results[i] == 3)
			{
				switch (i)
				{
				case (0): System.out.println("!!! HURRAYYY "+Player1.toUpperCase()+" WON THE GAME IN "+round+" ROUNDS !!!");break;
				case (1): System.out.println("!!! HURRAYYY "+Player2.toUpperCase()+" WON THE GAME IN "+round+" ROUNDS !!!");break;
				case (2): System.out.println("!!! HURRAYYY "+Player3.toUpperCase()+" WON THE GAME IN "+round+" ROUNDS !!!");break;
				case (3): System.out.println("!!! COMPUTER 1 WON THE GAME IN "+round+" ROUNDS !!!");break;
				case (4): System.out.println("!!! COMPUTER 1 WON THE GAME IN "+round+" ROUNDS !!!");break;
				}
			}
		}
		
		playAgain();
	}
	
	void playAgain()
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("\n\nDo you want to play again ? yes or no: ");
		String playAgain = scan.nextLine();
		
		switch (playAgain)
		{
		case ("yes"): GuessNumber.startGame() ; break;
		case ("no"): System.out.println("\n\nThank you for playing\n\nSee you next time !");break;
		default: System.out.println("\n\nThank you for playing\n\nSee you next time !");
		}
	}

}

public class GuessNumber {
	
	static String username;
	static String password;
	String usernameInput;
	String passwordInput;
	

	public static void main(String[] args) {
		
		Scanner scan = new Scanner (System.in);
		System.out.println("Hello and welcome to the console.\n\nTo Enter please create a username: ");
		String username = scan.nextLine();
				
		System.out.println("Please create a password (case sensitive): ");
		String password = scan.nextLine();
		
		System.out.println("Thank you.\n\nNow please login to start playing");
		login(username, password);
	}
	
	private static void login (String username, String password)
	{

		Scanner scan = new Scanner (System.in);
		System.out.println("Enter your username: ");
		String usernameInput = scan.nextLine();
		if (username.equalsIgnoreCase(usernameInput))
		{
			System.out.println("Enter your password (case sensitive): ");
			String passwordInput = scan.nextLine();
			if (password.equals(passwordInput))
			{
				System.out.println("\nlet's play !");
				startGame();
			}
			else
			{
				System.out.println("sorry wrong password. \nPlease log in again");
				login(username, password);
			}
		}
		else
		{
			System.out.println("sorry wrong username. \nPlease log in again");
			login(username, password);
		}
		
	}
	
	public static void startGame()
	{
		System.out.println("\n*** GUESS THE NUMBER BETWEEN 0 AND 9 ***\n\n3 players & 2 computers are playing\nThe first to win 3 rounds wins the Game !\n");
		// initiate the umpire
		Umpire u = new Umpire(); // create the object Umpire
		u.getTheNames();
		u.collectNums(); // Umpire collects the random mumber to guess
		u.compare(); // Umpire compares all the number and declares a winner
		u.countResult(); // displays the result
		u.declareWinner();
	}

}
//By IzzyNotEZ @Bizou972