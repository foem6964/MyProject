package kr.co.persistence;

import kr.co.domain.AdminDTO;
import kr.co.domain.UsersDTO;
import kr.co.dto.LoginDTO;

public interface UsersDAO {

	UsersDTO readUser(String userId);

	void createUser(String userId);

	void updateName(UsersDTO dto);

	Integer getU_noById(String userId);

	AdminDTO loginpost(AdminDTO login);

	
}
