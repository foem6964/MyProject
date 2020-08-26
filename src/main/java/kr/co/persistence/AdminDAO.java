package kr.co.persistence;

import kr.co.domain.AdminDTO;
import kr.co.domain.AdminloginDTO;

public interface AdminDAO {

	AdminDTO loginpost(AdminloginDTO login);

	AdminDTO login(AdminloginDTO login);

}
