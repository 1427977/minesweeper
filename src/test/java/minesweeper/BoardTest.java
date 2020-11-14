package minesweeper;

import static org.junit.Assert.*;
import java.util.Arrays;


import org.junit.Test;

public class BoardTest {

	@Test
	public void testInitBoard() {//We should test the LVL value we give to the Board constructor
		Board testboard = new Board(); //8x8
		
		//----TDD TESTS
		int[][] b = new int[8][8];
		int[][] c = new int[8][8];
		b[0][0] = testboard.Mine_value;
		b[1][1] = testboard.Mine_value;
		
		testboard.setBoard(b);
		testboard.initBoard();
		c = testboard.getBoard();
		
		assertEquals(c[0][1], 2);
		assertEquals(c[2][2], 1);
		assertEquals(c[5][5], 0);
		//TDD TESTS----
		
		
		//----Equivalence partitioning
		int lvl1_valid_dim = 8;
		Board testboardlvl1 = new Board();
		int[][] testdimlvl1 = new int[8][8];
		//Do a getSize for the board matrix then make an assert equals
		int lvl1_invalid_lower = 7;
		int lvl1_invalid_higher = 9;
		//assertTrue("Dimension for lvl1 matrix should be 8x8 instead of " + getSize, (getsize <= lvl1_invalid_lower) || ( getsize >= lvl1_invalid_higher));
	
		
		
		
		//Equivalence partitioning----
		
		
		//----Limit values
		
		
		
		//Limit values----
	}
	
	@Test
	public void testAdjacentMineChecks() {
		//testing checkRightMines, checkLeftMines, checkTopMines, checkBottomMines, checkTopRightMines, checkTopLeftMines, checkBottomRightMines, checkBottomLeftMines
		//this functions only will return a 1 if there is a mine on the position it's checking. for example, checkRight will return a 1 if there is a mine right to the cell or a 0 if not
				
		int [][] inputTest = new int[][] {{9, 9, 9, 0, 0, 0, 0, 0}, // we will use the position 1,1 to check when THERE IS a mine
										  {9, 0, 9, 0, 0, 0, 0, 0},
										  {9, 9, 9, 0, 0, 0, 0, 0},
										  {0, 0, 0, 0, 0, 0, 0, 0},
										  {0, 0, 0, 0, 0, 0, 0, 0},
										  {0, 0, 0, 0, 0, 0, 0, 0},
										  {0, 0, 0, 0, 0, 0, 0, 0}, // we will use the position 6,6 to check when THERE ISN'T a mine
										  {0, 0, 0, 0, 0, 0, 0, 0}};
										  
		Board testBoard = new Board();
		testBoard.setBoard(inputTest);
										  			
		//test if there is a bomb
		assertTrue("EP", testBoard.checkTopMines(1, 1) == 1);
		assertTrue("EP", testBoard.checkTopRightMines(1, 1) == 1);
		assertTrue("EP", testBoard.checkRightMines(1, 1) == 1);
		assertTrue("EP", testBoard.checkBottomRightMines(1, 1) == 1);
		assertTrue("EP", testBoard.checkBottomMines(1, 1) == 1);
		assertTrue("EP", testBoard.checkBottomLeftMines(1, 1) == 1);
		assertTrue("EP", testBoard.checkLeftMines(1, 1) == 1);
		assertTrue("EP", testBoard.checkTopLeftMines(1, 1) == 1);
	}
	
	@Test
	public void testInitBoard2() {
		Board testboard = new Board();
		MockBoard mockboard = new MockBoard(); //to simulate random board placement
		
		//Test1
		testboard.setBoard(mockboard.initMines(0));
		testboard.initBoard();
		int [][] expectedOut1 = new int[][] {{0, 0, 0, 0, 0, 0, 0, 0},
										     {0, 0, 0, 0, 0, 0, 0, 0},
										     {0, 0, 0, 0, 0, 0, 0, 0},
										     {0, 0, 0, 0, 0, 0, 0, 0},
										     {0, 0, 0, 0, 0, 0, 0, 0},
										     {0, 0, 0, 0, 0, 0, 0, 0},
										     {0, 0, 0, 0, 0, 0, 0, 0},
										     {0, 0, 0, 0, 0, 0, 0, 0}};
		assertArrayEquals(testboard.getBoard(), expectedOut1);
		
		//Test2
		testboard.setBoard(mockboard.initMines(1));
		testboard.initBoard();
		int [][] expectedOut2 = new int[][] {{9, 9, 9, 9, 9, 9, 9, 9},
      	  									 {9, 9, 9, 9, 9, 9, 9, 9},
      	  									 {9, 9, 9, 9, 9, 9, 9, 9},
      	  									 {9, 9, 9, 9, 9, 9, 9, 9},
      	  									 {9, 9, 9, 9, 9, 9, 9, 9},
      	  									 {9, 9, 9, 9, 9, 9, 9, 9},
      	  									 {9, 9, 9, 9, 9, 9, 9, 9},
      	  									 {9, 9, 9, 9, 9, 9, 9, 9}};
		assertArrayEquals(testboard.getBoard(), expectedOut2);  	
      	 
		//Test3
		testboard.setBoard(mockboard.initMines(2));
		testboard.initBoard();
		int [][] expectedOut3 = new int[][] {{9, 1, 0, 0, 0, 0, 1, 9},
											 {1, 1, 0, 0, 0, 0, 1, 1},
											 {0, 0, 0, 0, 0, 0, 0, 0},
											 {0, 0, 0, 0, 0, 0, 0, 0},
											 {0, 0, 0, 0, 0, 0, 0, 0},
											 {0, 0, 0, 0, 0, 0, 0, 0},
											 {1, 1, 0, 0, 0, 0, 1, 1},
											 {9, 1, 0, 0, 0, 0, 1, 9}};
		assertArrayEquals(testboard.getBoard(), expectedOut3);	
		
		//Test4
		testboard.setBoard(mockboard.initMines(3));
		testboard.initBoard();
		int [][] expectedOut4 = new int[][] {{3, 9, 2, 0, 0, 2, 9, 3},
			 								 {9, 9, 2, 0, 0, 2, 9, 9},
			 								 {2, 2, 1, 0, 0, 1, 2, 2},
			 								 {0, 0, 0, 0, 0, 0, 0, 0},
			 								 {0, 0, 0, 0, 0, 0, 0, 0},
			 								 {2, 2, 1, 0, 0, 1, 2, 2},
			 								 {9, 9, 2, 0, 0, 2, 9, 9},
			 								 {3, 9, 2, 0, 0, 2, 9, 3}};			 
		assertArrayEquals(testboard.getBoard(), expectedOut4);
		
		//Test5
		testboard.setBoard(mockboard.initMines(4));
		testboard.initBoard();
		int [][] expectedOut5 = new int[][] {{1, 2, 3, 3, 3, 3, 2, 1},
											 {2, 9, 9, 9, 9, 9, 9, 2},
											 {3, 9, 5, 3, 3, 5, 9, 3},
											 {3, 9, 3, 0, 0, 3, 9, 3},
											 {3, 9, 3, 0, 0, 3, 9, 3},
											 {3, 9, 5, 3, 3, 5, 9, 3},
											 {2, 9, 9, 9, 9, 9, 9, 2},
											 {1, 2, 3, 3, 3, 3, 2, 1}};
		assertArrayEquals(testboard.getBoard(), expectedOut5);
		
		//Test6
		testboard.setBoard(mockboard.initMines(5));
		testboard.initBoard();
		int [][] expectedOut6 = new int[][] {{1, 2, 3, 2, 1, 0, 0, 0},
											 {2, 9, 9, 9, 2, 0, 0, 0},
											 {3, 9, 8, 9, 3, 0, 0, 0},
											 {2, 9, 9, 9, 4, 3, 2, 1},
											 {1, 2, 3, 4, 9, 9, 9, 2},
											 {0, 0, 0, 3, 9, 8, 9, 3},
											 {0, 0, 0, 2, 9, 9, 9, 2},
											 {0, 0, 0, 1, 2, 3, 2, 1}};
		assertArrayEquals(testboard.getBoard(), expectedOut6);
	}
		 
	
	@Test
	public void testInitMines() {
		//----TDD TESTS
		Board testboard1 = new Board();
		int m1[][] = testboard1.getBoard();
		int mines1=0;
		
		//Search for 10 mines
		for(int i=0; i < 8; i++)//make a function???
		{
			for(int j=0; j < 8; j++) {
				if(m1[i][j]==9) {
					mines1 = mines1+1;
				}
			}
		}
		assertEquals(mines1,10);
		
		
		//TDD TESTS----
		
		//----Equivalence partitioning
		//Already tested for the valid values on TDD tested
		
		//SHOULD WE DO A NEW TEST EXECUTION??
		
		//Now we want to test the invalid values, THROW EXCEPTION???
		//Lvl1 has 10 bombs, we should test if we have more or less than 10 and show an error if we have a case
		int lvl1_invalid_lower = 9;
		int lvl1_invalid_higher = 11;
		assertTrue("Mines for lvl 1 should be 10 instead of " + mines1, (mines1 >= lvl1_invalid_lower) || (mines1 <= lvl1_invalid_higher));
		
		//Equivalence partitioning----
		
		//----Limit values
		//In this case we don't have a valid range, so we can only test individual numbers
		//Min 0, 9(invalid), 10(valid)
		
		assertTrue("Test not passed due to the mine value beeing lower than the limit value", mines1 >= lvl1_invalid_lower);
		
		
		//Limit values----
	}
	
	@Test
	public void testopenCell() {
		//TDD
		Board testboard10 = new Board();
		int [][] input = new int[][] {{3, 9, 2, 0, 0, 2, 9, 3},
									 {9, 9, 2, 0, 0, 2, 9, 9},
									 {2, 2, 1, 0, 0, 1, 2, 2},
									 {0, 0, 0, 0, 0, 0, 0, 0},
									 {0, 0, 0, 0, 0, 0, 0, 0},
									 {2, 2, 1, 0, 0, 1, 2, 2},
									 {9, 9, 2, 0, 0, 2, 9, 9},
									 {3, 9, 2, 0, 0, 2, 9, 3}};
			 
		 testboard10.setBoard(input);
		 //Selecting any middle cell with value 0 should output the following matrix
		 int [][] expectedOu = new int[][] {{-1, -1, 2, 0, 0, 2, -1, -1},
										   {-1, -1, 2, 0, 0, 2, -1, -1},
										   {2, 2, 1, 0, 0, 1, 2, 2},
										   {0, 0, 0, 0, 0, 0, 0, 0},
										   {0, 0, 0, 0, 0, 0, 0, 0},
										   {2, 2, 1, 0, 0, 1, 2, 2},
										   {-1, -1, 2, 0, 0, 2, -1, -1},
										   {-1, -1, 2, 0, 0, 2, -1, -1}};
										   
		int [][] expectedOu1 = new int[][] {{3, -1, -1, -1, -1, -1, -1, -1},
										   {-1, -1, -1, -1, -1, -1, -1, -1},
										   {-1, -1, -1, -1, -1, -1, -1, -1},
										   {-1, -1, -1, -1, -1, -1, -1, -1},
										   {-1, -1, -1, -1, -1, -1, -1, -1},
										   {-1, -1, -1, -1, -1, -1, -1, -1},
										   {-1, -1, -1, -1, -1, -1, -1, -1},
										   {-1, -1, -1, -1, -1, -1, -1, -1}};
										   
	   int [][] expectedOu2  = new int[][] {{3, 9, -1, -1, -1, -1, 9, -1},
										   {9, 9, -1, -1, -1, -1, 9, 9},
										   {-1, -1, -1, -1, -1, -1, -1, -1},
										   {-1, -1, -1, -1, -1, -1, -1, -1},
										   {-1, -1, -1, -1, -1, -1, -1, -1},
										   {-1, -1, -1, -1, -1, -1, -1, -1},
										   {9, 9, -1, -1, -1, -1, 9, 9},
										   {-1, 9, -1, -1, -1, -1, 9, -1}};
										   
		int [][] expectedOu3= new int[][] {{3, 9, -1, -1, -1, -1, 9, -1},
										   {9, 9, -1, -1, -1, -1, 9, 9},
										   {-1, -1, -1, -1, -1, -1, -1, -1},
										   {-1, -1, -1, -1, -1, -1, -1, -1},
										   {-1, -1, -1, -1, -1, -1, -1, -1},
										   {-1, -1, -1, -1, -1, -1, -1, -1},
										   {9, 9, -1, -1, -1, -1, 9, 9},
										   {-1, 9, -1, -1, -1, -1, 9, 3}};
	   								   
		testboard10.openCell(0, 3);									   
		int [][]p = new int[8][8];
		p = testboard10.getBoardUser();
		assertArrayEquals(expectedOu, p);
		
		Board testboard11 = new Board();
		testboard11.setBoard(input);
		int [][]v = new int[8][8];
		testboard11.openCell(0, 0);	
		
		v = testboard11.getBoardUser();
		assertArrayEquals(expectedOu1, v);
		
		//----TDD for opening a mine and losing
		testboard11.openCell(0, 1);
		v = testboard11.getBoardUser();
		assertArrayEquals(expectedOu2,v);
		
		//----Equivalence partitioning and Limit values
		//We already tested for a valid inputs
		//Now we are going to test invalid inputs
		//we should get the same out as the last one due to not opnening invalid values
		testboard11.openCell(-1, -1);
		v = testboard11.getBoardUser();
		assertArrayEquals(expectedOu2,v);
		
		testboard11.openCell(3, -1);
		v = testboard11.getBoardUser();
		assertArrayEquals(expectedOu2,v);
		
		testboard11.openCell(-1, 3);
		v = testboard11.getBoardUser();
		assertArrayEquals(expectedOu2,v);
		
		testboard11.openCell(8, 8);
		v = testboard11.getBoardUser();
		assertArrayEquals(expectedOu2,v);
		
		testboard11.openCell(0, 8);
		v = testboard11.getBoardUser();
		assertArrayEquals(expectedOu2,v);
		
		testboard11.openCell(7,7);
		v = testboard11.getBoardUser();
		assertArrayEquals(expectedOu3,v);
		
		//---Statement coverage
		int [][] input1 = new int[][] {{0, 0, 0, 0, 0, 0, 0, 0},
									 {0, 0, 0, 0, 0, 0, 0, 0},
									 {0, 0, 0, 0, 0, 0, 0, 0},
									 {0, 0, 0, 0, 0, 0, 0, 0},
									 {0, 0, 0, 0, 0, 0, 0, 0},
									 {0, 0, 0, 0, 0, 0, 0, 0},
									 {0, 0, 0, 0, 0, 0, 0, 0},
									 {0, 0, 0, 0, 0, 0, 0, 0}};
		 int [][] ExpectedO3 = new int[][]  {{0, 0, 0, 0, 0, 0, 0, 0},
										 {0, 0, 0, 0, 0, 0, 0, 0},
										 {0, 0, 0, 0, 0, 0, 0, 0},
										 {0, 0, 0, 0, 0, 0, 0, 0},
										 {0, 0, 0, 0, 0, 0, 0, 0},
										 {0, 0, 0, 0, 0, 0, 0, 0},
										 {0, 0, 0, 0, 0, 0, 0, 0},
										 {0, 0, 0, 0, 0, 0, 0, 0}};								 
									 
    Board testboard12 = new Board();
	testboard12.setBoard(input1);	
    testboard12.openCell(0, 0);
    testboard12.openCell(0, 7);	
    testboard12.openCell(7, 0);	
    testboard12.openCell(7, 7);	
	int [][]z = new int[8][8];
	z = testboard12.getBoardUser();
	assertArrayEquals(ExpectedO3, z);								 
	//testboard11.openCell(posX, posY);
	
	}


}
