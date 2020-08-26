package kr.co.domain;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class UsersDTO {
	private Integer u_no;
	private String id;
	private String name;
	private String address;

	public UsersDTO() {
	}

	public UsersDTO(Integer u_no, String id, String name, String address) {
		super();
		this.u_no = u_no;
		this.id = id;
		this.name = name;
		this.address = address;
	}



}
