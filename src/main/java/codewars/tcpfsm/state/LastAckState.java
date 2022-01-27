package codewars.tcpfsm.state;

public class LastAckState implements State {
  @Override
  public void nextState(StateContext state, EventEnum event) {
    if (event == EventEnum.RCV_ACK) {
      state.setState(new ClosedState());
    } else {
      state.setState(new ErrorState());
    }
  }

  @Override
  public String toString() {
    return "LAST_ACK";
  }

}
