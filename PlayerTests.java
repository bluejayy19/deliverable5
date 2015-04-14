import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerTests 
{
	@Test
	// Verify that the hasAllItems method returns true if a player has
	// all the required items.
	public void playerHasAllItems() 
	{
		Player subject = new Player(true,true,true);
		assertTrue(subject.hasAllItems());
	}
	
	@Test
	// Verify that the has method returns true after each of
	// the individual items have been required.
	public void playerHasAllItemsAfterGettingEachItem() 
	{
		Player subject = new Player();

		subject.getCoffee();
		subject.getCream();
		subject.getSugar();

		assertTrue(subject.hasAllItems());
	}
	
	@Test
	// Verify that the hasAllItems method returns true after each of
	// the individual items have been required.
	public void playerHasAllItemsAfterGettingEachItem() 
	{
		Player subject = new Player();
		assertTrue(subject.hasAllItems());
	}

	@Test
	// Verify that the hasAllItems method returns false if the player
	// does not have any items.
	public void playerDoesNotHaveItemsIfNoneHaveBeenAcquired()
	{
		Player subject = new Player();
		assertFalse(subject.hasAllItems());
	}

	@Test
	// Verify that the hasAllItems method returns false if the player
	// has some items, but not every item.
	public void playerDoesNotHaveAllItemsIfOnlySomeHaveBeenAcquired()
	{
		Player subject = new Player(true,false,false);
		assertFalse(subject.hasAllItems());
	}

	@Test
	// Verify that the drink method returns false if called while
	// the player does not have all of the items.
	public void playerLosesIfDrinkingWithNoItems() 
	{
		Player subject = new Player();
		assertFalse(subject.drink());
	}

	@Test
	// Verify that the drink method returns true if called while
	// the player has all three items.
	public void playerWinsIfDrinkingWithAllItems()
	{
		Player subject = new Player(true,true,true);
		assertTrue(subject.drink());
	}

	@Test
	// Verify that the drink method returns false if called
	// while the player only has coffee.
	public void playerLosesIfDrinkingWithOnlyCoffee()
	{
		Player subject = new Player(false, false, true);  
		assertFalse(subject.drink());
	}

	@Test
	// Verify that the drink method returns false if called
	// while the player only has coffee and cream.
	public void playerLosesIfDrinkingWithOnlyCoffeeAndCream()
	{
		Player subject = new Player(false, true, true);
		assertFalse(subject.drink());
	}

	@Test
	// Verify that the drink method returns false if called
	// while the player only has cream.
	public void playerLosesIfDrinkingWithOnlyCream()
	{
		Player subject = new Player(false, true, false);
		assertFalse(subject.drink());
	}

	@Test
	// Verify that the drink method returns false if called
	// while the player only has cream and sugar.
	public void playerLosesIfDrinkingWithOnlyCreamAndSugar()
	{
		Player subject = new Player(true, true, false);
		assertFalse(subject.drink());
	}

	@Test
	// Verify that the drink method returns false if called while
	// the player only has sugar.
	public void playerLosesIfDrinkingWithOnlySugar()
	{
		Player subject = new Player(true, false, false);
		assertFalse(subject.drink());
	}

	@Test
	// Verify that the drink method returns false if called while
	// the player only has sugar and coffee.
	public void playerLosesIfDrinkingWithOnlySugarAndCoffee()
	{
		Player subject = new Player(true, false, true);
		assertFalse(subject.drink());
	}
}