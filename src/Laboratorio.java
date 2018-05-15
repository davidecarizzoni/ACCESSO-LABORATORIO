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

public class Laboratorio implements Serializable
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

	//GETTER
	public int getElementi()
	{
		return elementi;
	}
	
	//ALTRI METODI
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

	//Inserimento sempre in testa
	public void registraAccesso(Accesso info)
	{
		Nodo p=creaNodo(info, head);
		head=p;
		elementi++;
	}

	public String toString()
	{
		String risultato="Head \n";
		if (elementi==0)
			return risultato+="--> ";
		Nodo p=head;
		while (p!=null)
		{
			risultato+="-->"+p.getInfo().toString()+"\n";
			p=p.getLink();
	}
		return risultato;
	}

	public void inserisciInPosizione(Accesso accesso , int posizione) throws LaboratorioException 
	{
		if(posizione==1 )
		{
			registraAccesso(accesso);
			return;
		}
		
		if(posizione<0 || posizione>elementi+1)
			throw new LaboratorioException("Posizione non valida");
		
		
		Nodo pn=creaNodo(accesso, getLinkPosizione(posizione));
		Nodo precedente=getLinkPosizione(posizione-1);
		
		precedente.setLink(pn);//il link del precedente punta a pn, che è  quello che inseriamo
		elementi++;
	}
	
	public void eliminaInTesta() throws LaboratorioException 
	{
		if(elementi==0)
			throw new LaboratorioException("Lista vuota");
		
		head=head.getLink();
		elementi--;
	}
	
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
	
	public Accesso getAcesso(int posizione) throws LaboratorioException 
	{
		if(elementi==0)
			throw new LaboratorioException("Lista vuota");
		if(posizione<0 || posizione>elementi)
			throw new LaboratorioException("Posizione non valida");
		Nodo p=getLinkPosizione(posizione);
		return p.getInfo();
	}

	

	//SERIALIAZZAZIONE E DESERIALIZZAZIONE
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
	
	public Laboratorio CaricaLaboratorio(LocalDate data) throws IOException, ClassNotFoundException
	{
		String nomeFile="";
		nomeFile=data.getDayOfMonth()+"_"+data.getMonthValue()+"_"+data.getYear();
		
		FileInputStream file=new FileInputStream(nomeFile);
		ObjectInputStream reader=new ObjectInputStream(file);
		
		Laboratorio laboratorio;
		laboratorio=(Laboratorio)reader.readObject();
		file.close();
		return laboratorio;
	}

	//SALVATAGGIO FILE DI TESTO LISTA ORDINATA PER ORA D'ACCESSO, da più vecchio a più giovane orario

	public void esportaLaboratorioCSV(LocalDate data) throws FileException, IOException, LaboratorioException
	{
		String nomeFile="";
		nomeFile="C:\\Users\\Davide Carizzoni\\Desktop\\Davide\\SCUOLA QUARTA SUPERIORE\\INFORMATICA\\JAVA\\Workspace-carizzoni\\ACCESSO LABORATORIO\\fileTXT\\"+data.getDayOfMonth()+"_"+data.getMonthValue()+"_"+data.getYear()+".txt";
		
		TextFile file=new TextFile(nomeFile,'W');
		String accessoCSV;
		Accesso accesso;
		
		for (int i = 1; i <=getElementi(); i++) 
		{
			accesso=getAcesso(i);
			accessoCSV=accesso.getDipendente().getNominativo()+";"+accesso.getDataOra()+";"+accesso.getIdAccesso()+";";
			file.toFile(accessoCSV);
		}
		file.closeFile();
	}













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
