package hillelee.reflection;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.regex.Matcher;

import static org.junit.Assert.*;

public class ProblemSolverTest {
	@Test
	public void solvePuzzle() throws Exception {
		String result = new ProblemSolver().solve(new Puzzle());
		
		Assert.assertThat(result, Matchers.is("Correct answer"));
	}
	
	public void solveDecryptor() throws Exception {
		String result = new ProblemSolver().solve(new MessageDecryptor());
		
		Assert.assertThat(result, Matchers.is("Correct answer"));
	}
}