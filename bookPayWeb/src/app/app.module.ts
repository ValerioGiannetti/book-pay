import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './component/home/home.component';
import { ClienteComponent } from './component/cliente/cliente.component';
import { EsercenteComponent } from './component/esercente/esercente.component';
import { SettingUserComponent } from './component/setting-user/setting-user.component';
import { UserInfoComponent } from './component/user-info/user-info.component';
import { MenuComponent } from './component/menu/menu.component';
import { ListEsercentiComponent } from './component/list-esercenti/list-esercenti.component';
import { LogoutComponent } from './component/logout/logout.component';
import { LoginComponent } from './component/login/login.component';
import { AuthInterceptorService } from './interceptor/auth-interceptor.service';


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
    LoginComponent,
    LogoutComponent,

  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule,
    HttpClientModule,
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthInterceptorService,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
