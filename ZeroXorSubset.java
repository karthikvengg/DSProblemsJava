import java.util.ArrayList;
import java.util.Scanner;

public class ZeroXorSubset {
	int count = 0;
	public static void main(String[] args) {
		int givenArr[];
		
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		givenArr = new int[n];
		for (int i = 0; i < n; i++)
			givenArr[i] = s.nextInt();

		int subsetArr[] = new int[givenArr.length];
		ZeroXorSubset obj = new ZeroXorSubset();
		obj.helper(givenArr, subsetArr, 0);
		System.out.println(obj.count);
	}

	void helper(int[] givenArr, int[] subsetArr, int i) {
		
		if (i == givenArr.length) {
			ArrayList<Integer> ls = new ArrayList<Integer>();
			//System.out.print("{");
			for (int n : subsetArr) {
				if (n != 0) {
					//System.out.print(n);
					ls.add(n);
				}
			}
			//System.out.print("} - ");
			if(ls.size()==1) {}
				//System.out.print(ls.get(0));
			else if (ls.size()>1){
				int k = ls.get(0);
				for (int j=1;j<ls.size();j++) {
					k=k^ls.get(j);
				}
				//System.out.print(k);
				if (k==0)
					count++;
			}
			//System.out.println();
		} else {
			subsetArr[i] = 0;
			helper(givenArr, subsetArr, i + 1);
			subsetArr[i] = givenArr[i];
			helper(givenArr, subsetArr, i + 1);
		}
		
	}
}
