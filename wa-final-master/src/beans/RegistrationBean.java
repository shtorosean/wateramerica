package beans;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import eao.RegistrationEAO;

@ManagedBean(name="regBean")
@SessionScoped()

public class RegistrationBean {
	@EJB RegistrationEAO service;
	
    private String password;
    private String confirmpassword;
    private String email;
    private String confirmemail;
    private String lastName;
    
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
 
    public String getConfirmpassword() {
        return confirmpassword;
    }
 
    public void setConfirmpassword(String confirmpassword) {
        this.confirmpassword = confirmpassword;
    }
    
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
    public String getConfirmemail() {
        return confirmemail;
    }
 
    public void setConfirmemail(String confirmemail) {
        this.confirmemail = confirmemail;
    }
    
    public String getLastName() {
        return lastName;
    }
 
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
 
    private void addMessage(FacesMessage message){
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public String addUser(){
    	 
        //If Successfull, return success message.
        if(service.persistUser(this)){
            addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "User Registration Successful!!!", null));
            return "success";
        }
     
        //If Unsuccessful, return failure message
        addMessage(new FacesMessage(FacesMessage.SEVERITY_ERROR, "User Registration Failed!!!", null));
        return "failure";
    }
}
