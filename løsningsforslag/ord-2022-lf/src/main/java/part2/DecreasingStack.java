package part2;

import java.util.ArrayList;
import java.util.List;

/**
 * A stack of integers that is decreasing in size.
 */
public class DecreasingStack {

	private final List<Integer> elements;

	/**
	 * Initializes this DecreasingStack with the provided element.
	 */
	public DecreasingStack(final int firstValue) {
		elements = new ArrayList<Integer>();
		elements.add(firstValue);
	}

	/**
	 * Pushed the provided element at the top, but
	 * only if it is less than the current topmost element.
	 *
	 * @param element to be pushed
	 * @return true if element is successfully pushed, false otherwise
	 */
	public boolean push(final int element) {
		if (elements.isEmpty() || element < peek()) {
			elements.add(element);
			return true;
		}
		return false;
	}

	/**
	 * Removes and return the topmost element (if any)
	 *
	 * @return the topmost element (if any)
	 * @throws an appropriate subclass of RuntimeException if is stack is empty.
	 */
	public int pop() {
		if (elements.isEmpty()) {
			throw new IllegalStateException("Stack is empty");
		}
		return elements.remove(elements.size() - 1);
	}

	/**
	 * Returns the topmost element (if any).
	 *
	 * @return top element of the stack (if any), or null if it is empty
	 */
	public int peek() {
		return (elements.isEmpty() ? null : elements.get(elements.size() - 1));
	}

	@Override
	public String toString() {
		return elements.toString();
	}

	/**
	 * @return true if stack is empty, false otherwise
	 */
	public boolean isEmpty() {
		return elements.isEmpty();
	}

	public static void main(final String[] args) {
		final DecreasingStack ds = new DecreasingStack(10);
		ds.push(6);
		ds.push(3);
		System.out.println(ds);

		if (ds.push(5)) {
			System.out.println("Pushed 5");
		} else {
			System.out.println("Cannot push 5");
		}

		while (!ds.isEmpty()) {
			System.out.println(ds.pop());
		}

		try {
			ds.peek();
		} catch (final RuntimeException e) {
			System.out.println("Cannot peek empty stack");
		}
	}
}
