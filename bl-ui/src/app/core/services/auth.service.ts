import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { evnironment } from '../../../environmnets/environment';

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

}
