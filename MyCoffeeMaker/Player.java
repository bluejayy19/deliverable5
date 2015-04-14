public class Player {

	private boolean _hasSugar = false;
	private boolean _hasCream = false;
	private boolean _hasCoffee = false;
	
	public Player() {
	
	}
	
	public Player(boolean sugar, boolean cream, boolean coffee) {
		_hasSugar = sugar;
		_hasCream = cream;
		_hasCoffee = coffee;
	}
	
	public void getSugar() {
		System.out.println("You found some sweet sugar!");
		_hasSugar = true;
	}
	
	public void getCream() {
		System.out.println("You found some creamy cream!");
		_hasCream = true;
	}
	
	public void getCoffee() {
		System.out.println("You found some caffeinated coffee!");
		_hasCoffee = true;
	}
	
	public boolean hasAllItems() {
		return (_hasCoffee && _hasCream && _hasSugar);
	}
	
	public String showInventory() {
		StringBuffer sb = new StringBuffer();
		if (_hasCoffee) {
			sb.append("You have a cup of delicious coffee.\n");
		} else {
			sb.append("YOU HAVE NO COFFEE!\n");
		}
		if (_hasCream) {
			sb.append("You have some fresh cream.\n");
		} else {
			sb.append("YOU HAVE NO CREAM!\n");
		}
		if (_hasSugar) {
			sb.append("You have some tasty sugar.\n");
		} else {
			sb.append("YOU HAVE NO SUGAR!\n");
		}
		
		return sb.toString();
	}
	
	public boolean drink() {
		boolean win = false;
		
		showInventory();
		
		System.out.println();
		
		if (_hasCoffee && _hasCream && _hasSugar) {
			System.out.println("You drink the beverage and are ready to study!");
			win = true;
		} else if (_hasCoffee) {
			if (!_hasCream) {
				System.out.println("Without cream, you get an ulcer and cannot study.");
			} else {
				System.out.println("Without sugar, the coffee is too bitter.  You cannot study.");
			}
		} else if (_hasCream) {
			if (!_hasSugar) {
				System.out.println("You drink the cream, but without caffeine, you cannot study.");
			} else {
				System.out.println("You drink the sweetened cream, but without caffeine, you cannot study.");
			}
		} else if (_hasSugar) {
			System.out.println("You eat the sugar, but without caffeine, you cannot study.");
		} else {
			System.out.println("You drink the air, as you have no coffee, sugar, or cream.\n"
					+ "The air is invigorating, but not invigorating enough.  You cannot study.");
		}
		return win;
	}
}
