package com.klef.jfsd.exam;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "department")
public class Department {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int departmentId;

	    @Column(nullable = false)
	    private String name;

	    @Column(nullable = false)
	    private String location;

	    @Column(nullable = false)
	    private String hodName;

	    // Getters and Setters
	    public int getDepartmentId() {
	        return departmentId;
	    }

	    public void setDepartmentId(int departmentId) {
	        this.departmentId = departmentId;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getLocation() {
	        return location;
	    }

	    public void setLocation(String location) {
	        this.location = location;
	    }

	    public String getHodName() {
	        return hodName;
	    }

	    public void setHodName(String hodName) {
	        this.hodName = hodName;
	    }
	
}
