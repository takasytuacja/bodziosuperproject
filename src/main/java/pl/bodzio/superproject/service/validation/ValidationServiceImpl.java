package pl.bodzio.superproject.service.validation;

import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ValidationServiceImpl implements ValidationService {

	private static final char OPENING = '(';
	private static final char CLOSING = ')';

	@Override
	public boolean hasValidBrackets(String stringToValidate) {
		char[] stringArray = stringToValidate.toCharArray();
		int bracketsCount = 0;
		boolean valid = true;

		for(char s : stringArray){
			if(s == OPENING){
				bracketsCount++;
			} else if(s == CLOSING){
				bracketsCount--;
			}
			if(bracketsCount < 0){
				valid = false;
			}
		}
		if (bracketsCount != 0){
			valid = false;
		}
		return valid;
	}

	@Override
	public Set<Integer> findDuplicate(List<Integer> numbers) {
		Set<Integer> setOfDuplicates = new HashSet<>();
		Set<Integer> setOfNumbers = new HashSet<>();
		numbers.forEach(i -> {
			if(!setOfNumbers.add(i)){
				setOfDuplicates.add(i);
			}
		});
		return setOfDuplicates;
	}

	@Override
	public String reverse(String s) {
		String reversed = null;
		if(StringUtils.isEmpty(s) || s.length() == 1){
			reversed = s;
		} else {
			reversed = s.charAt(s.length() - 1) + reverse(StringUtils.substring(s, 0, s.length()-1));
		}
		return reversed;
	}

	@Override
	public int reverse(int numToReverse) {
		int reversed = 0;

		while(numToReverse != 0){
			reversed = (reversed*10) + (numToReverse%10);
			numToReverse = numToReverse/10;
		}

		return reversed;
	}

	@Override
	public Set<Character> findDuplicate(String stringWithDups) {
		Set<Character> setOfDups = new HashSet<>();
		Set<Character> setOfAllLetters = new HashSet<>();

		char[] chrs = stringWithDups.toLowerCase().toCharArray();
		for(Character ch:chrs){
			if(!setOfAllLetters.add(ch)){
				setOfDups.add(ch);
			}
		}
		return setOfDups;
	}

	@Override
	public Set<Integer> finTopTwo(List<Integer> inputList) {
		Set<Integer> topTwo = new HashSet<>();
		int max1 = 0;
		int max2 = 0;

		for(Integer i : inputList){
			if(i > max1){
				max2 = max1;
				max1 = i;
			} else if(i > max2) {
				max2 = i;
			}
		}

		topTwo.add(max1);
		topTwo.add(max2);
		return topTwo;
	}

	public int getDecimalFromBinary(int binary){
		int decimal = 0;
		int power = 0;
		while(true){
			if(binary == 0){
				break;
			} else {
				int tmp = binary%10;
				decimal += tmp*Math.pow(2, power);
				binary = binary/10;
				power++;
			}
		}
		return decimal;
	}

}
