package kr.co.service;

import kr.co.domain.AdminDTO;
import kr.co.domain.UsersDTO;
import kr.co.dto.LoginDTO;

public interface UsersService {

	UsersDTO readUser(String userId);

	String createUserId(String snsName, String code);

	void createUser(String userId);

	void updateName(UsersDTO dto);

	Integer getU_noById(String userId);

	AdminDTO loginpost(AdminDTO login);

	
}
