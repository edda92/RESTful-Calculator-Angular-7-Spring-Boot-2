import { Injectable } from '@angular/core';
import { ApiService } from './api.service';
import { Observable } from 'rxjs';
import { Result } from '../models/result.model';

@Injectable()
export class CalculatorService{
    
    constructor(private apiService: ApiService){}

    add(operand1: number, operand2: number): Observable<Result>{
       return this.apiService.post("add", {"operand1": operand1, "operand2": operand2});
    }

}