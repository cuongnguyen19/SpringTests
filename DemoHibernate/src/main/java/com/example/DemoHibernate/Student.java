package com.example.DemoHibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
public class Student
{
    @Id
    private int id;
    private StudentName sname;
    private String email;
    @ManyToMany(mappedBy = "student", fetch = FetchType.EAGER)
    private List<Laptop> laptop = new ArrayList<Laptop>();
    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    public StudentName getSname() {
		return sname;
	}
	public void setSname(StudentName sname) {
		this.sname = sname;
	}
	public String getEmail()
    {
        return email;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
    public List<Laptop> getLaptop() {
		return laptop;
	}
	public void setLaptop(List<Laptop> laptop) {
		this.laptop = laptop;
	}
	@Override
    public String toString()
    {
        return "Student [id=" + id + ", name=" + sname + ", email=" + email + "]";
    }
    
}