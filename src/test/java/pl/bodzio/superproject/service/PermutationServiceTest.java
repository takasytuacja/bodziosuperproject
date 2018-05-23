package pl.bodzio.superproject.service;

import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.hamcrest.collection.IsIterableContainingInOrder;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.bodzio.superproject.TestContext;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestContext.class, initializers = ConfigFileApplicationContextInitializer.class)
public class PermutationServiceTest {

	private PermutationService permutationService;

	@Autowired
	public void setPermutationService(PermutationService permutationService){
		this.permutationService = permutationService;
	}

	@Test
	public void shouldReturnPermutations(){
		String stringToPermute = "xyz";
		List<String> permutations = Arrays.asList("xyz", "xzy", "yzx", "yxz", "zxy", "zyx");

		List<String> result = permutationService.generatePermutations(stringToPermute);
		Collections.sort(permutations);
		Collections.sort(result);

		assertEquals(permutations, result);
	}

}
