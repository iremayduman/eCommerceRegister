package business.concretes;

import business.abstracts.CheckService;
import business.abstracts.UserService;
import business.abstracts.UserValidityService;
import core.abstracts.OuterService;
import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class UserManager implements UserService{
	  CheckService checkService;
	    UserDao userDao;
	    OuterService outerService;

	    public UserManager(CheckService checkService, UserDao userDao, OuterService outerService) {
	        this.checkService = checkService;
	        this.userDao = userDao;
	        this.outerService = outerService;
	    }

	@Override
	public void userRegister(User user) {
		 UserValidityService validityService = new ValidityManager(userDao);
	        if (validityService.isUsed(user.getEmail())
	                && checkService.mailCheck(user.getEmail())
	                && checkService.firstNameCheck(user.getFirstName())
	                && checkService.lastNameCheck(user.getLastName())
	                && checkService.passwordCheck(user.getPassword()))
	        {
	            userDao.add(user);
	            outerService.registerOuter();
	            System.out.println(user.getEmail() + " adresine doðrulama mail'i gönderildi.: " + user.getEmail());
	            System.out.println(user.getFirstName() + " " + user.getLastName() + " üyeliðiniz baþarýyla gerçekleþtirilmiþtir.");
	        }
		
	}

	@Override
	public void signIn(String email, String password) {
		for (int i = 0; i < userDao.getAll().size(); i++) {
            if (userDao.getAll().get(i).getEmail().equals(email) &&
                    userDao.getAll().get(i).getPassword().equals(password)) {
                System.out.println("Giriþ Baþarýlý!");
                return;
            }
        }
        System.out.println("Mail veya parola hatalý!");
		
	}

}
