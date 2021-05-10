package business.concretes;

import business.abstracts.UserValidityService;
import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class ValidityManager implements UserValidityService{
	private UserDao userDao;

    public ValidityManager(UserDao userDao) {
        this.userDao = userDao;
    }

	@Override
	public boolean isUsed(String mail) {
		for (User user: userDao.getAll()) {
            if(mail.equals(user.getEmail())) {
                System.out.println("Bu mail kullanýlmýþtýr!: " + mail);
                return false;
            }
        }
        return true;
	}

}
