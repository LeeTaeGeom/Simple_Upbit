import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		int i=1;
		int mymoney,tran,wb,ck,c;
		float ws;
		
		Scanner sc = new Scanner(System.in);
		User me = new User(0);
		Upbit account = new Upbit(0);
		Kbank kbank = new Kbank();
		
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
					kbank.usertoupbit(tran,me,account);
					
					break;
				case 2:
					System.out.print("업비트에 들어있는 금액중 얼마를 빼시겠습니까? ");
					tran=sc.nextInt();
					kbank.upbittouser(tran,account,me);
					break;
				case 3:
					account.bitshow();
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
					
					account.buy(wb, c);
					break;
				case 8:
					System.out.println("0:BTC, 1:ETH, 2:XRP, 3:DOGE");
					System.out.print("무슨코인 매도하시나요? ");
					c=sc.nextInt();
					
					System.out.print("매도하려는 양은 어떻게되나요? ");
					ws=sc.nextFloat();
					
					ck=account.holdcoin(ws,c);
					if(ck==1) {
						account.sell(ws,c);
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
