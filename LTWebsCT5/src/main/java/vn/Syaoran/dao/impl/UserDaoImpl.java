package vn.Syaoran.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vn.Syaoran.configs.DBConnectMySQL;
import vn.Syaoran.dao.IUserDao;
import vn.Syaoran.models.UserModel;
import vn.Syaoran.services.IUserService;
import vn.Syaoran.services.impl.UserService;

public class UserDaoImpl extends DBConnectMySQL implements IUserDao {

	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;
	public PreparedStatement findMissingIdStmt = null;

	@Override
	public List<UserModel> findAll() {
		String sql = "select* from users";
		List<UserModel> list = new ArrayList<>();
		try {
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new UserModel(rs.getInt("id"), rs.getString("fullname"), rs.getString("username"),
						rs.getString("email"), rs.getString("password"), rs.getString("image"), rs.getString("phone"),
						rs.getInt("roleid"), rs.getDate("createday")));
			}
			return list;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public UserModel findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(UserModel user) {

		String sql = "INSERT INTO users(id,fullname, username, email, password,  images, phone, roleid, createDate) VALUES (?,?,?,?,?,?,?,?,?)";

		try {
			conn = super.getDatabaseConnection();

			String findMissingIdSQL = "SELECT t1.id + 1 AS missing_id " + "FROM ( " + "    SELECT id FROM users "
					+ "    UNION ALL " + "    SELECT 0 AS id " + ") AS t1 " + "LEFT JOIN users t2 ON t1.id + 1 = t2.id "
					+ "WHERE t2.id IS NULL " + "ORDER BY missing_id " + "LIMIT 1;";

			findMissingIdStmt = conn.prepareStatement(findMissingIdSQL);

			ps = conn.prepareStatement(sql);
			rs = findMissingIdStmt.executeQuery();

			while (rs.next()) {
				int missingId = rs.getInt("missing_id");

				ps.setInt(1, missingId);
				ps.setString(2, user.getFullName());
				ps.setString(3, user.getUserName());
				ps.setString(4, user.getEmail());
				ps.setString(5, user.getPassword());
				ps.setString(6, user.getImages());
				ps.setString(7, user.getPhone());
				ps.setInt(8, user.getRoleid());
				ps.setDate(9, user.getCreatedDate());

				ps.executeUpdate();

			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	@Override
	public boolean CheckEmailExist(String Email) {
		boolean duplicate = false;
		String query = "select * from users WHERE email = ?";
		try {
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, Email);
			rs = ps.executeQuery();
			if (rs.next()) {
				duplicate = true;
			}
			ps.close();
			conn.close();
		} catch (Exception ex) {
		}
		return duplicate;
	}

	@Override
	public boolean CheckUserExist(String User) {
		boolean duplicate = false;
		String query = "select * from users WHERE username = ?";
		try {
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, User);
			rs = ps.executeQuery();
			if (rs.next()) {
				duplicate = true;
			}
			ps.close();
			conn.close();
		} catch (Exception ex) {
		}
		return duplicate;
	}

	@Override
	public UserModel findByUsername(String username) {
		String sql = "SELECT * FROM users WHERE username=?";

		try {
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			while (rs.next()) {
				UserModel user = new UserModel();
				user.setId(rs.getInt("id"));
				user.setUserName(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setFullName(rs.getString("fullname"));
				user.setImages(rs.getString("images"));
				user.setEmail(rs.getString("email"));
				user.setRoleid(rs.getInt("roleid"));
				return user;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public UserModel changepassword(String username, String newpassword) {
		String sql = "UPDATE users SET password = ? WHERE username = ?";

		// Giả sử bạn đã có một kết nối
		try {
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			// Thiết lập giá trị cho tham số trong câu SQL
			ps.setString(2, username);
			ps.setString(1, newpassword);

			// Thực hiện truy vấn và kiểm tra số hàng bị ảnh hưởng
			int rowsUpdated = ps.executeUpdate();

			if (rowsUpdated > 0) {
				// Nếu thành công, trả về đối tượng UserModel sau khi thay đổi mật khẩu
				UserModel user = new UserModel();
				user.setUserName(username);
				user.setPassword(newpassword); // Thông thường bạn sẽ không lưu mật khẩu này dưới dạng văn bản thuần!
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public UserModel updateprofile(String username, String fullname, String phone, String image) {
		String sql = "UPDATE users SET fullname = ?, phone = ?, images = ? WHERE username = ?";

		// Giả sử bạn đã có một kết nối
		try {
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			// Thiết lập giá trị cho tham số trong câu SQL
			ps.setString(1, fullname);
			ps.setString(2, phone);
			ps.setString(3, image);
			ps.setString(4, username);

			// Thực hiện truy vấn và kiểm tra số hàng bị ảnh hưởng
			int rowsUpdated = ps.executeUpdate();

			if (rowsUpdated > 0) {
				// Nếu thành công, trả về đối tượng UserModel sau khi thay đổi mật khẩu
				UserModel user = new UserModel();
				user.setFullName(fullname);
				user.setPhone(phone);
				user.setImages(image);
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {

		UserDaoImpl userDao = new UserDaoImpl();
		IUserService userService =new UserService();
//		System.out.println()
		
		
		userDao.updateprofile("huy","XuanHuy","012345","asd");
		UserModel user=userDao.findByUsername("huy");
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
