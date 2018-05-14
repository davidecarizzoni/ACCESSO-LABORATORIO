
public class Laboratorio
{
	//ATTRIBUTI
	private Nodo head;
	private int elementi;
	
	//COTRUTTORE
	public Laboratorio()
	{
		head=null;
		elementi=0;
	}

	public int getElementi()
	{
		return elementi;
	}
	
	private Nodo creaNodo(Accesso info, Nodo link)
	{
		Nodo nodo=new Nodo(info);
		nodo.setLink(link);
		return nodo;
	}
	
	//restituisce reference a nodo in posizione
	private Nodo getLinkPosizione(int posizione) throws LaboratorioException
	{
		
		Nodo p;
		int n;
		p=head;
		n=1;
		
		if (posizione<1 || posizione>getElementi())
			throw new LaboratorioException("Posizione non valida");
		if (elementi==0)
			throw new LaboratorioException("Lista vuota");
			
		while(p.getLink()!=null && n<posizione)
		{
			p=p.getLink();	//p va a puntare al nodo successivo
			n++;
		}
		
		return p;
	}

	public void registraAccesso(Accesso info)
	{
		Nodo p=creaNodo(info, head);
		head=p;
		elementi++;
	}






















	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

	}

}
