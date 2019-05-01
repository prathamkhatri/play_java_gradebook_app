package models;

import java.util.HashSet;
import java.util.Set;

public class Grade {
	
	public Integer id;
	public String title;
	public double score;
	public String student;
	
	
	public Grade(Integer id, String title, double score, String student) {
		this.id  = id;
		this.title = title;
		this.score=score;
		this.student = student;
			
		
	}
	
	
	private static Set<Grade> grades;
	
	static {
		grades = new HashSet<>();
		grades.add(new Grade(410,"Intro to MYSQL",95.0,"Jack Hill"));
		grades.add(new Grade(410,"Intro to MYSQL",76.0,"Ronnie Packer"));

	}
	
	public static Set<Grade> allGrades() {
		
		return grades;
	}
	
	public static Grade findById(Integer id) {
		
		for(Grade grade: grades) {
			
			if(id.equals(grade.id)) {
				
				return grade;
			}
 		}
		return null;
		
	}
	
	public static void add(Grade grade) {
		grades.add(grade);
	}
	
	public static boolean remove(Grade grade) {
		
		return grades.remove(grade);
	}
	

}
