import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './component/home/home.component';
import { ClienteComponent } from './component/cliente/cliente.component';
import { EsercenteComponent } from './component/esercente/esercente.component';
import { SettingUserComponent } from './component/setting-user/setting-user.component';
import { UserInfoComponent } from './component/user-info/user-info.component';
import { MenuComponent } from './component/menu/menu.component';
import { ListEsercentiComponent } from './component/list-esercenti/list-esercenti.component';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ClienteComponent,
    EsercenteComponent,
    SettingUserComponent,
    UserInfoComponent,
    MenuComponent,
    ListEsercentiComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
