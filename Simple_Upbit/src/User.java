
class User {

	private float money; //통장잔고 
	private int ck; // 가능여부확인
	
	User(float i){
		money=i;
	}
	void setmoney(int i) {
		money+=i;
	}
	
	int compare(int i) { //업비트 돈넣을때 넣고싶은돈이 가진돈보다 많은지 적은지 확인 
		if(money>=i) {
			return 1;
		}
		else {
			return 0;
		}
	}
	
	void upbittouser(int mon, Upbit account) { //업비트에서 돈빼는거 
		ck = account.compare(mon);
		if(ck==1) {
			account.setKRW(-mon);
			money+=mon;
		}
		else {
			System.out.println("업비트에 원하시는 돈을 빼기엔 보유잔고가 부족합니다");
		}
	}
	
	void show(){ //보유잔고 
		System.out.println("보유 잔고 : "+money);
	}
}
