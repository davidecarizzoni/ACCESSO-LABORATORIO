
import java.io.Serializable;
import java.time.LocalDateTime;

public class Accesso implements Serializable
{
	//ATRIBUTI
	private int idAccesso;
	private static int contaAccessi=0;
	private int matricola;
	
	

	private LocalDateTime DataOra;
	
	
	
	//COSTRUTTORE
	public Accesso(int matricola, LocalDateTime DataOra)
	{
		contaAccessi++;
		setIdAccesso(contaAccessi);
		setDataOra(DataOra);
		setMatricola(matricola);
	}
	
	//COSTRUTTORE COPIA
	public Accesso(Accesso a)
	{
		setIdAccesso(a.getIdAccesso());
		setDataOra(a.getDataOra());
		setMatricola(a.getMatricola());
	}
	
	//GETTER E SETTER
	public int getIdAccesso() 
	{
		return idAccesso;
	}
	public void setIdAccesso(int contaAccessi) 
	{
		idAccesso=contaAccessi;
	}
	public int getMatricola() 
	{
		return matricola;
	}
	public void setMatricola(int matricola) 
	{
		this.matricola =matricola;
	}
	
	public LocalDateTime getDataOra() 
	{
		return DataOra;
	}
	public void setDataOra(LocalDateTime dataOra) 
	{
		this.DataOra = dataOra;
	}
	
	
	
	//ALTRI METODI
	public String toString()
	{
		return getMatricola()+". Data e ora: "+getDataOra()+" Id Accesso: "+getIdAccesso();
	}

//	<-------------------------------------------PROVA ACCESSO----------------------------------------------------------->
/*	public static void main(String[] args) 
	{
		Dipendente d1=new Dipendente(1,"Davide");
		Dipendente d2=new Dipendente(2,"Diego");
		Dipendente d3=new Dipendente(3,"Luca");
		
		Accesso a1=new Accesso(d1);
		Accesso a2=new Accesso(d2);
		Accesso a3=new Accesso(d3);
		Accesso a4=new Accesso(d1);
		Accesso a5=new Accesso(d2);
		Accesso a6=new Accesso(d3);
		Accesso a7=new Accesso(d1);
		Accesso a8=new Accesso(a1);
		Accesso a9=new Accesso(a2);
		
		
		System.out.println(a1.toString());
		System.out.println(a2.toString());
		
	
		
	}*/
	
	
}
