import { UserDTO } from '../users/userdto';
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
  error: string;
  errorMessage: string;
  cuurentUser: UserDTO;
  
  constructor(private loginService: LoginService) { }

  ngOnInit() {
  }
  
  authorization() {
    this.loginService.authorization(this.login, this.password)
      .then(u => this.errorMessage = u.login)
      .catch(error =>
        this.setErrorMessage(error._body)
      );
    //this.loginService.authorization(this.login, this.password).subscribe(u => this.cuurentUser = u, 
    //  e => this.error = e._body);
    //if (this.error) {
    //  this.setErrorMessage(this.error);
   // }
  }
  
  private setErrorMessage(error: string) {
    let searchMessage = error.indexOf('message') + 10;
    let searchPath = error.indexOf('path') - 3; 
    this.errorMessage = error.substring(searchMessage, searchPath);
  }

}
