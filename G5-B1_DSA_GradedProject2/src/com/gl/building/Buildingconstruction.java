package com.gl.building;

import java.util.InputMismatchException;
import java.util.Stack;
import java.util.Scanner;
import java.util.Arrays;

public class Buildingconstruction {
	public int day = 0;
	public int num_floors;
	public static final Scanner sc = new Scanner(System.in);

	/*
	 * This function orders the stack in descending order(high to low)
	 * 
	 * @param temp of type Stack passed into this function to order it returns Stack
	 * with ordering all the floor values (high to low)
	 * 
	 * Returns Stack - The reordered Stacks in decending order(high to low)
	 */
	public Stack<Integer> stack_order_desc(Stack<Integer> temp) {

		int stack_size = temp.size();
		int[] temparr = new int[stack_size];
		int count = 0;

		// if it is more than on store it in an array
		if (temp.size() > 1) {
			while (!temp.isEmpty()) {
				temparr[count] = temp.pop();
				count++;
			}
			/*
			 * Sort the array in ascending order push it stack will be arranged in
			 * descending order (highest to lowest)
			 */
			Arrays.sort(temparr);

			for (int i = 0; i < temparr.length; i++)
				temp.push(temparr[i]);

		}
		return temp;
	}

	/*
	 * This function checks any value higher from (i+1)th position until end of an
	 * array(length) if it finds greater number in the array returns true else false
	 * 
	 * @param i From (i+1)th location until the end of the array check any great
	 * value exists
	 * 
	 * Returns true if any max value exists / False when it is not found
	 *
	 */
	public boolean check_higherrank_found(int[] arr_floors, int i) {

		boolean found = false;
		for (int j = i + 1; j < arr_floors.length; j++) {
			if (arr_floors[j] > arr_floors[i]) {
				found = true;
				break;
			}
		}
		return found;
	}

	/*
	 * This function checks any number higher than value passed as a paramenter
	 * check from (i+1)th index till the end of the array if it finds returns true
	 * else returns false
	 * 
	 * @param arr_floors- an Array of floor size passed as parameter
	 * 
	 * @param i - From (i+1)th location until the end of the array check any great
	 * value exists
	 * 
	 * @param value - Checks for the 'value' from (i+1)th location onwards
	 *
	 * @return returns true if it exists / False when it is not found
	 */
	public boolean check_higherrank_found(int[] arr_floors, int i, int value) {
		boolean found = false;
		// Starting from (i+1)th
		for (int j = i + 1; j < arr_floors.length; j++) {
			// checking if any data has higher than value
			if (arr_floors[j] > value) {
				found = true;
				break;
			}

		}
		return found;
	}

	/*
	 * This is the main function which computes the sequence floor starting from the
	 * biggest to smallest
	 * 
	 * @param arr_floors - is an array of floor sizes entered by the user
	 * 
	 */
	public void compute_floor_sequence(int[] arr_floors) {

		Stack<Integer> tmpStack1 = new Stack<Integer>();
		boolean found;
		int num, val;

		// List all the floors
		for (int i = 0; i < arr_floors.length; i++) {
			tmpStack1.push(arr_floors[i]);
			// ordering the stack
			tmpStack1 = stack_order_desc(tmpStack1);
			day++;

			System.out.println("Day:" + day);

			num = i;
			// Check if any higher floor size value exist
			// in the rest of days.
			// if it doesn't exist then pop out from the stack
			if (!check_higherrank_found(arr_floors, num)) {
				found = false;
				// Check if stack is not empty and not found
				while (!tmpStack1.isEmpty() && !found) {

					System.out.print(" " + tmpStack1.pop());

					if (!tmpStack1.isEmpty()) {

						val = tmpStack1.peek();

						// Update status 'found' for every
						// if the any floor size exists
						found = check_higherrank_found(arr_floors, num, val);
					}
				}
			}

			System.out.println();

		}

	}

	/*
	 * This function checks for the duplicate entry in an array of floorsize
	 * 
	 * @Param arr - array of integers are passed into function returns boolean
	 * output Returns True - if it finds any max / False when it is not found
	 */
	public boolean check_for_duplicates(int[] arr) {

		boolean found = false;
		int item, i = 0;
		// Take each item from the array and compare with the rest
		while (i < arr.length && !found) {
			item = arr[i];
			// Comparison starting starting from i+1
			for (int j = i + 1; i < arr.length; j++) {
				// if j reaches length quit the checking
				if (j == arr.length)
					break;
				if (arr[j] == item) {
					found = true;
					break;
				}
			}
			i++;
		}
		return found;
	}
	/*
	 * This function allows the user to enter the total number floors and it will
	 * not allow negative or any alphabet as a data It will not exit out of the loop
	 * if user enters wrong data
	 * 
	 * @Param - no parameters returns integer (valid numeric value)
	 * 
	 * Returns - integer value (valid total number floors entered by the user)
	 */

	public int enter_totalfloors() {
		int keyin = 0;
		boolean valid = true;
		// do-while loop used - until user enters the right data
		do {
			System.out.println("Enter the total no of floors in the building");
			try {
				keyin = sc.nextInt();
				if (keyin <= 0) {
					System.out.println("Please re-enter value >0");
					valid = false;
				} else
					valid = true;
			} catch (InputMismatchException e) {
				System.out.println("Invalid data - Please enter valid integer");
				sc.nextLine();
				valid = false;
			}

		} while (!valid);

		return keyin;
	}

	/*
	 * This function allows the user to enter all the floor sizes and it is stored
	 * in an array of integers. It will not allow negative or any alphabet as a data
	 * It will not exit out of the loop if user enters wrong data
	 * 
	 * @Param - floorsize array of integers returns floor_size (an array of
	 * integers)
	 */
	public int[] enter_floorsize(int[] floorsize) {

		boolean valid;
		int keyin = 0;

		// Enter the floor size and store it in 'floorsize' array
		for (int i = 0; i < floorsize.length; i++) {
			valid = false;
			do {
				try {
					System.out.println("Enter the floor size given on day " + (i + 1));
					keyin = sc.nextInt();
					// Check for positive values
					if (keyin < 1) {
						valid = false;
						System.out.println("Please re-enter the valid floor size >0");
					} else
						valid = true;
					// catch any wrong entry by the user
				} catch (InputMismatchException e) {
					System.out.println("Invalid data - Please re-enter valid integer");
					sc.nextLine();
					valid = false;
				}
				// Loop is executed
			} while (!valid);
			floorsize[i] = keyin;

		}
		return floorsize;
	}

	// Driver code
	public static void main(String[] args) {

		// Create an object of Buildingconstruction
		Buildingconstruction bc = new Buildingconstruction();

		// Call the function enter_total_floors to enter total number of foors
		bc.num_floors = bc.enter_totalfloors();

		// Create an array of size depending on the num_floors
		int[] fl_size = new int[bc.num_floors];

		// Enter floor size and store it in an array
		fl_size = bc.enter_floorsize(fl_size);

		// Checking for the duplicate values present in floorsize array
		if (bc.check_for_duplicates(fl_size)) {
			// if duplicate floor size is found - User has to re-run the code
			System.out.println("Duplicate data found in the entry");
			System.out.println("Every day a floor distinct size is constructed");
			System.out.print("Please rerun the program - to re-enter data ");
		} else {
			// When duplicate floorsizes are not found in the array
			System.out.println("*====Result====*");
			bc.compute_floor_sequence(fl_size);
			System.out.print("**Successfully completed**");
		}
		sc.close();
	}
}
