package pl.bodzio.superproject.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.bodzio.superproject.TestContext;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestContext.class, initializers = ConfigFileApplicationContextInitializer.class)
public class BubbleSortServiceImplTest {

	BubbleSortService bubbleSortService;

	@Autowired
	public void setBubbleSortService(BubbleSortService bubbleSortService){
		this.bubbleSortService = bubbleSortService;
	}

	@Test
	public void shouldReturn45_56_78_102_5678(){
		int[] expected = {45, 56, 78, 102, 5678};
		int[] unsorted = {78, 102, 56, 5678, 45};
		assertArrayEquals(expected, bubbleSortService.sort(unsorted));
	}

}
