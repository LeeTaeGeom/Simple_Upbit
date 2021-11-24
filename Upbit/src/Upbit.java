
public class Upbit {
	
	private float KRW; // 업비트내 내 잔고 
	private float holding[]=new float[5]; // 보유수량 
	
	private BitBoard bb;
	Upbit(float i) {
		KRW=i;
		bb= new BitBoard();
	}
	void bitshow() {
		bb.show();
	}
	
	void setKRW(float i) {
		KRW+=i;
	}

	void upbitmoney() {
		System.out.println("업비트에 보유한 KRW는 "+KRW+"입니다");
	}
	
	int compare(int i) { //업비트 돈뺄때 원하는 금액이 가진돈보다 많은지 적은지 확인 
		if(KRW>=i) {
			return 1;
		}
		else {
			return 0;
		}
	}
	
	void buy(int wantbuy, int i) { //i는 무슨코인인지 
		
		if(0<=i && i<=3)  {
			if(KRW>=wantbuy) {
				holding[i]=(float)wantbuy/bb.getbitprice(i);
				setKRW(-wantbuy);
			}
			else {
				System.out.println("업비트 잔고가 부족합니다");
			}
		}
		else {
			System.out.println("그런코인 없습니다");
		}
		
	}
	int holdcoin(float i,int c) { //코인있는지 
		if(i<=holding[c]) {
			return 1;
		}
		else {
			return 0;
		}
		
	}
	void sell(float i,int c) {

		holding[c]-=i;
		setKRW(bb.getbitprice(c)*i);
	
	}
	void show() {
		int count=0;
		for(int i=0;i<4;i++) {
			if(holding[i]==0) {
				if(i==3&&count==0) 
					System.out.println("보유코인이없습니다 ");
				continue;
			}
			else{
				count+=1;
				switch(i) {
					case 0:
						System.out.println("BTC : "+holding[i]+"개");
						break;
					case 1:
						System.out.println("ETH : "+holding[i]+"개");
						break;
					case 2:
						System.out.println("XRP : "+holding[i]+"개");
						break;
					case 3:
						System.out.println("DOGE : "+holding[i]+"개");
						break;
					default:
						break;
						
					
				}
			}
				
		}
		
	}
}
