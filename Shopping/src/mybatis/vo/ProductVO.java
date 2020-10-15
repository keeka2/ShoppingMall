package mybatis.vo;

public class ProductVO {
	private String p_num, //기본키
				p_category, //카테고리
				p_name, // 제품명
				p_image_s, //작은 이미지(제품 목록창에서 사용)
				p_image_l, //큰 이미지(제품 상세보기에서 사용)
				p_content, //제품 설명
				p_date; //등록일
	
	private int p_price, //단가
				p_saleprice, //세일가격
				p_quant; //수량

	public String getP_num() {
		return p_num;
	}

	public void setP_num(String p_num) {
		this.p_num = p_num;
	}

	public String getP_category() {
		return p_category;
	}

	public void setP_category(String p_category) {
		this.p_category = p_category;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public String getP_image_s() {
		return p_image_s;
	}

	public void setP_image_s(String p_image_s) {
		this.p_image_s = p_image_s;
	}

	public String getP_image_l() {
		return p_image_l;
	}

	public void setP_image_l(String p_image_l) {
		this.p_image_l = p_image_l;
	}

	public String getP_content() {
		return p_content;
	}

	public void setP_content(String p_content) {
		this.p_content = p_content;
	}

	public String getP_date() {
		return p_date;
	}

	public void setP_date(String p_date) {
		this.p_date = p_date;
	}

	public int getP_price() {
		return p_price;
	}

	public void setP_price(int p_price) {
		this.p_price = p_price;
	}

	public int getP_saleprice() {
		return p_saleprice;
	}

	public void setP_saleprice(int p_saleprice) {
		this.p_saleprice = p_saleprice;
	}

	public int getP_quant() {
		return p_quant;
	}

	public void setP_quant(int p_quant) {
		this.p_quant = p_quant;
	}



			
}




