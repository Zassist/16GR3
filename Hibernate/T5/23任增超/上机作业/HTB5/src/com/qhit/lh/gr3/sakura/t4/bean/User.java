package com.qhit.lh.gr3.sakura.t4.bean;



/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String uname;
     private String password;

     private Emp emp;
    // Constructors

    /** default constructor */
    public User() {
    }

    
    /** full constructor */
    public User(String uname, String password) {
        this.uname = uname;
        this.password = password;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getUname() {
        return this.uname;
    }
    
    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }


	public Emp getEmp() {
		return emp;
	}


	public void setEmp(Emp emp) {
		this.emp = emp;
	}


	
   








}