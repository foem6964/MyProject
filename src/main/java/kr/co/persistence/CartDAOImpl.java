package kr.co.persistence;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.domain.CartDTO;

@Repository
public class CartDAOImpl implements CartDAO {
	@Autowired
	private SqlSession session;

	private static final String NS = "c.r.t";

	@Override
	public List<CartDTO> selectList(Integer u_no) {
		return session.selectList(NS + ".list", u_no);
	}

	@Override
	public void insert(CartDTO dto) {
		Integer c_no = session.selectOne(NS+".getC_no");
		dto.setC_no(c_no);
		session.insert(NS + ".insert", dto);
	}

	@Override
	public void delete(int c_no, Integer u_no) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("c_no", c_no);
		map.put("u_no", u_no);
		session.delete(NS + ".delete", map);
	}

	@Override
	public void update(Integer c_no, String count, Integer u_no) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("c_no", c_no);
		map.put("count", count);
		map.put("u_no", u_no.toString());
		System.out.println("c_no:" +c_no);
		System.out.println("count:" +count);
		System.out.println("u_no:" +u_no);
		session.update(NS+".update", map);
	}

}
