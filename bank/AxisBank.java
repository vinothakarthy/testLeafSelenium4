package bank;

public class AxisBank extends BankInfo {
	
	public void deposit()
	{
		System.out.println(" deposit method in AxisBank");
	}
public static void main(String[] args) {
	AxisBank an=new AxisBank();
	an.saving();
	an.fixed();
	an.deposit();

}
}
