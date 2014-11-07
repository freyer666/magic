package ch.hearc.ig.industrialisation.serie4b.business;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author LimidoB
 */
public class Address {

    private int id;
    private String street;
    private String zipCode;
    private String city;

    /**
     *
     * @param street
     * @param zipCode
     * @param city
     */
    public Address(String street, String zipCode, String city) {
        this.street = street;
        this.zipCode = zipCode;
        this.city = city;
    }

    /**
     *
     */
    public Address() {
    }

    /**
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     */
    /**
     *
     * @return street
     */
    public String getStreet() {
        return street;
    }

    /**
     *
     * @param street
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     *
     * @return zipCode
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     *
     * @param NPA
     */
    public void setZipCode(String NPA) {
        this.zipCode = NPA;
    }

    /**
     *
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     *
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

}
