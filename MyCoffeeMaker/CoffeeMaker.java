import java.util.Scanner;

public class CoffeeMaker {
	private Player _player = null;
	private House _house = null;
	
	public CoffeeMaker(Player p, House h) {
		_player = p;
		_house = h;
	}
	
	public int run(Scanner in) {
		int toReturn = 0;
		
		String move = null;
		
		boolean gameOver = false;
		boolean win = false;
		
		while (!gameOver) {
			System.out.println(_house.getCurrentRoomInfo());
			System.out.println(" INSTRUCTIONS (N,S,L,I,H,D) > ");
			move = in.nextLine();
			int status = doSomething(move);
			if(status==1)
				win = true;
			gameOver = isGameOver(status);
		}
		
		System.out.println(win + ": " + winOrLoseString(win));
		if(win) {
			toReturn = 1;
		} else {
			toReturn = -1;
		}
		in.close();
		
		return toReturn;
	}
	
	public int doSomething(String move) {
		int toReturn = 0;
		move = move.toLowerCase();
		switch(move) {
			case "n":
				if(!_house.moveNorth()) {
					toReturn = 2;
				}
				break;
			case "s":
				if(!_house.moveSouth()) {
					toReturn = 2;
				}
				break;
			case "l":
				_house.look(_player, null);
				break;
			case "i":
				System.out.println(_player.showInventory());
				break;
			case "d":
				boolean finalStatus = _player.drink();
				if(finalStatus) {
					toReturn = 1;
				} else {
					toReturn = -1;
				}
				break;
			case "h":
				showInstructions();
				break;
			default:
				System.out.println("What?");
		}
		
		return toReturn;
	}
	
	public boolean isGameOver(int status) {
		boolean gameOver = false;
		if (status == 1) {
			gameOver = true;
			System.out.println("You win!");
		} else if (status == -1) {
			gameOver = true;
		} else if (status == 2) {
			System.out.println("You run into the wall, receiving a concussion.\nYou now need coffee to use any brain cells you have left.");
		}
		
		return gameOver;
	}
	
	public String winOrLoseString(boolean win) {
		String str = "You lose!";
		if(win)
			str = "You win!";
		
		return str;
	}
	
	public void showInstructions() {
		System.out.println("INPUT (case-insensitive):");
		System.out.println("'N': player moves North if a door exists");
		System.out.println("'S': player moves South if a door exists");
		System.out.println("'L': player searches the room and collects items if they exist");
		System.out.println("'I': player looks into inventory and is told the items collected");
		System.out.println("'H': lists possible commands and effects (AKA this)");
		System.out.println("'D': player drinks items and ends the game, winning only if the player has collected coffee, sugar, and cream");
	}
	
	public static void main(String[] args) {
		System.out.println("Coffee Maker Quest 1.0");
		Player p = new Player();
		House h = new House(6);
		CoffeeMaker game = new CoffeeMaker(p, h);
		game.run(new Scanner(System.in));
	}
}
