import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Elevens {
	public static void main(String args[]) {
		Scanner kbReader = new Scanner(System.in);
		int handSize = 0;
		boolean dead = false;
		String[] valuesInHand = new String[12];
		int sum;
		int card1 = 0;
		int card2 = 0;
		int card3 = 0;
		//int count = 0;
		String choice = "";
		boolean death = false;
		Deck elevens = new Deck();
		elevens.shuffle(elevens);
		elevens.shuffle(elevens);
		System.out
				.println("This is Elevens. Remove all the cards in my hand to win.");
		System.out
				.println("But! You can only remove two cards that add to 11 per turn.");
		System.out
				.println("The only way to remove face cards is to remove all at the same time.");
		System.out.println("An ace is a 1.");

		for (int i = 0; i < 11; i++) {
			handSize++;
			System.out.print(i + 1 + ": " + elevens.getNextCard(i));
			System.out.println(" (Value = " + elevens.getNextCard(i).getValue()
					+ ")");
		}
		while (handSize > 0) {
			choice = "";
			System.out.println("\n");
			for (int i = 0; i < handSize; i++) {
				valuesInHand[i] = elevens.getNextCard(i).getKind();
			}
			if ((Arrays.asList(valuesInHand).contains("five") && (Arrays
					.asList(valuesInHand).contains("six")))
					|| (Arrays.asList(valuesInHand).contains("four") && (Arrays
							.asList(valuesInHand).contains("seven")))
					|| (Arrays.asList(valuesInHand).contains("three") && (Arrays
							.asList(valuesInHand).contains("eight")))
					|| (Arrays.asList(valuesInHand).contains("two") && (Arrays
							.asList(valuesInHand).contains("nine")))
					|| (Arrays.asList(valuesInHand).contains("ace") && (Arrays
							.asList(valuesInHand).contains("ten")))
					|| (Arrays.asList(valuesInHand).contains("jack")
							&& (Arrays.asList(valuesInHand).contains("queen")) && (Arrays
								.asList(valuesInHand).contains("king")))) {
				System.out
						.println("Choose your first card. Type its number (left-most number).");
				card1 = kbReader.nextInt();
				System.out
						.println("Choose your second card. Type its number (left-most number).");
				card2 = kbReader.nextInt();
				if (elevens.getNextCard(card1 - 1).isFace()
						&& elevens.getNextCard(card2 - 1).isFace()) {
					while (true) {
						System.out
								.println("Do you want to remove a 3rd face card? Enter y for yes and n for no.");// something// wrong// here
						choice = kbReader.nextLine();
						//count++;
						//System.out.println(count);
						if (choice.equals("y")) {
							System.out
									.println("Choose your third card. Type its number (left-most number).");
							card3 = kbReader.nextInt();
							//count++;
							//System.out.println(count);
							break;
						} else if (choice.equals("n")) {
							//count++;
							//System.out.println(count);
							break;
						}
					}
				}
				if (elevens.getNextCard(card1 - 1).getValue()
						+ elevens.getNextCard(card2 - 1).getValue() == 11) {
					handSize -= 2;
					System.out.println("You removed the "
							+ elevens.getNextCard(card1 - 1) + " and "
							+ elevens.getNextCard(card2 - 1) + "("
							+ elevens.getNextCard(card1 - 1).getValue()
							+ " and "
							+ elevens.getNextCard(card2 - 1).getValue() + ")");
					elevens.removeCard(card1);
					elevens.removeCard(card2);
					System.out.println("good");
				} else if (elevens.getNextCard(card1 - 1).isFace() == true
						&& elevens.getNextCard(card2 - 1).isFace() == true
						&& elevens.getNextCard(card3 - 1).isFace() == true) {
					System.out.println("! You removed the "
							+ elevens.getNextCard(card1 - 1) + ", the "
							+ elevens.getNextCard(card2 - 1) + ", and the "
							+ elevens.getNextCard(card3 - 1) + "("
							+ elevens.getNextCard(card1 - 1).getValue() + ", "
							+ elevens.getNextCard(card2 - 1).getValue()
							+ ", and "
							+ elevens.getNextCard(card3 - 1).getValue() + ")");
					elevens.removeCard(card1);
					elevens.removeCard(card2);
					elevens.removeCard(card3);
					handSize -= 3;
				} else {
					System.out.println("Those cards don't add up to 11.");
					continue;
				}
				handSize++;
				for (int i = 0; i < handSize; i++) {
					System.out.print(i + 1 + ": " + elevens.getNextCard(i));
					System.out.println(" (Value = "
							+ elevens.getNextCard(i).getValue() + ")");
				}
			} else {
				death = true;
				break;
			}
		}
		if (death == true) {
			System.out.println("You lose!");
		} else {
			System.out.println("You win!");
		}
	}
}

