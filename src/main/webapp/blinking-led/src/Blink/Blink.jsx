import React from 'react';
import { Grid } from 'react-bootstrap';
import { Row } from 'react-bootstrap';
import { Col } from 'react-bootstrap';
import { Button } from 'react-bootstrap';
import { FormGroup } from 'react-bootstrap';
import { FormControl } from 'react-bootstrap';
import { Label } from 'react-bootstrap';
import Interpreter from './Interpreter.js';
import Context from './Context.js';

class Blink extends React.Component {

  constructor(props) {
    super(props);
    this.state = {
      script: '',
      blinker: ''
     };

    this.textAreaChanged = this.textAreaChanged.bind(this);
    this.evalScript = this.evalScript.bind(this);
  }

  divStyle = {
    height: '350px'
  };

  evalScript() {
    console.log("Evaluating script: ");
    console.log(this.state.script);

    var interpreter = new Interpreter();

    var lines = this.state.script.split('\n');

    var context = new Context();

    for(var i = 0;i < lines.length;i++){
      context.input = lines[i];
      interpreter.interpret(context);

      if (isNaN(context.output)) {
        continue;
      }

      console.log("Computed result : " + context.output);
      //TODO add blinkers
      this.setState({blinker: context.output});

    }
  }

  textAreaChanged(event) {
    this.setState({script: event.target.value});
  }

  render() {
    return (
      <div>
        <Grid>
          <Row>
            <Col md={6}>
              <FormGroup controlId="formControlsTextarea">
                <FormControl componentClass="textarea" name="script" onChange={this.textAreaChanged} placeholder="Enter script" style={this.divStyle} />
                <Button bsStyle="primary" onClick={this.evalScript}>Evaluate</Button>
              </FormGroup>
            </Col>
            <Col md={6}>
              <Label>{this.state.blinker}</Label>
            </Col>
          </Row>
        </Grid>

      </div>
    );
  }
}

export default Blink;
