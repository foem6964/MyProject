package kr.co.service;

import java.util.HashMap;
import java.util.List;

import kr.co.domain.ProductDTO;
import kr.co.domain.ProductImgDTO;

public interface ProductService {

	ProductDTO selectByPno(Integer p_no);

	List<ProductImgDTO> selectListByPno(Integer p_no);

	Integer insert(HashMap<String, Object> map);

}
