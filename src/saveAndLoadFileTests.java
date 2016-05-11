import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class saveAndLoadFileTests {

	String testString;
	String nullString;
	Object obj;
	
	@Before
	public void setup()
	{
		testString = "Hey you, I'm a test String";
		nullString = "";
		obj = null;
	}
	
	
	@Test
	public void testThatSaveFileWorksOnAValidString() throws Exception
	{
		SaveFile.save(testString,"testfile.txt");
		assertTrue(testString.equals((String)LoadFile.load("testfile.txt")));
		
	}
	
	@Test
	public void testThatSaveFileWorksOnANullString() throws Exception	
	{
		SaveFile.save(nullString,"testNullFile.txt");
		assertTrue(nullString.equals((String)LoadFile.load("testNullFile.txt")));
	}
	
	@Test
	public void testThatSaveFileWorksOnANullObject() throws Exception	
	{
		SaveFile.save(obj,"testNullObjectFile.txt");
		assertEquals(obj,LoadFile.load("testNullObjectFile.txt"));
	}
	
	@Test
	public void testThatLoadThrowsExceptionOnInvalidFile()
	{
		boolean testResult;
		
		try
		{
			testResult = false;
			LoadFile.load("doesntexist.txt");
		}
		catch (Exception ex)
		{
			testResult = true;
		}
		
		assertTrue(testResult);
	}

}
