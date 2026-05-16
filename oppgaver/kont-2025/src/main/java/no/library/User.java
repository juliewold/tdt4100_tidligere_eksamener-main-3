package no.library;

import java.util.Objects;

/**
 * Represents a user in the library system. This class primarily acts as a data
 * object.
 */
public class User {
    private final String userId;
    private final String name;
    private final String email;

    public User(String userId, String name, String email) {
        if (userId == null || name == null || email == null) {
            throw new IllegalArgumentException("UserId, name and email cannot be null");
        }

        this.userId = userId;
        this.name = name;
        this.email = email;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return String.format("%s (%s)", name, userId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        User user = (User) obj;
        return Objects.equals(userId, user.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }
}
