package kr.co.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductImgDTO {
	private Integer i_no;
	private Integer p_no;
	private String imgAdr;
	
	public ProductImgDTO() {
	}
	
	public ProductImgDTO(Integer i_no, Integer p_no, String imgAdr) {
		this.i_no = i_no;
		this.p_no = p_no;
		this.imgAdr = imgAdr;
	}
	
}
