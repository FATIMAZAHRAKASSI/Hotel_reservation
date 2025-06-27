package hotel_reservation;
import java.util.*;
public class Booking {
private int userID;
private int roomID;
private Date checkIn;
private Date checkOut;

//constructor
public Booking( int userID, int roomID, Date checkIn, Date checkOut) {
	super();
	this.userID = userID;
	this.roomID = roomID;
	this.checkIn = checkIn;
	this.checkOut = checkOut;
	
}

//getters
public int getUserID() {
	return userID;
}
public int getRoomID() {
	return roomID;
}

public Date getCheckIn() {
	return checkIn;
}

public Date getCheckOut() {
	return checkOut;
}

}
