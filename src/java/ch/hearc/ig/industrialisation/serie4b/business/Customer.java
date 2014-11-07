package ch.hearc.ig.industrialisation.serie4b.business;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Limidob
 */
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Freyer
 */
public class Customer extends Person {

    private Integer number;
    private String firstName;
    private String lastName; 
    private List<Account> accounts;
    private Bank bank;

    /**
     *
     * @param number
     * @param firstName
     * @param lastName
     * @param address
     * @param bank
     */
    public Customer(Integer number, String firstName, String lastName, Address address, Bank bank) {
        this.number = number;
        this.firstName = firstName;
        this.lastName = lastName;
        this.setAddress(address);
        this.bank = bank;
        this.accounts = new ArrayList<Account>();
    }

    /**
     *
     * @param firstName
     * @param lastName
     * @param address
     * @param bank
     */
    public Customer(String firstName, String lastName, Address address, Bank bank) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.setAddress(address);
        this.bank = bank;
    }
    
    /**
     * Constructeur par defaut
     */
    public Customer() {
    }

    /**
     *
     * @return number
     */
    public Integer getNumber() {
        return number;
    }

    /**
     *
     * @param number
     */
    public void setNumber(Integer number) {
        this.number = number;
    }

    /**
     *
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     *
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     *
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     *
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     *
     * @return bank
     */
    public Bank getBank() {
        return bank;
    }

    /**
     *
     * @param bank
     */
    public void setBank(Bank bank) {
        this.bank = bank;
    }

    /**
     *
     * @return accounts
     */
    public List<Account> getAccounts() {
        return accounts;
    }

    /**
     *
     * @param account
     */
    public void setAccounts(List<Account> account) {
        this.accounts = account;
    }

}
