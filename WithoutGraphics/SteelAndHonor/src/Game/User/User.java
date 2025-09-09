package Game.User;
import java.util.ArrayList;

import Personajes.Caracteres.Caracter;
public class User {
	
	private String name;
	private int exp;
	private int level;
	private int gold;
	private Caracter mainCharter;
	
	private ArrayList<String> Inventory;//todo crear Clase invetario
	
	
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setCharter(Caracter ch) {
		this.mainCharter = ch;
	}
	public String getCharterName() {
		return mainCharter.getCharterName();
	}
	public Caracter getCharter() {
		return this.mainCharter;
	}
	
}
