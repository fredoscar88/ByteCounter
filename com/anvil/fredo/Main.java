package com.anvil.fredo;

//Please work this time.
import java.io.File;
import java.util.Scanner;

public class Main {
	
	static long timeStart;// = System.currentTimeMillis();

	static boolean prntTree = false;
	static boolean useParent = false;
	
	//static File file;
	static File directoryFiles[];
	static File parentDir;
	static String dirName;
	
	static long lngTotalBytes = 0;
	
	static int indents = 0;	//but really, four spaces. well we'll see. if \t is for and not 8 spaces we'll roll.
	
	public static void main(String[] args) {
				
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Print tree y/n: ");
		if (sc.nextLine().equals("y")) {
			prntTree = true;
		}
		System.out.println("Use parent y/n: ");
		if (sc.nextLine().equals("y")) {
			useParent = true;
		}		
		
		
		if (useParent) {
			
			parentDir = new File(System.getProperty("user.dir"));
			
		} else {
			System.out.print("\nInput the directory name: ");
			
			dirName = sc.nextLine();
			parentDir = new File(dirName);
			
		}
		
		System.out.println(parentDir.getName() + ":");
		directoryFiles = parentDir.listFiles();
		
		timeStart = System.currentTimeMillis();
		countBytes(directoryFiles);
		
		System.out.println("TOTAL BYTES: " + lngTotalBytes
							+"\nKilobytes (KB): " + (lngTotalBytes / 1_024l)			//2^10 (1024^1)
							+"\nMegabytes (MB): " + (lngTotalBytes / 1_048_576l)		//2^20 (1024^2
							+"\nGigabytes (GB): " + (lngTotalBytes / 1_073_741_824l));	//2^30 (1024^3)
		
		sc.close();
		System.out.println("\nELAPSED TIME: " + (System.currentTimeMillis() - timeStart) / 1000 + " seconds");
		
	}
	
	static void countBytes(File directoryFiles[]) {
		
		indents++;
		
		for (File file : directoryFiles) {
			
			
			if (file.isFile()) {
				
				lngTotalBytes += file.length();
				if (prntTree) {
					printTabs(indents);
					System.out.println(file.getName() + " " + file.length());
				}
				//Would have this be a function and perform recursive calls on other directories inside the listed one
				
			} else if (file.isDirectory()) {
				
				if (prntTree) {
					printTabs(indents);
					System.out.println(file.getName() + ":");
				}
				countBytes(file.listFiles());
				
			}
		}
		
		indents--;
		
	}
	
	public static void printTabs(int amt) {
		
		for (int i = 0; i < amt; i++) {
			//System.out.print("\t");
			System.out.print("  ");
		}		
		
	}

}
