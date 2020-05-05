import { Component, OnInit } from '@angular/core';
import { EsercenteService } from 'src/app/service/esercente.service';
import { Esercente } from 'src/app/model/esercente';

@Component({
  selector: 'app-list-esercenti',
  templateUrl: './list-esercenti.component.html',
  styleUrls: ['./list-esercenti.component.css']
})
export class ListEsercentiComponent implements OnInit {

  constructor(private service: EsercenteService) { }

  listaEsercenti: Array<Esercente>;
  ngOnInit(): void {
    this.listaEsercenti = new Array<Esercente>();
    this.getListaEsercenti();
  }

  getListaEsercenti() {
    this.service.listaEsercenti().subscribe((data: Esercente[]) => {
      this.listaEsercenti = data;

    })
    return this.listaEsercenti;
  }


  getListaEsercentiGps(lat: string, longi: string) {

  }


}
