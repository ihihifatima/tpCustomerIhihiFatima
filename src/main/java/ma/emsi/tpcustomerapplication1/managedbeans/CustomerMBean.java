/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ma.emsi.tpcustomerapplication1.managedbeans;

import javax.inject.Named;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import ma.emsi.tpcustomerapplication1.Customer;
import ma.emsi.tpcustomerapplication1.session.CustomerManager;

/**
 *
 * @author ihihi
 */
@Named(value = "customerMBean")
@ViewScoped
public class CustomerMBean implements Serializable {
private List<Customer> customerList;  
    @EJB
    private CustomerManager customerManager;

    /**
     * Creates a new instance of CustomerMBean
     */
    public CustomerMBean() {
    }
    /** 
   * Retourne la liste des clients pour affichage dans une DataTable 
   * @return 
   */  
     public List<Customer> getCustomers() {
    if (customerList == null) {
      customerList = customerManager.getAllCustomers();
    }
    return customerList;
  }
}
