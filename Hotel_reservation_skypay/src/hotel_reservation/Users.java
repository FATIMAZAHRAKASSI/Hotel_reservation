package hotel_reservation;

import java.util.Objects;

public class Users {
private int userId;
private int balance;
//constructor
Users(int userId,int balance)
{
	this.userId=userId;
	this.balance=balance;
}
//getters
public int getBalance() {
	return balance;
}
public int getuserId() {
	return userId;
}

//override equals to test if a user already exists in the list of users
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Users other = (Users) obj;
	return balance == other.balance && userId == other.userId;
}

@Override
public int hashCode() {
	return Objects.hash(balance, userId);
}

//method to deduct the balance 
public void deductBalance(int amount)
{
	this.balance-=amount;
}

}
