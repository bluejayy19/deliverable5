import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

public class HouseTests 
{
	@Test
	// Verifies the generateRooms method returns an array with
	// the specified number of rooms
	public void generateRoomsReturnsCorrectNumberOfRooms() 
	{
		House subject = new House(5);

		int numRooms = 10;
		Room[] rooms = subject.generateRooms(numRooms);

		assertNotNull(rooms);
		assertEquals(numRooms, rooms.length);
	}

	@Test
	// Verify northernmost generated Room has no door leading North.
	public void northernMostGeneratedRoomHasNoNorthDoor()
	{
		House subject = new House(3);
		Room[] rooms = subject.generateRooms(3);

		assertFalse(rooms[rooms.length - 1].northExit());
	}

	@Test
	// Verify southernmost generated Room has no door leading South. 
	public void southernMostRoomHasNoSouthDoor()
	{
		House subject = new House(3);
		Room[] rooms = subject.generateRooms(3);

		assertFalse(rooms[0].southExit());
	}

	@Test
	// Verify generateRooms produces the rooms with the expected items
	// i.e., the set of rooms contain coffee, sugar, and cream. 
	public void generatedRoomsHaveCoffeeSugarAndCream()
	{
		int house_size = 3;
		int coffee_room = 2;
		int cream_room = 0;
		int sugar_room = 2;
		
		House subject = new House(house_size);
		Room[] rooms = subject.generateRooms(house_size);

		boolean hasSugar = false;
		boolean hasCream = false;
		boolean hasCoffee = false;

		if (rooms[coffee_room].hasCoffee())
			hasCoffee = true;

		if (rooms[cream_room].hasCream())
			hasCream = true;

		if (rooms[sugar_room].hasSugar())
			hasSugar = true;

		assertTrue(hasCoffee);
		assertTrue(hasSugar);
		assertTrue(hasCream);
	}

	@Test
	// Verify that the House will query the Room for items when
	// the look method is called. 
	public void houseQueriesRoomForItems()
	{
		House subject = new House(5);

		Player player = mock(Player.class);
		Room room = mock(Room.class);

		when(room.hasItem()).thenReturn(true);
		when(room.hasCoffee()).thenReturn(false);
		when(room.hasSugar()).thenReturn(false);
		when(room.hasCream()).thenReturn(false);

		subject.look(player, room);

		verify(room).hasItem();
		verify(room).hasCoffee();
		verify(room).hasSugar();
		verify(room).hasCream();
	}

	@Test
	// Verify that the House will call the correspond getItem method
	// on the player when looking at a room that contains the items.
	public void playerGetsItemsFromRoomAfterLooking()
	{
		House subject = new House(5);
		Player player = mock(Player.class);
		Room room = new Room(true, true, true, false, false);

		subject.look(player, room);

		verify(player).getCoffee();
		verify(player).getSugar();
		verify(player).getCream();
	}

	@Test 
	// Verify the getRoomDescription method returns the current room
	// description.
	public void getCurrentRoomInfoReturnsCurrentRoomDescription()
	{
		Room room = mock(Room.class);

		String description = "a dummy description";
		when(room.getDescription()).thenReturn(description);

		Room[] rooms = { room };
		House subject = new House(rooms);

		assertEquals(description, subject.getCurrentRoomInfo());
	}

	@Test 
	// Verify that moveNorth when the current room has no North door
	// does not change the current room. 
	public void moveNorthDoesNotChangeRoomWhenRoomHasNoNorthernDoor()
	{
		Room room = mock(Room.class);

		String description = "a dummy description";
		when(room.getDescription()).thenReturn(description);
		when(room.northExit()).thenReturn(false);

		Room[] rooms = { room };
		House subject = new House(rooms);

		assertEquals(description, subject.getCurrentRoomInfo());
		subject.moveNorth();
		assertEquals(description, subject.getCurrentRoomInfo());
	}
	
	@Test 
	// Verify that moveNorth when the current room has no North door
	// returns false.
	public void moveNorthReturnsFalseWhenRoomHasNoNorthernDoor()
	{
		Room room = mock(Room.class);

		when(room.northExit()).thenReturn(false);

		Room[] rooms = { room };
		House subject = new House(rooms);

		assertFalse(subject.moveNorth());
	}

	@Test
	// Verify that moveNorth will move the player to the next room
	// when the current room has a North door.
	public void moveNorthMovesPlayerToNorthernRoom()
	{
		Room originalRoom = mock(Room.class);
		when(originalRoom.northExit()).thenReturn(true);
		when(originalRoom.getDescription()).thenReturn("wrong description");

		Room northernRoom = mock(Room.class);
		when(northernRoom.getDescription()).thenReturn("right description");

		Room[] rooms = {originalRoom, northernRoom};
		House subject = new House(rooms);

		assertEquals("wrong description", subject.getCurrentRoomInfo());
		subject.moveNorth();
		assertEquals("right description", subject.getCurrentRoomInfo());        
	}
	
	@Test 
	// Verify that moveNorth when the current room has no North door
	// returns true.
	public void moveNorthReturnsTrueWhenRoomHasANorthernDoor()
	{
		Room room = mock(Room.class);

		when(room.northExit()).thenReturn(true);

		Room[] rooms = { room };
		House subject = new House(rooms);

		assertTrue(subject.moveNorth());
	}

	@Test 
	// Verify that moveSouth when the current room has no South door
	// does not change the current room. 
	public void moveSouthDoesNotChangeRoomWhenRoomHasNoSouthernDoor()
	{
		Room room = mock(Room.class);

		String description = "a dummy description";
		when(room.getDescription()).thenReturn(description);
		when(room.southExit()).thenReturn(false);

		Room[] rooms = { room };
		House subject = new House(rooms);

		assertEquals(description, subject.getCurrentRoomInfo());
		subject.moveSouth();
		assertEquals(description, subject.getCurrentRoomInfo());
	}
	
	@Test 
	// Verify that moveSouth when the current room has no South door
	// returns false.
	public void moveSouthReturnsFalseWhenRoomHasNoSouthernDoor()
	{
		Room room = mock(Room.class);

		when(room.southExit()).thenReturn(false);

		Room[] rooms = { room };
		House subject = new House(rooms);

		assertFalse(subject.moveSouth());
	}

	@Test
	// Verify that moveSouth will move the player to the southern room
	// when the current room has a South door.
	public void moveSouthMovesPlayerToSouthernRoom()
	{
		Room originalRoom = mock(Room.class);
		when(originalRoom.getDescription()).thenReturn("right description");
		when(originalRoom.northExit()).thenReturn(true);

		Room southernRoom = mock(Room.class);
		when(southernRoom.southExit()).thenReturn(true);
		when(southernRoom.getDescription()).thenReturn("wrong description");

		Room[] rooms = {originalRoom, southernRoom};
		House subject = new House(rooms);

		subject.moveNorth();
		assertEquals("wrong description", subject.getCurrentRoomInfo());
		subject.moveSouth();
		assertEquals("right description", subject.getCurrentRoomInfo());        
	}
	
	@Test 
	// Verify that moveSouth when the current room has a South door
	// returns true.
	public void moveSouthReturnsTrueWhenRoomHasASouthernDoor()
	{
		Room room = mock(Room.class);

		when(room.southExit()).thenReturn(true);

		Room[] rooms = { room };
		House subject = new House(rooms);

		assertTrue(subject.moveSouth());
	}

	@Test
	// Verifies that the look method will inspect the currently occupied Room
	// in the House when the Room argument is null.
	public void lookInspectsCurrentRoomWhenNoRoomIsProvided()
	{
		Room room = mock(Room.class);
		when(room.hasItem()).thenReturn(false);
		when(room.getDescription()).thenReturn("dummy");

		Room[] rooms = { room };
		House subject = new House(rooms);

		Player player = new Player();

		subject.look(player, null);

		// House should have called hasItem on the current room.
		verify(room).hasItem();
	}
}