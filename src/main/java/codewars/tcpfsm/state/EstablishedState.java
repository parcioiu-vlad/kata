package codewars.tcpfsm.state;

public class EstablishedState implements State {
  @Override
  public void nextState(StateContext state, EventEnum event) {
    switch (event) {
    case APP_CLOSE -> state.setState(new FinWait1State());
    case RCV_FIN -> state.setState(new CloseWaitState());
    default -> state.setState(new ErrorState());
    }
  }

  @Override
  public String toString() {
    return "ESTABLISHED";
  }
}
