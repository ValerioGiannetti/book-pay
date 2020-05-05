import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ClienteComponent } from './component/cliente/cliente.component';
import { ListEsercentiComponent } from './component/list-esercenti/list-esercenti.component';
import { LoginComponent } from './component/login/login.component';
import { LogoutComponent } from './component/logout/logout.component';
import { AuthGuardService } from './guard/auth-guard.service';


const routes: Routes = [
  { path:'', redirectTo: '/home', pathMatch: 'full'},
  {path:'home', component: ClienteComponent, canActivate:[AuthGuardService] },
  {path:'lista-esercenti', component: ListEsercentiComponent, canActivate:[AuthGuardService] },
  { path:'login',component:LoginComponent},
  { path:'logout',component:LogoutComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
