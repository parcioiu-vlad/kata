class Context {
    constructor() {
        this.input = '';
        this.output = '';
        this.scriptLines = [];
        this.currentLineNo = 0;
        this.variablesMap = new Map();
        //Contains the label name and position in script
        this.labelMap = new Map();
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

    endScript() {
        return this.currentLineNo > this.scriptLines.length - 1;
    }

}

export default Context;
