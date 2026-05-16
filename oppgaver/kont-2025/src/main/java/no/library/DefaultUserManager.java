package no.library;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.library.part3.LibraryItem;

import no.library.Loan;
import no.library.User;
import no.library.UserManager;

/**
 * A default implementation of the UserManager interface.
 * This class manages user-related operations, such as checking borrowing
 * eligibility and sending notifications.
 */
public class DefaultUserManager implements UserManager {

    private final Map<String, User> users;

    public DefaultUserManager() {
        this.users = new HashMap<>();
    }

    @Override
    public void addUser(User user) {
        if (user != null) {
            users.put(user.getUserId(), user);
        }
    }

    @Override
    public boolean canUserBorrow(String userId) {
        // This is a simplified check. A real system would have more complex rules.
        return findUser(userId).isPresent();
    }

    @Override
    public boolean canUserReserve(String userId, LibraryItem item) {
        if (item == null) {
            return false;
        }
        // This is a simplified check. A real system would have more complex rules.
        return findUser(userId).isPresent() && item.canReserve();
    }

    @Override
    public Optional<User> findUser(String userId) {
        return Optional.ofNullable(users.get(userId));
    }

    @Override
    public void notifyItemAvailable(String userId, LibraryItem item) {
        findUser(userId).ifPresent(user -> 
            System.out.printf("NOTIFICATION to %s: Item '%s' is now available for pickup.%n",
                user.getName(), item.getId())
        );
    }

    @Override
    public void notifyOverdueLoans(String userId, List<Loan> overdueLoans) {
        findUser(userId).ifPresent(user -> {
            if (overdueLoans != null && !overdueLoans.isEmpty()) {
                System.out.printf("NOTIFICATION to %s: You have %d overdue loan(s).%n",
                    user.getName(), overdueLoans.size());
                // In a real system, you would likely include more details here.
            }
        });
    }
}
