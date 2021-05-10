package business.abstracts;

public interface CheckService {
	boolean passwordCheck(String password);
    boolean mailCheck(String mail);
    boolean firstNameCheck(String firstName);
    boolean lastNameCheck(String lastName);
}
