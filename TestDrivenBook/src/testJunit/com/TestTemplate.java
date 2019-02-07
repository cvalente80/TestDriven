package testJunit.com;
import org.junit.*;
import static org.junit.Assert.*;


public class TestTemplate {
	
	private Template template;
	
	@Before
	public void setUp() throws Exception{
		template = new Template("${one}, ${two}, ${three}"); 
		template.set("one", "1");
		template.set("two", "2");
		template.set("three", "3");
	}
	
	
	@Test
	public void oneVariale() throws Exception {
		
		Template template = new Template("Hello, ${name}");
		template.set("name", "Reader");
		assertEquals("Hello, Reader", template.evaluate());		
		
	}
	
	@Test
	public void differentValue() throws Exception{
		
		Template template = new Template ("Hello, ${name}");
		template.set("name", "someone else");
		assertEquals("Hello, someone else",template.evaluate());
	}
	
	@Test
	public void multipleVariables() throws Exception{
			
		assertEquals("1, 2, 3", template.evaluate());
		
	}
	
	@Test
	public void unknownVariablesAreIgnored() throws Exception{
		Template template = new Template ("Hello, ${name}");
		template.set("name", "Reader");
		template.set("doesnotexist", "Hi");
		assertEquals("Hello, Reader",template.evaluate());
		
	}
	
	
	
	

}
