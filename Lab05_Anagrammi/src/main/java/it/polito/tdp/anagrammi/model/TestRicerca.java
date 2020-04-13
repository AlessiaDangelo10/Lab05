package it.polito.tdp.anagrammi.model;

public class TestRicerca {
	public  static  void  main ( String [] args ) {
		Ricerca r=new Ricerca();
		r.anagrammi("goodbye");
		System.out.println(r.getCorretti());
		System.out.println(r.getErrati());
		
	}
		

}
