import { Component, OnInit } from '@angular/core';
import { ClienteService } from 'src/app/service/cliente.service';
import { Prenotazioni } from 'src/app/model/prenotazioni';

@Component({
  selector: 'app-cliente',
  templateUrl: './cliente.component.html',
  styleUrls: ['./cliente.component.css']
})
export class ClienteComponent implements OnInit {

  constructor(private service:ClienteService) { }
  listaPrenotazioniWeek:Array<Prenotazioni>;
  
  
  ngOnInit(): void {
    this.listaPrenotazioniWeek = new Array<Prenotazioni>();
    this.getListaPrenotazioniWeek(null);

  }
  getListaPrenotazioniWeek(id:string){
      this.service.listaPrenotazioniWeek(id).subscribe((data: Prenotazioni[]) => {
      this.listaPrenotazioniWeek = data;

    })
    return this.listaPrenotazioniWeek;
  }

}
