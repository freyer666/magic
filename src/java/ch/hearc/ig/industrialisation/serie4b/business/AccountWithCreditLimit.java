package ch.hearc.ig.industrialisation.serie4b.business;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author LimidoB
 */
public class AccountWithCreditLimit extends Account {

    private Float limitCredit;
    private Float totalCredit;

    /**
     *
     */
    public AccountWithCreditLimit() {
        this.totalCredit = 0f;
    }

    /**
     *
     * @param number
     * @param label
     * @param balance
     * @param rate
     * @param limiteCredit
     */
    public AccountWithCreditLimit(Integer number, String label, Float balance, Float rate, Float limiteCredit) {
        super(number,label, balance, rate);
        this.limitCredit = limiteCredit;
        this.totalCredit = 0f;
    }

    /**
     *
     * @param limitCredit
     * @param number
     * @param label
     * @param balance
     * @param rate
     * @param idCustomer
     */
    public AccountWithCreditLimit(Float limitCredit, Integer number, String label, Float balance, Float rate, Integer idCustomer) {
        super(number, label, balance, rate, idCustomer);
        this.limitCredit = limitCredit;
        this.totalCredit = 0f;
    }
    

    /**
     *
     * @param amount
     *   Controle si ce nouveau crédit ne dépasse pas la limite de crédit
     */
  
    @Override
    public void credit(Float amount) {
        if (this.totalCredit + amount <= this.limitCredit) {
            super.credit(amount);
        } else {
            System.out.println("The credit limit is reached");
        }
    }

    /**
     *
     * @return limitCredit
     */
    public Float getLimiteCredit() {
        return limitCredit;
    }

    /**
     *
     * @param limiteCredit
     */
    public void setLimiteCredit(Float limiteCredit) {
        this.limitCredit = limiteCredit;
    }

    /**
     *
     * @return totalCredit
     */
    public Float getCreditCumul() {
        return totalCredit;
    }

    /**
     *
     * @param creditCumul
     */
    public void setCreditTotal(Float creditCumul) {
        this.totalCredit = creditCumul;
    }

}
