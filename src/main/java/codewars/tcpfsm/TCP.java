package codewars.tcpfsm;

import codewars.tcpfsm.state.EventEnum;
import codewars.tcpfsm.state.StateContext;

/**
 * over engineered using https://en.wikipedia.org/wiki/State_pattern
 * https://www.codewars.com/kata/54acc128329e634e9a000362
 */
public class TCP {

  public static String traverseStates(String[] events) {
    StateContext stateContext = new StateContext();

    for (String event: events) {
      stateContext.nextState(EventEnum.valueOf(event));
    }

    return stateContext.getState().toString();
  }

}
