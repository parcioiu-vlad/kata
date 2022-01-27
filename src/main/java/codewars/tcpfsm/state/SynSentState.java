package codewars.tcpfsm.state;

public class SynSentState implements State {
  @Override
  public void nextState(StateContext state, EventEnum event) {
    switch (event) {
    case RCV_SYN -> state.setState(new SynRcvdState());
    case RCV_SYN_ACK -> state.setState(new EstablishedState());
    case APP_CLOSE -> state.setState(new ClosedState());
    default -> state.setState(new ErrorState());
    }

  }

  @Override
  public String toString() {
    return "SYN_SENT";
  }

}
