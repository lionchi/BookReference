import { BooklistComponent } from './books/booklist.component';
import { RouterModule, Routes } from '@angular/router';
const routes: Routes = [

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
    redirectTo: '/book',
    pathMatch: 'full'
  },
];
 
export const routing = RouterModule.forRoot(routes);
