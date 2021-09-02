import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GameTester {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		Random rand = new Random();

		Garage g = new Garage();
		Player p1 = new Player("Challenger Hellcat", "Muscle", 707, 3.6, 3, 1, 400);
		Player p2 = new Player("Porsche GT3 RS", "Sports", 680, 3.5, 3, 1, 400);
		Player p3 = new Player("Mercedes AMG GTR", "Sports", 675, 3.5, 3, 1, 400);
		Player p4 = new Player("McLaren 720s", "Sports", 710, 2.6, 3, 1, 400);
		Player p5 = new Player("Huracan Perfomante", "Sports", 700, 2.3, 3, 1, 400);
		Player p6 = new Player("Bentley Continental", "Luxury", 650, 4.3, 3, 1, 400);

		g.add(p1);
		g.add(p2);
		g.add(p3);
		g.add(p4);
		g.add(p5);
		g.add(p6);

		System.out.println("\t\t\t\t\t\t\t\t\t----------Welcome to Drag Race----------");
		System.out.println("Player One, enter your name: ");
		String playerName1 = in.nextLine();
		System.out.println("Player Two, enter your name: ");
		String playerName2 = in.nextLine();

		System.out.println("There are six vehicles in the garage.\n");

		ArrayList<Player> playerOne = new ArrayList<Player>();
		ArrayList<Player> playerTwo = new ArrayList<Player>();

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < g.getGarage().size(); j++) {
				System.out.println(g + "\n");
				System.out.println(playerName1 + " - Pick a car: ");
				int n = in.nextInt();

				while (n < 1 || n > g.getGarage().size()) {
					System.out.println("Enter a valid car: ");
					n = in.nextInt();
				}

				playerOne.add(g.getPlayer(n));
				g.removePlayer((n));

				System.out.println(g + "\n");
				System.out.println(playerName2 + " - Pick a car: ");
				n = in.nextInt();

				while (n < 1 || n > g.getGarage().size()) {
					System.out.println("Enter a valid car: ");
					n = in.nextInt();
				}

				playerTwo.add(g.getPlayer(n));
				g.removePlayer((n));

			}
		}

		int playerOneDubs = 0;
		int playerTwoDubs = 0;

		boolean runGame = true;
		boolean round1 = true;
		while (runGame) {

			System.out.println(playerName1 + "'s Team: ");
			for (int i = 0; i < playerOne.size(); i++) {
				System.out.print("(" + (i + 1) + ") " + playerOne.get(i).getName() + " | ");
			}
			System.out.println("\n");
			System.out.println(playerName2 + "'s Team: ");
			for (int i = 0; i < playerTwo.size(); i++) {
				System.out.print("(" + (i + 1) + ") " + playerTwo.get(i).getName() + " | ");
			}

			System.out.println(playerName1 + ", which car would you like to bring to the strip?");
			int choicep1 = in.nextInt();
			System.out.println(playerName2 + ", which car would you like to bring to the strip?");
			int choicep2 = in.nextInt();

			System.out.println(
					playerOne.get(choicep1 - 1).getName() + " VS " + playerTwo.get(choicep2 - 1).getName() + "\n");

			while (round1) {
				if (playerOne.size()==0||playerOne.size()==0) {
					System.out.println("Race over ");
					break;
				}
				System.out.println(playerName1 + ", what would you like to do?\n(1)Keep Racing\n(2)Accelerate ("
						+ playerOne.get(choicep1 - 1).getAccelerate() + " left)" + "\n(3)Use Turbo Boost ("
						+ playerOne.get(choicep1 - 1).getTurbo() + " left)");

				int moveP1 = in.nextInt();

				if (playerOne.get(choicep1 - 1).getPosition() >= 400
						&& playerTwo.get(choicep2 - 1).getPosition() < playerOne.get(choicep1 - 1).getPosition()) {
					System.out.println(playerName1 + " wins Round 1");
					playerOneDubs++;
					playerOne.remove(choicep1 - 1);
					playerTwo.remove(choicep2 - 1);
					break;
				} else if (playerTwo.get(choicep2 - 1).getPosition() >= 400
						&& playerTwo.get(choicep2 - 1).getPosition() > playerOne.get(choicep1 - 1).getPosition()) {
					System.out.println(playerName2 + " wins Round 1");
					playerTwoDubs++;
					playerOne.remove(choicep1 - 1);
					playerTwo.remove(choicep2 - 1);
					break;
				} else {
					if (moveP1 == 1) {
						if (playerOne.get(choicep1 - 1).getPosition() >= 400 && playerTwo.get(choicep2 - 1)
								.getPosition() < playerOne.get(choicep1 - 1).getPosition()) {
							System.out.println(playerName1 + " wins this race");
							playerOneDubs++;
							playerOne.remove(choicep1 - 1);
							playerTwo.remove(choicep2 - 1);
							break;
						} else if (playerTwo.get(choicep2 - 1).getPosition() >= 400 && playerTwo.get(choicep2 - 1)
								.getPosition() > playerOne.get(choicep1 - 1).getPosition()) {
							System.out.println(playerName2 + " wins this race");
							playerTwoDubs++;
							playerOne.remove(choicep1 - 1);
							playerTwo.remove(choicep2 - 1);
							break;
						} else {
							int distance = rand.nextInt(40) + 25;
							playerOne.get(choicep1 - 1).keepRacing(distance);
						}
					} else if (moveP1 == 2) {
						if (playerOne.get(choicep1 - 1).getPosition() >= 400 && playerTwo.get(choicep2 - 1)
								.getPosition() < playerOne.get(choicep1 - 1).getPosition()) {
							System.out.println(playerName1 + " wins this race");
							playerOneDubs++;
							playerOne.remove(choicep1 - 1);
							playerTwo.remove(choicep2 - 1);
							break;
						} else if (playerTwo.get(choicep2 - 1).getPosition() >= 400 && playerTwo.get(choicep2 - 1)
								.getPosition() > playerOne.get(choicep1 - 1).getPosition()) {
							System.out.println(playerName2 + " wins this race");
							playerTwoDubs++;
							playerOne.remove(choicep1 - 1);
							playerTwo.remove(choicep2 - 1);
							break;
						} else {
							if (playerOne.get(choicep1 - 1).getAccelerate() == 0) {
								System.out.println("Acceleration's are used, skip turn");
							} else {
								int distance = rand.nextInt(55) + 45;
								playerOne.get(choicep1 - 1).accelerate(distance);
							}
						}
					} else if (moveP1 == 3) {
						if (playerOne.get(choicep1 - 1).getPosition() >= 400 && playerTwo.get(choicep2 - 1)
								.getPosition() < playerOne.get(choicep1 - 1).getPosition()) {
							System.out.println(playerName1 + " wins this race");
							playerOneDubs++;
							playerOne.remove(choicep1 - 1);
							playerTwo.remove(choicep2 - 1);
							break;
						} else if (playerTwo.get(choicep2 - 1).getPosition() >= 400 && playerTwo.get(choicep2 - 1)
								.getPosition() > playerOne.get(choicep1 - 1).getPosition()) {
							System.out.println(playerName2 + " wins this race");
							playerTwoDubs++;
							playerOne.remove(choicep1 - 1);
							playerTwo.remove(choicep2 - 1);
							break;
						} else {
							if (playerOne.get(choicep1 - 1).getTurbo() == 0) {
								System.out.println("Turbo's already used, skip turn");
							} else {
								int distance = rand.nextInt(75) + 65;
								playerOne.get(choicep1 - 1).turboBoost(distance);
							}
						}
					}

					System.out.println(
							playerName1 + ", your car is at: " + playerOne.get(choicep1 - 1).getPosition() + "m/400m");
					System.out.println(playerName2 + ", your car is at: " + playerTwo.get(choicep2 - 1).getPosition()
							+ "m/400m\n");

					System.out.println(playerName2 + ", what would you like to do?\n(1)Keep Racing\n(2)Accelerate ("
							+ playerTwo.get(choicep2 - 1).getAccelerate() + " left)" + "\n(3)Use Turbo Boost ("
							+ playerTwo.get(choicep2 - 1).getTurbo() + " left)");

					int moveP2 = in.nextInt();

					if (moveP2 == 1) {
						if (playerOne.get(choicep1 - 1).getPosition() >= 400 && playerTwo.get(choicep2 - 1)
								.getPosition() < playerOne.get(choicep1 - 1).getPosition()) {
							System.out.println(playerName1 + " wins this race");
							playerOneDubs++;
							playerOne.remove(choicep1 - 1);
							playerTwo.remove(choicep2 - 1);
							break;
						} else if (playerTwo.get(choicep2 - 1).getPosition() >= 400 && playerTwo.get(choicep2 - 1)
								.getPosition() > playerOne.get(choicep1 - 1).getPosition()) {
							System.out.println(playerName2 + " wins this race");
							playerTwoDubs++;
							playerOne.remove(choicep1 - 1);
							playerTwo.remove(choicep2 - 1);
							break;
						} else {
							int distance = rand.nextInt(40) + 25;
							playerTwo.get(choicep2 - 1).keepRacing(distance);
						}
					} else if (moveP2 == 2) {
						if (playerOne.get(choicep1 - 1).getPosition() >= 400 && playerTwo.get(choicep2 - 1)
								.getPosition() < playerOne.get(choicep1 - 1).getPosition()) {
							System.out.println(playerName1 + " wins this race");
							playerOneDubs++;
							playerOne.remove(choicep1 - 1);
							playerTwo.remove(choicep2 - 1);
							break;
						} else if (playerTwo.get(choicep2 - 1).getPosition() >= 400 && playerTwo.get(choicep2 - 1)
								.getPosition() > playerOne.get(choicep1 - 1).getPosition()) {
							System.out.println(playerName2 + " wins this race");
							playerTwoDubs++;
							playerOne.remove(choicep1 - 1);
							playerTwo.remove(choicep2 - 1);
							break;
						} else {
							if (playerTwo.get(choicep2 - 1).getAccelerate() == 0) {
								System.out.println("Accelerations are used, skip turn");
							} else {
								int distance = rand.nextInt(55) + 45;
								playerTwo.get(choicep2 - 1).accelerate(distance);
							}
						}
					} else if (moveP2 == 3) {
						if (playerOne.get(choicep1 - 1).getPosition() >= 400 && playerTwo.get(choicep2 - 1)
								.getPosition() < playerOne.get(choicep1 - 1).getPosition()) {
							System.out.println(playerName1 + " wins this race");
							playerOneDubs++;
							playerOne.remove(choicep1 - 1);
							playerTwo.remove(choicep2 - 1);
							break;
						} else if (playerTwo.get(choicep2 - 1).getPosition() >= 400 && playerTwo.get(choicep2 - 1)
								.getPosition() > playerOne.get(choicep1 - 1).getPosition()) {
							System.out.println(playerName2 + " wins this race");
							playerTwoDubs++;
							playerOne.remove(choicep1 - 1);
							playerTwo.remove(choicep2 - 1);
							break;
						} else {
							if (playerTwo.get(choicep2 - 1).getTurbo() == 0) {
								System.out.println("Turbo already used, skip turn");
							} else {
							int distance = rand.nextInt(75) + 65;
							playerTwo.get(choicep2 - 1).turboBoost(distance);
							}
						}
					}

					System.out.println(
							playerName1 + ", your car is at: " + playerOne.get(choicep1 - 1).getPosition() + "m/400m");
					System.out.println(playerName2 + ", your car is at: " + playerTwo.get(choicep2 - 1).getPosition()
							+ "m/400m\n");

				}
			}
		}

		if (playerOneDubs > playerTwoDubs) {
			System.out.println("Winner of the drag race is " + playerName1);
		} else if (playerOneDubs < playerTwoDubs) {
			System.out.println("Winner of the drag race is " + playerName2);
		} else {
			System.out.println("It is a tie");
		}
		in.close();
		
	}
}
