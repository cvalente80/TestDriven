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
	
	//Testing for an exception
	
	/*@Test
	public void missingValueRaisesException() throws Exception{
		try{
		new Template("${Foo}").evaluate();
		fail("evaluate() should throw an exceptio if a variable was left without value");
		}catch (MissingValueException expected){
			
		}			
	}
	*/
	/*	
	@Test(expected = MissingValueExpection.class)
	public void missingValueRaisesExceptionII() throws Exception{
		
		new Template("${Foo}").evaluate();		
		
	}*/
		
	//testing for an expected exception
	
	@Test	
	public void missingValueRaisesException() throws Exception {
		
		try {
			new Template("${foo}").evaluate();
			fail("evaluate() should throw an exception if "
			+ "a variable was left without value!");
		}catch(MissingValueException expected) {
			assertEquals("no value for ${foo}", expected.getMessage());
		}
	}
	
	

}
