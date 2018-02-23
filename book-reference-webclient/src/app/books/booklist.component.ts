import { BookService } from './book.service';
import { BookDTO } from './bookdto';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-booklist',
  templateUrl: './booklist.component.html',
  styles: []
})
export class BooklistComponent implements OnInit {
  books: BookDTO[] = [];
 
  constructor(private bookService: BookService) { }
 
  ngOnInit() {
    //this.bookService.getAll().subscribe(b => this.books = b);
    this.bookService.getAllPromise().then(b => this.books = b);
  }

}
