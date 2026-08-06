
import { Routes } from '@angular/router';
import { MainContent } from './layouts/main-content/main-content';
import { Customers } from './customers/customers';
import { Default } from './default/default';

export const routes: Routes = [
  { path: '', component: MainContent },
  { path: 'customers', component: Customers },
  { path: '**', component: Default }
];
