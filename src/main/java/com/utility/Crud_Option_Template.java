package com.utility;

import java.util.Scanner;

public class Crud_Option_Template {
 public static int crud_option_template(Scanner sc) {
	 System.out.println("Insert Data Enter-1\n"
 			+ "Show Data Enter-2\n"
 			+ "Update Data Enter-3\n"
 			+ "Delete Data Enter-4\n"
 			+ "Show All Data Enter-5\n "
 			+ "Exit Enter-6");
 	int no=sc.nextInt();
 	return no;
 }
 
}
