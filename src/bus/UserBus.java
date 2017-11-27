package bus;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import dao.UserDao;
import model.User;
import util.Validate;

public class UserBus {
	static Scanner sc=new Scanner(System.in);
	public static boolean exists(User user) throws SQLException {
		ResultSet rs=new UserDao().findByAccount(user);
		if(rs.next()) {
			
			return true;
		}else {
			
			return false;
		}	
		
	}
	public void getAllUser()throws Exception {
		UserDao userDao=new UserDao();
		userDao.show();
		
	}
	public void input() throws SQLException {
		String account = null;
	    String firstname = null;
	    String lastname = null;
	    String email = null;
	    while(true) {
	    	 System.out.println("Input account");
	    	 account=sc.nextLine();
	    	 if(account.length()>1) {
	    		 break;
	    	 }
	    }
	    while(true) {
	    	 System.out.println("Input firstname");
	    	 firstname=sc.nextLine();
	    	 if(firstname.length()>1) {
	    		 break;
	    	 }
	    }
	    while(true) {
	    	 System.out.println("Input lastname");
	    	 lastname=sc.nextLine();
	    	 if(lastname.length()>1) {
	    		 break;
	    	 }
	    }
	    while(true) {
	    	 System.out.println("Input email");
	    	 email=sc.nextLine();
	    	 Validate validate=new Validate();
	    	 if(email.length()>1&&validate.validate(email)) {
	    		 break;
	    	 }
	    }
	    
	    while(true) {
	    	User user=new User(account, firstname, lastname, email);
	    	if(exists(user)) {
	    		new UserBus().Update(user);
	    		break;
	    	}else {
	    		new UserBus().Insert(user);
	    		break;
	    	}  		
	    }
	   
	}
	public void Delete() throws SQLException{
		System.out.println("Delete account");
		String dAccount=sc.nextLine();
		UserDao userDao=new UserDao();
		userDao.delete(dAccount);
	}
	private void Update(User user) throws SQLException {
		// TODO Auto-generated method stub
		UserDao userDao=new UserDao();
		userDao.update(user);
	}
	private void Insert(User user) throws SQLException {
		// TODO Auto-generated method stub
		UserDao userDao=new UserDao();
		userDao.insert(user);
	}
}
