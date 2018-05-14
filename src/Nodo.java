/**
 * La classe Nodo rappresenta un nodo. Il nodo � costituito dai seguenti attributi:
 * un info e un link. Info � la componente informativa, contiene informazioni sugli elementi della lista,
 * mentre link � un puntatore che punta all'elemento successivo della lista. 
 * 
 * @author Davide Carizzoni
 * @version 1.0
 */
public class Nodo 
{
	private Accesso info;//contiene reference a oggettto
	private Nodo link;
	
	/**
	 * Costruttore della classe nodo. Consente di istanziare un oggetto di tipo nodo.
	 * richiede un invitato, che rappresenta l'atributo info della classe nodo.
	 * 
	 * @param persona � un oggetto di tipo persona
	 */
	public Nodo(Accesso accesso)
	{
		setInfo(accesso);
		link = null;
	}
	
	public Accesso getInfo() 
	{
		return info;
	}

	public void setInfo(Accesso info) 
	{
		this.info = new Accesso(info);
		
	}

	public Nodo getLink()
	{
		return link;
	}

	public void setLink(Nodo link)
	{
		this.link = link;
	}
}
