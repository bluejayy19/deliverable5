import java.util.Scanner;

public class Game {
	private Player _player = null;
	private House _house = null;
	
	public Game(Player p, House h) {
		_player = p;
		_house = h;
	}
	
	public int doSomething(String move) {
		int toReturn = 0;
		move = move.toLowerCase();
		switch(move) {
			case "n":
				_house.moveNorth();
				break;
			case "s":
				_house.moveSouth();
				break;
			case "i":
				_player.showInventory();
				break;
			case "d":
				boolean finalStatus = player.drink();
				break;
			default:
		}
		
		return toReturn;
	}
}
