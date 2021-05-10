package core.concretes;

import GoogleUser.GoogleUserManager;
import core.abstracts.OuterService;

public class GoogleAdapterManager implements OuterService{

	@Override
	public void registerOuter() {
		 GoogleUserManager manager = new GoogleUserManager();
	        manager.register();
		
	}

}
