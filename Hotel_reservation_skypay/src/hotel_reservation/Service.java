package hotel_reservation;
import java.util.*;
import java.text.SimpleDateFormat;
public class Service {
ArrayList<Room> rooms;
ArrayList<Users> users;
ArrayList<Booking> booking;
Service()
{
	rooms=new ArrayList<Room>();
	users=new ArrayList<Users>();
	booking=new ArrayList<Booking>();
}
//method to create a room if it doesn't exist
void setRoom(int roomNumber, RoomType roomType, int roomPricePerNight) {
	Room r=new Room(roomNumber,roomType,roomPricePerNight);
	if(!rooms.contains(r))
	{rooms.add(0,r);}
	else {
		for(Room ro :rooms)
		{
			if(ro.getroomNumber()==roomNumber)
			{
				ro.setPrice(roomPricePerNight);
				ro.setType(roomType);
				System.out.println("Room nbr: "+roomNumber+" is now updated");
			}
		}
	}
}

//method to create a user if it doesn't exist
void setUser(int userId, int balance) {
	Users u=new Users(userId, balance);
	if(!users.contains(u))
	{users.add(0,u);}
	else {
		System.out.println("This user alredy exists!");
	}
}

//print all users from latest to oldest created
void printAllUsers() {
	System.out.println("ALL USERS FROM LAST TO OLDEST CREATED:");
	for(Users u:users)
	{
		System.out.println("user nr: "+u.getuserId()+" with balance: "+u.getBalance());
	}
}


//print rooms and booking data
void printAll() {
	//rooms
	System.out.println("ALL ROOMS FROM LAST TO OLDEST CREATED:");
	for(Room r:rooms)
	{
		System.out.println("Room nr: "+r.getroomNumber()+" of type: "+r.getType().name()+" with price per night: "+r.getPrice());
	}
	
	//booking data
	System.out.println("ALL BOOKINGS FROM LAST TO OLDEST CREATED::");
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");//to display a comprehensive date
	if(booking.isEmpty())
	{
		System.out.println("NO BOOKING FOR THE MOMENT!");
	}
	for(Booking b:booking)
	{
		
	 
		System.out.println("Booking of room: "+b.getRoomID()+" by user: "+b.getUserID()+" starts from: "+formatter.format(b.getCheckIn())+" and ends at: "+formatter.format(b.getCheckOut())+" With the amount: "+b.getPriceBooking());
	}
}

//method to book a room
void bookRoom(int userId, int roomNumber, Date checkIn, Date checkOut) {
	//invalid date check
	if (checkIn.after(checkOut)) {
        System.out.println("The booking of room: "+roomNumber+ " by user: "+userId+" is not successfull because The dates are not valid : check-in should be before check-out.");
        return;
    }
	

    //check if the room is available in that period : which means in it overlaps another booking's period
   for(Booking b:booking)
   {
	   if(b.getRoomID()==roomNumber)
	   {
		   if (!(checkOut.before(b.getCheckIn()) || checkIn.after(b.getCheckOut())))
		   {
			   System.out.println("The booking of room: "+roomNumber+ " by user: "+userId+" is not successfull becauseThe room is already booked during this period!");
			   return;
		   }
	   }
   }
   
   //if it continues till this part of the code it means that the room is available
 
   //get user's balance
 	Users user=null;
 	for(Users u:users)
 	{
 		if(u.getuserId()==userId)
 		{
 			user=u;
 			break;
 		}
 	}
 	
 	//get the price per night for the room in question
 	Room room=null;
 	for(Room r:rooms)
 	{
 		if(r.getroomNumber()==roomNumber)
 		{
 			room=r;
 			break;
 		}
 	}
    
 	//Calculate the period of staying
 	long diffMillis = checkOut.getTime() - checkIn.getTime();
 	long diffDays = diffMillis / (1000 * 60 * 60 * 24);//convert to days


 	//calculate the amount needed for the staying
 	int amount=(int) (room.getPrice()*diffDays);
 	
 	if(amount>user.getBalance())
 	{
 		System.out.println("The booking of room: "+roomNumber+ " by user: "+userId+" is not successfull because your balance is not sufficent for it for the period desired");
		return;
 	}
 	
 	//if it gets to this point the code it means the user can book the room
 	//deduct the balance
 	user.deductBalance(amount);
 	booking.add(0,new Booking(userId,roomNumber,checkIn,checkOut,amount));
 	System.out.println("The booking of the room :"+roomNumber+" By user: "+userId+ " is successfull!");
}

}
