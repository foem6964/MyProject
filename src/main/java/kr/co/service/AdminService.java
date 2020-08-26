package kr.co.service;

import kr.co.domain.AdminDTO;
import kr.co.domain.AdminloginDTO;

public interface AdminService {

	AdminDTO loginpost(AdminloginDTO login);
	
	AdminDTO login(AdminloginDTO login);

}
