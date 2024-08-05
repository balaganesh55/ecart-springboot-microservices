import { Routes } from '@angular/router';
import { FetchallproductsComponent } from './fetchallproducts/fetchallproducts.component';
import { HomeComponent } from './home/home.component';
import { AddproductComponent } from './addproduct/addproduct.component';
import { GetproductComponent } from './getproduct/getproduct.component';
import { DeleteproductComponent } from './deleteproduct/deleteproduct.component';
import { UpdateproductComponent } from './updateproduct/updateproduct.component';

export const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'getallproducts', component: FetchallproductsComponent },
  { path: 'addproduct', component: AddproductComponent },
  { path: 'getproduct/:id', component: GetproductComponent },
  { path: 'deleteproduct/:id', component: DeleteproductComponent },
  { path: 'updateproduct/:id', component: UpdateproductComponent },
];
