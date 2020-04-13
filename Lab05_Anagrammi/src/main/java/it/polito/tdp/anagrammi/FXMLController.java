package it.polito.tdp.anagrammi;

import java.util.List;
import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.Ricerca;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	Ricerca r;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtInserisci;

    @FXML
    private Button btnCalcola;

    @FXML
    private TextArea txtCorretti;

    @FXML
    private TextArea txtSbagliati;

    @FXML
    private Button btnReset;

    @FXML
    void doCalcola(ActionEvent event) {
    	String p = txtInserisci.getText ();
    	if (p.equals(" ") || p.contains("  ")) {
    		txtCorretti.appendText ( "Inserisci una parola \n");
    		txtSbagliati.appendText ("Inserisci una parola \n");
    		return ;
    	}
    	else{
    		r.anagrammi(p);
    		List<String> anagrammiCorretti = r.getCorretti ();
    		List< String > anagrammiErrati = r.getErrati ();
    		for( String c:anagrammiCorretti)
    			txtCorretti . appendText (c + "\n" );
    		for ( String c1 : anagrammiErrati)
    			txtSbagliati.appendText (c1 + "\n" );
    		return;
    	}
    }

    @FXML
    void doReset(ActionEvent event) {
    	txtCorretti.clear();
    	txtInserisci.clear();
    	txtSbagliati.clear();

    }

    @FXML
    void initialize() {
        assert txtInserisci != null : "fx:id=\"txtInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCalcola != null : "fx:id=\"btnCalcola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCorretti != null : "fx:id=\"txtCorretti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtSbagliati != null : "fx:id=\"txtSbagliati\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    public  void  setModel ( Ricerca r ) {
	this.r=r;
	}
}
