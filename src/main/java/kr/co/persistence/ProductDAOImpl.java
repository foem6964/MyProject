package kr.co.persistence;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.domain.ProductDTO;
import kr.co.domain.ProductImgDTO;

@Repository
public class ProductDAOImpl implements ProductDAO {
	@Autowired
	private SqlSession session;

	private static final String NS = "p.d.t";

	@Override
	public ProductDTO selectByPno(Integer p_no) {
		return session.selectOne(NS + ".selectByPno", p_no);
	}

	@Override
	public List<ProductImgDTO> selectListByPno(Integer p_no) {
		return session.selectList(NS + "selectListByPno", p_no);
	}

	@Override
	public Integer getP_no() {
		return session.selectOne(NS + "getP_no");
	}

	@Override
	public Integer getI_no() {
		return session.selectOne(NS + "getI_no");
	}

	@Override
	public void insertProduct(ProductDTO product) {
		session.insert(NS + ".insertProduct", product);
	}

	@Override
	public void insertProductImg(ProductImgDTO img) {
		session.insert(NS + ".insertImg", img);
	}

}
