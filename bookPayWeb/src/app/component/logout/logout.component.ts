import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/service/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(private auth:AuthService,
              private route:Router) { }

  ngOnInit(): void {
    this.logout();
  }


  logout(){
      this.auth.logout();
      this.route.navigate(['/login']);
  }

}
