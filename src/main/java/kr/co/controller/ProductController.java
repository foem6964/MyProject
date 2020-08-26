package kr.co.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.domain.ProductDTO;
import kr.co.domain.ProductImgDTO;
import kr.co.service.ProductService;

@Controller
@RequestMapping("product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "/productList", method = RequestMethod.GET)
	public void ProductList(String searchValue, Model model) {
		model.addAttribute("searchValue", searchValue);
	}
	
	@RequestMapping(value = "/productInfo", method = RequestMethod.GET)

	public void ProductInfo(String ProductCode, String SalePrice,String ProductPrice, String ProductImage300, Model model) {
		
			model.addAttribute("ProductCode", ProductCode);
	}

	/*
	 * @RequestMapping(value = "/productInfo", method = RequestMethod.GET) public
	 * void ProductInfo(String ProductCode, Model model) {
	 * 
	 * }
	 */
	
	@RequestMapping(value = "/select/{p_no}", method = RequestMethod.GET)
	public String selectOne(Model model, @PathVariable Integer p_no) {
		ProductDTO product = productService.selectByPno(p_no);
		List<ProductImgDTO> imgList = productService.selectListByPno(p_no);
		model.addAttribute("product", product);
		model.addAttribute("imgList", imgList);
		return "/product/select";
	}
	
	@RequestMapping(value = "/select", method = RequestMethod.GET)
	public String selectOne(Model model) {
		return "/product/select";
	}
	
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insert(HashMap<String, Object> map) {
		//get List<Img> get Product
		Integer p_no = productService.insert(map);
		return "/product/select/"+p_no;
	}
	
	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public void insert() {
	}
	
}