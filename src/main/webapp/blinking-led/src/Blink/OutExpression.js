class OutExpression {
  interpret(context) {
    return context.variablesMap.get(context.output);
  }
}

export default OutExpression;
