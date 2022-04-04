package com.example.virtualkey.services;

import java.io.File;

import com.example.virtualkey.entity.Directory;

public class DirectoryService {

	public static Directory fileDirectory=new Directory();
	
	
	public static void printFiles() {
		fileDirectory.fillFiles();
//		fileDirectory.print();
//		System.out.println(" :print Files");
		for (File file : DirectoryService.getFileDirectory().getFiles()) {
			
			System.out.println(file.getName());
		}
		 
		
	}
	public static Directory getFileDirectory() {
		return fileDirectory;
	}
	public static void setFileDirectory(Directory fileDirectory) {
		DirectoryService.fileDirectory = fileDirectory;
	}
}
