package abstractclass;

public class College extends University{
	
public static void main(String[] args) {
	College col= new College();
			col.ug();
	col.pg(" MCA");
}

@Override
public void ug() {
	// TODO Auto-generated method stub
	System.out.println(" ug class implementation in college class");
}
}
