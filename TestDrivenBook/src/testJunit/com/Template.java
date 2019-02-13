package testJunit.com;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.internal.Throwables;

import java.util.Map;
import java.util.Map.Entry;;;

public class Template {
	
	private Map<String, String> variables;
	
	private String templateText;
	
	public Template(String templateText){
		this.variables = new HashMap<String,String>();
		
		this.templateText = templateText;
	}
	
	public void set(String name, String value)	{
		this.variables.put(name, value);
	}
	
	public String evaluate(){
		
		String result = replaceVariables();		
		
		checkForMissingresult(result);	
		return result;
		
	}
	
	private String replaceVariables() {
	
		String result = templateText;
		
		for (Entry<String,String> entry: variables.entrySet()){		
			String regex = "\\$\\{" + entry.getKey() + "\\}";
			result = result.replaceAll(regex, entry.getValue());
		}
		return result;
		
	}
	
	
	private void checkForMissingresult(String result){
		
		Matcher m = Pattern.compile(".*\\$\\{.+\\}.*").matcher(result);
		if(m.find()) {
			throw new MissingValueException("no value for " + m.group());
		}		
			
		
	}
	
	
		
	
	

}
