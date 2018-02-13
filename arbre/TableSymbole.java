package yal.arbre;

import java.util.HashMap;

import yal.exceptions.AnalyseSyntaxiqueException;

public class TableSymbole {
	
	private static TableSymbole instance=new TableSymbole();
	
	private HashMap<Entree,Symbole> table;
	
	private TableSymbole() {
		table=new HashMap<Entree,Symbole>();
	}
	
	public void ajouter(Entree e,Symbole s) {
		if(table.containsKey(e)) {
			throw new AnalyseSyntaxiqueException("Variable " + e.getIdf() + "a déjà été déclarée.\n");
		}
		table.put(e,s);
	}
	
	public static TableSymbole getInstance() {
		return instance;
	}
	
	public int getTaille() {
		return table.size()*4;
	}
	
	public Symbole identifier(Entree e) {
		return table.get(e);
	}

	public boolean contains(Entree identificateur) {
		// TODO Auto-generated method stub
		return table.containsKey(identificateur);
	}
}
