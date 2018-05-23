package pl.bodzio.superproject.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PermutationService {

	List<String> permutations = new ArrayList<>();

	public List<String> generatePermutations(String input) {

		permutations("", input);
		return permutations;
	}

	private void permutations(String consChars, String input) {

		if(input.isEmpty()) {
			permutations.add(consChars+input);
			return;
		}

		for(int i=0; i<input.length(); i++) {
			permutations(consChars+input.charAt(i),
					input.substring(0, i)+input.substring(i+1));
		}
	}
}
