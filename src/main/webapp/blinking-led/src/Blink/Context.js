class Context {
    constructor() {
        this.input = '';
        this.output = '';
        this.variablesMap = new Map();
    }

    getElements() {
        return this.input.trim().split(/[ ,]+/);
    }

    setInput(input) {
        this.input = input;
    }

    getInput() {
        if (!this.input) {
            return '';
        }
        return this.input.trim();
    }

    getVariablesMap() {
        return this.variablesMap;
    }

}

export default Context;
