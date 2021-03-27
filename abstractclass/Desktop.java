package abstractclass;

public  class Desktop implements Hardware,Software
{

	public void softwareResource() {
		// TODO Auto-generated method stub
		System.out.println("Software Resource");
	}

	public void hardwareResource() {
		// TODO Auto-generated method stub
		System.out.println("Hardware Resource");
	}
	
	public void desktopModel()
	{
	System.out.println("Deskto Model");
	}
public static void main(String[] args) {
	Desktop ds = new Desktop();
	ds.hardwareResource();
	ds.softwareResource();
	ds.desktopModel();
}	
}