package del4;

public class DelegatingTemperature {

	// Add any needed fields
	private Temperature delegate;
	private char scale;
	/**
	 * 
	 * @param delegate - the Temperature to get degree from
	 * @param scale    a character declaring the scale of this temperature object
	 * 
	 * @throws IllegalArgumentException if scale is not 'C' or 'F'
	 */
	public DelegatingTemperature(Temperature delegate, char scale) {
		this.delegate = delegate;
		this.setScale(scale);
	}

	/**
	 * 
	 * @return The current scale
	 */
	public char getScale() {
		return this.scale;
	}
	
	private void setScale(char scale) {
		if (scale != 'F' && scale != 'C') {
			throw new IllegalArgumentException() ;
		}
		this.scale = scale;
	}

	/**
	 * 
	 * @return the current degree from the delegate, converted to the correct scale
	 */
	public double getDegrees() {
		if (this.scale == this.delegate.getScale()) {
			return this.delegate.getDegrees();
		}
		return this.delegate.inOther().getDegrees();
	}

	/**
	 * 
	 * @return this temperature object, with scale converted to Celsius if the
	 *         current scale of this delegatingTemperature object is in Fahrenheit, and
	 *         value in Fahrenheit if this delegatingTemperature object is in Celsius
	 */
	public DelegatingTemperature toOther() {
		this.scale = this.scale == 'C' ? 'F' : 'C';
		return this;
	}

	/**
	 * 
	 * @return a new DelegatingTemperature object, with the same delegate, with
	 *         scale converted to Celsius if the current scale of this
	 *         delegatingTemperature object is Fahrenheit, and value in Fahrenheit
	 *         if this delegatingTemperature object is Celsius
	 */
	public DelegatingTemperature inOther() {
		return new DelegatingTemperature(this.delegate, this.scale == 'C' ? 'F' : 'C');

	}

	public static void main(String[] args) {
		Temperature t = new Temperature(10, 'C');
		DelegatingTemperature dt = new DelegatingTemperature(t, 'F');
		// Should now print 10
		System.out.println(t.getDegrees());
		// Should now print 50
		System.out.println(dt.getDegrees());
		dt.toOther();
		// Should now print 10
		System.out.println(dt.getDegrees());
		// Should now print 10
		System.out.println(t.getDegrees());
	}
}
