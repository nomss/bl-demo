import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../../core/services/auth.service';
import { LoginRequest } from '../../shared/requests/loginRequest';
import { LoginResponse } from '../../shared/response/loginResponse';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [
    FormsModule
  ],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

  username: string = '';
  password: string = '';

  constructor(
    private router: Router,
    private authService: AuthService
  ) {}

  login(): void {
    const loginreq: LoginRequest = {
      username: this.username,
      password: this.password
    }
    console.log('USERNAME1: ', this.username);
    console.log('PASSWORD: ', this.password);
    this.authService.login(loginreq).subscribe((response: LoginResponse) => {
      console.log("response: ", response);
      if(response != null && response.id) {
        this.router.navigate(['/dashboard']);
      }
    })
  }

  navigateToSignUp(): void {
    this.router.navigate(['/signup']);
  }

}
