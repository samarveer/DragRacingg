public class Player {

	private String name;
	private String type;
	private int horsepower;
	private double zerotosixty;
	private int turbo;
	private int accelerate;
	private int totalDistance;
	private int distanceLeft = 400;
	private int position;

	public Player(String name, String type, int horsepower, double zerotosixty, int accelerate, int turbo,
			int distance) {
		this.name = name;
		this.type = type;
		this.horsepower = horsepower;
		this.zerotosixty = zerotosixty;
		this.turbo = turbo;
		this.accelerate = accelerate;
		this.totalDistance = distance;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public int getHorsepower() {
		return horsepower;
	}

	public double getZTS() {
		return zerotosixty;
	}

	public int getAccelerate() {
		return accelerate;
	}

	public int getTurbo() {
		return turbo;
	}

	public int getTotalDistance() {
		return totalDistance;
	}

	public int keepRacing(int distance) {
		distanceLeft -= distance;
		position = totalDistance - distanceLeft;
		return position;
	}

	public int accelerate(int distance) {
		distanceLeft -= distance;
		position = totalDistance - distanceLeft;
		accelerate--;
		return position;
	}

	public int turboBoost(int distance) {
		distanceLeft -= distance;
		position = totalDistance - distanceLeft;
		turbo--;
		return position;
	}

	public int getPosition() {
		return position;
	}

	public String toString() {
		return name + "\nType: " + type + "\nHorsepower: " + horsepower + "\n0-60: " + zerotosixty + "s\n";
	}
}
