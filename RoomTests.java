import static org.junit.Assert.*;
import org.junit.Test;

public class RoomTests 
{

	@Test
	// Verify that the hasItem method returns false if the
	// room was initialized to have no items.
	public void roomDoesNotHaveItemIfNotInitializedWithAnyItem()
	{
		Room subject = new Room(false, false, false, false, false);
		assertFalse(subject.hasItem());
	}

	@Test
	// Verifies that the hasItem method returns true if the
	// room was initialized to have items.
	public void roomHasItemIfInitializedWithItems()
	{
		Room subject = new Room(true, false, false, false, false);
		assertTrue(subject.hasItem());
	}

	@Test
	// Verifies that the hasCoffee method returns true if the 
	// room was initialized to have coffee.
	public void roomHasCoffeeIfInitializedWithCoffee() 
	{
		Room subject = new Room(true, false, false, false, false);
		assertTrue(subject.hasCoffee());
	}

	@Test
	// Verify that the hasCream method returns true if the 
	// room was initialized to have cream.
	public void roomHasCreamIfInitializedWithCream() 
	{
		Room subject = new Room(false, true, false, false, false);
		assertTrue(subject.hasCream());
	}

	@Test
	// Verify that the hasSugar method returns true if the 
	// room was initialized to have sugar.
	public void roomHasSugarIfInitializedWithSugar() 
	{
		Room subject = new Room(false, false, true, false, false);
		assertTrue(subject.hasSugar());
	}

	@Test
	// Verify that the northExit method returns true if the 
	// room was initialized to have a northExit.
	public void roomHasNorthExitIfInitializedWithNorthExit() 
	{
		Room subject = new Room(false, false, false, true, false);
		assertTrue(subject.northExit());
	}

	@Test
	// Verify that the southExit method returns true if the 
	// room was initialized to have a southExit.
	public void roomHasSouthExitIfInitializedWithSouthExit() 
	{
		Room subject = new Room(false, false, false, false, true);
		assertTrue(subject.southExit());
	}

	@Test
	// Verify getDescription does not return null.
	public void roomDescriptionIsNonNull()
	{
		Room subject = new Room(false, false, false, false, false);
		assertNotNull(subject.getDescription());
	}

	@Test
	// Verify getDescription returns a String that indicates a door
	// that leads north is present, when the room was initialized 
	// to have a northern door.
	public void roomDescriptionIndicatesNorthDoorWhenRoomHasNorthDoor()
	{
		Room subject = new Room(false, false, false, true, false);

		String description = subject.getDescription();
		assertTrue(description.contains("door leads North"));
	}

	@Test
	// Verify getDescription returns a String that indicates a door
	// that leads south is present, when the room was initialized 
	// to have a southern door.
	public void roomDescriptionIndicatesSouthDoorWhenRoomHasSouthDoor()
	{
		Room subject = new Room(false, false, false, false, true);

		String description = subject.getDescription();
		assertTrue(description.contains("door leads South"));
	}

	@Test
	// Verify getDescription returns a String that does not indicate
	// south/north doors existed when the room was initialized without
	// south/north doors.
	public void roomDescriptionDoesNotIndicateNonExistentDoorsExist()
	{
		Room subject = new Room(false, false, false, false, false);

		String description = subject.getDescription();
		assertFalse(description.contains("door leads North"));
		assertFalse(description.contains("door leads South"));
	}

	@Test
	// Verify that two different Rooms return different Strings from the
	// method getDescription.
	public void roomsHaveUniqueDescriptions()
	{
		Room subject1 = new Room(false, false, false, false, false);
		Room subject2 = new Room(false, false, false, false, false);

		assertNotEquals(subject1.getDescription(), subject2.getDescription());
	}
}