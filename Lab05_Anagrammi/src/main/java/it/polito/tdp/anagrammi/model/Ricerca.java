package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;

import java.util.List;

import it.polito.tdp.anagrammi.DAO.AnagrammaDAO;

public class Ricerca {
	 List<String>corretti = new ArrayList<>();
	 List<String> errati = new ArrayList<>();
   AnagrammaDAO  dao=new AnagrammaDAO();
	public void anagrammi(String parola) {
		
		parola=parola.toUpperCase() ;
		
		List<Character> disponibili = new ArrayList<>() ;
		for(int i=0; i<parola.length(); i++) {
			disponibili.add(parola.charAt(i)) ; // aggiungo il carattere estratto dalla posizione i-esima(CHARAT)
		}
		
		// avvia la ricorsione
		cerca("", 0, disponibili) ; 
		
		
	}
	private void cerca( String parziale, int livello, List<Character> disponibili) {
		if(disponibili.size()==0) {
			
			if(dao.isCorretto(parziale)) {
				corretti.add(parziale);
			}
			else
				errati.add(parziale);
		}
		
		
		for(Character ch: disponibili) {
			String tentativo = parziale + ch ;
			
			List<Character> rimanenti = new ArrayList<>(disponibili) ;
			rimanenti.remove(ch) ;
				cerca( tentativo, livello+1, rimanenti) ;
		}
	
}
	public List<String> getCorretti() {
		return corretti;
	}
	public List<String> getErrati() {
		return errati;
	}
}
