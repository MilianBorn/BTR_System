package Systems.LoginSystem;
import Components.User;

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
