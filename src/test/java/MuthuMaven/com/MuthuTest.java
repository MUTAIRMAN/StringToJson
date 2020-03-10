package MuthuMaven.com;

import java.util.Arrays;

public class MuthuTest {

	public static void main(String a[]) {

		int[] mut = { 1, 2, 3, 4 };

		// left Rotation by one
		
		for (int i = 0; i < 1; i++) {
			int last = mut[0];
			
			for (int j =1; j <  mut.length; j++) {
				mut[j-1] = mut[j];
			}
			mut[mut.length-1]=last;
		}
		
		Arrays.stream(mut).forEach(num->System.out.println(num));
		
	}

}
