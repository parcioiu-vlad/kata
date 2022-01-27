package codewars.tcpfsm.state;

public class FinWait2State implements State {
  @Override
  public void nextState(StateContext state, EventEnum event) {
    if (event == EventEnum.RCV_FIN) {
      state.setState(new TimeWaitState());
    } else {
      state.setState(new ErrorState());
    }
  }

  @Override
  public String toString() {
    return "FIN_WAIT_2";
  }

}
