package eao;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.AddressUpdate;
import model.Customer;
import util.Util;
import beans.RegistrationBean;

/**
 * Session Bean implementation class RegistrationEAO
 */
@Stateless(mappedName = "registrationEAO")
@LocalBean
public class RegistrationEAO {
 
    @PersistenceContext()
    EntityManager entityManager;
 
    /**
     * Default constructor.
     */
    public RegistrationEAO() {
    	
    }
 
    public boolean persistUser(RegistrationBean registrationBean) {
 
        try {
            // Populate an instance of the User Entity
            
        	Customer user = new Customer();
            user.setEmail(registrationBean.getEmail());
            user.setPassword(Util.hash(registrationBean.getPassword()));
            user.setLastName(registrationBean.getLastName());
            //Commit data to the database
            entityManager.persist(user);
 
            return true;
        } catch (ClassCastException e) {
            System.out.println("Class Cast Exception");
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            System.out.println("Illegal Argument Exception");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Generic Exception");
            e.printStackTrace();
        }
 
        return false;
    }
 
}