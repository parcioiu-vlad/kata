package codewars.tcpfsm.state;

public class SynRcvdState implements State {
  @Override
  public void nextState(StateContext state, EventEnum event) {
    switch (event) {
    case APP_CLOSE -> state.setState(new FinWait1State());
    case RCV_ACK -> state.setState(new EstablishedState());
    default -> state.setState(new ErrorState());
    }
  }

  @Override
  public String toString() {
    return "SYN_RCVD";
  }

}
