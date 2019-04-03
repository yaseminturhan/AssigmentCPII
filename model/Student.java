package model;

public class Student {

    public int id;
    public int stNumber;
    public String name;
    public String surname;
    public String type;
    private double GPA, grade1, grade2, grade3, grade4,grade5;
    
    public void setGPA(double GPA){
		
		this.GPA = GPA;
	}
    
    
    public double getGPA(){
		calcGPA(grade1, grade2, grade3, grade4, grade5);
		return this.GPA;
	}
	
	public void calcGPA(double grade1, double grade2, double grade3, double grade4, double grade5){
		
		this.GPA = (grade1 + grade2 + grade3 + grade4 + grade5) / 5;
	}
	
	public double getCalcAverageGPA(double sum, double numStudent) {
		
		double average;
		sum = 0;
		sum = sum + this.getGPA();
		average = sum / numStudent;
	
		return average;
	}
  	
  	
   
      
        }
    



