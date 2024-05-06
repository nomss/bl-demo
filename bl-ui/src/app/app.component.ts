import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { TestService } from '../services/test.service';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit {
  title = 'bl-ui';

  constructor(private testService: TestService) {}

  ngOnInit(): void {
    this.testService.getHello().subscribe(
      (res: any) => {
        console.log("res: ", res);
      }
    )
  }


}
