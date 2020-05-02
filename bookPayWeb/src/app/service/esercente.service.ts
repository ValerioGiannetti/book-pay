import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
@Injectable({
  providedIn: 'root'
})
export class EsercenteService {

  constructor(private http:HttpClient) { }

  url = environment.url_lista_esercenti;

  listaEsercenti(){
    return this.http.get(this.url+"lista-esercenti");
  }

}
