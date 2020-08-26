package kr.co.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductDTO {
	private Integer p_no;
	private String pName;
	private String pPrice;
	private String detailText;
	private String sellerNick;
	private String seller;
	private String detailPageUrl;
	private String salePrice;
	private String delivery;
	private String buySatisfy;
	private String discount;
	private String mileage;
	private Integer Invntry;

	public ProductDTO() {
	}

	public ProductDTO(Integer p_no, String pName, String pPrice, String detailText, String sellerNick, String seller,
			String detailPageUrl, String salePrice, String delivery, String buySatisfy, String discount, String mileage,
			Integer invntry) {
		this.p_no = p_no;
		this.pName = pName;
		this.pPrice = pPrice;
		this.detailText = detailText;
		this.sellerNick = sellerNick;
		this.seller = seller;
		this.detailPageUrl = detailPageUrl;
		this.salePrice = salePrice;
		this.delivery = delivery;
		this.buySatisfy = buySatisfy;
		this.discount = discount;
		this.mileage = mileage;
		Invntry = invntry;
	}

}
