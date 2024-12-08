public class WareContext {
    private State currentState;

    public WareContext() {
        currentState = new LoginState(this); // Initial state
    }

    public void setState(State state) {
        this.currentState = state;
    }

    public void executeState() {
        currentState.execute();
    }
}
