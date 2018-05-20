import java.io.IOException;
/**
 * Rappresenta un menu. Consente di Creare un menu con delle voci numeriche e di effettuare i controlli sulla
 * correttezza del dato inserito da parte dell'utente. Consente all'utente di inserire solamente valori numerici compresi fra 
 * 0 e (numero di voci del menu)-1. In caso di inserimento non corrretto o non conforme al formato richiesto
 * l'utente viene invitato ad eseguire nuovamente la scelta.
 * Gli attributi sono: una stringa che rappresenta il titolo(il nome)del menu', un elenco di stringhe che rappresentano le varie voci del menu', 
 * un intero che rappresenta il numero di voci di cui è composto il menu'.
 * 
 * @author Davide Carizzoni
 * @version 1.0
 */
public class Menu
{
	//ATTRIBUTI
	private String titolo;
	private String[] elencoVoci;
	private int numeroVociMenu;
	
	/**
	 * Costruttore
	 * @param elencoVoci Array rappresenta un array di stringhe di cui ogni elemento rappresenta una voce del menu da costruire
	 */
	//COSTRUTTORE
	public Menu(String titolo, String[] elencoVoci)
	{
		this.titolo=titolo;
		numeroVociMenu=elencoVoci.length;
		this.elencoVoci=new String[numeroVociMenu];
		for (int i = 0; i < numeroVociMenu; i++) 
		{
			this.elencoVoci[i]=elencoVoci[i];
		}
	}
	
	//ALTRI METODI
	/**
	 * Visualizza sul monitor tutte le voci del menu
	 */
	public void visualizza() //visualizzazione scelte del menu
	{
		for (int i = 0; i < numeroVociMenu; i++) 
		{
			System.out.println(elencoVoci[i]);
		}
		
	}
	
	/**
	 * Consente all'utente di scegliere fra una delle voci numeriche del menu. In caso di scelta non corretta 
	 * o formato del dato inserito non conforme l'utente deve effettuare nuovamente la propria scelta.
	 * @return Il numero intero che corrispondente alla voce del menu scelta dall'utente.
	 */
	public int scelta() //scelta operazione contenuta nell'elenco menu
	{
		ConsoleInput tastiera=new ConsoleInput();
		int scelta=-1;
		while(scelta<0 ||scelta>=numeroVociMenu)
		{
			visualizza();
			System.out.print("Scegli l'operazione: ");
			try 
			{
				scelta=tastiera.readInt();
				if(scelta>=numeroVociMenu|| scelta<0)
				{
					System.out.println("Opzione non disponibile, reinserire");
				}
			} 
			catch (NumberFormatException e) 
			{
				System.out.println("Formato dato inserito errato, reinserire");
			} 
			catch (IOException e) 
			{
				System.out.println("Impossibile leggere dal dispositivo di input");
			}
		}
		return scelta;
	}
}
