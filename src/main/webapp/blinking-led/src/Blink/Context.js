class Context {
  constructor() {
    this.input = '';
    this.output = '';
    this.variablesMap = new Map();
  }

  getElements() {
    return this.input.trim().split(/[ ,]+/);
  }

  getInput() {
    return this.input.trim();
  }

  getVariablesMap() {
    return this.variablesMap;
  }

}

export default Context;
