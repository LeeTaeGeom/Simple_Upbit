
public class Kbank {
	
	private int ck; // 가능여부확인 
	
	void usertoupbit(int mon, User me,Upbit account) { //업비트에 돈넣는
		
		ck=me.compare(mon);
		if(ck==1) {
			me.setmoney(-mon);
			account.setKRW(mon);
		}
		else {
			System.out.println("업비트에 원하시는 돈을 넣기에 보유잔고가 부족합니다");
		}
	}
	
	void upbittouser(int mon, Upbit account, User me) { //업비트에서 돈빼는거 
		ck = account.compare(mon);
		if(ck==1) {
			account.setKRW(-mon);
			me.setmoney(mon);
		}
		else {
			System.out.println("업비트에 원하시는 돈을 빼기엔 보유잔고가 부족합니다");
		}
	}

}
