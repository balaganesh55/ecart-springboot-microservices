import { Routes } from '@angular/router';
import { FetchallproductsComponent } from './Product-Components/fetchallproducts/fetchallproducts.component';
import { HomeComponent } from './home/home.component';
import { AddproductComponent } from './Product-Components/addproduct/addproduct.component';
import { GetproductComponent } from './Product-Components/getproduct/getproduct.component';
import { DeleteproductComponent } from './Product-Components/deleteproduct/deleteproduct.component';
import { UpdateproductComponent } from './Product-Components/updateproduct/updateproduct.component';
import { GetcustomersComponent } from './Customer-Components/getcustomers/getcustomers.component';
import { AddcustomerComponent } from './Customer-Components/addcustomer/addcustomer.component';
import { FetchcustomerComponent } from './Customer-Components/fetchcustomer/fetchcustomer.component';
import { DeletecustomerComponent } from './Customer-Components/deletecustomer/deletecustomer.component';
import { UpdatecustomerComponent } from './Customer-Components/updatecustomer/updatecustomer.component';

export const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'getallproducts', component: FetchallproductsComponent },
  { path: 'addproduct', component: AddproductComponent },
  { path: 'getproduct/:id', component: GetproductComponent },
  { path: 'deleteproduct/:id', component: DeleteproductComponent },
  { path: 'updateproduct/:id', component: UpdateproductComponent },

  { path: 'getallcustomers', component: GetcustomersComponent },
  { path: 'addcustomer', component: AddcustomerComponent },
  { path: 'getcustomer/:id', component: FetchcustomerComponent },
  { path: 'deletecustomer/:id', component: DeletecustomerComponent },
  { path: 'updatecustomer/:id', component: UpdatecustomerComponent },
];
