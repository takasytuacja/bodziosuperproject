package pl.bodzio.superproject.service;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.bodzio.superproject.TestContext;
import pl.bodzio.superproject.service.validation.ValidationException;
import pl.bodzio.superproject.service.validation.ValidationService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
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

	@Rule
	public ExpectedException thrown = ExpectedException.none();

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

	@Test
	public void shouldReturn987(){
		List<Integer> nums = new ArrayList<>(Arrays.asList(2,987,4,5,567, 3,7,234,987));
		Set<Integer> expectedResult = new HashSet<>();
		expectedResult.add(987);
		assertEquals(expectedResult, validationService.findDuplicate(nums));
	}

/*	@Test
	public void shouldThrowNotDuplicatedException(){
		thrown.expect(ValidationException.class);
		List<Integer> nums = new ArrayList<>(Arrays.asList(2,987,4,5,567, 3,7,234));
		validationService.findDuplicate(nums);
	}*/

	@Test
	public void shouldReturnSameSingleSignString(){
		String s = "h";
		assertEquals(s, validationService.reverse(s));
	}

	@Test
	public void shouldReturnCDAB(){
		final String reversedString = "CDAB";
		final String sToReverse = "BADC";
		assertEquals(reversedString, validationService.reverse(sToReverse));
	}

	@Test
	public void shouldReverseNumber(){
		final int numToReverse = 5735621;
		final int expectedNum = 1265375;

		assertEquals(expectedNum, validationService.reverse(numToReverse));
	}

	@Test
	public void shouldReturnSetOfGW(){
		final Set<Character> expectedSet = new HashSet<>();
		expectedSet.add('g');
		expectedSet.add('w');
		final String stringWithDups = "haGlWRDgw";
		assertEquals(expectedSet, validationService.findDuplicate(stringWithDups));
	}

	@Test
	public void shouldReturn169And590(){
		final List<Integer> inputList = Arrays.asList(46, 590, 43, 6, 169, 99);
		final Set<Integer> expectedSet = new HashSet<>();
		expectedSet.add(169);
		expectedSet.add(590);
		assertEquals(expectedSet, validationService.finTopTwo(inputList));
	}

	@Test
	public void getDecimalFromBinary(){
		int b = 101;
		int expectedDec = 5;

		assertEquals(expectedDec, validationService.getDecimalFromBinary(b));
	}
}
