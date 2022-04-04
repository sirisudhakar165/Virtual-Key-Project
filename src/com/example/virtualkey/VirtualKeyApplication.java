package com.example.virtualkey;

import com.example.virtualkey.displays.FileOptions;
import com.example.virtualkey.displays.WelcomeScreen;

public class VirtualKeyApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		FileOptions fileOp=new FileOptions();
//		fileOp.display();
//		fileOp.getUserInput();
		WelcomeScreen welcomeScreen=new WelcomeScreen();
		welcomeScreen.intro();
		welcomeScreen.getUserInput();
		
		}

}
