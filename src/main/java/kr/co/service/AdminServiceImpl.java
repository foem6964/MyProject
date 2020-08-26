package kr.co.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.domain.AdminDTO;
import kr.co.domain.AdminloginDTO;
import kr.co.persistence.AdminDAO;

@Service

public class AdminServiceImpl implements AdminService{
	@Inject
	private AdminDAO adao;

	@Override
	public AdminDTO loginpost(AdminloginDTO login) {
		// TODO Auto-generated method stub
		return adao.loginpost(login);
	}

	@Override
	public AdminDTO login(AdminloginDTO login) {
		// TODO Auto-generated method stub
		return adao.login(login);
	}
	

}
