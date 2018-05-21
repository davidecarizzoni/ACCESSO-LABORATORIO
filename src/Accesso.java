
import java.io.Serializable;
import java.time.LocalDateTime;
/**
 * La classe Accesso rappresenta un accesso di un dipendente al laboratorio. La classe è costituita dai seguenti attributi:
 * la matricola del dipendente che esegue l'accesso,
 * l'identificativo numerico dell'accesso e la data e l'ora in cui il dipendente eseguirà l'accesso
 * 
 * @author Davide Carizzoni
 * @version 1.0
 */
public class Accesso implements Serializable
{
	//ATTRIBUTI
	private int idAccesso;
	private static int contaAccessi=0;
	

	private int matricola;
	
	private LocalDateTime DataOra;
	
	
	/**
	 * Costruttore della classe accesso. Instanzia un nuovo accesso.
	 * Richiede la matricola del dipendente di cui si istanzia l'accesso,
	 * la data e l'orario
	 * 	
	 * @param matricola rappresenta la matricola del dipendente che esegue l'accesso
	 * @param DataOra rappresenta la data e l'orario(attuale) nei quali il dipendente esegue l'accesso
	 */
	//COSTRUTTORE
	public Accesso(int matricola, LocalDateTime DataOra)
	{
		contaAccessi++;
		setIdAccesso(contaAccessi);
		setDataOra(DataOra);
		setMatricola(matricola);
	}
	
	/**
	 * Costruttore di copia della classe Accesso. Istanzia un nuovo accesso
	 * @param accesso rappresenta l/accesso di cui si vuole creare una copia
	 */
	//COSTRUTTORE COPIA
	public Accesso(Accesso accesso)
	{
		setIdAccesso(accesso.getIdAccesso());
		setDataOra(accesso.getDataOra());
		setMatricola(accesso.getMatricola());
	}
	
	/**
	 * Costruttore di default della classe Accesso. Istanzia un nuovo accesso vuoto
	 */
	//COSTRUTTORE DEFAULT
		public Accesso()
		{
			setIdAccesso(0);
			setDataOra(null);
			setMatricola(0);
		}
	
	//GETTER E SETTER
	/**
	 * Metodo di tipo getter che restituisce l'identificativo dell'accesso
	 * @return idAccesso che rappresenta l'identificativo
	 */
	public int getIdAccesso() 
	{
		return idAccesso;
	}
	
	/**
	 * Metodo di tipo setter che permette di settare l'identificativo dell'accesso
	 * @param contaAccessi
	 */
	public void setIdAccesso(int contaAccessi) 
	{
		idAccesso=contaAccessi;
	}
	
	/**
	 * Metodo di tipo getter che restituisce la matricola
	 * @return matricola che rappresenta la matricola del dipendente a cui si riferisce l'accesso
	 */
	public int getMatricola() 
	{
		return matricola;
	}
	
	/**
	 * Metodo  setter che permette di settare la matricola
	 * @param matricola che rappresenta la matrciola da settare, ovvero da assegnare all'accesso
	 */
	public void setMatricola(int matricola) 
	{
		this.matricola =matricola;
	}
	
	/**
	 * Metodo getter che restituisce la data dell'accesso
	 * @return DataOra che rappreenta la Data e l'orario in cui è stato registrato l'accesso
	 */
	public LocalDateTime getDataOra() 
	{
		return DataOra;
	}
	
	/**
	 * Metodo setter che permette di settare la data e l'ora dell'accesso
	 * @param dataOra che rappresenta la data e l'ora da assegnare all'accesso
	 */
	public void setDataOra(LocalDateTime dataOra) 
	{
		this.DataOra = dataOra;
	}
	
	/**
	 * Metodo ti tipo getter su un attributo statico che restituisce il valore del contatore degli accessi
	 * @return contaAccessi, che rappresenta il contatore degli accessi
	 */
	public static int getContaAccessi() {
		return contaAccessi;
	}

	/**
	 * Metodo di tipo setter che permette di settare l'attributo statico contaAccessi
	 * @param contaAccessi rappresenta il contatore statico degli accessi
	 */
	public static void setContaAccessi(int contaAccessi) {
		Accesso.contaAccessi = contaAccessi;
	}
	
	//ALTRI METODI
	/**
	 * Metodo toString che restituisce una stringa composta
	 * dalla data, l'ora, la matricola e l'identificativo dell'accesso
	 */
	public String toString()
	{
		return "Matricola: "+getMatricola()+". Data e ora: "+getDataOra()+" Id Accesso: "+getIdAccesso();
	}

	/**
	 * Metodo equals che verifica se 2 accessi sono uguali in base all'identificativo del progetto. Usato solo nel test
	 * @param accesso rappresenta l'accesso da confrontare
	 * @return true se sono uguali
	 * @return false se sono diversi
	 */
	public boolean equals(Accesso accesso)
	{
		if (getIdAccesso()==accesso.getIdAccesso())
			return true;
		else
			return false;
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
