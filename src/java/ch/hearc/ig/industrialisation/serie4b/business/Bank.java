package ch.hearc.ig.industrialisation.serie4b.business;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author LimidoB
 */
import java.util.LinkedHashSet;
import java.util.Set;

/**
 *
 * @author Freyer
 */
public class Bank {

    
    private Integer id;

    
    private String name;
    private Address address;
    private Set<Customer> customers;

    /**
     *
     * @param name
     * @param adress
     */
    public Bank(String name, Address adress) {
        this.name = name;
        this.address = adress;
        this.customers = new LinkedHashSet<Customer>();
    }

    /**
     *
     */
    public Bank() {
    }


    /**
     *
     * @return name
     */
    public String getName() {
        return name;
    }
    
    /**
     *
     * @return
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return address
     */
    public Address getAdress() {
        return address;
    }

    /**
     *
     * @param adress
     */
    public void setAdress(Address adress) {
        this.address = adress;
    }

    /**
     *
     * @return customers
     */
    public Set<Customer> getCustomers() {
        return customers;
    }

    /**
     *
     * @param customers
     */
    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }

    /**
     *
     * @param number
     * @return customer
     */
    /*Recherche du client dans la banque*/
    public Customer getCustomerByNumber(Integer number) {
        for (Customer c : this.customers) {
            if (c.getNumber().equals(number)) {
                return c;
            }
        }
        System.out.println("Client " + number + " pas trouvé");
        return null;
    }

}
