import { LoginService } from './login.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.css']
})
export class LoginComponent implements OnInit {

  login: string;
  password: string;
  errorMessage: string;
  response: any;
  
  constructor(private loginService: LoginService) { }

  ngOnInit() {
  }
  
  authorization() {
    //this.loginService.authorization(this.login, this.password)
    //  .catch(function(e) {
    //    //this.errorMessage = e._body;
    //    console.log(e._body);
    //  });
    this.loginService.authorization(this.login, this.password).subscribe(u => this.errorMessage = u.login, e => this.errorMessage = e._body);
  }

}
