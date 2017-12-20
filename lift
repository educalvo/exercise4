package liftproblem;

import java.util.ArrayList;

public class life {

	private static int NR_OF_FAILS = 0;
	private static int NR_OF_PRUNES = 0;
	private static ArrayList<Integer> testPeople = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		ArrayList<Integer> s = new ArrayList<Integer>();

		int[] money0 = {};
		int target0 = 500;
		System.out.println("Number of solutions: " + solutions(money0, 0, target0, s));
		globalStuff();
		
	}

	private static void globalStuff() {
		printGlobals();
		resetGlobals();
	}

	private static void resetGlobals() {
		NR_OF_FAILS = 0;
		NR_OF_PRUNES = 0;
	}

	private static void printGlobals() {
		System.out.println("Number of fails: " + NR_OF_FAILS);
		System.out.println("Number of prunes: " + NR_OF_PRUNES);
		System.out.println(" ");
		
	}

	/**
	 * Returns the number of ways of creating specified target value as a sum of
	 * money starting with c
	 * 
	 * @param money
	 * @param c
	 * @param target
	 * @return number of ways
	 */
	private static int solutions(int[] money, int c, int target, ArrayList<Integer> s) { //ArrayList s not currently being used
		assert money != null : "array should be initialized";
		assert c >= 0 && c <= money.length;
		
		if (target == 0) {
			showSolution(testPeople);
			return 1;
		} else if (target < 0 || c >= money.length) {
			NR_OF_FAILS++;
		} else if (money.length != 0) {
			if (smallestUntriedCoin(money, c) > target || sumOfUntriedCoins(money, c) < target || testPeople.size() > 6) {
				NR_OF_PRUNES++;
				return 0;
			}
			testPeople.add(money[c]);
			int with = solutions(money, c + 1, target - money[c], s);
			testPeople.remove(testPeople.size() - 1);
			int without = solutions(money, c + 1, target, s);
			return with + without;
		}
		return 0;
	}

	private static int smallestUntriedCoin(int[] money, int c) {
		if (c==money.length-1) {
			return money[c];
		}
		return Math.min(money[c], smallestUntriedCoin(money, c+1));
	}

	private static int sumOfUntriedCoins(int[] money, int c) {
		if (c==money.length) {
			return 0;
		}
		return money[c]+sumOfUntriedCoins(money, c+1);
	}

	private static void showSolution(ArrayList<Integer> s) {
		System.out.println("Possible solution: " + s);

	}

}
