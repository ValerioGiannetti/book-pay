import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { first } from 'rxjs/operators';
import { User } from 'src/app/model/user';
import { AuthService } from 'src/app/service/auth.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private auth: AuthService,
    private router: Router,
    private route: ActivatedRoute, ) {

   // if (this.auth.currentUserValue) {
     // this.router.navigate(['/']);
   // }
   this.auth.currentUser.subscribe(data => {
    this.currentUser = data;
  });
  }
  returnUrl: string;
  error = '';
  public currentUser: User;

  ngOnInit(): void {

    this.auth.currentUser.subscribe(data => {
      this.currentUser = data;
    });
    if(!this.auth.currentUser._isScalar){
      this.currentUser = new User();
    }
    this.returnUrl = this.route.snapshot.queryParams['home'] || '/';

  }

  onSubmit() {

    /*this.auth.login(this.user.email, this.user.password).subscribe(user => {
      console.log("id " + user.id + " token" + user.token);

      localStorage.setItem('currentUser',user.token);
      this.goHome();
    });*/


    this.auth.login(this.currentUser.email, this.currentUser.password)
    .pipe(first())
    .subscribe(
        data => {
          console.log("id " + data.id + " token" + data.token);
          
          this.router.navigate([this.goHome()]);
        },
        error => {
            this.error = error;
            
        });

  }
  goHome() {
    this.router.navigate(['home']);
  }
}