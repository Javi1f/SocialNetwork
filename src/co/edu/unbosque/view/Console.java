package co.edu.unbosque.view;

import java.util.Scanner;

public class Console {

	private static Scanner sc = new Scanner(System.in);
	
	public static void printLine(String txt) {
		System.out.println(txt);
	}
	
	public static void print(String txt) {
		System.out.print(txt);
	}
	
	public static void printSuccessLine(String txt) {
		System.out.println("\u001B[32m" + txt + "\u001B[0m");
	}
	
	public static void printSuccess(String txt) {
		System.out.print("\u001B[32m" + txt + "\u001B[0m");
	}
	
	public static void printErrLine(String txt) {
		System.err.println(txt);
	}
	
	public static void printErr(String txt) {
		System.err.print(txt);
	}
	
	public static int readInt() {
		return sc.nextInt();
	}
	
	public static long readLong() {
		return sc.nextLong();
	}
	
	public static String readLine() {
		return sc.nextLine();
	}
	
	public static String read() {
		return sc.next();
	}
	
	public static float readFloat() {
		return sc.nextFloat();
	}
	
	public static double readDouble() {
		return sc.nextDouble();
	}
	
	public static char readChar() {
		return sc.next().charAt(0);
	}
	
	public static boolean readBoolean() {
		return sc.nextBoolean();
	}
	
	public static void burnLine() {
		sc.nextLine();
	}
	
	
}