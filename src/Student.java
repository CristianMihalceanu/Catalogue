import java.util.ArrayList;
import java.util.Collections;

public class Student extends User {
	Parent mother, father;
	
	public boolean isParent(Parent prnt) {
		if ( (prnt.firstName == mother.firstName && prnt.lastName == mother.lastName) ||
				(prnt.firstName == father.firstName && prnt.lastName == father.lastName)) {
			return true;
		}
		return false;
	}
	
	public void setMother(Parent mother) {
		this.mother = mother;
	}
	
	public void setFather(Parent father) {
		this.father = father;
	}

	public Student(String firstName, String lastName) {
		super(firstName, lastName);
		// TODO Auto-generated constructor stub
	}

}

interface Strategy {  //Strategy pattern
	//clasa Course are o instanta de tip Strategy, prin polimorfism o sa fie una din astea 3 de mai jos
    Student getBestStudent(ArrayList<Grade> grades);
}

class BestPartialScore implements Strategy {

	@Override
	public Student getBestStudent(ArrayList<Grade> grades) {
		
		Grade max1 = grades.get(0);
		for (int i =1; i<grades.size();i++) {
			if ( grades.get(i).partialScore > max1.partialScore ) {
				max1 = grades.get(i);
			}
		}
		return max1.getStudent();
	
		//return Collections.max(grades).getStudent(); 
		//asa merge la ultima, ca grades sunt ordonati
		//dupa totalscore
	}
	
}

class BestExamScore implements Strategy {

	@Override
	public Student getBestStudent(ArrayList<Grade> grades) {
		Grade max1 = grades.get(0);
		for (int i =1; i<grades.size();i++) {
			if ( grades.get(i).examScore > max1.examScore ) {
				max1 = grades.get(i);
			}
		}
		return max1.getStudent();
	}
	
}

class BestTotalScore implements Strategy {

	@Override
	public Student getBestStudent(ArrayList<Grade> grades) {
		//grades sunt ordonati dupa TotalScore
		// Collections.max(grades)  ne returneaza Grade - ul cu cel mai mare TotalScore
		//si noi vrem studentul care are acel Grade
		return Collections.max(grades).getStudent(); 
	}
	
}
