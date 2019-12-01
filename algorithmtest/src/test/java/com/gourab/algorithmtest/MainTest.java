/**
 * 
 */
package com.gourab.algorithmtest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Gourab Chakraborty
 *
 */
public class MainTest {
	int playerCount;
	int[] skills;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		playerCount = 6;
		skills = new int[]{2, 8, 3, 3, 5, 5};
	}

	@Test
	public void testGetMinSkillSumAllDistinct() {
		skills = new int[]{2, 3, 1, 6, 5, 7};
		
		assertEquals(7, Main.getMinSkillSum(skills, playerCount));
	}
	
	@Test
	public void testGetMinSkillSumAllSame() {
		skills = new int[] {4, 4, 4, 4, 4, 4};
		
		assertEquals(24, Main.getMinSkillSum(skills, playerCount));
	}
	
	
	@Test
	public void testGetMinSkillSum() {
		assertEquals(13, Main.getMinSkillSum(skills, playerCount));
	}
	
	@Test
	public void testGetMinSkill1() {
		skills = new int[] {1, 2, 2, 3, 4, 5};
		
		assertEquals(7, Main.getMinSkillSum(skills, playerCount));
	}
	
	@Test
	public void testGetMinSkill2() {
		skills = new int[] {1, 2, 3, 2, 3, 2};
		
		assertEquals(8, Main.getMinSkillSum(skills, playerCount));
	}
	
	@Test
	public void testGetMinSkill3() {
		skills = new int[] {1, 0, 0, 2, 3, 2};
		
		assertEquals(5, Main.getMinSkillSum(skills, playerCount));
	}

}
