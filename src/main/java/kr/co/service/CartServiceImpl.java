package kr.co.service;

import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.domain.CartDTO;
import kr.co.persistence.CartDAO;

@Service
public class CartServiceImpl implements CartService {
	@Autowired
	private CartDAO dao;

	@Override
	public List<CartDTO> selectList(Integer u_no) {
		return dao.selectList(u_no);
	}

	@Override
	public void insert(CartDTO dto) {
		dao.insert(dto);
	}

	@Override
	public void delete(int c_no, Integer u_no) {
		dao.delete(c_no, u_no);
	}

	@Override
	public void update(Integer c_no, String count, Integer u_no) {
		dao.update(c_no, count, u_no);
	}

	@Override
	public void getCartDTOfrom11st(String productCode, Integer u_no) {
		String url = new StringBuffer().append("https://openapi.11st.co.kr/openapi/OpenApiService.tmall")
				.append("?key=4a972a13f9e22b164bbe473d226d2dd3").append("&apiCode=ProductSearch").append("&keyword=")
				.append(productCode) // 필수
				.append("&pageSize=1")// 선택적 항목 검색
				.toString();
		try {
			Document doc = Jsoup.connect(url).get();
			String pName = doc.select("ProductName").text();
			String pPrice = doc.select("ProductPrice").text();
			String pImage = doc.select("ProductImage150").text();
			String sellerNick = doc.select("SellerNick").text();
			String seller = doc.select("Seller").text();
			String detailPageUrl = "/product/productInfo?ProductCode="+productCode;
			String salePrice = doc.select("SalePrice").text();
			String delivery = doc.select("Delivery").text();
			String buySatisfy = doc.select("BuySatisfy").text();
			String discount = doc.select("Discount").text();
			String mileage = doc.select("Mileage").text();
			String count = doc.select("TotalCount").text();
			CartDTO dto = new CartDTO(null, pName, pPrice, pImage, sellerNick, seller, detailPageUrl, salePrice,
					delivery, buySatisfy, discount, mileage, null, count);
			
			dto.setU_no(u_no);
			insert(dto);
		} catch (IOException e) {
			throw new RuntimeException("get CartDTO from 11st fail method:cartService.getCartDTOfrom11st");
		}
	}
}
