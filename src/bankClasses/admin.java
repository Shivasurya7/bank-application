package bankClasses;

import java.util.ArrayList;

public class admin {
	private String adminUserName = "system";
	private long passWord = 12345678;
	private static ArrayList <user> data = new ArrayList<user>();
	public void addUser(user d) {
		data.add(d);
	}
	public boolean adminLogin(String userName,long pin) {
		if(passWord == pin && userName.contentEquals(adminUserName)) {
			return true;
		}
		return false;
	}
	public int getUserIndex(String name,long pin) {
		for(int i = 0; i < data.size(); i++) {
			if(data.get(i).getPassWord() == pin && name.contentEquals(data.get(i).getUserName())) {
				return i;
			}
		}
		return -1;
	}
	public int getUserIndex(String name) {
		for(int i = 0; i < data.size(); i++) {
			if(name.contentEquals(data.get(i).getUserName())) {
				return i;
			}
		}
		return -1;
	}
	public void removeUser(String userName) {
		int u = getUserIndex(userName);
		if( u == -1) {
			System.out.println("User Does Not Exist");
		}
		else {
			data.remove(u);
		}
	}
	public void changeUserName(int i,String userName) {
		data.get(i).setUserName(userName);
	}
	public void changeUserPassWord(int i,long pin) {
		data.get(i).setPassWord(pin);
	}
	public void changeUserBalance(int i,int amount) {
		data.get(i).setBalance(amount);
	}
	public void displayUsers() {
		System.out.printf("-------------------------------------------------------%n");
		System.out.printf("| %-20s | %-15s | %-10s |%n", "USERNAME", "PASSWORD", "BALANCE");
		System.out.printf("-------------------------------------------------------%n");
		for(int i = 0; i < data.size(); i++) {
			System.out.printf("| %-20s | %-15d | %-10d |%n",data.get(i).getUserName(),data.get(i).getPassWord(),data.get(i).getBalance());
		}
		System.out.printf("-------------------------------------------------------%n");
	}
	public int getBalance(int i) {
		return data.get(i).getBalance();
	}
	public void cashWithdraw(int i,int amount) {
		if(data.get(i).getBalance()>amount) {
			data.get(i).setBalance(data.get(i).getBalance()-amount);
			System.out.println("your current balance after withdraw : "+data.get(i).getBalance());
		}
		else {
			System.out.println("insufficient balance..!!!!!");
		}
	}
	public void cashDeposit(int i,int amount) {
		data.get(i).setBalance(data.get(i).getBalance()+amount);
		System.out.println("your current balance after deposit: "+data.get(i).getBalance());
	}
	
}
