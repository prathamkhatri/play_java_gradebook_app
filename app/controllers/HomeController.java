package controllers;

import play.data.DynamicForm;
import play.data.Form;
import play.mvc.*;
import views.html.*;

import java.util.List;
import java.util.Set;
import javax.inject.Inject;

import models.Grade;
import models.User;
import play.data.FormFactory;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {
	/**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
	
	@Inject
	FormFactory formFactory;
	
	// redirect to login page in the main page
    public Result index() {
    	return redirect("/sign");		
    }
   
     
    // this is the sign in page
    public Result getSign(){
    	Form<User> userForm = formFactory.form(User.class);
    	return ok(getSign.render(userForm));
        
    }
    
    
	
	public Result postSign(){
		
		String us, ps;
		Form<User> userForm = formFactory.form(User.class).bindFromRequest();
    	User user = userForm.get();
    	us = user.getUserName().trim();
    	ps = user.getPassword().trim();
    	int t1 = us.compareTo("admin");
    	int t2 = ps.compareTo("admin");
    	if(t1 == 0) {
    		if(t2 == 0) {
    			return redirect("/adminHome");
    		}
    	}
    	flash("danger","Wrong password or username. Please try again.");
		return redirect("/sign");
    	
	}
    
    public Result adminHome() {
    	
    	return ok(views.html.adminHome.render());
    }
    
    // student page
    public Result stuHome() {
    	
    	return redirect("/studgrades");
    }
    
    public Result studentmode() {
    	
    	List<Grade> grades = Grade.find.all();
    	return ok(views.html.studentmode.render(grades));
    	
    }

    
   //passing parameters
    public Result hello(Http.Request request) {
        DynamicForm requestData = formFactory.form().bindFromRequest(request);
        String firstname = requestData.get("firstname");
        String lastname = requestData.get("lastname");
        return ok("Hello " + firstname + " " + lastname);
    }
    
    //Grade controllers starts from there--
    
    //for all grades 
    public Result showAll() {
		List<Grade> grades = Grade.find.all();
		return ok(views.html.showAll.render(grades));
    }
    
    //create grade
    public Result create() {
    	Form<Grade> gradeForm = formFactory.form(Grade.class);
    	return ok(create.render(gradeForm));
		
   	
   }
    
    //save grade
    public Result save() {
    	Form<Grade> gradeForm = formFactory.form(Grade.class).bindFromRequest();
    	Grade grade = gradeForm.get();
    	grade.save();

		
   	 	return redirect(routes.HomeController.showAll());
   }
    
    // edit single grade
    public Result edit(Integer id) {
    	Grade grade = Grade.find.byId(id);
    	if(grade == null) {
    		
    		return notFound("Grade ID not found");
    	}
    	Form<Grade> gradeForm = formFactory.form(Grade.class);
		return ok(edit.render(gradeForm));
   }
    
    
    public Result update() {
    	
    	Form<Grade> gradeForm = formFactory.form(Grade.class).bindFromRequest();
    	Grade grade = gradeForm.get();
    	Grade oldGrade = Grade.find.byId(grade.id); 
    	if(oldGrade == null) {
    		
    		return notFound("Record not found, No changes made to the database");
    		
    	}
    	oldGrade.id = grade.id;
    	oldGrade.title = grade.title;
    	oldGrade.score = grade.score;
    	oldGrade.student = grade.student;
    	
    	oldGrade.save();

   	 	return redirect(routes.HomeController.showAll());

   }
    
    public Result destroy(Integer id) {
    	Grade grade = Grade.find.byId(id);
    	if(grade == null) {
   
    		return notFound("Record not found, No changes made to the database");
    		
    	}
    	grade.delete();
		
    	return redirect(routes.HomeController.showAll());
   }
    
    // to show one grade details 
    
    public Result show(Integer id) {
    	Grade grade = Grade.find.byId(id);
    	if(grade == null) {
   
    		return notFound("Record not found");
    		
    	}
    	
		
   	 return ok(show.render(grade));
   }
    

}
