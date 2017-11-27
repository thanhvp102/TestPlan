package view;

import bus.UserBus;

public class Main {
	public static void main(String[] args) throws Exception {
		UserBus userBus=new UserBus();
		userBus.getAllUser();
		userBus.input();
		userBus.getAllUser();
		userBus.Delete();
		userBus.getAllUser();
	}
}
