import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int BTC = 46000000;
		int ETH = 3180000;
		int XRP = 1165;
		int DOGE = 420;
		int i=1;
		int mymoney,tran,wb,ck,c;
		float ws;
		
		Scanner sc = new Scanner(System.in);
		User me = new User(0);
		Upbit account = new Upbit(0);
		
		
		System.out.print("통장잔고가 어떻게되나요? ");
		mymoney=sc.nextInt();
		me.setmoney(mymoney);
			
		System.out.println("[ menu ]");
		System.out.println("0 : exit");
		System.out.println("1 : transfer (현금->upbit)");
		System.out.println("2 : transfer (upbit->현금)");
		System.out.println("3 : price (코인가격)");
		System.out.println("4 : show  (보유 코인)");
		System.out.println("5 : show  (보유 잔고)");
		System.out.println("6 : show  (업비트 보유 잔고)");
		System.out.println("7 : buy  (매수)");
		System.out.println("8 : sell  (매도)");
		System.out.println("9 : menu");
		while(i!=0){
			
			
			System.out.print("> ");
			i = sc.nextInt();
			
			switch(i) {
				case 0:
					System.out.println("끝");
					break;
				case 1:
					System.out.print("보유현금중 얼마를 업비트에 넣을건가요? ");
					tran=sc.nextInt();
					account.usertoupbit(tran,me);
					break;
				case 2:
					System.out.print("업비트에 들어있는 금액중 얼마를 빼시겠습니까? ");
					tran=sc.nextInt();
					me.upbittouser(tran,account);
					break;
				case 3:
					System.out.println("BTC : "+BTC+"\nETH : "+ETH+"\nXRP : "+XRP+"\nDOGE : "+DOGE);
					break;
				case 4:
					account.show();
					break;
				case 5:
					me.show();
					break;
				case 6:
					account.upbitmoney();
					break;
				case 7:
					System.out.println("0:BTC, 1:ETH, 2:XRP, 3:DOGE");
					System.out.print("구매하려는 코인번호 : ");
					c=sc.nextInt();
					System.out.print("구매하려는 금액 : ");
					wb=sc.nextInt();
					
					if(c==0) {
						account.buy(BTC,wb,0);
					}
					else if(c==1) {
						account.buy(ETH,wb,1);
					}
					else if(c==2) {
						account.buy(XRP,wb,2);
					}
					else if(c==3) {
						account.buy(DOGE,wb,3);
					}
					else {
						System.out.println("그런 코인없습니다");
					}
					break;
				case 8:
					System.out.println("0:BTC, 1:ETH, 2:XRP, 3:DOGE");
					System.out.print("무슨코인 매도하시나요? ");
					c=sc.nextInt();
					
					System.out.print("매도하려는 양은 어떻게되나요? ");
					ws=sc.nextFloat();
					
					ck=account.holdcoin(c,ws);
					if(ck==1) {
						
						if(c==0) {
							account.sell(c,ws,BTC);
						}
						else if(c==1) {
							account.sell(c,ws,ETH);
						}
						else if(c==2) {
							account.sell(c,ws,XRP);
						}
						else if(c==3) {
							account.sell(c,ws,DOGE);
						}
						else {
							System.out.println("그런코인없습니다");
							break;
						}
					}
					else {
						System.out.println("코인이 그만큼 없습니다");
					}
						
					break;
				case 9:
					System.out.println("[ menu ]");
					System.out.println("0 : exit");
					System.out.println("1 : transfer (현금->upbit)");
					System.out.println("2 : transfer (upbit->현금)");
					System.out.println("3 : price (코인가격)");
					System.out.println("4 : show  (보유 코인)");
					System.out.println("5 : show  (보유 잔고)");
					System.out.println("6 : show  (업비트 보유 잔고)");
					System.out.println("7 : buy  (매수)");
					System.out.println("8 : sell  (매도)");
					System.out.println("9 : menu");
					break;
				default:
					System.out.println("잘못입력하셨습니다 ");
					break;
			}
			
		}
		sc.close();
	}

}
