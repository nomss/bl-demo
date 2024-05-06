import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, map } from 'rxjs';

@Injectable({
  providedIn: 'root',
  
})
export class TestService {

  constructor(private http: HttpClient) {}

  getHello(): Observable<string> {
    return this.http.get<string>('http://localhost:8080/hello');
  }


}
