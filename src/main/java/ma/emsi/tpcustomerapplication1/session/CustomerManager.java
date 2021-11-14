/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package ma.emsi.tpcustomerapplication1.session;

import javax.ejb.Stateless;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import ma.emsi.tpcustomerapplication1.Customer;


/**
 *
 * @author ihihi
 */
@Stateless
public class CustomerManager {

    @PersistenceContext(name = "customerPU")
    private EntityManager em;
   // @Resource
  //  private javax.transaction.UserTransaction utx;

    public List<Customer> getAllCustomers() { 
      Query query =em.createNamedQuery("Customer.findAll");
      return query.getResultList();  
    }  
        
    public Customer update(Customer customer) {
     return em.merge(customer);
    }     

    public void persist(Customer customer) {
          em.persist(customer);
        /*try {
            //utx.begin();
            em.persist(customer);
           // utx.commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }*/
    }
    
    
}
