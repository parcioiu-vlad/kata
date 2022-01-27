package codewars.tcpfsm.state;

public class ClosedState implements State {

  @Override
  public void nextState(StateContext state, EventEnum event) {
    switch (event) {
    case APP_PASSIVE_OPEN -> state.setState(new ListenState());
    case APP_ACTIVE_OPEN -> state.setState(new SynSentState());
    default -> state.setState(new ErrorState());
    }
  }

  @Override
  public String toString() {
    return "CLOSED";
  }
}
