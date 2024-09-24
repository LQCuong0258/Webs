package vn.Syaoran.services.impl;

import vn.Syaoran.models.UserModel;
import vn.Syaoran.dao.IUserDao;
import vn.Syaoran.dao.impl.UserDaoImpl;
import vn.Syaoran.services.IUserService;

public class UserService implements IUserService {
	
	IUserDao userDao = new UserDaoImpl();

	@Override
	public UserModel login(String username, String password) {
		UserModel user = this.findByUsername(username);
		 
		if (user != null && password.equals(user.getPassword())) {
			 return user;
		 }
		return null;
	}

	@Override
	public UserModel findByUsername(String username) {
		// TODO Auto-generated method stub
		return userDao.findByUsername(username);
	}
	
	public static void main(String[] args) {

		UserDaoImpl userDao = new UserDaoImpl();
		IUserService userService =new UserService();
//		System.out.println()
		
		
		
		UserModel user=userService.findByUsername("Syaoran");
		System.out.println(user);

//		userDao.insert(new UserModel("XHuy", "huy@gmail.com", "1234", "Duy Khai", "null"));
//
//		List<UserModel> list = userDao.findAll();
//
//		for (UserModel user : list) {
//			System.out.println(user);
//		}

//		UserModel user1 = userDao.findById(1);
//	    if (user1 != null) {
//	        System.out.println(user1);
//	    } else {
//	        System.out.println("User not found!");
//	    }
	}
	
}
