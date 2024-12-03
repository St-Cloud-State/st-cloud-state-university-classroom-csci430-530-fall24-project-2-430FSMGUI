public class Context {
    private State currentState;
    private String initialState; // To track where to logout (e.g., Clerk or Manager)

    public Context() {
        // Start with LoginState
        this.currentState = new LoginState(this);
        this.initialState = "LoginState";
    }

    public void setState(State state) {
        this.currentState = state;
    }

    public void setInitialState(String initialState) {
        this.initialState = initialState;
    }

    public String getInitialState() {
        return initialState;
    }

    public void handle() {
        currentState.handle();
    }
}

