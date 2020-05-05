import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { environment } from 'src/environments/environment';
import { User } from '../model/user';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  url = environment.base_url_auth;
  private currentUserSubject: BehaviorSubject<User>;
  public currentUser: Observable<User>;


  constructor(private http: HttpClient) {


    const userData = localStorage.getItem('currentUser');
    if (userData) {
      const resp = JSON.parse(userData);
      this.currentUserSubject = new BehaviorSubject<User>(resp);
      this.currentUser = this.currentUserSubject.asObservable();
    } else {
      const ut = new User();
      this.currentUserSubject = new BehaviorSubject<User>(ut);
      this.currentUser = this.currentUserSubject.asObservable()
    }


  }

  public get currentUserValue(): User {
    return this.currentUserSubject.value;
  }

  login(email: string, password: string) {
    let user = new User();
    user.email = email;
    user.password = password;
    //return this.http.post<User>(`${environment.base_url_auth}login`, user)
    console.log("URL "+`${environment.base_url_auth}login`)
    return this.http.post<any>(`${environment.base_url_auth}login`, user)
      .pipe(map(resp => {
        // store user details and jwt token in local storage to keep user logged in between page refreshes
        user = resp;
      //  user.commerciante.setupCommercianteDto = resp['setupCommercianteDto'];
        user.token = resp.token;
        localStorage.setItem('currentUser', JSON.stringify(user));
        this.currentUserSubject.next(user);
        return resp;
      }));

  }

  logout() {
    // remove user from local storage to log user out
    localStorage.removeItem('currentUser');
    this.currentUserSubject.next(null);
  }
}
