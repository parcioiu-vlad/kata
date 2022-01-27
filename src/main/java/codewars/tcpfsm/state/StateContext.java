package codewars.tcpfsm.state;

public class StateContext {

  private State state;

  public StateContext() {
    this.state = new ClosedState();
  }

  public void setState(State state) {
    this.state = state;
  }

  public void nextState(EventEnum event) {
    state.nextState(this, event);
  }

  public State getState() {
    return state;
  }
}
