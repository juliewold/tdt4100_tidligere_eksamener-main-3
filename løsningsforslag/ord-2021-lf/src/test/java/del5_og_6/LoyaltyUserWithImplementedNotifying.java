package del5_og_6;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class LoyaltyUserWithImplementedNotifying extends LoyaltyUser {
	
	public LoyaltyUserWithImplementedNotifying(String name) {
		super(name);
	}
	/**
	 * This is a method written purely to test for student's that have not implemented this method correctly, where
	 * we then still can test whether they've implemented other methods correctly. 
	 * For students reading this, the methods (Reflection) used in this method to access private variables are not part of 
	 * the curriculum and we do not expect you to understand what's going on here. 
	 */
	public void checkForStatusUpgrade() {
		try {
			String oldStatus = this.getStatus();
			Field points = getClass().getSuperclass().getDeclaredField("points");
			Field status = getClass().getSuperclass().getDeclaredField("status");
			status.setAccessible(true);
			points.setAccessible(true);
			int pointsValue = points.getInt(this);
			if (pointsValue <= 1000) {
			
				status.set(this, "Basic");
			}
			if (pointsValue > 1000) {
				status.set(this, "Silver");
			}
			if (pointsValue > 5000) {
				status.set(this, "Gold");
			}
			if (pointsValue > 10000) {
				status.set(this, "Platinum");
			}
			if (!oldStatus.equals(this.getStatus())) {
				Method method = getClass().getSuperclass().getDeclaredMethod("fireStatusChanged", String.class, String.class);
				method.setAccessible(true);
				method.invoke(this, oldStatus, this.getStatus());
			}
		}
		catch (NoSuchFieldException | SecurityException | InvocationTargetException | IllegalAccessException | NoSuchMethodException e) {
			System.out.println(e);
		}
	
	}

}
