import { Injectable } from '@angular/core';
import { ApiService } from './api.service';
import { Observable } from 'rxjs';
import { Result } from '../models/result.model';

@Injectable()
export class CalculatorService{
    
    constructor(private apiService: ApiService){}

    doOperation(operand1: number, operand2: number, operation: string): Observable<Result>{
       return this.apiService.post(operation, {"operand1": operand1, "operand2": operand2});
    }

     fibonacci(operand1: number, operand2: number): Observable<Result>{
        return this.apiService.post("fibonacci", {"operand1": operand1});
     }
}