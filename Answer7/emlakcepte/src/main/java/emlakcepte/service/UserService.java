package emlakcepte.service;

import java.util.List;

import emlakcepte.dao.UserDao;
import emlakcepte.model.User;

public class UserService { // Businness and Validation Operations
	UserDao userDao = new UserDao();
	
	public void createUser(User user) {
		//userDao = new UserDao(); tekrar tekrar oluşturmaya gerek yok 
		System.out.println("Ben bir userDao objesiyim " + userDao.toString());
		if (user.getPassword().length() < 8) {
			System.out.println("Şifre en az 8 karakterli olmalı!!");
		}
		
		if(user.getType().INDIVIDUAL.equals(user.getType())) {
		// bireysel hesap en fazla 5 ilan girebilir
			
			
			
		}
		
		userDao.createUser(user);
	}
	
	public List<User> getAllUsers() {
		UserDao userDao = new UserDao();
		return userDao.findAllUsers();
	}
	
	public void printAllUsers() {
		getAllUsers().forEach(user->System.out.println(user.getName()));
		
	}
	
	public void updatePassword(User user, String newPassword) {
		// önce hangi user bul ve passwordu update et..
		//realtyService.printAll(realtyService.getAllByUserName(userBeyza))
	
		getAllUsers().stream()
		.filter(user -> user.getPassword()).equals(newPassword);
	}

}








