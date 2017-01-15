import React from 'react';
import {Grid} from 'react-bootstrap';
import {Row} from 'react-bootstrap';
import {Col} from 'react-bootstrap';
import {Button} from 'react-bootstrap';
import {FormGroup} from 'react-bootstrap';
import {FormControl} from 'react-bootstrap';
import {Label} from 'react-bootstrap';
import Interpreter from './interpreter/Interpreter.js';
import Context from './interpreter/Context.js';

class Blink extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            script: '',
            blinker: '',
            leds: []
        };

        //init the leds
        for (let i = 0; i < 8; i++) {
            let led = {
                color: 'grey'
            };
            this.state.leds.push(led);
        }

        this.interpreter = new Interpreter();
        this.contextInterpreter = new Context();

        this.textAreaChanged = this.textAreaChanged.bind(this);
        this.evalScript = this.evalScript.bind(this);
    }

    divStyle = {
        height: '350px'
    };

    evalScript() {

        console.log("Evaluating script: ");
        console.log(this.state.script);

        let lines = this.state.script.split('\n');

        this.contextInterpreter = new Context();

        this.contextInterpreter.scriptLines = lines;
        this.contextInterpreter.setInput(lines[0]);

        this.interpret();
    }

    interpret() {
        if (this.contextInterpreter.endScript()) {
            return;
        }

        this.interpreter.interpret(this.contextInterpreter);

        if (isNaN(this.contextInterpreter.output)) {
            return this.interpret();
        }

        console.log("Computed result : " + this.contextInterpreter.output);
        this.setState({blinker: this.contextInterpreter.output});
        this.changeLedsColor(this.contextInterpreter.output);

        let self = this;
        setTimeout(
            function() {
                return self.interpret();
            }
            , 1000);
    }

    textAreaChanged(event) {
        this.setState({script: event.target.value});
    }

    /**
     * Change the color of the leds based on the received binary number
     * @param binaryNumber
     */
    changeLedsColor(binaryNumber) {

        let ledList = this.state.leds;
        let binaryString = binaryNumber.toString();

        let binaryDiff = 8 - binaryString.length;

        for (let i=0;i<binaryDiff;i++) {
            ledList[i].color = 'grey';
        }

        for (let i=0;i<binaryString.length;i++) {
            let ledIndex = i + binaryDiff;

            if (binaryString.charAt(i) === '1') {
                ledList[ledIndex].color = 'green';
            } else {
                ledList[ledIndex].color = 'grey';
            }
        }

        this.setState({leds: ledList});
    }

    render() {

        let ledItems = this.state.leds.map(function (led, index) {
            return (
                <svg width={25} height={25} key={index}>
                    <circle cx={10} cy={10} r={10} fill={led.color}/>
                </svg>
            )
        });

        return (
            <div>
                <Grid>
                    <Row>
                        <Col md={6}>
                            <FormGroup controlId="formControlsTextarea">
                                <FormControl componentClass="textarea" name="script" onChange={this.textAreaChanged}
                                             placeholder="Enter script" style={this.divStyle}/>
                                <Button bsStyle="primary" onClick={this.evalScript}>Evaluate</Button>
                            </FormGroup>
                        </Col>
                        <Col md={6}>
                            <Label>{this.state.blinker}</Label>
                            <div>
                                {ledItems}
                            </div>
                        </Col>
                    </Row>
                </Grid>
            </div>
        );
    }
}

export default Blink;
