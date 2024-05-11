import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AuthService } from '../../core/services/auth.service';

@Component({
  selector: 'app-signup',
  standalone: true,
  imports: [
    FormsModule
  ],
  templateUrl: './signup.component.html',
  styleUrl: './signup.component.css'
})
export class SignupComponent {

  username: string = '';
  password: string = '';

  constructor(
    private authService: AuthService
  ) {}

  signup(): void {
    if (!this.username || !this.password) {
      alert('Please fill out username and password');
    } else {
      this.authService.signup(this.username, this.password).subscribe((response: any) => {
        console.log("response: ", response);
      });
    }
  }
}
