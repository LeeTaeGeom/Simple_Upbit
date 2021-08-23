
class Upbit {
	
	private float KRW; // 업비트내 내 잔고 
	private float holding[]=new float[5]; // 보유수량 
	private int ck; // 가능여부확인 
	
	Upbit(float i) {
		KRW=i;
	}
	void setKRW(float i) {
		KRW+=i;
	}

	void upbitmoney() {
		System.out.println("업비트에 보유한 KRW는 "+KRW+"입니다");
	}
	void usertoupbit(int mon, User me) { //업비트에돈넣는
		ck=me.compare(mon);
		if(ck==1) {
			me.setmoney(-mon);
			KRW+=mon;
		}
		else {
			System.out.println("업비트에 원하시는 돈을 넣기에 보유잔고가 부족합니다");
		}
	}
	
	int compare(int i) { //업비트 돈뺄때 원하는 금액이 가진돈보다 많은지 적은지 확인 
		if(KRW>=i) {
			return 1;
		}
		else {
			return 0;
		}
	}
	
	void buy(int coinprice, int wantbuy, int i) { //i는 무슨코인인지 
		holding[i]=(float)wantbuy/coinprice;
		setKRW(-wantbuy);
		
	}
	int holdcoin(int c,float i) { //코인있는지 
		if(i<=holding[c]) {
			return 1;
		}
		else {
			return 0;
		}
		
	}
	void sell(int c,float i,int m) {
		holding[c]-=i;
		setKRW(m*i);
	}
	void show() {
		for(int i=0;i<4;i++) {
			if(holding[i]==0) {
				if(i==3) 
					System.out.println("보유코인이없습니다 ");
				continue;
			}
			else{
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
