package model;

import java.util.Date;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
@AllArgsConstructor
public class Member {
	@Id
	private long membId;
	private String name;
	private String address;
	private String membType;
	private Date membDate;
	private Date expiryDate;

	public long getMembId() {
		return membId;
	}

	public void setMembId(long membId) {
		this.membId = membId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMembType() {
		return membType;
	}

	public void setMembType(String membType) {
		this.membType = membType;
	}

	public Date getMembDate() {
		return membDate;
	}

	public void setMembDate(Date membDate) {
		this.membDate = membDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

}
