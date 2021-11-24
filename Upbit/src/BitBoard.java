
public class BitBoard {
	private int BTC;
	private int ETH;
	private int XRP;
	private int DOGE;
	BitBoard(){
		BTC = 72000000;
		ETH = 5300000;
		XRP = 1315;
		DOGE = 280;
	}
	
	void show() {
		System.out.println("BTC : "+BTC+"\nETH : "+ETH+"\nXRP : "+XRP+"\nDOGE : "+DOGE);
	}
	int getbitprice(int i) {
		int price=1;
		switch(i){
		case 0:
			price=BTC;
			break;
		case 1:
			price=ETH;
			break;
		case 2:
			price=XRP;
			break;
		case 3:
			price=DOGE;
			break;
			
		}
		
		return price;
	}
	

}
