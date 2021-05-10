import business.concretes.CheckManager;
import business.concretes.UserManager;
import core.concretes.GoogleAdapterManager;
import core.concretes.NoAdapter;
import dataAccess.concretes.HibernateUserDao;
import entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		User user1 = new User(1, "Ýrem", "Ayduman","irem03052@gmail.com","123456");

        UserManager userManager = new UserManager(new CheckManager(), new HibernateUserDao(), new NoAdapter());

        userManager.userRegister(user1);
        

        UserManager userManager1 = new UserManager(new CheckManager(), new HibernateUserDao(), new GoogleAdapterManager());
        User user2 = new User(2, "Azra", "Ayduman","irem03052@gmail.com","123456");//Bu mail adresi kullanýldýðý için
        User user3 = new User(3, "Azra", "Ayduman","ayduman@gmail.com","123456");
        userManager.userRegister(user2);
        userManager.userRegister(user3);
        userManager.signIn("irem03052@gmail.com", "123456");


	}

}
