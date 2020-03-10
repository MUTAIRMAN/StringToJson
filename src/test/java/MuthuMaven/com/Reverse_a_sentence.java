package MuthuMaven.com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Reverse_a_sentence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String strSam = "muthu! is good.";
		String strSam2=strSam.replaceAll("[^A-Za-z\\s]", "");
		System.out.println(strSam2);
		List<String> u = new ArrayList<String>();

		String[] str = strSam.split(" ");
		String[] str2= strSam2.split(" ");
		String p;
		for (int i = 0; i < str.length; i++) {
			u.add(str[i].replaceAll("[A-Za-z]", ""));
		}
		
		
		int i = 0;
		for (int j = str2.length - 1; j >= 0; j--) {
			if (u.get(i) != "") {
				System.out.print(str2[j] + u.get(i)+ " ");
			} else
				System.out.print(str2[j]+ " ");
			i++;
		}

	}

}
