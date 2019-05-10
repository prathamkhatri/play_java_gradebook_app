package models;

import java.util.HashSet;


import java.util.Set;
import io.ebean.*;

import javax.persistence.*;

@Entity
public class Grade extends Model {
	
	
	@Id	
	public Integer id;
	public String title;
	public double score;
	public String student;
	public String professor;
	public String classroom;
	public String semester;
	public String major;
	
	
	
	public static Finder<Integer,Grade> find = new Finder<>(Grade.class);
	
}
