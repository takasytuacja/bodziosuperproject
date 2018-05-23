package pl.bodzio.superproject.service.validation;

import java.util.List;
import java.util.Set;

public interface ValidationService {

	boolean hasValidBrackets(String s);

	Set<Integer> findDuplicate(List<Integer> numbers);

	String reverse(String s);

	int reverse(int numToReverse);

	Set<Character> findDuplicate(String stringWithDups);

	Set<Integer> finTopTwo(List<Integer> inputList);

	int getDecimalFromBinary(int binary);
}
