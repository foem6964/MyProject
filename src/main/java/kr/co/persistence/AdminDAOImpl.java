package kr.co.persistence;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.domain.AdminDTO;
import kr.co.domain.AdminloginDTO;

@Repository
public class AdminDAOImpl implements AdminDAO{
	@Autowired
	private SqlSession session;
	private final String NS = "a,d,s";
	@Override
	public AdminDTO loginpost(AdminloginDTO login) {
		// TODO Auto-generated method stub
		return session.selectOne(NS+".loginpost", login);
	}
	@Override
	public AdminDTO login(AdminloginDTO login) {
		// TODO Auto-generated method stub
		return session.selectOne(NS+".read", login);
	}
	
	

}
