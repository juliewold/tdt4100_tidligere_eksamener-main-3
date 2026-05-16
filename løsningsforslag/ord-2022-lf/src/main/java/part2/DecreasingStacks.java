package part2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * DecreasingStacks is a class that manages an ordered list of
 * {@link DecreasingStack} instances
 * None of the stacks are allowed to be empty.
 */
public class DecreasingStacks {

	private final List<DecreasingStack> stacks = new ArrayList<DecreasingStack>();

	/**
	 * @return true if all stacks (if any) are empty
	 */
	public boolean isEmpty() {
		return stacks.isEmpty();
	}

	/**
	 * Pushes the provided element onto the first stack that accepts it.
	 * If there are no such stacks, add a new DecreasingStack to end of stack list,
	 * that is initialized with the element.
	 *
	 * @param element the element to push
	 */
	public void push(final int element) {
		for (final DecreasingStack stack : stacks) {
			if (stack.push(element)) {
				return;
			}
		}
		stacks.add(new DecreasingStack(element));
	}

	/**
	 * @return newline-separated string of stacks
	 */
	@Override
	public String toString() {
		return stacks.stream()
				.map(Object::toString)
				.collect(Collectors.joining("\n"));
	}

	/**
	 * Remove and return the smallest element across all stacks.
	 *
	 * @return (and remove) the element from the stacks that is smalles
	 * @throws an appropriate subclass of RuntimeException if no element can be
	 *            popped
	 */
	public int pop() {
		final DecreasingStack stackWithSmallest = stacks.stream()
				.min(Comparator.comparing(DecreasingStack::peek))
				.get();
		final int result = stackWithSmallest.pop();
		if (stackWithSmallest.isEmpty()) {
			stacks.remove(stackWithSmallest);
		}
		return result;
	}

	/**
	 * @return a List with the elements in increasing order.
	 *         If there are no elements, return an empty list.
	 *         The elements are also removed from this DecreasingStacks.
	 */
	public List<Integer> popAll() {
		final List<Integer> popped = new ArrayList<Integer>();
		while (!isEmpty()) {
			popped.add(pop());
		}
		return popped;
	}

	public static void main(final String[] args) {
		final DecreasingStacks stacks = new DecreasingStacks();
		List.of(5, 3, 8, 2, 1, 4, 4, 7, 6).forEach(stacks::push);
		System.out.println(stacks.toString());
		// Should print
		// [5, 3, 2, 1]
		// [8, 4]
		// [4]
		// [7, 6]

		System.out.println(stacks.popAll());
		// Should print
		// [1, 2, 3, 4, 4, 5, 6, 7, 8]
	}
}
