package testJunit.com;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestTemplatePerformance {
	
	private Template template;
	
	@Before
	public void setUp() throws Exception{
		template = new Template("${one}, ${two}, ${three}"); 
		template.set("one", "1");
		template.set("two", "2");
		template.set("three", "3");
	}
	
	@Test
	public void templateWith100WordsAnd20Variables() throws Exception {
		
		long expected = 200L;
		
		System.out.println("teste");
		long time = System.currentTimeMillis();
		template.evaluate();
		time = System.currentTimeMillis() - time;
		assertTrue("Rendering the template took " + time + " ms while the target was " + expected , time <= expected);
	}
	
	
	

}
