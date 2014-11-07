package ch.hearc.ig.industrialisation.serie4b.business;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author LimidoB
 */
public class AccountWithDebitLimit extends Account {

    private Float debitLimit;
    private Float debitAccumulation;

    /**
     *
     */
    public AccountWithDebitLimit() {
        this.debitAccumulation = 0f;
    }

    /**
     *
     * Crée un compt qui as une limite de débit
     * @param number
     * @param label
     * @param balance
     * @param rate
     * @param debitLimit
     
     */
    public AccountWithDebitLimit(Integer number, String label, Float balance, Float rate, Float debitLimit) {
        super(number, label, balance, rate);
        this.debitLimit = debitLimit;
        this.debitAccumulation = 0f;
    }

    /**
     *
     * @param debitLimit
     * @param number
     * @param label
     * @param balance
     * @param rate
     * @param idCustomer
     */
    public AccountWithDebitLimit(Float debitLimit, Integer number, String label, Float balance, Float rate, Integer idCustomer) {
        super(number, label, balance, rate, idCustomer);
        this.debitLimit = debitLimit;
        
    }

    /**
     * Controle si la limite de débit sera atteinte avec ce nouveau débit
     * @param amount
     * 
     */
    
    
    @Override
    public void debit(Float amount) {
        if (this.debitAccumulation + amount <= this.debitLimit) {
            super.debit(amount);
        } else {
            System.out.println("The debit limit is reached");
        }
    }

    /**
     *
     * @return debitLimit
     */
    public Float getDebitLimit() {
        return debitLimit;
    }

    /**
     *
     * @param debitlimit
     */
    public void setDebitLimit(Float debitlimit) {
        this.debitLimit = debitlimit;
    }

    /**
     *
     * @return debitAccumulation
     */
    public Float getDebitAccumulation() {
        return debitAccumulation;
    }

    /**
     *
     * @param debitAccumulation
     */
    public void setDebitAccumulation(Float debitAccumulation) {
        this.debitAccumulation = debitAccumulation;
    }

}
