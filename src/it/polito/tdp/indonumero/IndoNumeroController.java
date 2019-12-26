/**
 * Sample Skeleton for 'IndoNumero.fxml' Controller Class
 */

package it.polito.tdp.indonumero;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;

public class IndoNumeroController {
	private int NMAX=100;
	private int TMAX=7;
	
	private int ContTent;
	private int numeroSegreto;
	
	private  void partita() {
		String numS=TentativoAttuale.getText();
    	if(numS.length()!=0) {
    		try {
    			int num=Integer.parseInt(numS);
    			if (num>numeroSegreto) {
    				textLog.appendText("Valore troppo ALTO\n");
    				ContTent++;
    				if(ContTent+1<=TMAX) {
    					Tentativo.setText(String.format("%d", ContTent));
        				TentativoAttuale.clear();
    				}else {
    					ContTent++;
    					Tentativo.setText(String.format("%d", ContTent));
    					textLog.appendText("HAI PERSO! Il numero era "+numeroSegreto+"\n");
    					HBoxTentativo.setDisable(true);
        				BtnNuovaPartita.setDisable(false);
        				
    				}
    				
    			}else if(num<numeroSegreto) {
    				textLog.appendText("Valore troppo BASSO\n");
    				ContTent++;
    				if(ContTent+1<=TMAX) {
    					Tentativo.setText(String.format("%d", ContTent));
        				TentativoAttuale.clear();
    				}else {
    					ContTent++;
    					Tentativo.setText(String.format("%d", ContTent));
    					textLog.appendText("HAI PERSO! Il numero era "+numeroSegreto+"\n");
    					HBoxTentativo.setDisable(true);
        				BtnNuovaPartita.setDisable(false);
        				
    					return;
    				}
    			}else {
    				textLog.appendText("HAI INDOVINATO!\n");
    				ContTent++;
    				Tentativo.setText(String.format("%d", ContTent));
    				HBoxTentativo.setDisable(true);
    				BtnNuovaPartita.setDisable(false);
    				
    			}
    			
    		} catch (NumberFormatException e) {
    			textLog.appendText("valore inserito non valido!\n");
    			TentativoAttuale.clear();
    			return;
    		}
    	}else {
    		textLog.appendText("Nessun valore inserito!\n");
    		TentativoAttuale.clear();
    		return;
    	}
	}
	

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="BtnNuovaPartita"
    private Button BtnNuovaPartita; // Value injected by FXMLLoader

    @FXML // fx:id="TentativiRimasti"
    private TextField Tentativo; // Value injected by FXMLLoader

    @FXML // fx:id="TentativiMax"
    private TextField TentativiMax; // Value injected by FXMLLoader

    @FXML // fx:id="HBoxTentativo"
    private HBox HBoxTentativo; // Value injected by FXMLLoader

    @FXML // fx:id="TentativoAttuale"
    private TextField TentativoAttuale; // Value injected by FXMLLoader

    @FXML // fx:id="BtnProva"
    private Button BtnProva; // Value injected by FXMLLoader

    @FXML // fx:id="textLog"
    private TextArea textLog; // Value injected by FXMLLoader

    @FXML
    void ClickNuovaPartita(ActionEvent event) {
    	ContTent=0;
    	numeroSegreto=(int) (Math.random()*NMAX)+1;
    	
    	HBoxTentativo.setDisable(false);
    	BtnNuovaPartita.setDisable(true);
    	
    	TentativoAttuale.clear();
    	Tentativo.setText(String.format("%d", this.ContTent));
    	TentativiMax.setText(String.format("%d", this.TMAX));
    	textLog.clear();
    	textLog.setText("Indovina un numero conpreso tra 1 e 100\n");
    }

    @FXML
    void ClickProva(ActionEvent event) {
    	
    	partita();
    	
    }
    @FXML
    void PressInvio(KeyEvent event) {
    	if(event.getCode()==KeyCode.ENTER) {
    		partita();
    	}
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert BtnNuovaPartita != null : "fx:id=\"BtnNuovaPartita\" was not injected: check your FXML file 'IndoNumero.fxml'.";
        assert Tentativo != null : "fx:id=\"TentativiRimasti\" was not injected: check your FXML file 'IndoNumero.fxml'.";
        assert TentativiMax != null : "fx:id=\"TentativiMax\" was not injected: check your FXML file 'IndoNumero.fxml'.";
        assert HBoxTentativo != null : "fx:id=\"HBoxTentativo\" was not injected: check your FXML file 'IndoNumero.fxml'.";
        assert TentativoAttuale != null : "fx:id=\"TentativoAttuale\" was not injected: check your FXML file 'IndoNumero.fxml'.";
        assert BtnProva != null : "fx:id=\"BtnProva\" was not injected: check your FXML file 'IndoNumero.fxml'.";
        assert textLog != null : "fx:id=\"textLog\" was not injected: check your FXML file 'IndoNumero.fxml'.";

    }
}
