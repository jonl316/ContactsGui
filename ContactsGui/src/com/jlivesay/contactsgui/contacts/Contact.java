package com.jlivesay.contactsgui.contacts;

/**
 * Created with IntelliJ IDEA.
 * Created by: Jonathan David Livesay
 * Email: jonl316@gmail.com
 * User: jonl316
 * Date: 5/13/13
 * Time: 10:43 AM
 * To change this template use File | Settings | File Templates.
 */
public class Contact extends Person
{
    // Private Fields for Contact Class
    private String _Street1 = "" ;
    private String _Street2 = "";
    private String _City = "";
    private String _State = "";
    private String _ZipCode = "";
    private String _CellPhone = "";
    private String _HomePhone = "";
    private String _WorkPhone = "";
    private String _Email1 = "";
    private String _Email2 = "";
    private String _Email3 = "";


    public String getStreet1() {
        return _Street1;
    }

    public void setStreet1(String street1) {
        this._Street1 = street1;
    }

    public String getStreet2() {
        return _Street2;
    }

    public void setStreet2(String street2) {
        this._Street2 = street2;
    }

    public String getCity() {
        return _City;
    }

    public void setCity(String city) {
        this._City = city;
    }

    public String getState() {
        return _State;
    }

    public void setState(String state) {
        this._State = state;
    }

    public String getZipCode() {
        return _ZipCode;
    }

    public void setZipCode(String zipCode) {
        this._ZipCode = zipCode;
    }

    public String getCellPhone() {
        return _CellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this._CellPhone = cellPhone;
    }

    public String getHomePhone() {
        return _HomePhone;
    }

    public void setHomePhone(String homePhone) {
        this._HomePhone = homePhone;
    }

    public String getWorkPhone() {
        return _WorkPhone;
    }

    public void setWorkPhone(String workPhone) {
        this._WorkPhone = workPhone;
    }

    public String getEmail2() {
        return _Email2;
    }

    public void setEmail2(String email2) {
        this._Email2 = email2;
    }

    public String getEmail3() {
        return _Email3;
    }

    public void setEmail3(String email3) {
        this._Email3 = email3;
    }

    public String getEmail1() {
        return _Email1;
    }

    public void setEmail1(String email1) {
        this._Email1 = email1;
    }


    // no arg constructor
    public Contact()
    {
    	
    }

    // arg constructor with simplified fields with the ID field
    public Contact(int id, String fn, String ln, String s1, String c, String st, String zp, String cell, String home, String em1, String em2)
    {
        super(id, fn, ln);
        this.setStreet1(s1);
        this.setCity(c);
        this.setState(st);
        this.setZipCode(zp);
        this.setCellPhone(cell);
        this.setHomePhone(home);
        this.setEmail1(em1);
        this.setEmail2(em2);
    }
    
    // arg constructor with simplified fields
    public Contact(String fn, String ln, String s1, String c, String st, String zp, String cell, String home, String em1, String em2)
    {
        super(fn, ln);
        this.setStreet1(s1);
        this.setCity(c);
        this.setState(st);
        this.setZipCode(zp);
        this.setCellPhone(cell);
        this.setHomePhone(home);
        this.setEmail1(em1);
        this.setEmail2(em2);
    }

    // arg constructor with every field with the ID field
    public Contact(int id, String fn, String ln, String s1, String s2, String c, String st, String zp,
                   String cell, String home, String work, String em1, String em2, String em3)
    {
        super(id, fn, ln);
        this.setStreet1(s1);
        this.setStreet2(s2);
        this.setCity(c);
        this.setState(st);
        this.setZipCode(zp);
        this.setCellPhone(cell);
        this.setHomePhone(home);
        this.setWorkPhone(work);
        this.setEmail1(em1);
        this.setEmail2(em2);
        this.setEmail3(em3);
    }
    
    
    // arg constructor with every field
    public Contact(String fn, String ln, String s1, String s2, String c, String st, String zp,
                   String cell, String home, String work, String em1, String em2, String em3)
    {
        super(fn, ln);
        this.setStreet1(s1);
        this.setStreet2(s2);
        this.setCity(c);
        this.setState(st);
        this.setZipCode(zp);
        this.setCellPhone(cell);
        this.setHomePhone(home);
        this.setWorkPhone(work);
        this.setEmail1(em1);
        this.setEmail2(em2);
        this.setEmail3(em3);
    }

    // to string method to print out the state of the instance.
    public String toString()
    {
        return  "**********************************\n" +
                "Name: " + this.getFirstName() + " " +  this.getLastName() + "\n" +
                "Street1: " + this.getStreet1() + "\n" +
                "Street2: " + this.getStreet2() + "\n" +
                "City: " + this.getCity() + "\n" +
                "State: " + this.getState() + "\n" +
                "Zip: " + this.getZipCode() + "\n" +
                "Cell Ph: " + this.getCellPhone() + "\n" +
                "Home Ph: " + this.getHomePhone() + "\n" +
                "Work Ph: " + this.getWorkPhone() + "\n" +
                "Email1: " + this.getEmail1() + "\n" +
                "Email2: " + this.getEmail2() + "\n" +
                "Email3: " + this.getEmail3() + "\n" +
                "**********************************\n";

    }
    
    public String toFileFormat()
    {
        return  this.getFirstName() + ";" +  
        		this.getLastName() + ";" +
                this.getStreet1() + ";" +
                this.getStreet2() + ";" +
                this.getCity() + ";" +
                this.getState() + ";" +
                this.getZipCode() + ";" +
                this.getCellPhone() + ";" +
                this.getHomePhone() + ";" +
                this.getWorkPhone() + ";" +
                this.getEmail1() + ";" +
                this.getEmail2() + ";" +
                this.getEmail3();

    }
    
    public String toSqlFormat()
    {
    	return "'" + this.getFirstName() + "'";
    }

}
