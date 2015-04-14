import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

public class GameTests {
	@Test
	// Verify that calling doSomething with 'N' or 'n' results 
	// in the moveNorth method being called on the House.
	public void gameMovesPlayerNorthWhenGivenStringN()
	{
		House house = mock(House.class);

		Game game = new Game(new Player(), house);
		game.doSomething("N");
		game.doSomething("n");

		verify(house, times(2)).moveNorth();        
	}

	@Test
	// Verify that the game returns 0 when the string 'N' or 'n'
	// is passed to the doSomething method.
	public void doSomethingReturnsZeroWhenNorthCommandIsGiven()
	{
		Game game = new Game(new Player(), new House(5));

		assertEquals(0, game.doSomething("N"));
		assertEquals(0, game.doSomething("n"));
	}

	@Test
	// Verify that calling doSomething with 'S' or 's' results 
	// in the moveNorth method being called on the House.
	public void gameMovesPlayerSouthWhenGivenStringS()
	{
		House house = mock(House.class);

		Game game = new Game(new Player(), house);
		game.doSomething("S");
		game.doSomething("s");

		verify(house, times(2)).moveSouth();        
	}

	@Test
	// Verify that the game returns 0 when the string 'S' or 's'
	// is passed to the doSomething method.
	public void doSomethingReturnsZeroWhenSouthCommandIsGiven()
	{
		Game game = new Game(new Player(), new House(5));

		assertEquals(0, game.doSomething("S"));
		assertEquals(0, game.doSomething("s"));
	}

	@Test
	// Verify that calling doSomething with 'L' or 'l' results 
	// in the look method being called on the House.
	public void gameLooksInCurrentRoomWhenGivenStringL()
	{
		House house = mock(House.class);
		Player player = new Player();

		Game game = new Game(player, house);
		game.doSomething("L");
		game.doSomething("l");

		verify(house, times(2)).look(player, null);        
	}

	@Test
	// Verify that the game returns 0 when the string 'L' or 'l'
	// is passed to the doSomething method.
	public void doSomethingReturnsZeroWhenLookCommandIsGiven()
	{
		Game game = new Game(new Player(), new House(5));

		assertEquals(0, game.doSomething("L"));
		assertEquals(0, game.doSomething("l"));
	}

	@Test
	// Verify that calling doSomething with 'I' or 'i' results 
	// in the showInventory method being called on the Player.
	public void gameShowsPlayersInventoryWhenGivenStringI()
	{
		House house = new House(5);
		Player player = mock(Player.class);

		Game game = new Game(player, house);
		game.doSomething("I");
		game.doSomething("i");

		verify(player, times(2)).showInventory();     
	}

	@Test
	// Verify that the game returns 0 when the string 'I' or 'i'
	// is passed to the doSomething method.
	public void doSomethingReturnsZeroWhenInventoryCommandIsGiven()
	{
		Game game = new Game(new Player(), new House(5));

		assertEquals(0, game.doSomething("I"));
		assertEquals(0, game.doSomething("l"));
	}

	@Test
	// Verify that calling doSomething with 'D' or 'd' results 
	// in the drink method being called on the Player.
	public void gameShowsPlayersInventoryWhenGivenStringD()
	{
		House house = new House(5);
		Player player = mock(Player.class);

		Game game = new Game(player, house);
		game.doSomething("D");
		game.doSomething("d");

		verify(player, times(2)).drink();        
	}

	@Test
	// Verify that the game returns -1 when the string 'D' or 'd'
	// is passed to the doSomething method if the player has not
	// acquired all the items.
	public void doSomethingReturnsNegativeOneIfPlayerDrinksWithoutAllItems()
	{        
		Game game = new Game(new Player(), new House(5));

		assertEquals(-1, game.doSomething("D"));
		assertEquals(-1, game.doSomething("d"));
	}

	@Test
	// Verify that the game returns 1 when the string 'D' or 'd'
	// is passed to the doSomething method if the player has 
	// acquired all the items.
	public void doSomethingReturnsOneIfPlayerDrinksWithAllItems()
	{        
		Game game = new Game(new Player(true, true, true), new House(5));

		assertEquals(1, game.doSomething("D"));
		assertEquals(1, game.doSomething("d"));
	}

	@Test
	// Verify that the game returns 0 when the string 'H' or 'h'
	// is passed to the doSomething method.
	public void doSomethingReturnsZeroWhenHelpCommandIsGiven()
	{
		Game game = new Game(new Player(), new House(5));

		assertEquals(0, game.doSomething("H"));
		assertEquals(0, game.doSomething("h"));
	}
}