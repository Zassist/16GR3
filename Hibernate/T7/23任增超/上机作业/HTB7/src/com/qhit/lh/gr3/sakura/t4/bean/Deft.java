package com.qhit.lh.gr3.sakura.t4.bean;

import java.util.HashSet;
import java.util.Set;



/**
 * Deft entity. @author MyEclipse Persistence Tools
 */

public class Deft  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String dname;
     private String address;

     private Set<Emp> emps = new HashSet<>();
    // Constructors

    /** default constructor */
    public Deft() {
    }

	/** minimal constructor */
    public Deft(String dname) {
        this.dname = dname;
    }
    
    /** full constructor */
    public Deft(String dname, String address) {
        this.dname = dname;
        this.address = address;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getDname() {
        return this.dname;
    }
    
    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }

	public Set<Emp> getEmps() {
		return emps;
	}

	public void setEmps(Set<Emp> emps) {
		this.emps = emps;
	}
   


}