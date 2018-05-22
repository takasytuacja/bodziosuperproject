package pl.bodzio.superproject.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.bodzio.superproject.TestContext;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestContext.class, initializers = ConfigFileApplicationContextInitializer.class)
public class ValidationServiceImplTest {

	private static final String VALID_STRING = "(a+b)(c*d)";
	private static final String INVALID_STRING = "((a+d)()))";
	private static final String INVALID_STRING_TOO_MANY_OPENINGS = "((a+d)()))(";
	private static final String INVALID_STRING_WRONG_ORDER = ")(";

	@Autowired
	ValidationService validationService;

	@Test
	public void shouldReturnTrueWhenValidStringPassed(){
		assertTrue(validationService.hasValidBrackets(VALID_STRING));
	}

	@Test
	public void shouldReturnTrueWhenEmptyStringPassed(){
		assertTrue(validationService.hasValidBrackets(""));
	}

	@Test
	public void shouldReturnFalseWhenTooManyClosingBrackets(){
		assertFalse(validationService.hasValidBrackets(INVALID_STRING));
	}

	@Test
	public void shouldReturnFalseWhenTooManyOpeningBrackets(){
		assertFalse(validationService.hasValidBrackets(INVALID_STRING_TOO_MANY_OPENINGS));
	}

	@Test
	public void shouldReturnFalseWhenReverseOrder(){
		assertFalse(validationService.hasValidBrackets(INVALID_STRING_WRONG_ORDER));
	}

}
