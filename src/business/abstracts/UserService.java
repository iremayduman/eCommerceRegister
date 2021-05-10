package business.abstracts;

import entities.concretes.User;

public interface UserService {
	void userRegister(User user);
    void signIn(String email, String password);

}
