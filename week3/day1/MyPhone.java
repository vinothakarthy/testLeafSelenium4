package week3.day1;

public class MyPhone  {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Samsung phone = new Samsung();
		OnePlus onePl= new OnePlus();
		
		System.out.println("MOdel Number "+phone.phoneName());
		System.out.println("Phone Name " +phone.phoneModelNumber());
		System.out.println(" One PLus "+ onePl.getCountry());
		System.out.println(" One PLus "+ onePl.getYear());
	}

}
