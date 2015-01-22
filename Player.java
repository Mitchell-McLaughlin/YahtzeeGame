/*
 * Mitchell McLaughlin
 * CompSci 251
 * Program 8
 * Ke Chen for TA
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Player {

	private String name;

	private ScoringBox scores[];

	public Player(String name) {
		this.name = name;
		scores = new ScoringBox[19];
		NumberBox numbers[] = new NumberBox[6];
		ScoringBox topSubtotal[] = new ScoringBox[7];
		ScoringBox bottomSubtotal[] = new ScoringBox[7];
		ScoringBox total[] = new ScoringBox[3];
		DiceRollBox otherBoxes[] = new DiceRollBox[12];
		YahtzeeBox y;
		for (int i = 0; i < 6; ++i)
			topSubtotal[i] = scores[i] = otherBoxes[i] = numbers[i] = new NumberBox(
					i + 1);
		topSubtotal[6] = scores[6] = new NumbersBonusBox(numbers);
		total[0] = scores[7] = scores[16] = new TotalBox(topSubtotal,
				"Upper Score");
		bottomSubtotal[0] = scores[8] = otherBoxes[6] = new OfAKindBox(3);
		bottomSubtotal[1] = scores[9] = otherBoxes[7] = new OfAKindBox(4);
		bottomSubtotal[2] = scores[10] = otherBoxes[8] = new FullHouseBox();
		bottomSubtotal[3] = scores[11] = otherBoxes[9] = new SmallStraightBox();
		bottomSubtotal[4] = scores[12] = otherBoxes[10] = new LargeStraightBox();
		bottomSubtotal[5] = scores[13] = y = new YahtzeeBox();
		bottomSubtotal[6] = scores[14] = otherBoxes[11] = new ChanceBox();
		total[1] = scores[15] = new TotalBox(bottomSubtotal, "Lower Score");
		total[2] = scores[17] = new YahtzeeBonusBox(y, otherBoxes);
		scores[18] = new TotalBox(total, "Total");
	}

	public boolean score(int box, DiceCup roll) {
		if (box > 0 && box <= scores.length && !scores[box - 1].isUsed()) {
			scores[box - 1].score(roll);
			return true;
		}
		return false;
	}

	public int totalScore() {
		return scores[18].getScore();
	}

	public String getName() {
		return name;
	}

	private void takeTurn(DiceCup cup, Scanner stdIn) {
		int rolls = 2;
		int box = -1;
		boolean scored = false;
		cup.unlockAll();
		cup.roll();
		System.out.println(this);
		do {
			System.out.println(cup);
			System.out
					.print((rolls > 0 ? ("[T]oggle locks, [R]eroll(" + rolls + "), ")
							: "")
							+ "[S]core? ");
			String choice = stdIn.next();
			switch (choice.trim().charAt(0)) {
			case 't':
			case 'T':
				System.out.print("Die? ");
				cup.toggle(stdIn.nextInt() - 1);
				break;
			case 'r':
			case 'R':
				cup.roll();
				--rolls;
				break;
			case 's':
			case 'S':
				do {
					System.out.println("Score as? ");
				} while (!score(box = stdIn.nextInt(), cup));
				scored = true;
				break;
			default:
				System.out.println("ERROR ");
			}
		} while (!scored);

		System.out.println("\nThat scored " + scores[box - 1].getScore()
				+ " points");

	}

	public String toString() {
		String s = name;
		for (int i = 0; i < scores.length; ++i)
			s += String.format("\n%2d) ", i + 1) + scores[i];
		return s + "\n";
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int totalBoxes = 13;
		Scanner stdIn = new Scanner(System.in);
		ArrayList<Player> players = inputPlayers(stdIn);
		DiceCup cup = new DiceCup(5);

		for (int turn = 0; turn < totalBoxes; ++turn) {
			for (Player p : players) {
				p.takeTurn(cup, stdIn);
				if (turn == totalBoxes - 1)
					System.out.println("Total for " + p.toString());
			}
		}

		System.out.println("\n Final Scores\n--------------");
		for (Player p : players) {
			System.out.printf("%10s: %3d", p.getName(), p.totalScore());
		}
	}

	private static ArrayList<Player> inputPlayers(Scanner in) {
		ArrayList<Player> players = new ArrayList<Player>();
		do {
			System.out.print("Enter name: ");
			String name = in.nextLine();
			players.add(new Player(name));
			System.out.print("Another? [y/n] ");
		} while (Character.toLowerCase(in.nextLine().trim().charAt(0)) == 'y');
		return players;
	}

}
