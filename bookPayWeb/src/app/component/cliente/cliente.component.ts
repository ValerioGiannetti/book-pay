import { Component, OnInit } from '@angular/core';
import { ClienteService } from 'src/app/service/cliente.service';
import { Prenotazioni } from 'src/app/model/prenotazioni';
import { User } from 'src/app/model/user';
import { AuthService } from 'src/app/service/auth.service';

@Component({
  selector: 'app-cliente',
  templateUrl: './cliente.component.html',
  styleUrls: ['./cliente.component.css']
})
export class ClienteComponent implements OnInit {

  constructor(private service:ClienteService,
    private auth:AuthService) { }
  listaPrenotazioniWeek:Array<Prenotazioni>;
  user:User;
  
  ngOnInit(): void {
    this.user = this.auth.currentUserValue;
    this.listaPrenotazioniWeek = new Array<Prenotazioni>();
    this.getListaPrenotazioniWeek(this.user.idUtente);

  }
  getListaPrenotazioniWeek(id:string){
      this.service.listaPrenotazioniWeek(id).subscribe((data: Prenotazioni[]) => {
      this.listaPrenotazioniWeek = data;

    })
    return this.listaPrenotazioniWeek;
  }

}
