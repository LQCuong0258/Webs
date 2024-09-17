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
		
		return userDao.findByUsername(username);
	}
	public static void main(String[] args) {
	 	
        IUserService userDao = new UserServiceImpl();
        System.out.println(userDao.findByUsername("Syaoran"));
    }
}
