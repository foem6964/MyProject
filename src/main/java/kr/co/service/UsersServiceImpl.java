package kr.co.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.constant.SnsUrlGroup;
import kr.co.domain.AdminDTO;
import kr.co.domain.UsersDTO;
import kr.co.dto.LoginDTO;
import kr.co.persistence.UsersDAO;
@Transactional
@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UsersDAO dao;

	@Override
	public UsersDTO readUser(String userId) {
		return dao.readUser(userId);
	}

	@Override
	public String createUserId(String snsName, String code) {
		SnsUrlGroup sns = SnsUrlGroup.valueOf(snsName.toUpperCase());
		try {
			String id = sns.getSnsUniqueId(code);
			String userId = snsName + id;
			return userId;
		} catch (IOException e) {
			throw new RuntimeException("snsName+id 실패");
		}
	}

	@Override
	public void createUser(String userId) {
		dao.createUser(userId);
	}

	@Override
	public void updateName(UsersDTO dto) {
		dao.updateName(dto);
	}

	@Override
	public Integer getU_noById(String userId) {
		return dao.getU_noById(userId);
	}

	@Override
	public AdminDTO loginpost(AdminDTO login) {
		// TODO Auto-generated method stub
		return dao.loginpost(login);
	}

	
}
