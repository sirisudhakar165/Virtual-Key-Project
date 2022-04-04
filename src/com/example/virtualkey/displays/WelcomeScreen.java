package com.example.virtualkey.displays;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.example.virtualkey.services.DirectoryService;
import com.example.virtualkey.services.DisplayService;

public class WelcomeScreen implements Displays {
	
	private String welcomeText="Welcome To Virtual Key Appication";
	private String developerDetails ="Developer Sudhakar";
	
	private ArrayList<String> options=new ArrayList<>();
	
	public  WelcomeScreen() {
		options.add("1. Show Files");
		options.add("2. Show Files Menu");
		options.add("3. Quit");
//		 System.out.println(options);
		
	}

	public void intro() {
		System.out.println(welcomeText);
		System.out.println(developerDetails);
		System.out.println("\n");
		display();
	}
	
	public void getUserInput() {
		 int userInput=0;
		 
		 while((userInput = this.getInput())!= 3) {
			 this.navigate(userInput);
			 
			 
		 }
		
	}

	

	private int getInput() {
		int userInput=0;
		Scanner in=new Scanner(System.in);
		try {
			userInput=in.nextInt();
			
	      }
		catch (InputMismatchException e) {
			e.printStackTrace();
		}
	
		return userInput;
	}

	@Override
	public void display() {
		System.out.println("Main Menu");
	       for (String list : options) {
	    	   System.out.println(list);
			
		}
	}
  
  

	@Override
	public void navigate(int userInput) {
		switch(userInput) {
		case 1:
		this.displayFiles();
		this.display();
		
		break;
		case 2:
			DisplayService.setCurrentScreen(DisplayService.fileOption);
			DisplayService.getCurrentScreen().display();
			DisplayService.getCurrentScreen().getUserInput();
		
		
		break;
		
		default:
			System.out.println("Invalid input");
		
			
		}
		
		
	}

	private void displayFiles() {
		// TODO Auto-generated method stub
		System.out.println("List of files:");
		DirectoryService.printFiles();
		
		
	}
}
