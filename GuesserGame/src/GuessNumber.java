import java.util.*;

class Giver 
{
	int giveNum;
	int giveNum()
	{
		Random rand = new Random(); // get a random number between 0 and 9
		giveNum = rand.nextInt(10);
		return giveNum;
	}
}

class Player
{
	int guessNum; // store the number guessed by players
	String username; // store the player username
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
	String username(int player)
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("Player "+ player+" enter your name "); // players input their guessed number
		username=scan.nextLine();
		return username;
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
	static String usernamePlayer1;
	static String usernamePlayer2;
	static String usernamePlayer3;
	
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
	
	void getTheNames()
	{
		Player p1= new Player(); // create the object of player 1
		Player p2= new Player(); // create the object of player 2
		Player p3= new Player(); // create the object of player 3
		
		usernamePlayer1 = p1.username(1);
		usernamePlayer2 = p2.username(2);
		usernamePlayer3 = p3.username(3);
		
		System.out.println();
		System.out.println("Welcome "+usernamePlayer1+", "+usernamePlayer2+" and "+usernamePlayer3+" ! You will play against 2 computers\nMay the best Guesser win !\n\n");
	}
	
	void collectNums()
	{
		System.out.println("ROUND "+round+"\n");
		Giver g = new Giver(); // create the object of Giver
		numFromGiver=g.giveNum(); // call the method to get the random number
	
		Player p1= new Player(); // create the object of player 1
		Player p2= new Player(); // create the object of player 2
		Player p3= new Player(); // create the object of player 3
		
		numFromPlayer1 = p1.guessNum(usernamePlayer1); // store the guessed number of player 1 in the variable numFromPlayer1
		numFromPlayer2 = p2.guessNum(usernamePlayer2); // store the guessed number of player 2 in the variable numFromPlayer2
		numFromPlayer3 = p3.guessNum(usernamePlayer3); // store the guessed number of player 3 in the variable numFromPlayer3
	
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
				System.out.println("=> "+usernamePlayer1+" and "+usernamePlayer2+" won this round !");
			}
			else if (numFromGiver == numFromPlayer3)
			{
				countPlayer1 ++;
				countPlayer3 ++;
				System.out.println("=> "+usernamePlayer1+" and "+usernamePlayer3+" won this round !");
			}
			else 
			{
				countPlayer1 ++;
				System.out.println("=> "+usernamePlayer1+" won this round !");
			}
		}
		else if (numFromGiver == numFromPlayer2)
		{
			if (numFromGiver == numFromPlayer3)
			{
				countPlayer3 ++;
				countPlayer2 ++;
				System.out.println("=> "+usernamePlayer2+" and "+usernamePlayer3+" won this round !");
			}
			else 
			{
				countPlayer2 ++;
				System.out.println("=> "+usernamePlayer2+" won this round !");
			}
		}
		else if (numFromGiver == numFromPlayer3)
		{
			countPlayer3 ++;
			System.out.println("=> "+usernamePlayer3+" won this round !");
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
		System.out.println(usernamePlayer1+": "+countPlayer1);
		System.out.println(usernamePlayer2+": "+countPlayer2);
		System.out.println(usernamePlayer3+": "+countPlayer3);
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
				case (0): System.out.println("!!! HURRAYYY "+usernamePlayer1.toUpperCase()+" WON THE GAME IN "+round+" ROUNDS !!!");break;
				case (1): System.out.println("!!! HURRAYYY "+usernamePlayer2.toUpperCase()+" WON THE GAME IN "+round+" ROUNDS !!!");break;
				case (2): System.out.println("!!! HURRAYYY "+usernamePlayer3.toUpperCase()+" WON THE GAME IN "+round+" ROUNDS !!!");break;
				case (3): System.out.println("!!! COMPUTER 1 WON THE GAME IN "+round+" ROUNDS !!!");break;
				case (4): System.out.println("!!! COMPUTER 1 WON THE GAME IN "+round+" ROUNDS !!!");break;
				}
			}
		}
	}
}

public class GuessNumber {

	public static void main(String[] args) {
		
		System.out.println("\n*** GUESS THE NUMBER BETWEEN 0 AND 9 ***\nThe first to win 3 rounds wins the Game !\n");
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