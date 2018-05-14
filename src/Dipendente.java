

public class Dipendente
{
	//ATTRIBUTI
	private int matricola;
	private String nominativo;
	
	
	//COSTRUTTORE
	public Dipendente(int matricola, String nominativo)
	{
		setMatricola(matricola);
		setNominativo(nominativo);
		
	}
	
	//COSTRUTTORE COPIA
	public Dipendente(Dipendente dipendente)
	{
		setMatricola(dipendente.getMatricola());
		setNominativo(dipendente.getNominativo());
	}
	
	
	//GETTER E SETTER
	public int getMatricola() 
	{
		return matricola;
	}
	public void setMatricola(int matricola) //METTO CONTROLLO SE MATRICOLA GIA IN USO
	{
		this.matricola = matricola;
	}
	public String getNominativo() 
	{
		return nominativo;
	}
	public void setNominativo(String nominativo) 
	{
		this.nominativo = nominativo;
	}
	
	//ALTRI METODI
	public String toString()
	{
		return "Matricola:"+ getMatricola()+". Nominativo: "+getNominativo();	
	}

//	<----------------------------------------------------------PROVA DIPENDENTE----------------------------------------------------------->
	public static void main(String[] args) 
	{
		Dipendente d1=new Dipendente(1,"Davide");
		Dipendente d2=new Dipendente(1,"Diego");
		Dipendente d3=new Dipendente(3,"Luca");
		
		System.out.println(d1.toString());
		System.out.println(d2.toString());
		
		
		
	}
	
}
