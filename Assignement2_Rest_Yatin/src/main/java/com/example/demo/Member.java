package com.example.demo;



import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String email;
    private String phone;
    private Date membershipDate;
   
    public Member() {}
    
    public Member(String name, String email, String phone, Date membershipDate) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.membershipDate = membershipDate;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getMembershipDate() {
		return membershipDate;
	}

	public void setMembershipDate(Date membershipDate) {
		this.membershipDate = membershipDate;
	}
    
  
}