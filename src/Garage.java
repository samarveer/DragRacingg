import java.util.ArrayList;

public class Garage {

	ArrayList<Player> g = new ArrayList<Player>();
	int[] choice = new int[3];

	public void add(Player j) {
		g.add(j);
	}

	public ArrayList<Player> getGarage() {
		return g;
	}

	public Player getPlayer(int n) {
		return g.get(n - 1);
	}

	public void removePlayer(int n) {
		g.remove(n - 1);
	}

	public String toString() {
		String output = "";
		for (int i = 0; i < g.size(); i++) {
			if (g.get(i) != null) {
				output += ("(" + (i + 1) + ")" + g.get(i)).toString();
			}
			output += "\n";
		}
		return output;
	}
}
