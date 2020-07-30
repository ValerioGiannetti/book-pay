package com.book.cloud.dto;

public class PrenotazioniDto {

	private String idPrenotazioni;
	private ClienteDto clienteDto;
	private StaffDto staffDto;
	private String giorno;
	private String ora;
	private String minuti;
	private String dataPrenotazione;
	
	public String getIdPrenotazioni() {
		return idPrenotazioni;
	}
	public void setIdPrenotazioni(String idPrenotazioni) {
		this.idPrenotazioni = idPrenotazioni;
	}
	public ClienteDto getClienteDto() {
		return clienteDto;
	}
	public void setClienteDto(ClienteDto clienteDto) {
		this.clienteDto = clienteDto;
	}
	public StaffDto getStaffDto() {
		return staffDto;
	}
	public void setStaffDto(StaffDto staffDto) {
		this.staffDto = staffDto;
	}
	public String getGiorno() {
		return giorno;
	}
	public void setGiorno(String giorno) {
		this.giorno = giorno;
	}
	public String getOra() {
		return ora;
	}
	public void setOra(String ora) {
		this.ora = ora;
	}
	public String getMinuti() {
		return minuti;
	}
	public void setMinuti(String minuti) {
		this.minuti = minuti;
	}
	public String getDataPrenotazione() {
		return dataPrenotazione;
	}
	public void setDataPrenotazione(String dataPrenotazione) {
		this.dataPrenotazione = dataPrenotazione;
	}
	
	
}
