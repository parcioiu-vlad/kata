package codewars.tcpfsm.state;

public class TimeWaitState implements State {
  @Override
  public void nextState(StateContext state, EventEnum event) {
    if (event == EventEnum.APP_TIMEOUT) {
      state.setState(new ClosedState());
    } else {
      state.setState(new ErrorState());
    }
  }

  @Override
  public String toString() {
    return "TIME_WAIT";
  }

}
