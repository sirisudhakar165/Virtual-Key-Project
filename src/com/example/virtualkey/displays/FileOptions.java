package com.example.virtualkey.displays;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.example.virtualkey.entity.Directory;

public class FileOptions implements Displays {
	
	WelcomeScreen wl=new WelcomeScreen();

	private Directory dr=new Directory();
	private ArrayList<String> list=new ArrayList<>();
	
	
	public FileOptions() {
		super();
		list.add("1. ADD File");
		list.add("2.Delete File");
		list.add("3.Search File");
		list.add("4. Return to Menu");
	}

	@Override
	public void display() {
		System.out.println("File Option Main Menu");
		
		list.forEach(l->System.out.println(l));
		
	}
	
	public  void getUserInput() {
		int selectedOption;
		while((selectedOption=this.getInput())!=5) {
			this.navigate(selectedOption);
		}
	}

	private int getInput() {
		
		Scanner in=new Scanner(System.in);
		int userInput=0;
		try {
			userInput=in.nextInt();
		}
		catch(InputMismatchException e) {
			e.printStackTrace();
		}
		return userInput;
	}

	@Override
	public void navigate(int userInput) {
		// TODO Auto-generated method stub
		switch(userInput) {
		case 1: // ADD a File
			this.addFile();
			this.display();
			break;
			
		case 2: //DELETE File
			this.deleteFile();
			this.display();
			break;
			
		case 3: //Search a File
			this.searchFile();
			this.display();
			break;
		case 4:
		   wl.display();
		   break;
			
		default :
			System.out.println("Invalid Input");
			break;
				
		}
		
	}

	private void searchFile() {
		Boolean found=false;
		System.out.println("Please Enter the File to be searched");
		
		String fileName=this.getInputString();
		System.out.println("you are searching for a file :"+fileName);
		
		ArrayList<File> file=dr.getFiles();
		
		for(int i=0;i<file.size();i++) {
			if(file.get(i).getName().equals(fileName)) {
				System.out.println("file Found:"+fileName);
				found =true;
			}
			
				
			
		}
		if(found == false) {
			System.out.println("File Not Found");
		} 
	}

	private void deleteFile() {
		// TODO Auto-generated method stub
		System.out.println("Enter The File Name to Delete");
		
		String fileName=this.getInputString();
		System.out.println("yor are deleting the file :" +fileName);
		
			Path path=FileSystems.getDefault().getPath(Directory.name +fileName).toAbsolutePath();
			File file=path.toFile();
			if(file.delete()) {
				System.out.println("File Deleted:"+file.getName());
				dr.getFiles().remove(file);
			}
			else {
				System.out.println("Failed to delete the " +fileName+ "file was not found");
			}
	}

	private void addFile() {
		// TODO Auto-generated method stub
		
		System.out.println("Please enter the file Name");
		
		String fileName=this.getInputString();
		System.out.println("you are adding a file: "+ fileName);
		try {
		Path path=FileSystems.getDefault().getPath(Directory.name + fileName).toAbsolutePath();
		File file=new File(dr.getName()+fileName);
		
			if(file.createNewFile()) {
				System.out.println("File created :"+file.getName());
				dr.getFiles().add(file);
			}
			else {
				System.out.println("FIle already Exit , no Need to add another");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private String getInputString() {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		return (in.nextLine());
	}

	

}
