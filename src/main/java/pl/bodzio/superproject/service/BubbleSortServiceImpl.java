package pl.bodzio.superproject.service;

import org.springframework.stereotype.Service;

@Service
public class BubbleSortServiceImpl implements BubbleSortService{

	@Override
	public int[] sort(int[] unsorted) {
		int arrayLength = unsorted.length;
		for(int transitionCount = 0; transitionCount < arrayLength; transitionCount++){
			for(int i = 0; i < unsorted.length-1; i++){
				if(unsorted[i] > unsorted[i+1]){
					int temp = unsorted[i];
					unsorted[i] = unsorted[i+1];
					unsorted[i+1] = temp;
				}
			}
		}
		return unsorted;
	}

}
