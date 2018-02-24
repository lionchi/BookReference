import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { routing } from './app.routes';
import { BookService } from './books/book.service';
import { BooklistComponent } from './books/booklist.component';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { LoginComponent } from './logins/login.component';
import { LoginService } from './logins/login.service';


@NgModule({
  declarations: [
    AppComponent,
    BooklistComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    routing
  ],
  providers: [BookService, LoginService],
  bootstrap: [AppComponent]
})
export class AppModule { }
