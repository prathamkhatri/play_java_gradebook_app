package models;

public class User{
	
    protected String username;
    protected String password;
    
    public User() {
    	
    }
    
    public User(String username, String password) {
    	
    	this.username =username;
    	this.password = password;
    }
    
 
    public void setUserName(String username) {
        this.username = username;
    }

    public String getUserName() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

}
