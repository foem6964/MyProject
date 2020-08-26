package kr.co.persistence;

import java.util.List;

import kr.co.domain.CartDTO;

public interface CartDAO {

	List<CartDTO> selectList(Integer u_no);

	void insert(CartDTO dto);

	void delete(int c_no, Integer u_no);

	void update(Integer c_no, String count, Integer u_no);

}
