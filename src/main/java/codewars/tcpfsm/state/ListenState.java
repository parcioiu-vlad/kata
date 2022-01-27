package codewars.tcpfsm.state;

public class ListenState implements State {
  @Override
  public void nextState(StateContext state, EventEnum event) {
    switch (event) {
    case RCV_SYN -> state.setState(new SynRcvdState());
    case APP_SEND -> state.setState(new SynSentState());
    case APP_CLOSE -> state.setState(new ClosedState());
    default -> state.setState(new ErrorState());
    }
  }

  @Override
  public String toString() {
    return "LISTEN";
  }

}
