package controllers;

import play.data.DynamicForm;
import play.data.Form;
import play.mvc.*;
import views.html.*;
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
	
    public Result index() {
    	
    	return redirect("/sign");		
    }
   
     
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
    
    
    
    public Result errorPage() { 	
    	
    	return ok("this is the errorPage");
    }
    
    public Result adminHome() {
    	
    	return ok("You are in admin Home page");
    }
    
    public Result stuHome() {
    	
    	return redirect("/grades");
    }
    
    public Result explore() {
        return ok(views.html.explore.render());
    }
    
    public Result tutorial() {
        return ok(views.html.tutorial.render());
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
		Set<Grade> grades = Grade.allGrades();
		return ok(views.html.showAll.render(grades));
    }
    
    //create grade
    public Result create() {
		
   	 return TODO();
   }
    
    //save grade
    public Result save() {
		
   	 return TODO();
   }
    
    
    public Result edit(Integer id) {
		
   	 return TODO();
   }
    
    public Result update() {
		
   	 return TODO();
   }
    
    public Result destroy(Integer id) {
		
   	 return TODO();
   }
    
    // for grade details 
    
    public Result show(Integer id) {
		
   	 return TODO();
   }
    
    
    
    
    
    

}
