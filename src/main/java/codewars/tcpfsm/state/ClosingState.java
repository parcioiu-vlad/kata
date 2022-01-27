package codewars.tcpfsm.state;

public class ClosingState implements State {
  @Override
  public void nextState(StateContext state, EventEnum event) {
    if (event == EventEnum.RCV_ACK) {
      state.setState(new TimeWaitState());
    } else {
      state.setState(new ErrorState());
    }
  }

  @Override
  public String toString() {
    return "CLOSING";
  }
}
