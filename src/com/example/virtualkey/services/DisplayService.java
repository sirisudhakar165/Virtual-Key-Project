package com.example.virtualkey.services;

import com.example.virtualkey.displays.Displays;
import com.example.virtualkey.displays.FileOptions;
import com.example.virtualkey.displays.WelcomeScreen;

public class DisplayService {

	public static FileOptions fileOption=new FileOptions();
	public static WelcomeScreen welcomeScreen=new WelcomeScreen();
	
	public static Displays currentScreen=welcomeScreen;

	public static Displays getCurrentScreen() {
		return currentScreen;
	}

	public static void setCurrentScreen(Displays currentScreen) {
		DisplayService.currentScreen = currentScreen;
	}
	
	
}
