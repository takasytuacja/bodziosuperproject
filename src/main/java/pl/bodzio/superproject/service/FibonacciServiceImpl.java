package pl.bodzio.superproject.service;

import org.springframework.stereotype.Service;

@Service
public class FibonacciServiceImpl implements FibonacciService {

	@Override
	public int get(int index) {
		if(index <= 1){
			return index;
		} else {
			return get(index-1) + get(index-2);
		}
	}
}
