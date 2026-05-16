package del3;

import java.util.HashMap;
import java.util.Map;

public class CachingCalculations implements Calculations {

	private Calculations delegate;
	private Map<Integer, Integer> cache1 = new HashMap<>();
	private Map<Integer, Integer> cache2 = new HashMap<>();

	public CachingCalculations(Calculations delegate) {
		this.delegate = delegate;
	}

	@Override
	/**
	 * Delegates the job of calculating the square root to the delegate If the
	 * argument has been previously seen, the delegate should not be used and a
	 * local cached version of the result should be returned
	 * 
	 * @returns the square root of the argument
	 */
	public int getCalculation1(int number) {
		if (cache1.containsKey(number)) {
			return cache1.get(number);
		}
		int result = delegate.getCalculation1(number);
		cache1.put(number, result);
		return result;
	}

	@Override
	/**
	 * Delegates the job of calculating the square to the delegate If the argument
	 * has been previously seen, the delegate should not be used and a local cached
	 * version of the result should be returned
	 * 
	 * @returns the square of the argument
	 */
	public int getCalculation2(int number) {
		if (cache2.containsKey(number)) {
			return cache2.get(number);
		}
		int result = delegate.getCalculation2(number);
		cache2.put(number, result);
		return result;
	}

	public static void main(String[] args) {
		CachingCalculations calc = new CachingCalculations(new CalculationsImpl());
		// Should print 81
		System.out.println(calc.getCalculation2(9));
		// Should print 81 again, should not use the delegate
		System.out.println(calc.getCalculation2(9));
		// Should print 3
		System.out.println(calc.getCalculation1(9));
	}

}
