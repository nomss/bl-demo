import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { TestService } from '../services/test.service';
import { LoginService } from '../services/login.service';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit {

  title = 'bl-ui';
  public userName: string = "";
  private password: string = "";

  constructor(private testService: TestService, private loginService: LoginService) { }

  ngOnInit(): void {
    this.testService.getHello().subscribe(
      (res: any) => {
        console.log("res: ", res);
      }
    )
  }

  login() {
    console.log("Login");
    this.loginService.login().subscribe((res: any) => {
      console.log("res", res);
    })
  }


}
