package hotel_reservation;

import java.util.Objects;

public class Room {
private int roomNumber;
private RoomType type;
private int price;
//constructor
Room(int roomNumber,RoomType type,int price)
{
	this.roomNumber=roomNumber;
	this.type=type;
	this.price=price;
}

public int getroomNumber()
{
	return roomNumber;
}
//getters and setters
public RoomType getType() {
	return type;
}

public int getPrice() {
	return price;
}

//override equals to compare room objects
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Room other = (Room) obj;
	return roomNumber == other.roomNumber;
}

@Override
public int hashCode() {
	return Objects.hash(price, roomNumber, type);
}




}
