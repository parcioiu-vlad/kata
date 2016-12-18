class LdExpression {
  interpret(context) {
    return (context.input >>> 0).toString(2);
  }
}

export default LdExpression;
