import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient) {}

  public login(): Observable<string> {
    let body = {
      userName: "UserName",
      password: "Password"
    }
    return this.http.post<any>("http://localhost:8080/login", body
    // , {
    //   headers: new HttpHeaders({
    //     'Content-Type': 'application/json'
    //   })
    // }
  );
  }


}
