package bankClasses;

public class user{
	private String userName;
	private String passWord;
	private int balance;
	//constructor
	public user(String name,long pass){
		userName = name;
		passWord = passWordEncrypt(pass);
		balance = 0;
	}
	public user(String name,long pass,int amount){
		userName = name;
		passWord = passWordEncrypt(pass);
		balance = amount;
	}
	//setters
	void setUserName(String name) {
		userName = name;
	}
	void setPassWord(long pass) {
		passWord = passWordEncrypt(pass);
	}
	void setBalance(int amount) {
		balance = amount;
	}
	//getters
	String getUserName() {
		return userName;
	}
	long getPassWord() {
		//decrypting
		long pass = 0;
		for(int i = 0; i < passWord.length(); i++) {
			pass = (pass*10)+(int)(passWord.charAt(i)-97);
		}
		return pass;
	}
	int getBalance() {
		return balance;
	}
	//encrypting
	String passWordEncrypt(long pass) {
		char k;
		String s = new String("");
		while(pass != 0) {
			k =(char)((pass%10)+97);
			pass = pass/10;
			s = k+s;
		}
		return s;
	}
}
