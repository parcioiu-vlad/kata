package codewars.tcpfsm.state;

public class ErrorState implements State {
  @Override
  public void nextState(StateContext state, EventEnum event) {

  }

  @Override
  public String toString() {
    return "ERROR";
  }

}
