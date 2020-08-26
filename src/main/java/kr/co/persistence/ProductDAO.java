package kr.co.persistence;

import java.util.List;

import kr.co.domain.ProductDTO;
import kr.co.domain.ProductImgDTO;

public interface ProductDAO {

	ProductDTO selectByPno(Integer p_no);

	List<ProductImgDTO> selectListByPno(Integer p_no);

	void insertProduct(ProductDTO product);

	void insertProductImg(ProductImgDTO img);

	Integer getP_no();

	Integer getI_no();


}
