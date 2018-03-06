import { UserDTO } from '../users/userdto';
import { Injectable } from '@angular/core';
import { Http, Response, Headers } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';

@Injectable()
export class LoginService {
  private baseUrl = 'http://localhost:8080/api/logins?';

  constructor(private http: Http) { }
  
  authorization(login: string, password: string): Promise<any> {
     const url = `http://localhost:8080/api/logins?login=${login}&password=${password}`;
     return this.http.get(url).toPromise().then(response => response.json());
  }
  
  //authorization(login: string, password: string): Observable<UserDTO> {
  //  const url = `http://localhost:8080/api/logins?login=${login}&password=${password}`;
  //  return this.http
  //    .get(url)
  //    .map(mapUser);
  //}
}

function mapUsers(response: Response): UserDTO[] {
  return response.json().map(toUser);
}
 
function mapUser(response: Response): UserDTO {
  return toUser(response.json());
}
 
function toUser(r: any): UserDTO {
  return r;
}
