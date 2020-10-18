package mybatis.vo;

public class CartVO extends ProductVO{
	private int count;
	private int totalPrice;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	
}
