package codewars.tcpfsm.state;

public class FinWait1State implements State {
  @Override
  public void nextState(StateContext state, EventEnum event) {
    switch (event) {
    case RCV_FIN -> state.setState(new ClosingState());
    case RCV_FIN_ACK -> state.setState(new TimeWaitState());
    case RCV_ACK -> state.setState(new FinWait2State());
    default -> state.setState(new ErrorState());
    }
  }

  @Override
  public String toString() {
    return "FIN_WAIT_1";
  }
}
