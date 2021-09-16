public class Grade implements Comparable{ 
	// clasa data de ei in laborator
	
	Double partialScore, examScore;
	private Student student;
	private String course;
	
	public Student getStudent() {
		return this.student;
	}
	 
	public Grade(String course, Student student) {
	        partialScore = 0.0;
	        examScore = 0.0;
	        this.course = course;
	        this.student = student; 
	    	}
	 
	public Grade(String course, Student student,Double partialScore, Double examScore ) {
	        this.partialScore = partialScore;
	        this.examScore = examScore;
	        this.course = course;
	        this.student = student; 
	    	}
	 
	public void setPartialScore(Double score) {
	     partialScore = score;
	}
	public void setExamScore(Double score) {
	     examScore = score;
	}
	public Double getTotal() {
	      return partialScore + examScore;
	}

	@Override
	//le comparam dupa nota finala
	public int compareTo(Object o) {
		Grade g = (Grade) o;
		double sum1 = this.getTotal().doubleValue();
		double sum2 = g.getTotal().doubleValue(); 
		return (int) (sum1-sum2);
	}
}