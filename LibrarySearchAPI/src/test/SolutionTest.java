package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.List;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import main.Solution;

class SolutionTest {

	Solution solution = new Solution();
	String[] words;
	@Test
	void test1() {
		words = new String[1];
		words[0] = "Dune";
		assertEquals(words.length, solution.doSearch("treachery").length);
		assertEquals(words[0], solution.doSearch("treachery")[0]);
	}
	
	@Test
	void test2() {
		words = new String[1];
		words[0] = "Hitchhiker's Guide to the Galaxy";
		assertEquals(words.length, solution.doSearch("researcher").length);
		assertEquals(words[0], solution.doSearch("researcher")[0]);
	}
	
	@Test
	void test3() {
		words = new String[1];
		words[0] = "A Song Of Ice And Fire Series";
		assertEquals(words.length, solution.doSearch("winter").length);
		assertEquals(words[0], solution.doSearch("winter")[0]);;
	}
	
	@Test
	void test4() {
		assertEquals(null, solution.doSearch("any word not found"));
	}
	
	@Test
	void test5() { 
		
		words = new String[2];
		words[0] = "Dune";
		words[1] = "A Song Of Ice And Fire Series";
		assertEquals(words.length, solution.doSearch("and").length);
		assertEquals(words[0], solution.doSearch("and")[0]);
		assertEquals(words[1], solution.doSearch("and")[1]);
	}

}
