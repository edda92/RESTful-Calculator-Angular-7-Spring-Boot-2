import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Result } from '../models/result.model';

const httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json',
    })
  };

@Injectable()
export class ApiService{
    constructor(private http: HttpClient){}

    post(path: String, body: Object = {}) : Observable<Result>{
        console.log("executing post metod : " + JSON.stringify(body));
        return this.http.post<Result>(`${environment.api_url}${path}`, JSON.stringify(body), httpOptions);
    }
}