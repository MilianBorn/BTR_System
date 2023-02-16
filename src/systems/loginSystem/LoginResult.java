package systems.loginSystem;
import components.User;

// this class is used in the LoginManager to return a combination of variables in one object
public final class LoginResult {
    private final User user;
    private final boolean isValidated;

    public LoginResult(User user, boolean isValidated) {
        this.user = user;
        this.isValidated = isValidated;
    }

    public User getUser() {
        return user;
    }

    public boolean validation(){
        return isValidated;
    }
}
