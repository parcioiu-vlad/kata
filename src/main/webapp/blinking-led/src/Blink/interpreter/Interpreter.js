import LdExpression from './LdExpression.js';
import OutExpression from './OutExpression.js';
import DjnzExpression from './DjnzExpression';

class Interpreter {
    constructor() {
        this.ld = 'ld';
        this.out = 'out';
        this.djnz = 'djnz';
        this.ldExpression = new LdExpression();
        this.outExpression = new OutExpression();
        this.djnzExpression = new DjnzExpression();
    }

    /**
     * Interprets a line
     * @param  {Context} context line
     * @return {void}
     */
    interpret(context) {
        //TODO check for malformed inputs (e.g. input > 255)
        let input = context.getInput();

        if (!input) {
            return;
        }

        let elements = context.getElements();

        if (input.startsWith(this.ld)) {
            context.input = elements[2];
            let result = this.ldExpression.interpret(context);
            //add the result to the variable
            context.variablesMap.set(elements[1], result);
            context.output = elements[1];

            console.log("Added " + result + " to variable " + elements[1]);
        }
        else if (input.startsWith(this.out)) {
            context.output = this.outExpression.interpret(context);
        }
        else if (input.startsWith(this.djnz)) {
            this.djnzExpression.interpret(context);
        }
        else if (input.endsWith(':')) {
            context.labelMap.set(input.replace(':', ''), context.currentLineNo)
        }

        context.currentLineNo++;
        context.input = context.scriptLines[context.currentLineNo];
    }
}

export default Interpreter;
