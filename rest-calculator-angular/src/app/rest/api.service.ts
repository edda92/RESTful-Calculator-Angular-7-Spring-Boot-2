import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Result } from '../models/result.model';
import { catchError } from 'rxjs/operators';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
  })
};

@Injectable()
export class ApiService {
  constructor(private http: HttpClient) { }

  post(path: String, body: Object = {}): Observable<Result> {
    console.log("executing post metod : " + JSON.stringify(body));
    return this.http.post<Result>(`${environment.api_url}${path}`, JSON.stringify(body), httpOptions);
  }

  private handleErrors(error: any) {
    return throwError(error.error);
  }
}