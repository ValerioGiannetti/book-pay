import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  constructor(private http: HttpClient) { }

  url = environment.url_lista_prenotazioni;

  listaPrenotazioniWeek(id:string){
    
    return this.http.get(this.url+"lista-prenotazioni/"+id);
  }

}
