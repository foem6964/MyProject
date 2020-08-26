package kr.co.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginDTO {
	private String uid;
	private String upw;
	
	public LoginDTO() {
		// TODO Auto-generated constructor stub
	}

	public LoginDTO(String uid, String upw) {
		super();
		this.uid = uid;
		this.upw = upw;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((uid == null) ? 0 : uid.hashCode());
		result = prime * result + ((upw == null) ? 0 : upw.hashCode());
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
		LoginDTO other = (LoginDTO) obj;
		if (uid == null) {
			if (other.uid != null)
				return false;
		} else if (!uid.equals(other.uid))
			return false;
		if (upw == null) {
			if (other.upw != null)
				return false;
		} else if (!upw.equals(other.upw))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LoginDTO [uid=" + uid + ", upw=" + upw + "]";
	}
	
}
