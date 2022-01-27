package codewars.tcpfsm.state;

public interface State {

  void nextState(StateContext state, EventEnum event);

}
