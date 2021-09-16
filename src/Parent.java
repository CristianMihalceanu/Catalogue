
public class Parent extends User implements Observer{

	public Parent(String firstName, String lastName) {
		super(firstName, lastName);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void getUpdate(String notification) {
		// TODO Auto-generated method stub
		System.out.println(notification);
	}
	
	

}


interface Observer {  // impreuna cu Subject de la Catalog formeaza Observer pattern
	//parintii se aboneaza la catalog si sunt notificati de nota copilului lor
    void getUpdate(String notification);
}