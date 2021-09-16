import java.util.ArrayList;

public class Course { // Builder pattern, CourseBuilder e inner class
	//pentru ca clasa asta are multe variabile si poate la unele obiecte ne trebuie doar cateva
	
	Strategy strategy;
	
	
	private final String name;
	private Teacher teacher;
	private ArrayList<Assistant> assistants = new ArrayList<>();
	private ArrayList<Grade> grades = new ArrayList<>();
	//private ArrayList<Student> students = new ArrayList<>(); //e camp privat la Grade
	
	private Course (CourseBuilder builder) {
		this.name = builder.name;
		this.teacher = builder.teacher;
		this.assistants.addAll(builder.assistants);
		this.grades.addAll(builder.grades);
	}
	
	public String getName() {
		return this.name;
	}
	                    // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! pentru Strategy pattern
	public Strategy getStrategy() {
		// alegem random o strategie de urmat
		double r = Math.random()*3;
		if (r < 1) { 
			System.out.println(" strategia PartialScore ");
			this.strategy = new BestPartialScore();
			return strategy;
		}
		if (r < 2) {
			System.out.println(" strategia ExamScore ");
			this.strategy = new BestExamScore();
			return strategy;
		}
		else {
			System.out.println(" strategia TotalScore ");
			this.strategy = new BestTotalScore();
			return strategy;
		}
		
	}
	
	public Student getBestStudent() {
		this.strategy = this.getStrategy();
		//getStrategy();
		return strategy.getBestStudent(grades);
	}  
	                       ////////////////////////////////////

	
	public Teacher getTeacher() {
		return this.teacher;
	}
	
	public String toString() {
		String s="";
		for(Assistant a: this.assistants) {
			s += a.firstName + " " + a.lastName + " ";
		} 
		return "Curs de "+ name + " tinut de prof. " + teacher.lastName + " cu asistentii " + s;
		
	}
							// inner class
	public static class CourseBuilder {
		private final String name;
		private Teacher teacher;
		private ArrayList<Assistant> assistants = new ArrayList<>();
		private ArrayList<Grade> grades = new ArrayList<>();
		//private ArrayList<Student> students = new ArrayList<>();
		
		public CourseBuilder( String name) {
			this.name= name;
		}
		
		public CourseBuilder teacher(Teacher teacher) {
			this.teacher = teacher;
			return this;
		}
		
		public CourseBuilder assistant(Assistant assistant) {
			this.assistants.add(assistant);
			return this;
		}
		
		public CourseBuilder grade(Grade g) {
			this.grades.add(g);
			return this;
		}
		
		public Course build() {
			return new Course(this);
		}
		
	}
	
}
