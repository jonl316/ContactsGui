package com.jlivesay.contactsgui.contacts;

/**
 * Created with IntelliJ IDEA.
 * Created by: Jonathan David Livesay
 * Email: jonl316@gmail.com
 * User: jonl316
 * Date: 5/13/13
 * Time: 8:48 AM
 * To change this template use File | Settings | File Templates.
 */
public class Person {

    private int _Id = 0;
	private String _FirstName = "";
    private String _LastName = "";

    // no args constructor
    public Person()
    {
//        	setId(0);
//    		setFirstName("");
//        	setLastName("");
    }

    // args constructor
    public Person(int id, String fn, String ln)
    {
        this.setId(id);
    	this.setFirstName(fn);
        this.setLastName(ln);
    }
    
    // args constructor without ID
    public Person( String fn, String ln)
    {
    	this.setId(0);
    	this.setFirstName(fn);
        this.setLastName(ln);
    }

    public int getId()
	{
		return _Id;
	}

	public void setId(int Id)
	{
		this._Id = Id;
	}

	public String getFirstName() {
        return _FirstName;
    }

    public void setFirstName(String firstName) {
        this._FirstName = firstName;
    }

    public String getLastName() {
        return _LastName;
    }

    public void setLastName(String lastName) {
        this._LastName = lastName;
    }


    // personToString Method to show the firstname and lastname;
    public void personToString()
    {
        System.out.println(this.getFirstName() + " " + this.getLastName());
    }

    // tostring method to make the name show up lastname, firstname
    public String toString()
    {
        return this.getLastName() + ", " + this.getFirstName();
    }








}


