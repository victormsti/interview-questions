package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.Solution;

class SolutionTest {

	Solution solution = new Solution();
	@Test
	void test1() {
		assertEquals("Dune", solution.doSearch("treachery"));
	}
	
	@Test
	void test2() {
		assertEquals("Hitchhiker's Guide to the Galaxy", solution.doSearch("researcher"));
	}
	
	@Test
	void test3() {
		assertEquals("A Song Of Ice And Fire Series", solution.doSearch("winter"));
	}
	
	@Test
	void test4() {
		assertEquals(null, solution.doSearch("any word not found"));
	}

}
