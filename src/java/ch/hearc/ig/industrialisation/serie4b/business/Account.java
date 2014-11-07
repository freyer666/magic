package ch.hearc.ig.industrialisation.serie4b.business;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author LimidoB
 */
public class Account {

    private Integer number;
    private String label;
    private Float balance;
    private Float rate;
    private Integer idCustomer;

   

    /**
     *
     * Constructeur vide
     */
    
    public Account() {
    }

    /**
     *
     * @param number
     * @param label
     * @param balance
     * @param rate
     */
    public Account(Integer number, String label, Float balance, Float rate) {
        this.number = number;
        this.label = label;
        this.balance = balance;
        this.rate = rate;
    }

    /**
     *
     * @param number
     * @param label
     * @param balance
     * @param rate
     * @param idCustomer
     */
    public Account(Integer number, String label, Float balance, Float rate, Integer idCustomer) {
        this.number = number;
        this.label = label;
        this.balance = balance;
        this.rate = rate;
        this.idCustomer = idCustomer;
    }

    
    

    /**
     *
     * @param amount
     */
    public void credit(Float amount) {
        this.balance = this.balance + amount;
    }

    /**
     *
     * @param amount
     */
    public void debit(Float amount) {
        this.balance = this.balance - amount;
    }

    /**
     *Tranfers d'un compt source a un compt destination une somme
     * @param transfer
     * @param source
     * @param amount
     * 
     */
    public static void transfer(Account transfer, Account source, Float amount) {
        transfer.credit(amount);
        source.debit(amount);
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
     * @return label
     */
    public String getLabel() {
        return label;
    }

    /**
     *
     * @param number
     */
    public void setLabel(String number) {
        this.label = number;
    }

    /**
     *
     * @return balance
     */
    public Float getBalance() {
        return balance;
    }

    /**
     *
     * @param balance
     */
    public void setBalance(Float balance) {
        this.balance = balance;
    }

    /**
     *
     * @return rate
     */
    public Float getRate() {
        return rate;
    }

    /**
     *
     * @param rate
     */
    public void setRate(Float rate) {
        this.rate = rate;
    }
    
    /**
     *
     * @return
     */
    public Integer getIdCustomer() {
        return idCustomer;
    }

    /**
     *
     * @param idCustomer
     */
    public void setIdCustomer(Integer idCustomer) {
        this.idCustomer = idCustomer;
    }
}
