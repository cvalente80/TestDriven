package testJunit.com;

import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;

public class TestTemplateParse {
	
	@Test
	public void emptyTemplateRenderAsEmotyString() throws Exception {
		
		TemplateParse parse = new TemplateParse();
		List<String> segments = parse.parse("");
		assertEquals("Numeber of segments", 1, segments.size());
		assertEquals("",segments.get(0));
		
	}

}
