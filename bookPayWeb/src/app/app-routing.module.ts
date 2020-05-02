import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ClienteComponent } from './component/cliente/cliente.component';
import { ListEsercentiComponent } from './component/list-esercenti/list-esercenti.component';


const routes: Routes = [
  { path:'', redirectTo: '/home', pathMatch: 'full'},
  {path:'home', component: ClienteComponent },
  {path:'lista-esercenti', component: ListEsercentiComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
