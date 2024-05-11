import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

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
    private router: Router
  ) {}

  login(): void {
    console.log('USERNAME: ', this.username);
    console.log('PASSWORD: ', this.password);
  }

  navigateToSignUp(): void {
    this.router.navigate(['/signup']);
  }

}
