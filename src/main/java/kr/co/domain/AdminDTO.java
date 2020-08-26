package kr.co.domain;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class AdminDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String pw;
	
	public AdminDTO() {
		// TODO Auto-generated constructor stub
	}

	public AdminDTO(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((pw == null) ? 0 : pw.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AdminDTO other = (AdminDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (pw == null) {
			if (other.pw != null)
				return false;
		} else if (!pw.equals(other.pw))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", pw=" + pw + "]";
	}
	
	
	
	

}
