import java.util.ArrayList;

interface Subject { // pentru parintii care vor fi notificati de nota copilului lor
	   void addObserver(Observer observer);
	   void removeObserver(Observer observer);
	   void notifyObservers(Grade grade);
	}

public class Catalog implements Subject {
	//Singleton pattern
	private static Catalog instance = null;
	
	ArrayList<Course> courses = new ArrayList<>();
	private ArrayList<Parent> parentsToBeNotified = new ArrayList<>();
	
	//constructor privat
	private Catalog() {	}
	
	public void addCourse( Course c ) {
		this.courses.add(c);
	}
	
	//Singleton pattern
	public static Catalog getInstance() {
		if (instance == null) {
			instance = new Catalog();
		}
		return instance;
	}

	@Override
	public void addObserver(Observer observer) {		
		parentsToBeNotified.add((Parent) observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		parentsToBeNotified.remove((Parent) observer);		
	}

	@Override
	public void notifyObservers(Grade grade) { 
		//trebuie localizati parintii studentului ce corespunde grade-ului
		Student st = grade.getStudent();
		for(Parent p : parentsToBeNotified) {
			if (st.isParent(p)) {
				p.getUpdate("Nota elevului dvs. este "+ grade.getTotal().doubleValue());
			}		
		}	
		
	}
}
