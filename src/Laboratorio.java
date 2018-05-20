import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
/**
 * La classe rappresenta un Laboratotio, in particolare gli accessi dei dipendenti al laboratorio
 * gli attributi sono: il puntatore head di tipo nodo e il numero di elementi(Accessi) del laboratorio
 * La classe mette a disposizione tutti i metodi necessari per la gestione degli accessi
 *  
 * @author Davide Carizzoni
 * @version 1.0
 */
public class Laboratorio implements Serializable
{
	//ATTRIBUTI
	private Nodo head;
	private int elementi;
	
	public static final String workingDir = System.getProperty("user.dir")+"\\fileBIN\\"; //directory del progetto corrente
	
	//COTRUTTORE
	/**
	 * Metodo costruttore. Consente di creare un Laboratorio vuoto,senza alcun accesso
	 */
	public Laboratorio()
	{
		head=null;
		elementi=0;
	}

	//GETTER
	/**
	 * Metodo di tipo getter che restituisce il numero di elementi di cui è composto il Laboratorio, ossia il numero di accessi registrati
	 * @return elementi, rappresenta il numero di accessi registrati nel Laboratorio in una determinata data
	 */
	public int getElementi()
	{
		return elementi;
	}
	
	/**
	 * Metodo di tipo getter che restituisce il nodo puntato da head
	 * @return head che rappresenta il nodo puntato
	 */
	public Nodo getHead()
	{
		return head;
	}
	
	//ALTRI METODI
	/**
	 * Metodo di tipo getter che restituisce una stringa
	 * @return workingDir che rappresenta il percorso dei progeti
	 */
	public static String getDirectoryCorrente()
	{
		return workingDir;
	}
	
	/**
	 * Elenca le date presenti nel file system nella cartella fileBIN
	 * @return una stringa contenente il nome dei file salvati. Il nome del progetto coincide con la data
	 * del file binario dove sono salvati gli acessi per quella data
	 */
	//elenco dei file binari di progetto presenti nella cartella elencoProgetti
	public static String[] elencaDate()
	{
		File filesPresenti=new File(workingDir); //classe File, crea una rappresentazione astratta dei file in una directory
						
		int numeroFilesPresenti=filesPresenti.list().length;
		String[] elencoDate=new String[numeroFilesPresenti];
		elencoDate=filesPresenti.list();
		for (int i = 0; i < numeroFilesPresenti; i++)
			elencoDate[i]=elencoDate[i].substring(0, elencoDate[i].length()-4); //tolgo l'estensione.bin ai nomi dei file
		return elencoDate;		
	}
	
	/**
	 * Metodo privato che permette di creare un oggetto di nodo
	 * @param info rappresenta la componente informativa , ossia un accesso
	 * @param link rappresenta il reference al nodo successivo
	 * @return nodo, che rappreenta il nodo creato
	 */
	private Nodo creaNodo(Accesso info, Nodo link)
	{
		Nodo nodo=new Nodo(info);
		nodo.setLink(link);
		return nodo;
	}
	
	//restituisce reference a nodo in posizione
	/**
	 * Metodo privato che restituisce un oggetto di tipo nodo in una detrminata posizione
	 * @param posizione rappresenta la posizine di cui si vuole ricavare il nodo
	 * @return p che rappresenta il nodo che i ottiene nella posizione desiderata
	 * @throws LaboratorioException eccezione che si verifica quando la posizione non è valida o la lista è vuota
	 */
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

	//Inserimento sempre in testa
	/**
	 * Metodo che permette di inserire un accesso in testa
	 * @param info rappresenta la componente informativa, ossia un accesso
	 */
	public void registraAccesso(Accesso info)
	{
		Nodo p=creaNodo(info, head);//nodo p punta a heda
		head=p;//head andrà a puntare a p
		elementi++;
	}
	
	/**
	 * Metodo che permette di inserire un accesso in coda
	 * @param info rappresenta la componente informativa, ossia un accesso
	 * @throws LaboratorioException eccezione che si verifica quando la lista è vuota
	 */
	public void registraAccessoInCoda(Accesso info) throws LaboratorioException 
	{
		if(elementi==0)
		{
			registraAccesso(info);
			return;
		}
		
		Nodo pn=creaNodo(info, null);//crea nodo con dentro persona
		Nodo p=getLinkPosizione(elementi);
		p.setLink(pn);//punta a pn
		elementi++;	
	}
	
	/**
	 * Metodo che restituisce una stringa formata da tutti gli accessi con i relativi dati
	 */
	public String toString()
	{
		String risultato="";
		if (elementi==0)
			return risultato;
		Nodo p=head;
		while (p!=null)
		{
			risultato+="-->"+p.getInfo().toString()+"\n";
			p=p.getLink();
		}
		return risultato;
	}

	/**
	 * Metodo che permette di inserire un accesso,ovvero di creare un nodo in una determinata posizione della lista
	 * @param info rappresenta la componente informativa, ossia un accesso da inserire nella posizione
	 * @param posizione rappresenta la posizione nella quale inserire l'oggetto di tipo Accesso
	 * @throws LaboratorioException eccezione che si verifica se la posizione non è valida
	 */
	public void inserisciInPosizione(Accesso info , int posizione) throws LaboratorioException 
	{
		if(posizione==1 )
		{
			registraAccesso(info);
			return;
		}
		
		if(posizione<0 || posizione>elementi+1)
			throw new LaboratorioException("Posizione non valida");
		
		
		Nodo pn=creaNodo(info, getLinkPosizione(posizione));
		Nodo precedente=getLinkPosizione(posizione-1);
		
		precedente.setLink(pn);//il link del precedente punta a pn, che è  quello che inseriamo
		elementi++;
	}
	
	/**
	 * Metodo che  consente di eliminare l'elemento in testa alla lista 
	 * @throws LaboratorioException eccezione che si verifica quando la lista è vuota
	 */
	public void eliminaInTesta() throws LaboratorioException 
	{
		if(elementi==0)
			throw new LaboratorioException("Lista vuota");
		
		head=head.getLink();
		elementi--;
	}
	
	/**
	 * Metodo che consente di eliminare l'elemento in coda alla lista
	 * @throws LaboratorioException eccezione che si verifica quando la posizione è vuota
	 */
	public void eliminaInCoda() throws LaboratorioException 
	{
		if(elementi==0)
			throw new LaboratorioException("Lista vuota");
		if(elementi==1)
		{
			eliminaInTesta();
			return;
		}
		Nodo penultimo=getLinkPosizione(elementi-1);
		penultimo.setLink(null);
		elementi--;
		
	//	if(elementi==1)
	//	{
	//		eliminaInTesta();
	//		
	//	}
	//	else
	//	{
	//		Nodo penultimo=getLinkPosizione(elementi-1);
	//		penultimo.setLink(null);
	//		elementi--;
	//	}
	}
	
	/**
	 * Metodo che consente di eliminare un elemento,ossia un nodo della lista nella posizione desiderata
	 * @param posizione rappresenta la posizione nella quale si vuole effetuare l'eliminazione del nodo
	 * @throws LaboratorioException eccezione che si verifica quando la lista è vuota o la posizione non è valida
	 */
	public void eliminaInPosizione(int posizione) throws LaboratorioException
	{
		if(elementi==0)
			throw new LaboratorioException("Lista vuota");
		if(posizione<0 || posizione>elementi)
			throw new LaboratorioException("Posizione non valida");
		if(elementi==1)
		{
			eliminaInTesta();
			return;
		}
		if(posizione==elementi)
		{
			eliminaInCoda();
			return;
		}
		Nodo p=getLinkPosizione(posizione);
		Nodo precedente=getLinkPosizione(posizione-1);
		precedente.setLink(p.getLink());
	//	else
	//	{
	//		Nodo p=getLinkPosizione(posizione);
	//		Nodo precedente=getLinkPosizione(posizione-1);
	//		precedente.setLink(p.getLink());
	//	}
	}
	
	/**
	 * Metodo che permette di recuperare i dati dell'accesso in una determinata posizione
	 * @param posizione rappresenta la posizione nella quale si desidera recuperare i dati
	 * @return i dati dell'accesso nella posizione desoderata
	 * @throws LaboratorioException eccezione che si verifica quando la lista è vuota o la posizione non è valida
	 */
	public Accesso getAccesso(int posizione) throws LaboratorioException 
	{
		if(elementi==0)
			throw new LaboratorioException("Lista vuota");
		if(posizione<0 || posizione>elementi)
			throw new LaboratorioException("Posizione non valida");
		Nodo p=getLinkPosizione(posizione);
		return p.getInfo();
	}
/*
	public boolean verificaPresenza(int matricola) throws LaboratorioException
	{
		boolean presenza=false;
		for (int i = 1; i < getElementi()+1; i++) 
		{
			if(matricola==getAccesso(i).getMatricola())
				presenza=true;
		}
		return presenza;
	}
	*/
	
	/**
	 * Metodo che consente di verificare la presenza di un dipendente in un determinato giorno inserendo la matricola
	 * @param matricola rappresenta la matricola del dipendente di cui si vuole verificare la presenza
	 * @return true se la presenza è verificata
	 * @throws LaboratorioException eccezione che si verifica se la lista è vuota
	 * @throws AccessoMatricolaNotFoundException eccezione sollevata quando non viene verificata la presenza di un dipendente in una determinata giornata
	 */
	public boolean verificaPresenza(int matricola) throws LaboratorioException, AccessoMatricolaNotFoundException
	{
		
		for (int i = 1; i < getElementi()+1; i++) 
		{
			if(matricola==getAccesso(i).getMatricola())
				return true;
		}
		throw new AccessoMatricolaNotFoundException("Nessun accesso presente per il dipendente con matricola " +matricola+ " ");
	
	}
	
	//SERIALIAZZAZIONE E DESERIALIZZAZIONE
	/**
	 * Metodo che consente di salvare il laboratorio in un file binario
	 * @param data rappresenta la data di cui si desidera salvare gliaccessi, ossia il laboratorio
	 * @throws IOException eccezione che si verifica per errori nella scrittura del file
	 */
	public void salvaLaboratorio(LocalDate data) throws IOException
	{
		String nomeFile="";
		nomeFile="C:\\Users\\Davide Carizzoni\\Desktop\\Davide\\SCUOLA QUARTA SUPERIORE\\INFORMATICA\\JAVA\\Workspace-carizzoni\\ACCESSO LABORATORIO\\fileBIN\\"+data.getDayOfMonth()+"_"+data.getMonthValue()+"_"+data.getYear()+".bin";
		
		FileOutputStream file=new FileOutputStream(nomeFile);
		ObjectOutputStream writer=new ObjectOutputStream(file);
		
		writer.writeObject(this);
		writer.flush();
		writer.close();
		
	}
	
	/**
	 * Metodo che consente di caricare un'oggetto ti tipo laboratorio effettuandone la deserializzazione da file binario
	 * @param data rappresenta la data del file binario da deserializzare
	 * @return il Laboratorio
	 * @throws IOException eccezione che si verifica per errori durante il caricamento del laboratorio
	 * @throws ClassNotFoundException eccezione che si verifica quando non è possibile deserializzare oggetti di tipo Laboratorio
	 */
	public Laboratorio CaricaLaboratorio(LocalDate data) throws IOException, ClassNotFoundException
	{
		String nomeFile="";
		nomeFile="C:\\Users\\Davide Carizzoni\\Desktop\\Davide\\SCUOLA QUARTA SUPERIORE\\INFORMATICA\\JAVA\\Workspace-carizzoni\\ACCESSO LABORATORIO\\fileBIN\\"+data.getDayOfMonth()+"_"+data.getMonthValue()+"_"+data.getYear()+".bin";
		
		FileInputStream file=new FileInputStream(nomeFile);
		ObjectInputStream reader=new ObjectInputStream(file);
		
		Laboratorio laboratorio;
		laboratorio=(Laboratorio)reader.readObject();
		file.close();
		return laboratorio;
	}
	/**
	 * Metodo che consente di salvare il laboratorio in un file binario
	 * @param nomeFile rappresenta il nome del file sul quale si vuole salvare l'oggetto
	 * @throws IOException eccezione che si verifica per errori nella scrittura del file
	 */
	public void salvaLaboratorio(String nomeFile) throws IOException
	{
		FileOutputStream file=new FileOutputStream(nomeFile);
		ObjectOutputStream writer=new ObjectOutputStream(file);
		
		writer.writeObject(this);
		writer.flush();
		writer.close();
		
	}
	
	/**
	 *  Metodo che consente di caricare un'oggetto ti tipo laboratorio effettuandone la deserializzazione da file binario
	 * @param nomeFile rappresenta il file da cui si effettua la deserializzazione
	 * @return il Laboratorio
	 * @throws IOException eccezione che si verifica per errori durante il caricamento del laboratorio
	 * @throws ClassNotFoundException eccezione che si verifica quando non è possibile deserializzare oggetti di tipo Laboratorio
	 */
	public Laboratorio CaricaLaboratorio(String nomeFile) throws IOException, ClassNotFoundException
	{
		FileInputStream file=new FileInputStream(nomeFile);
		ObjectInputStream reader=new ObjectInputStream(file);
		
		Laboratorio laboratorio;
		laboratorio=(Laboratorio)reader.readObject();
		file.close();
		return laboratorio;
	}
	//SALVATAGGIO FILE DI TESTO LISTA ORDINATA PER ORA D'ACCESSO, da più vecchio a più giovane orario

	/**
	 * Metodo che permette di salvare i dati del Laboratorio su un file di testo in formato CSV
	 * @param data rappresenta la data per la quale si vogliono slavare gli accessi
	 * @throws IOException eccezione che si verifica per errori durante la scrittura su file
	 * @throws FileException ecczione che si verifica se si prova a leggere
	 * @throws LaboratorioException eccezione che si verifica se la lista di cui si vogliono salvare i dati è vuota
	 */
	public void esportaLaboratorioCSV(LocalDate data) throws  IOException, LaboratorioException, FileException
	{
		String nomeFile="";
		nomeFile="C:\\Users\\Davide Carizzoni\\Desktop\\Davide\\SCUOLA QUARTA SUPERIORE\\INFORMATICA\\JAVA\\Workspace-carizzoni\\ACCESSO LABORATORIO\\fileTXT\\"+data.getDayOfMonth()+"_"+data.getMonthValue()+"_"+data.getYear()+".txt";
		
		TextFile file=new TextFile(nomeFile,'W');
		String accessoCSV;
		Accesso accesso;
		if(getElementi()==0)
			throw new LaboratorioException("Lista vuota, impossibile completare l'operazione");
			
		for (int i = 1; i <=getElementi(); i++) 
		{
			accesso=getAccesso(i);
			accessoCSV=accesso.getMatricola()+";"+accesso.getDataOra()+";"+accesso.getIdAccesso()+";";
			file.toFile(accessoCSV);
		}
		file.closeFile();
	}




/*
	public static void main(String[] args) throws LaboratorioException 
	{
		Laboratorio laboratorio=new Laboratorio();
		LocalDate data= LocalDate.of(2018, 3, 1);
		LocalTime ora=LocalTime.of(16,30,0);
		LocalDateTime dataOra=LocalDateTime.of(data,ora);
		Accesso a=new Accesso(1,dataOra);
		laboratorio.registraAccesso(a);
		System.out.println(laboratorio.toString());
		String risultato1=a.toString();
		String risultato=laboratorio.toString();
		System.out.println(risultato);
		
		if(laboratorio.toString().compareTo(risultato)==0)
			System.out.println("OK");
		else
			System.out.println("NO");
	
	}
	*/







/*	public static void main(String[] args) 
	{
		LocalDate data= LocalDate.of(2018, 3, 1);
		LocalTime ora=LocalTime.of(16,30,0);
		LocalDateTime dataOra=LocalDateTime.of(data,ora);
		
		//LocalDate data1= LocalDate.of(2018, 3, 1);
		LocalTime ora1=LocalTime.of(16,32,0);
		LocalDateTime dataOra1=LocalDateTime.of(data,ora1);

		//LocalDate data2= LocalDate.of(2018, 3, 1);
		LocalTime ora2=LocalTime.of(16,34,0);
		LocalDateTime dataOra2=LocalDateTime.of(data,ora2);
		
		Dipendente d=new Dipendente(1,"Davide");
		Dipendente d1=new Dipendente(2,"Diego");
		Dipendente d2=new Dipendente(3,"Luca");
		
		Accesso a=new Accesso(d,dataOra);
		Accesso a1=new Accesso(d1,dataOra);
		Accesso a2=new Accesso(d2,dataOra1);
		Accesso a3=new Accesso(d1,dataOra2);
		Accesso a4=new Accesso(d,dataOra);
		
		Laboratorio laboratorio=new Laboratorio();
		laboratorio.registraAccesso(a1);
		laboratorio.registraAccesso(a3);
		laboratorio.registraAccesso(a2);
		laboratorio.registraAccesso(a4);
		
		System.out.println(laboratorio.toString());
		try 
		{
			laboratorio.salvaLaboratorio(data);
			System.out.println("Salvataggio avvenuto con successo");
		} 
		catch (IOException e) 
		{
			System.out.println("Impossibile scrivere su file");
		}
		
	}*/
	

}
