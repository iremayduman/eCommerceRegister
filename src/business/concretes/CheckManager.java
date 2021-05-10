package business.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import business.abstracts.CheckService;

public class CheckManager implements CheckService{
	public CheckManager() {
		
	}

	@Override
	public boolean passwordCheck(String password) {
		if (password.length() < 6) {
            System.out.println("�ifreniz 6 karakterden k�sa olamaz!");
            return false;
        } else {
            return true;
        }
	}

	@Override
	public boolean mailCheck(String mail) {
		  String regex = "^(.+)@(.+)$";
	        Pattern pattern = Pattern.compile(regex);
	        Matcher matcher = pattern.matcher(mail);
	        if (matcher.matches()) {
	            return true;
	        } else {
	            System.out.println("Mailiniz ge�ersiz! L�tfen ge�erli bir mail giriniz. Mail:" + mail);
	            return false;
	            }
	}

	@Override
	public boolean firstNameCheck(String firstName) {
		  if (firstName.length()>2) {
	            return true;
	        } else {
	            System.out.println("�sminiz 2 karakterden k�sa olamaz!");
	            return false;
	        }
	}

	@Override
	public boolean lastNameCheck(String lastName) {
		if (lastName.length()>2) {
            return true;
        } else {
            System.out.println("Soyad�n�z 2 karakterden k�sa olamaz!");
            return false;
        }
	}

}
