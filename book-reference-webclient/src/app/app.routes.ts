import { BooklistComponent } from './books/booklist.component';
import { LoginComponent } from './logins/login.component';
import { RouterModule, Routes } from '@angular/router';
const routes: Routes = [

  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'book',
    component: BooklistComponent
  },

  //{
  //  path: 'book/:id',
  //  component: BookdetailsComponent
  //},
  
  //{
  //  path: 'book/edit/:id',
  //  component: BookeditComponent
 // },
 
  {
    path: '',
    redirectTo: '/login',
    pathMatch: 'full'
  },
];
 
export const routing = RouterModule.forRoot(routes);
