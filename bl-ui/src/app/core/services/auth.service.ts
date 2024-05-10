import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { evnironment } from '../../../environmnets/environment';
import { LoginRequest } from '../../shared/requests/loginRequest';
import { LoginResponse } from '../../shared/response/loginResponse';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) {}

  public signup(username: string, password: string): Observable<any> {
    const user = {
      username: username,
      password: password
    };
    return this.http.post<any>(`${evnironment.apiUrl}/users`, user);
  }

  public login(loginRequest: LoginRequest): Observable<LoginResponse> {
    return this.http.post<LoginResponse>(`${evnironment.apiUrl}/users`, loginRequest);
  }

}
