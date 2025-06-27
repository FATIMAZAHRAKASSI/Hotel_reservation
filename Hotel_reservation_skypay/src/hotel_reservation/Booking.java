package hotel_reservation;
import java.util.*;
public class Booking {
private int userID;
private int roomID;
private Date checkIn;
private Date checkOut;
private int PriceBooking;

//constructor
public Booking( int userID, int roomID, Date checkIn, Date checkOut,int PriceBooking) {
	super();
	this.userID = userID;
	this.roomID = roomID;
	this.checkIn = checkIn;
	this.checkOut = checkOut;
	this.PriceBooking=PriceBooking;
	
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

public int getPriceBooking() {
	return PriceBooking;
}

public void setPriceBooking(int priceBooking) {
	PriceBooking = priceBooking;
}

}
