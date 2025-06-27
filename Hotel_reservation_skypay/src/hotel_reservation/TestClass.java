package hotel_reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class TestClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Service serviceHotel=new Service();
		//creating 3 rooms
		serviceHotel.setRoom(1, RoomType.STANDARD, 1000);
		serviceHotel.setRoom(2, RoomType.JUNIOR, 2000);
		serviceHotel.setRoom(3, RoomType.SUITE, 1000);

		
		//displaying rooms
		System.out.println("DISPLAY ROOMS BEFORE BOOKING");
		serviceHotel.printAll();
		
		//creating 2 users
		serviceHotel.setUser(1, 5000);
		serviceHotel.setUser(2, 10000);
		

		//make some bookings
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			serviceHotel.bookRoom(1, 2, sdf.parse("30/06/2026"), sdf.parse("07/07/2026"));
			serviceHotel.bookRoom(1, 2, sdf.parse("07/07/2026"), sdf.parse("30/06/2026"));
			serviceHotel.bookRoom(1, 1, sdf.parse("07/07/2026"), sdf.parse("8/07/2026"));
			serviceHotel.bookRoom(2, 1, sdf.parse("07/07/2026"), sdf.parse("9/07/2026"));
			serviceHotel.bookRoom(2, 3, sdf.parse("07/07/2026"), sdf.parse("8/07/2026"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		serviceHotel.setRoom(1, RoomType.SUITE, 10000);
		
		//displaying users
		serviceHotel.printAllUsers();
		//displaying rooms
		serviceHotel.printAll();

	}

}
