package emailapp;

import java.util.Scanner;

public class Email {
   private String firstname;
   private String lastname;
   private String password;
   private String department;
   private String email;
   private int mailboxcapacity=500;
   private int defaultpasswordlength=10;
   private String alternateemail;
   private String companySuffix="ms.com";
	
	//constructor to receive the first and last name
   public Email () {
	   //this.firstname=firstname;
	   //this.lastname=lastName;
	   Scanner sc=new Scanner(System.in);
	   System.out.println("enter your first name");
	    this.firstname=sc.nextLine();
	    System.out.println("enter your last name");
	   this.lastname=sc.nextLine();
	   
	   //call the method asking for department -return the department
	   this.department=setDepartment();
	   
	   //callthe method that return the random passwords
	   this.password=randomPassword(defaultpasswordlength);
	   System.out.println("your password is:"+this.password);
	   //combine the elements to generate email
	   email=firstname.toLowerCase()+'.'+lastname.toLowerCase()+'@'+department+ '.'+companySuffix;
	   
   }
   
   //ask for the department
   private String setDepartment() {
	   System.out.println("New employee: "+firstname+ ". Department codes\n1 for Sales\n2 for development \n3 for Accounting\n4 for HR\n0 for none \nEnter department code: ");
	   Scanner sc=new Scanner(System.in);
	   int depchoice=sc.nextInt();
	   if(depchoice==1) {return "sales";}
	   else if(depchoice==2) {return "Developer";}
	   else if(depchoice==3) {return "Accounting";}
	   else if(depchoice==4) {return "hr";}
	   else {return "" ;}
	   
	   
   }
   
   //generate a random password
   private String randomPassword(int length) {
	   String passwordset="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
	   char []password=new char[length];
	   for(int i=0;i<length;i++) {
		  int rand= (int)(Math.random()* passwordset.length());
		  password[i]=passwordset.charAt(rand);
	   }
	   return new String (password);
   }
   
   //set the mailbox capacity
   //we have not put it insidew the construtor bcz we have already defined them so no need
   public void setMailboxcapacity(int capacity) {
	   this.mailboxcapacity=capacity;
   }
   //set the alternate email
   public void setAlternateEmail(String altemail) {
	   this.alternateemail=altemail;
   }
   //change the password
   public void changePassword(String password) {
	   this.password=password;
   }
   
    public int getmailboxcapacity() {return mailboxcapacity;}
    public String getalternateemail() {return alternateemail;}
    public String getpassword() {return password;}
   
    public String showInfo() {
    	return "Display name: "+ firstname+" "+ lastname +
    			"\nCompany Email: "+email +
    			"\nMailBox capacity:"+ mailboxcapacity + "mb";
    }
}
