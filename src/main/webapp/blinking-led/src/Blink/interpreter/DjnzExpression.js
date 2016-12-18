/**
 * Created by Vlad-Alexandru.PIRCI on 12/18/2016.
 */
class Djnzxpression {
    interpret(context) {
        let elements = context.getElements();
        context.currentLineNo = context.labelMap.get(elements[1]);
        context.output = 'output';
    }
}

export default Djnzxpression;
