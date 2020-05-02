export class Esercente {

    id:string
	nomeEsercente:string;
	nomeAttivita:string;
	via:string;
	citta:string;
	numeroCivico:number;
	tipologiaAttivita:string;
	oraApertura:number;
	oraChiusura:number;
	
	password:string;
	email:string;
    indirizzo:string

    getIndirizzo(){
        if(this.citta != null && this.numeroCivico != null && this.via !=null){
            this.indirizzo = this.citta+" "+this.via+" "+this.numeroCivico;
        }
        return this.indirizzo
    }


}
