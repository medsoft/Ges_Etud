import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {PaymentsComponent} from './payments/payments.component';
import {StudentsComponent} from './students/students.component';
import {DashboardComponent} from './dashboard/dashboard.component';
import {HomeComponent} from './home/home.component';
import {LoadPaymentsComponent} from './load-payments/load-payments.component';
import {LoadStudentsComponent} from './load-students/load-students.component';
import {ProfileComponent} from './profile/profile.component';
import {LoginComponent} from './login/login.component';
import {AdminTemplateComponent} from './admin-template/admin-template.component';
import {AuthGuard} from './guards/auth.guard';
import {AuthorisationGuard} from './guards/authorisation.guards';

const routes: Routes = [
  {path : "" , component: LoginComponent},
  {path : "login" , component: LoginComponent},
  {path : "admin" , component: AdminTemplateComponent ,
    canActivate : [AuthGuard] ,
    children:[
      {path : "profile" , component: ProfileComponent},
      {path : "loadStudents" , component: LoadStudentsComponent ,
      canActivate :[AuthorisationGuard], data : {roles : ['ADMIN'] }},
      {path : "loadPayments" , component: LoadPaymentsComponent},
      {path : "home" , component: HomeComponent},
      {path : "dashboard" , component: DashboardComponent},
      {path : "students" , component: StudentsComponent},
      {path : "payments" , component: PaymentsComponent},
    ]},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
