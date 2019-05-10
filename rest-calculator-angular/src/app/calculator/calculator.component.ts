import { Component, OnInit } from '@angular/core';
import { mixinColor } from '@angular/material/core';
import { CalculatorService } from '../rest/calculator.service';
import { Result } from '../models/result.model';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent implements OnInit {

  //its a flag that identify if the user have inserted the first value, if so we need to remove the zero from the operator1
  firstValue : boolean;

  //only one point is permitted
  pointInserted : boolean = false;

  displayedValue : string = '0';

  operator1 : string = '0';
  operator2 : string = '';
  operation : string;

  constructor(private restCalculator : CalculatorService) { 
    this.firstValue = true;
    this.displayedValue = this.operator1.toString();
  }

  ngOnInit() {
  }

  click(numberInput: string){
    if(this.operation == undefined){
      if(this.firstValue){
        console.log("firstValue = " + this.firstValue);
        this.operator1 = numberInput.toString();
        this.firstValue = false;
      }else{        
        console.log("firstValue = " + this.firstValue + " numberInput " + numberInput);
        this.operator1 = this.operator1.concat(numberInput);
      }
    }else{
      this.operator2 = this.operator2.concat(numberInput);
    }
    this.displayedValue = this.displayedValue.concat(numberInput);
  }

 setOperation(operation: string){
    this.operation = operation;
    this.displayedValue = this.displayedValue.concat(operation);
    console.log(operation);
  }

  delete(){
    if(this.operation == undefined){
      if(!this.firstValue){
        this.operator1 = this.operator1.substring(0, this.operator1.length -1);
      }
    }else{
      this.operator2 = this.operator2.substring(0, this.operator1.length -1);
    }
  }

  result(){
    console.log(Number.parseFloat(this.operator1) + " " + Number.parseFloat(this.operator2));
    this.restCalculator.add(Number.parseFloat(this.operator1), Number.parseFloat(this.operator2)).subscribe(res =>{
        this.displayedValue = res.result.toString();
        this.operator1 = res.result.toString();
    });
  }
}
