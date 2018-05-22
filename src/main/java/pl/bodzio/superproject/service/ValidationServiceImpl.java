package pl.bodzio.superproject.service;

import org.springframework.stereotype.Service;

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
}
