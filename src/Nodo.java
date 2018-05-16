import java.io.Serializable;

/**
 * La classe Nodo rappresenta un nodo. Il nodo è costituito dai seguenti attributi:
 * un info e un link. Info è la componente informativa, contiene informazioni sugli elementi della lista,
 * mentre link è un puntatore che punta all'elemento successivo della lista. 
 * 
 * @author Davide Carizzoni
 * @version 1.0
 */
public class Nodo implements Serializable
{
	private Accesso info;//contiene reference a oggettto
	private Nodo link;
	
	/**
	 * Costruttore della classe nodo. Consente di istanziare un oggetto di tipo nodo.
	 * richiede un invitato, che rappresenta l'atributo info della classe nodo.
	 * 
	 * @param persona è un oggetto di tipo persona
	 */
	public Nodo(Accesso accesso)
	{
		setInfo(accesso);
		link = null;
	}
	
	/**
	 * Metodo di tipo getter che restituisce la componente informativa del nodo, ossia un Accesso
	 * @return info cge rappresenta un oggetto Accesso
	 */
	public Accesso getInfo() 
	{
		return info;
	}
	
	/**
	 * Metodo di tipo setter che permette di settare la componente informativa del nodo
	 * @param info rappresenta l'Accesso che rappresenterà la componente in formativa del nodo
	 */
	public void setInfo(Accesso info) 
	{
		this.info = new Accesso(info);
		
	}
	
	/**
	 * Metodo di tipo getter che ritorna il link del nodo
	 * @return link rappresenta il reference al nodo successivo
	 */
	public Nodo getLink()
	{
		return link;
	}

	/**
	 * Metodo setter che permette di settare il link di un nodo
	 * @param link rappresenza il reference al nodo successivo che si vuole far assumere  al nodo
	 */
	public void setLink(Nodo link)
	{
		this.link = link;
	}
}
