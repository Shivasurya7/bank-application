import java.util.Scanner;

import bankClasses.admin;
import bankClasses.user;

public class menu {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		admin a1 = new admin();
		a1.addUser(new user("shiva",21052001,20000));
		a1.addUser(new user("surya",86374600,50000));
		a1.addUser(new user("mugilan",21052001,40000));
		a1.addUser(new user("karthik",21052001,30000));
		int choose,userIndex;
		long passWord;
		String userName;
		while(true) {
			
			System.out.println("LOGIN AS : \n1.ADMIN\n2.USER\n3.EXIT\nenter your choose : ");
			choose = cin.nextInt();
			if(choose == 1) {
				System.out.println("ENTER YOUR USERNAME :");
				userName = new String(cin.next());
				System.out.println("ENTER THE PASSWORD : ");
				passWord = cin.nextLong();
				if(a1.adminLogin(userName,passWord)) {
					while(true) {
						System.out.println("1.ADD USER\n2.REMOVE USER\n3.CHANGE USER DETAILS\n4.DISPLAY USER DETAILS\n5.LOGOUT\nenter your choose : ");
						choose = cin.nextInt();
						if(choose == 1) {
							System.out.println("ENTER USERNAME :");
							userName = new String(cin.next());
							System.out.println("ENTER PASSWORD : ");
							passWord = cin.nextLong();
							a1.addUser(new user(userName,passWord));
							System.out.println("ACCOUNT CREATED sucessfully");
						}
						else if(choose == 2) {
							System.out.println("ENTER YOUR USERNAME :");
							userName = new String(cin.next());
							a1.removeUser(userName);
						}
						else if(choose == 3) {
							System.out.println("ENTER YOUR USERNAME :");
							userName = new String(cin.next());
							userIndex = a1.getUserIndex(userName);
							if(userIndex >= 0) {
								while(true) {
									System.out.println("1.Change username\n2.change password\n3.change balance\n4.back");
									choose = cin.nextInt();
									if(choose == 1) {
										System.out.println("ENTER YOUR NEW USERNAME :");
										userName = new String(cin.next());
										a1.changeUserName(userIndex,userName);
									}
									else if(choose == 2) {
										System.out.println("ENTER THE NEW PASSWORD : ");
										passWord = cin.nextLong();
										a1.changeUserPassWord(userIndex,passWord);
									}
									else if(choose == 3) {
										System.out.println("ENTER THE NEW BALANCE : ");
										a1.changeUserBalance(userIndex,cin.nextInt());
									}
									else if(choose == 4) {
										break;
									}
									else {
										System.out.println("INVALID CHOOSE");
									}
								}
							}
							else {
								System.out.println("user does not exist");
							}
						}
						else if(choose == 4) {
							a1.displayUsers();
						}
						else if(choose == 5) {
							break;
						}
						else {
							System.out.println("INVALID CHOOSE");
						}
					}
				}
				else {
					System.out.println("USERNAME or PASSWORD is incorrect");
				}
			}
			else if(choose == 2) {
				while(true) {
					System.out.println("1.CREATE ACCOUNT\n2.LOGIN\n3.BACK\nenter your choose");
					choose = cin.nextInt();
					if(choose == 1) {
						System.out.println("ENTER YOUR USERNAME :");
						userName = new String(cin.next());
						System.out.println("ENTER THE PASSWORD : ");
						passWord = cin.nextLong();
						a1.addUser(new user(userName,passWord));
						System.out.println("ACCOUNT CREATED SUCESSFULLY");
					}
					else if(choose == 2) {
						System.out.println("ENTER YOUR USERNAME :");
						userName = new String(cin.next());
						System.out.println("ENTER THE PASSWORD : ");
						passWord = cin.nextLong();
						userIndex = a1.getUserIndex(userName,passWord);
						if(userIndex >= 0) {
							System.out.println("Login sucessfull....");
							while(true) {
								System.out.println("1.cash withdraw\n2.cash deosit\n3.check balance\n4.change username\n5.change password\n6.back\nenter your choose");
								choose = cin.nextInt();
								if(choose == 1) {
									System.out.println("enter the amount : ");
									a1.cashWithdraw(userIndex,cin.nextInt());
								}
								else if(choose == 2) {
									System.out.println("enter the amount : ");
									a1.cashDeposit(userIndex,cin.nextInt());
								}
								else if(choose == 3) {
									System.out.println("your current balance is "+a1.getBalance(userIndex));
								}
								else if(choose == 4) {
									System.out.println("ENTER YOUR NEW USERNAME :");
									userName = new String(cin.next());
									a1.changeUserName(userIndex,userName);
								}
								else if(choose == 5) {
									System.out.println("ENTER THE NEW PASSWORD : ");
									passWord = cin.nextLong();
									a1.changeUserPassWord(userIndex,passWord);
								}
								else if(choose == 6) {
									break;
								}
								
							}
						}
						else {
							System.out.println("USERNAME or PASSWORD is incorrect");
						}
					}
					else if(choose == 3) {
						break;
					}
					else {
						System.out.println("INVALID CHOOSE");
					}
				}
			}
			else if(choose == 3) {
				System.exit(0);
			}
			else {
				System.out.println("INVALID CHOOSE");
			}
		}		
	}
}
