/**
 * Classe che rappresenta un'eccezione sollevata in particolari casi.
 * L'attributo della classe è il messaggio che si vuole mostrare quando l'eccezione viene sollevata
 * @author Davide Carizzoni
 * @version 1.0
 */
public class AccessoMatricolaNotFoundException extends Exception 
{
	private String messaggio;

	/**
	 Costruttore 
	 * @param messaggio rappresenta il messaggio da mostrare
	 */
	public AccessoMatricolaNotFoundException(String messaggio)
	{
		this.messaggio=messaggio;
	}
	
	/**
	 * Metodo to string che ritorna il messaggio da mostrare al verificarsi dell'eccezione
	 */
	public String toString()
	{
		return messaggio;
	}
}
