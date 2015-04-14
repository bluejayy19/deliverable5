import java.util.Scanner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

public class CoffeeMakerTests {
	@Test
	// Verify that calling run results in the doSomething
	// and isGameOver methods being called.
	public void runCallsDoSomethingAndIsGameOver()
	{
		House house = mock(House.class);
		Player player = new Player(true,true,true);
		Scanner scan = new Scanner("d");

		CoffeeMaker game = new CoffeeMaker(player, house);
		CoffeeMaker spy = spy(game);
		spy.run(scan);

		verify(spy, times(1)).doSomething("d");
		verify(spy, times(1)).isGameOver(1);
	}
	
	@Test
	// Verify that calling run results in the doSomething
	// and isGameOver methods being called twice if the first
	// time that isGameOver is called it returns false.
	public void runCallsDoSomethingAndIsGameOverTwiceWithFalse()
	{
		House house = mock(House.class);
		Player player = new Player(true,true,true);
		Scanner scan = new Scanner("l\nd");

		CoffeeMaker game = new CoffeeMaker(player, house);
		CoffeeMaker spy = spy(game);
		spy.run(scan);

		verify(spy, times(2)).doSomething(anyString());
		verify(spy, times(2)).isGameOver(anyInt());
	}
	
	@Test
	// Verify that calling doSomething with 'N' or 'n' results 
	// in the moveNorth method being called on the House.
	public void gameMovesPlayerNorthWhenGivenStringN()
	{
		House house = mock(House.class);

		CoffeeMaker game = new CoffeeMaker(mock(Player.class), house);
		game.doSomething("N");
		game.doSomething("n");

		verify(house, times(2)).moveNorth();        
	}
	
	@Test
	// Verify that the game returns 0 when the string 'N' or 'n'
	// is passed to the doSomething method.
	public void doSomethingReturnsZeroWhenNorthCommandIsGiven()
	{
		House house = mock(House.class);
		CoffeeMaker game = new CoffeeMaker(mock(Player.class), house);
		when(house.moveNorth()).thenReturn(true);
		
		assertEquals(0, game.doSomething("N"));
		assertEquals(0, game.doSomething("n"));
	}
	
	@Test
	// Verify that calling doSomething with 'N' or 'n' 
	// when in the last room (with no North door) results 
	// in the doSomething method returning 2.
	public void doSomethingReturnsTwoWhenNorthCommandIsGivenAtEnd()
	{
		House house = mock(House.class);

		CoffeeMaker game = new CoffeeMaker(mock(Player.class), house);
		when(house.moveNorth()).thenReturn(false);
		
		assertEquals(2, game.doSomething("N"));
		assertEquals(2, game.doSomething("n"));
	}

	@Test
	// Verify that calling doSomething with 'S' or 's' results 
	// in the moveNorth method being called on the House.
	public void gameMovesPlayerSouthWhenGivenStringS()
	{
		House house = mock(House.class);

		CoffeeMaker game = new CoffeeMaker(mock(Player.class), house);
		game.doSomething("S");
		game.doSomething("s");

		verify(house, times(2)).moveSouth();        
	}

	@Test
	// Verify that the game returns 0 when the string 'S' or 's'
	// is passed to the doSomething method.
	public void doSomethingReturnsZeroWhenSouthCommandIsGiven()
	{
		House house = mock(House.class);
		CoffeeMaker game = new CoffeeMaker(mock(Player.class), house);
		when(house.moveSouth()).thenReturn(true);

		assertEquals(0, game.doSomething("S"));
		assertEquals(0, game.doSomething("s"));
	}
	
	@Test
	// Verify that calling doSomething with 'S' or 's' 
	// when in the last room (with no North door) results 
	// in the doSomething method returning 2.
	public void doSomethingReturnsTwoWhenSouthCommandIsGivenAtBeginning()
	{
		House house = mock(House.class);

		CoffeeMaker game = new CoffeeMaker(mock(Player.class), house);
		when(house.moveSouth()).thenReturn(false);
		
		assertEquals(2, game.doSomething("N"));
		assertEquals(2, game.doSomething("n"));
	}

	@Test
	// Verify that calling doSomething with 'L' or 'l' results 
	// in the look method being called on the House.
	public void gameLooksInCurrentRoomWhenGivenStringL()
	{
		House house = mock(House.class);
		Player player = new Player();

		CoffeeMaker game = new CoffeeMaker(player, house);
		game.doSomething("L");
		game.doSomething("l");

		verify(house, times(2)).look(player, null);        
	}

	@Test
	// Verify that the game returns 0 when the string 'L' or 'l'
	// is passed to the doSomething method.
	public void doSomethingReturnsZeroWhenLookCommandIsGiven()
	{
		CoffeeMaker game = new CoffeeMaker(mock(Player.class), mock(House.class));

		assertEquals(0, game.doSomething("L"));
		assertEquals(0, game.doSomething("l"));
	}

	@Test
	// Verify that calling doSomething with 'I' or 'i' results 
	// in the showInventory method being called on the Player.
	public void gameShowsPlayersInventoryWhenGivenStringI()
	{
		House house = mock(House.class);
		Player player = mock(Player.class);

		CoffeeMaker game = new CoffeeMaker(player, house);
		game.doSomething("I");
		game.doSomething("i");

		verify(player, times(2)).showInventory();     
	}

	@Test
	// Verify that the game returns 0 when the string 'I' or 'i'
	// is passed to the doSomething method.
	public void doSomethingReturnsZeroWhenInventoryCommandIsGiven()
	{
		Player player = mock(Player.class);
		CoffeeMaker game = new CoffeeMaker(player, mock(House.class));
		when(player.showInventory()).thenReturn("something");
		
		assertEquals(0, game.doSomething("I"));
		assertEquals(0, game.doSomething("l"));
	}

	@Test
	// Verify that calling doSomething with 'D' or 'd' results 
	// in the drink method being called on the Player.
	public void gamePlayerDrinksWhenGivenStringD()
	{
		House house = mock(House.class);
		Player player = mock(Player.class);

		CoffeeMaker game = new CoffeeMaker(player, house);
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
		Player player = mock(Player.class);
		CoffeeMaker game = new CoffeeMaker(player, mock(House.class));
		when(player.drink()).thenReturn(false);

		assertEquals(-1, game.doSomething("D"));
		assertEquals(-1, game.doSomething("d"));
	}

	@Test
	// Verify that the game returns 1 when the string 'D' or 'd'
	// is passed to the doSomething method if the player has 
	// acquired all the items.
	public void doSomethingReturnsOneIfPlayerDrinksWithAllItems()
	{        
		Player player = mock(Player.class);
		CoffeeMaker game = new CoffeeMaker(player, mock(House.class));
		when(player.drink()).thenReturn(true);
		
		assertEquals(1, game.doSomething("D"));
		assertEquals(1, game.doSomething("d"));
	}

	@Test
	// Verify that calling doSomething with 'H' or 'h' results 
	// in the showInstructions method being called.
	public void gameShowsPlayersInventoryWhenGivenStringH()
	{
		House house = mock(House.class);
		Player player = mock(Player.class);

		CoffeeMaker game = new CoffeeMaker(player, house);
		CoffeeMaker spy = spy(game);
		spy.doSomething("H");
		spy.doSomething("h");

		verify(spy, times(2)).showInstructions();        
	}
	
	@Test
	// Verify that the game returns 0 when the string 'H' or 'h'
	// is passed to the doSomething method.
	public void doSomethingReturnsZeroWhenHelpCommandIsGiven()
	{
		CoffeeMaker game = new CoffeeMaker(mock(Player.class), mock(House.class));

		assertEquals(0, game.doSomething("H"));
		assertEquals(0, game.doSomething("h"));
	}
	
	@Test
	// Verify that calling isGameOver returns true if given 1 or -1.
	public void isGameOverReturnsTrueWhenGivenOneOrNegativeOne()
	{
		House house = mock(House.class);
		Player player = mock(Player.class);

		CoffeeMaker game = new CoffeeMaker(player, house);
		CoffeeMaker spy = spy(game);
		
		assertTrue(spy.isGameOver(1));
		assertTrue(spy.isGameOver(-1));
	}
	
	@Test
	// Verify that calling isGameOver returns false if given 0 or 2.
	public void isGameOverReturnsFalseWhenGivenZeroOrTwo()
	{
		House house = mock(House.class);
		Player player = mock(Player.class);

		CoffeeMaker game = new CoffeeMaker(player, house);
		CoffeeMaker spy = spy(game);
		
		assertFalse(spy.isGameOver(0));
		assertFalse(spy.isGameOver(2));
	}
	
	@Test
	// Verify that calling when given a true boolean
	// winOrLoseString returns "You win!"
	public void winOrLoseStringWithTrueReturnsWin()
	{
		House house = mock(House.class);
		Player player = mock(Player.class);

		CoffeeMaker game = new CoffeeMaker(player, house);
		
		assertEquals("You win!", game.winOrLoseString(true));
	}
	
	@Test
	// Verify that calling when given a true boolean
		// winOrLoseString returns "You lose!".
	public void winOrLoseStringWithFalseReturnsLose()
	{
		House house = mock(House.class);
		Player player = mock(Player.class);

		CoffeeMaker game = new CoffeeMaker(player, house);
		
		assertEquals("You lose!", game.winOrLoseString(false));
	}
	
	@Test
	// Verify that calling run returns one if the doSomething
	// methods returns 1.
	public void runReturnsOneWhenWin()
	{
		House house = mock(House.class);
		Player player = new Player(true,true,true);
		Scanner scan = new Scanner("d\n");

		CoffeeMaker game = new CoffeeMaker(player, house);
		
		assertEquals(1, game.run(scan));
	}
	
	@Test
	// Verify that calling run returns -1 if the doSomething
	// methods returns -1.
	public void runReturnsNegativeOneWhenLose()
	{
		House house = mock(House.class);
		Player player = mock(Player.class);
		Scanner scan = new Scanner("d");

		CoffeeMaker game = new CoffeeMaker(player, house);
		CoffeeMaker spy = spy(game);
		stub(spy.doSomething("something")).toReturn(-1);
		
		assertEquals(-1, spy.run(scan));
	}
}