
public abstract class User {
  protected String firstName, lastName;
  
  public User(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }
  
  public String toString() {
    return firstName + " " + lastName;
  }
  
}

class UserFactory { //Factory pattern
	//in functie de argumentul UserFactory.createUser("Student"   <-- cream un obiect de care trebuie
	public static User createUser(String type, String firstName, String lastName ) {
		if (type.equals("Student")) {
			return new Student(firstName, lastName );
		}
		else if (type.equals("Parent")) {
			return new Parent(firstName, lastName );
		}
		else if (type.equals("Teacher")) {
			return new Teacher(firstName, lastName );
		}
		//else
		return new Assistant(firstName, lastName );
	}
}
