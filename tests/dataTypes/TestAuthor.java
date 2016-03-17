package dataTypes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



public class TestAuthor {

	private static final String EXPECTED_AUTHOR_NAME = "Bruno";
	Author author;
	
	
	
	@Before
	public void initAuthor(){
		author = new Author(EXPECTED_AUTHOR_NAME);
	}
	
	@Test
	public void testGetName(){
		String name = author.getName();
		Assert.assertEquals(EXPECTED_AUTHOR_NAME, name);
	}
	
	@Test
	public void testListInit(){
		Assert.assertNotNull(author.getRevisions());
	}
	
}
