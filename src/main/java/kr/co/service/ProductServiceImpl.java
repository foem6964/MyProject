package kr.co.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.domain.ProductDTO;
import kr.co.domain.ProductImgDTO;
import kr.co.persistence.ProductDAO;

@Service
public class ProductServiceImpl implements ProductService{
	
	private ProductDAO dao;

	@Override
	public ProductDTO selectByPno(Integer p_no) {
		return dao.selectByPno(p_no);
	}

	@Override
	public List<ProductImgDTO> selectListByPno(Integer p_no) {
		return dao.selectListByPno(p_no);
	}
	
	@Transactional
	@Override
	public Integer insert(HashMap<String, Object> map) {
		ProductDTO product = (ProductDTO) map.get("product");
		Integer p_no = dao.getP_no();
		product.setP_no(p_no);
		product.setDetailPageUrl("/product/select/"+p_no);
		
		@SuppressWarnings("unchecked")
		List<ProductImgDTO> imgList = (List<ProductImgDTO>) map.get("imgList");
		dao.insertProduct(product);
		for (ProductImgDTO img : imgList) {
			Integer i_no = dao.getI_no();
			dao.insertProductImg(img);
		}
		return p_no;
	}


}
