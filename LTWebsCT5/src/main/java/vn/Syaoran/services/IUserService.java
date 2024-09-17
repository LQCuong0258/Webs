package vn.Syaoran.services;

import vn.Syaoran.models.UserModel;

public interface IUserService {
	UserModel login(String username, String password);
	UserModel findByUsername(String username);
}
