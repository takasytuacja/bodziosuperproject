package pl.bodzio.superproject.controller.algorithm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.bodzio.superproject.service.FibonacciService;
import pl.bodzio.superproject.service.ValidationService;

@RestController
@RequestMapping("/api/algh")
public class AlghorithmsController {

	private ValidationService validationService;

	private FibonacciService fibonacciService;

	@Autowired
	public AlghorithmsController(ValidationService validationService, FibonacciService fibonacciService){
		this.validationService = validationService;
		this.fibonacciService = fibonacciService;
	}

	@GetMapping("/validate/{stringToValidate}")
	public Boolean validate(@PathVariable
			String stringToValidate){
		return validationService.hasValidBrackets(stringToValidate);
	}

	@GetMapping("/fibonacci/{index}")
	public Integer getFibonacciValue(@PathVariable
			Integer index){
		return fibonacciService.get(index);
	}

}
