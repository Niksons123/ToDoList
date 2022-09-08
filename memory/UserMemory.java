package memory;

import entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserMemory {

    private final List<User> users = new ArrayList<>();

    public boolean exists(String username) {
        return users.stream()
                .anyMatch( x -> x.getUsername().equals( username ) );

    }

    public User findByUsernameAndPassword(String username, String password) {
        return users.stream()
                .filter( user -> user.getUsername().equals( username ) && user.getPassword().equals( password ) )
                .findFirst().orElse( null );
    }

    public void save(User user) {
        users.add( user );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserMemory that = (UserMemory) o;
        return Objects.equals( users, that.users );
    }

    @Override
    public int hashCode() {
        return Objects.hash( users );
    }
}
