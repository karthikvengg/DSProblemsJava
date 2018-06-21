import java.util.Scanner;

public class SubsetsOfArray {

	public static void main(String[] args) {
		int givenArr[];
		
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		givenArr = new int[n];
		for (int i = 0; i < n; i++)
			givenArr[i] = s.nextInt();

		int subsetArr[] = new int[givenArr.length];
		new SubsetsOfArray().helper(givenArr, subsetArr, 0);
	}

	void helper(int[] givenArr, int[] subsetArr, int i) {
		if (i == givenArr.length) {
			System.out.print("{");
			for (int n : subsetArr)
				if (n != 0)
					System.out.print(n);
			System.out.print("}, ");
		} else {
			subsetArr[i] = 0;
			helper(givenArr, subsetArr, i + 1);
			subsetArr[i] = givenArr[i];
			helper(givenArr, subsetArr, i + 1);
		}
	}
}
