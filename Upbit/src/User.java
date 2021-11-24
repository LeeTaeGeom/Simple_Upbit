
public class User {

	private float money; //통장잔고 
	
	
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
	
	
	void show(){ //보유잔고 
		System.out.println("보유 잔고 "+money+"원 입니다");
	}
}
