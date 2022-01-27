package codewars.tcpfsm.state;

public class CloseWaitState implements State {
  @Override
  public void nextState(StateContext state, EventEnum event) {
    if (event == EventEnum.APP_CLOSE) {
      state.setState(new LastAckState());
    } else {
      state.setState(new ErrorState());
    }
  }

  @Override
  public String toString() {
    return "CLOSE_WAIT";
  }
}
