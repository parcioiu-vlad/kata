package codewars.tcpfsm.state;

public enum EventEnum {

  APP_PASSIVE_OPEN,
  APP_ACTIVE_OPEN,
  RCV_SYN,
  APP_SEND,
  APP_CLOSE,
  RCV_ACK,
  RCV_SYN_ACK,
  RCV_FIN,
  RCV_FIN_ACK,
  APP_TIMEOUT

}
