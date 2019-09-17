//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:            Battleship
// Files:            Battleship.java
// Semester:         Summer 2018
//
// Author:           Archana Dhyani
// Email:            adhyani@cs.wisc.edu
// CS Login:         arch
// Lecturer's Name:  Jeff Burge
// Lab Section:      Lec 001
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// No help received from any person or other source.
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
/**
 * This file contains testing methods for the Battleship project. These methods are intended to
 * provide an example of a way to incrementally test your code, and to provide example method calls
 * for the Battleship methods
 *
 * Toward these objectives, the expectation is that part of the grade for the Battleship project is
 * to write some tests and write header comments summarizing the tests that have been written.
 * Specific places are noted with FIXME but add any other comments you feel would be useful.
 */

import java.util.Random;
import java.util.Scanner;

/**
 * This class contains a few methods for testing methods in the Battleship
 * class as they are developed. These methods are all private as they are only
 * intended for use within this class.
 *
 * @author Marc Renault
 * @author FIXME add your name here when you add test
 *
 */
public class TestBattleship {

	/**
	 * This is the main method that runs the various tests. Uncomment the tests when
	 * you are ready for them to run.
	 *
	 * @param args (unused)
	 */
	public static void main(String[] args) {
		// Milestone 1
		testCoordAlphaToNum();
		testCoordNumToAlpha();
		// Milestone 2
		testCheckWater();
		testPlaceShip();
		testPlaceRandomShip();
		// Milestone 3
		testTakeShot();
		testCheckLost();
	}

	private static void testCoordAlphaToNum() {
		int numTests = 4;
		int passed = numTests;
		int res;
		if((res = Battleship.coordAlphaToNum("BAAA")) != 17576) {
			System.out.println("FAILED: Battleship.coordAlphaToNum(\"BAAA\") != 17576, but " + res);
			passed--;
		}
		if((res = Battleship.coordAlphaToNum("ZERTY")) != 11506714) {
			System.out.println("FAILED: Battleship.coordAlphaToNum(\"ZERTY\") != 11506714, but " + res);
			passed--;
		}
		if((res = Battleship.coordAlphaToNum("zerty")) != 11506714) {
			System.out.println("FAILED: Battleship.coordAlphaToNum(\"zerty\") != 11506714, but " + res);
			passed--;
		}
		if((res = Battleship.coordAlphaToNum("&é\"")) != -14747) {
			System.out.println("FAILED: Battleship.coordAlphaToNum(\"&é\\\"\") != -14747, but " + res);
			passed--;
		}
		System.out.println("testCoordAlphatoNum: Passed " + passed + " of " + numTests + " tests.");
	}

	private static void testCoordNumToAlpha() {
		int numTests = 2;
		int passed = numTests;
		String res;
		if(!(res = Battleship.coordNumToAlpha(11506714)).equals("ZERTY") ) {
			System.out.println("FAILED: Battleship.coordNumToAlpha(11506714) != \"ZERTY\", but " + res);
			passed--;
		}
		if(!(res = Battleship.coordNumToAlpha(17576)).equals("BAAA")) {
			System.out.println("FAILED: Battleship.coordNumToAlpha(17576) != \"BAAA\", but " + res);
			passed--;
		}
		System.out.println("testCoordNumToAlpha: Passed " + passed + " of " + numTests + " tests.");
	}

	private static void testCheckWater() {
		int numTests = 3;
		int passed = numTests;
		int res=0;
		char board [][]= new char[5][5];
		Battleship.initBoard(board);
		Battleship.placeShip(board, 0, 0, 1, true, 5);
		if((res = Battleship.checkWater(board, -1, -1, 15, false)) != -2 ) {
			System.out.println("FAILED: Battleship.checkWater(board, -1, -1, 15, false) != -2, but " + res);
			passed--;
		}
		if((res = Battleship.checkWater(board, 0, 0, 1, true)) != -1) {
			System.out.println("FAILED: Battleship.checkWater(board, 0, 0, 1, true) != -1, but " + res);
			passed--;
		}

		if((res = Battleship.checkWater(board, 2, 4, 2, false)) != 1) {
			System.out.println("FAILED: Battleship.checkWater(board, "
					+ "+2, 4, 1, false) != 1, but " + res);
			passed--;
		}
		System.out.println("testCheckWater: Passed " + passed + " of " + numTests + " tests.");

	}

	private static void testPlaceShip() {
		int numTests = 3;
		int passed = numTests;
		boolean res=true;
		char board [][]= new char[3][3];
		Battleship.initBoard(board);
		if((res = Battleship.placeShip(board, 0, 0, 3, true, 1)) != true) {
			System.out.println("FAILED: Battleship.placeShip(board, 0, 0, 3, true, 4) != true, but " + res);
			passed--;
		}
		if((res = Battleship.placeShip(board, 2, 2, 1, true, 2)) != true) {
			System.out.println("FAILED: Battleship.placeShip(board, 2, 2, 1, true, 2) != true, but " + res);
			passed--;
		}
		if((res = Battleship.placeShip(board, 0, 99, 4, true, 3)) != false) {
			System.out.println("FAILED: Battleship.placeShip(board, 1, 2, 4, false, 3) != false, but " + res);
			passed--;
		}
		System.out.println("testPlaceShip: Passed " + passed + " of " + numTests + " tests.");
	}
	private static void testPlaceRandomShip() {
		int numTests = 3;
		int passed = numTests;
		char board [][]= new char[6][6];
		Battleship.initBoard(board);
		Random rand = new Random();
		boolean res= Battleship.placeRandomShip(board, 1, 1, rand);
		res = Battleship.placeRandomShip(board, 2, 2, rand);
		res = Battleship.placeRandomShip(board, 2, 3, rand);



	}

	private static void testTakeShot() {
		int numTests = 3;
		int passed = numTests;
		int res;
		char board [][]= new char[4][4];
		Battleship.initBoard(board);
		Battleship.placeShip(board, 2, 2, 1, true, 2);
		if((res = Battleship.takeShot(board, 1,0)) != 2) {
			System.out.println("FAILED: Battleship.takeShot(board, 1,0) != 2, but " + res);
			passed--;
		}
		if((res = Battleship.takeShot(board, 6,2)) != -1) {
			System.out.println("FAILED: Battleship.takeShot(board, 5,5) != -1, but " + res);
			passed--;
		}
		if((res = Battleship.takeShot(board,2,2)) != 1) {
			System.out.println("FAILED: Battleship.takeShot(board, 2,2) != 1, but " + res);
			passed--;
		}
		System.out.println("testTakeShot: Passed " + passed + " of " + numTests + " tests.");
	}

	private static void testCheckLost() {
		int numTests = 2;
		int passed = numTests;
		boolean res=true;
		Scanner sc = new Scanner(System.in);
		char board [][]= new char[4][4];
		Battleship.initBoard(board);
		Battleship.placeShip(board, 2, 2, 1, true, 2);
		Battleship.takeShot(board, 2, 2);
		Battleship.shootPlayer(sc,board,board);
		Battleship.printBoard(board, "");
		if((res = Battleship.checkLost(board)) != true) {
			System.out.println("FAILED: Battleship.checkLost(board) != true, but " + res);
			passed--;
		}
		Battleship.initBoard(board);
		Battleship.placeShip(board, 2, 2, 1, true, 2);
		if((res = Battleship.checkLost(board)) != false) {
			System.out.println("FAILED: Battleship.checkLost(board) != false, but " + res);
			passed--;
		}
		System.out.println("testTakeShot: Passed " + passed + " of " + numTests + " tests.");



	}



}
