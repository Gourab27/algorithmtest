/**
 * 
 */
package com.gourab.algorithmtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author Gourab Chakraborty
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		try {
			// First line of input takes the number of players
			int playerCount = Integer.parseInt(reader.readLine());

			// Next line of input contains space separated integers to indicate the skills
			// of each player
			int[] skills = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();

			// Method to get the minimun skills remaining
			int minSkill = getMinSkillSum(skills, playerCount);
			System.out.println(minSkill);
		} catch (NumberFormatException | IOException e) {
			System.out.println("Please enter a valid number");
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				System.out.println("Unable to close BufferedReader, exception occured");
				e.printStackTrace();
			}
		}

	}

	/**
	 * Method to find the minimum sum of the skills for the remaining players
	 * 
	 * @param skills
	 * @param playerCount
	 * @return
	 */
	public static int getMinSkillSum(int[] skills, int playerCount) {
		int minSum = 0;

		// Sorting the array
		Arrays.sort(skills);

		int j = -1;
		for (int i = 1; i < playerCount; i++) {
			int max = -1;

			for (int start = j + 1; start < i; start++) {
				if (skills[start] == skills[i]) {
					break;
				}else if (skills[start] > max) {
					max = skills[start];
					j = start;
				}
			}

			if (j >= 0) {
				skills[j] = -1;
			}
		}

		minSum = Arrays.stream(skills).filter(skill -> skill >= 0).sum();

		return minSum;
	}

}
