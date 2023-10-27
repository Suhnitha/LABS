//Interfaces must be declared abstract
abstract interface RoomBillComponent{
	public double tax = 0.12;
	public double charge = 500;
	public double food = 800;
	float calculateBill();
}
//class accquiring the access to datamembers of a class and defining the abstarct methods of an Interface is called as Implementing the Interface
//This can be done with the help of the keyword "implements"
class RoomDetails implements RoomBillComponent{
	int billId;
	String name;
	String type;
	int per;
	int day;
	static int counter = 101;

	int bp;
	float totalbill;
//Parameterized constructor to initialize the datamembers
	public RoomDetails(String name, String type, int per, int day){
		this.name = name;
		this.type = type;
		this.per = per;
		this.day = day;
	}
//method to autoincrement the billId and return it
	public int getBillId(){
		billId =counter++;
		return billId;
	}
//method to return Customer Name
	public String getCustomerName(){
		return name;
	}
//method to return Type of the room
	public String getTypeOfRoom(){
		return type;
	}
//method to return No.of extra persons
	public int GetNoOfExtraPersons(){
		return per;
	}
//method to return No.of days of stay
	public int getNoOfDaysOfStay(){
		return day;
	}
//method to validate No.of days of stay
	public boolean validateNoOfDaysOfStay(){
		if(day>=1 && day<=15){
			return true;
		}
		else{
			System.out.println("Accomodation is of minimum 1 day and maximum of 15 days");
			return false;
		}
	}
//method to validate No.of Extra Persons
	public boolean validateNoOfExtraPerson(){
		if(per>=0 && per<=2){
			return true;
		}
		else{
			System.out.println("More than 2 persons are not allowed");
			return false;
		}
	}
//method to validate type of the room
	public boolean validateTypeOfRoom(){
		if(type.equalsIgnoreCase("Standard") || type.equalsIgnoreCase("Deluxe") || type.equalsIgnoreCase("Cottage")){
			 return true;
		}
		else{
			System.out.println("Entered type of rooms are not available");
			return false;
		}
	}
//method to calculate the total bill and return it
	public float calculateBill(){
		if(validateTypeOfRoom() & validateNoOfDaysOfStay() & validateNoOfExtraPerson()){
			//validateTypeOfRoom();validateNoOfDaysOfStay();validateNoOfExtraPerson();
			if(type.equalsIgnoreCase("Standard")){
				bp = 2500;
			}else if(type.equalsIgnoreCase("Deluxe")){
				bp = 3500;
			}else if(type.equalsIgnoreCase("Cottage")){
				bp = 5500;
			}
			totalbill = (day*bp)+(day*(float)food)+(per*(float)charge);
			totalbill += (float)tax*(totalbill);

		}
		return totalbill;
	}
}
//Tester class
class CapstoneTester{
//method to display the details of each room
	public static void getdetails(RoomDetails obj){
		System.out.println();
		System.out.println("BillId : "+obj.getBillId());
		System.out.println("Customer name : "+obj.name);
		System.out.println("No.of days of Stay : "+obj.day);
		System.out.println("Total Bill : "+obj.calculateBill());
	}
//main method
	public static void main(String[] args){
		RoomDetails room1 = new RoomDetails("Suhi","Standard",3,3);
		RoomDetails room2 = new RoomDetails("Suhi","Standard",2,30);
		RoomDetails room3 = new RoomDetails("Suhi","hello",2,15);
		RoomDetails room4 = new RoomDetails("Suhi","standard",1,10);
		RoomDetails room5 = new RoomDetails("Suhi","DELUXE",1,10);
		RoomDetails room6 = new RoomDetails("Suhi","COttaGE",1,10);
		getdetails(room1);
		getdetails(room2);
		getdetails(room3);
		getdetails(room4);
		getdetails(room5);
		getdetails(room6);
	}
}	
