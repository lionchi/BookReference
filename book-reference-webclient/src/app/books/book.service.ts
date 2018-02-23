import { BookDTO } from './bookdto';
import { Injectable } from '@angular/core';
import { Http, Response, Headers } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';

@Injectable()
export class BookService {

 private baseUrl = 'http://localhost:8080/api/books';
 
  constructor(private http: Http) {
  }
 
  get(id: number): Observable<BookDTO> {
    return this.http
      .get(`${this.baseUrl}/${id}`)
      .map(mapBook);
  }
 
  getAll(): Observable<BookDTO[]> {
     return this.http
      .get(`${this.baseUrl}`)
      .map(mapBooks);
  }
  
    getAllPromise(): Promise<BookDTO[]> {
     return this.http.get(`${this.baseUrl}`).toPromise().then(response => response.json());
  }
 
  save(book: BookDTO): Observable<Response> {
    console.log('Saving person ' + JSON.stringify(book));
    return this.http.put(`${this.baseUrl}/save/${book.id}`, book);
  }
}

function mapBooks(response: Response): BookDTO[] {
  return response.json().map(toBook);
}
 
function mapBook(response: Response): BookDTO {
  return toBook(response.json());
}
 
function toBook(r: any): BookDTO {
  return r;
}
