import java.util.Scanner;

import javax.swing.JOptionPane;

public class MainClass {

	public static void main(String[] args)

	{
		
		Scanner myKeyboard = new Scanner(System.in);
		String doAgain;
		int gameCount = 0;
		int myChoice;
		float winGame = 0;
		float evenCount = 0;
		float oddCount = 0;
		float winPercent;
		float evenPercent;
		float oddPercent;

		do {

			myChoice = Integer.parseInt(JOptionPane.showInputDialog(null, "A dice was rolled.\nTry to guess the number (1-6)."));
			int cpuChoice = 1 + (int) ( Math.random() * 6 );
			while (myChoice < 1 || myChoice > 6)
			{
				if(myChoice < 1 )
				{
					JOptionPane.showMessageDialog(null, "Too low.\nNumbers below 1 are not valid.\nEnter a higher number.");
				}
				else if (myChoice > 6)
				{
					JOptionPane.showMessageDialog(null, "Too high. Numbers above 10 are not valid. Enter a lower number.");
				}
				myChoice = Integer.parseInt(JOptionPane.showInputDialog(null, "A dice was rolled.\nTry to guess the number (1-6)."));
			}
			if (myChoice == cpuChoice) 
			{

				JOptionPane.showMessageDialog(null, "You've guessed it!");
				if (myChoice % 2 == 0)
				{
					evenCount++;
					winGame++;
				}
				else if (cpuChoice % 2 != 0)
				{
					oddCount++;
					winGame++;
				}
			}
			else 
			{
				JOptionPane.showMessageDialog(null, "Sorry, the dice rolled on a(n) " + cpuChoice + ".");
				if (myChoice % 2 == 0)
				{
					evenCount++;
				}
				else if (cpuChoice % 2 != 0)
				{
					oddCount++;
				}
			}
			doAgain = JOptionPane.showInputDialog("Do it again? (Y/N)").toUpperCase();
			while(!(doAgain.matches("[YN]+"))) 
			{				
				JOptionPane.showMessageDialog(null, "Error: Invalid choice.");
				doAgain = JOptionPane.showInputDialog("Do it again? (Y/N)").toUpperCase();

			}
			gameCount++;
		} while (!(doAgain.equals("N")));

		evenPercent = (evenCount / gameCount) * 100;
		oddPercent = (oddCount / gameCount) * 100;
		winPercent = (winGame / gameCount) * 100;

		JOptionPane.showMessageDialog(null, "Here are your stats: \n" + "Number of games played: " + gameCount + "\n" + 
				"Percent of games won: " + winPercent + "%\n" + "Percent of even guesses by you: " + evenPercent + "%\n" + "Percent of odd numbers the dice landed on: "
				+ oddPercent + "%");
		JOptionPane.showMessageDialog(null,"GoodBye!");
	}
}