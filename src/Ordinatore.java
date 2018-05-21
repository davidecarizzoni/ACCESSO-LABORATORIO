import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.swing.plaf.FontUIResource;
import javax.swing.plaf.synth.SynthSeparatorUI;
/**
 * La classe Ordinatore rappresenta un ordinatore. Serve per ordinare una serie di elementi in ordine crescente o decrescente
 * 
 * @author Davide Carizzoni
 * @version 1.0
 */
public class Ordinatore 
{	
//eseguita documentazione per metodi solo sui nodi
//	<--------------------------------------------------------------NODI-------------------------------------------------------------------->
	/**
	 * Metodo che consente di scambiare due accessi del laboratorio rispettivamente in posizione 1 e posizione 2
	 * @param laboratorio rappresenta il Laboratorio sul quale si desidera effettuare lo scambio
	 * @param pos1 rappresenta la posizione del primo Accesso da scambiare
	 * @param pos2 rappresenta la posizione del secondo Acesso da scambiare
	 * @throws LaboratorioException eccezione che si verifica quando le posizioni inserite non sono valide
	 */
	//funziona quando non deve fare elimina in testa o elimina in coda
	public static void scambia(Laboratorio laboratorio, int pos1, int pos2) throws LaboratorioException 
	{
		if(pos1<=0 || pos1>laboratorio.getElementi() || pos2<=0 ||pos2>laboratorio.getElementi())
			throw new LaboratorioException("Posizioni non valide");
		Accesso a1,a2;
		a1=new Accesso(laboratorio.getAccesso(pos1));
		a2=new Accesso(laboratorio.getAccesso(pos2));
	
		laboratorio.inserisciInPosizione(a1, pos2);
		laboratorio.inserisciInPosizione(a2, pos1);
		
		laboratorio.eliminaInPosizione(pos2+2);
		laboratorio.eliminaInPosizione(pos1+1);
	}
	
	/**
	 * Metodo che consente di copiare un oggetto Laboratorio.
	 * @param laboratorio rappresenta il Laboratorio di cui si desidera creare una copia
	 * @return la copia del Laboratorio passato come parametro
	 * @throws IOException eccezione che si verifica per errori in fase di lettura o scrittura
	 * @throws ClassNotFoundException eccezione che si verifica quando non è possibile deserializzare oggetti di tipo Laboratorio
	 */
	private static Laboratorio copia(Laboratorio laboratorio) throws IOException, ClassNotFoundException 
	{
		Laboratorio l2=new Laboratorio();
		laboratorio.salvaLaboratorio("copia.bin");
		l2=l2.CaricaLaboratorio("copia.bin");
		return l2;
	}
	
	/**
	 * Metodo che permette di ordinare gli accessi di un Laboratorio in ordine crescente, quindi dal meno recente al più recente
	 * @param laboratorio rappresenta il Laboratorio da ordinare in maniera crescente
	 * @return il laboratorio ordinato 
	 * @throws ClassNotFoundException eccezione che si verifica quando non è possibile deserializzare oggetti di tipo Laboratorio
	 * @throws IOException eccezione che si verifica per errori in fase di lettura e scrittura
	 * @throws FileException eccezione che si verifica se non viene trovato il file
	 * @throws LaboratorioException eccezione che si verifica quando le posizioni non sono valide
	 */
	public static Laboratorio selectionSortCrescenteNodi(Laboratorio laboratorio) throws ClassNotFoundException, IOException, FileException, LaboratorioException
	{
		Laboratorio labCopia=copia(laboratorio);
		boolean scambioOK;
		do
		{
			scambioOK=false;
			for (int i = 1; i < labCopia.getElementi(); i++) 
			{
				if(labCopia.getAccesso(i).getDataOra().isAfter(labCopia.getAccesso(i+1).getDataOra()))
				{
					scambia(labCopia,i,i+1);
					scambioOK=true;
				}
						
					
			}
		} while (scambioOK==true);
		return labCopia;
	}
	
	/**
	 * Metodo che permette di ordinare gli accessi di un Laboratorio in ordine decrescente, quindi dal più recente al meno recente
	 * in realtà questo non è necessario dato che gli accessi vengono registrati l'orario attuale e essendo inseriti sempre in testa,
	 * rendendoli, di conseguenza, già ordinati in maniera decrescente.
	 * @param laboratorio rappresenta il Laboratorio da ordinare in maniera crescente
	 * @return il laboratorio ordinato 
	 * @throws ClassNotFoundException eccezione che si verifica quando non è possibile deserializzare oggetti di tipo Laboratorio
	 * @throws IOException eccezione che si verifica per errori in fase di lettura e scrittura
	 * @throws FileException eccezione che si verifica se non viene trovato il file
	 * @throws LaboratorioException eccezione che si verifica quando le posizioni non sono valide
	 */
	public static Laboratorio selectionSortDecrescenteNodi(Laboratorio laboratorio) throws ClassNotFoundException, IOException, FileException, LaboratorioException
	{
		Laboratorio labCopia=copia(laboratorio);
		boolean scambioOK;
		do
		{
			scambioOK=false;
			for (int i = 1; i < labCopia.getElementi(); i++) 
			{
				if(labCopia.getAccesso(i).getDataOra().isBefore(labCopia.getAccesso(i+1).getDataOra()))
				{
					scambia(labCopia,i,i+1);
					scambioOK=true;
				}
						
					
			}
		} while (scambioOK==true);
		return labCopia;
	}
	
//	<--------------------------------------------------------------NODI USANDO ARRAY-------------------------------------------------------------------->
	
	public static Accesso[] copiaInArray(Laboratorio l) throws LaboratorioException 
	{
		Accesso[] arrayCopia=new Accesso[l.getElementi()];
		for (int i = 1; i < l.getElementi()+1; i++) 
		{
			arrayCopia[i-1]=l.getAccesso(i);	
		}
		
		return arrayCopia;
	}
	
	public static Accesso[] copia(Accesso[] array)
	{
		Accesso[] arrayCopia=new Accesso[array.length];
		for (int i = 0; i < arrayCopia.length; i++) 
		{
		arrayCopia[i]=array[i];	
		}
		
		return arrayCopia;
	}
	public static Laboratorio creaLista(Accesso[] array)
	{
		Laboratorio l1=new Laboratorio();
		for (int i = 0; i < array.length; i++) 
		{
			l1.registraAccesso(array[i]);
		}
		
		return l1;
	}
	
	public static int scambia(Accesso[] array, int pos1, int pos2)
	{
		Accesso a;
		if(pos1<0 || pos1>=array.length || pos2<0 ||pos2>=array.length)
			return -1;
		a=new Accesso(array[pos1]);
		array[pos1]=new Accesso(array[pos2]);
		array[pos2]=new Accesso(a);
		return 0;
	}
	
	public static Laboratorio selectionSortCrescente(Laboratorio laboratorio) throws LaboratorioException
	{
		Accesso[] array=copiaInArray(laboratorio);
		Accesso[] arrayOrdinato=copia(array);
		for (int i = 0; i < arrayOrdinato.length-1; i++) 
		{
			for (int j = i+1; j < arrayOrdinato.length; j++) 
			{
				if(arrayOrdinato[j].getDataOra().isAfter(arrayOrdinato[i].getDataOra()))
					scambia(arrayOrdinato, i, j);
				
			}
		}
		
		Laboratorio labOrdinato=creaLista(arrayOrdinato);
		return labOrdinato;
	}
	
	public static Laboratorio selectionSortDecrescente(Laboratorio laboratorio) throws LaboratorioException
	{
		Accesso[] array=copiaInArray(laboratorio);
		Accesso[] arrayOrdinato=copia(array);
		for (int i = 0; i < arrayOrdinato.length-1; i++) 
		{
			for (int j = i+1; j < arrayOrdinato.length; j++) 
			{
				if(arrayOrdinato[j].getDataOra().isBefore(arrayOrdinato[i].getDataOra()))
					scambia(arrayOrdinato, i, j);
				
			}
		}
		
		Laboratorio labOrdinato=creaLista(arrayOrdinato);
		return labOrdinato;
	}
//<---------------------------------------------------PROVA ORDINATORE NODI----------------------------------------->	
/*	public static void main(String[] args) 
	{
		LocalDate data= LocalDate.of(2018, 5, 15);
		LocalTime ora=LocalTime.of(16,30,0);
		LocalDateTime dataOra=LocalDateTime.of(data,ora);
		
		//LocalDate data1= LocalDate.of(2018, 3, 1);
		LocalTime ora1=LocalTime.of(16,32,0);
		LocalDateTime dataOra1=LocalDateTime.of(data,ora1);

		//LocalDate data2= LocalDate.of(2018, 3, 1);
		LocalTime ora2=LocalTime.of(16,34,0);
		LocalDateTime dataOra2=LocalDateTime.of(data,ora2);
		
		
		Accesso a=new Accesso(1,dataOra);
		Accesso a1=new Accesso(2,dataOra);
		Accesso a2=new Accesso(4,dataOra1);
		Accesso a3=new Accesso(3,dataOra2);
		Accesso a4=new Accesso(1,dataOra);
		
		Laboratorio laboratorio=new Laboratorio();
		
		laboratorio.registraAccesso(a);
		laboratorio.registraAccesso(a1);
		laboratorio.registraAccesso(a2);
		laboratorio.registraAccesso(a3);
		laboratorio.registraAccesso(a4);
		
		//System.out.println(laboratorio.getElementi());
		System.out.println(laboratorio.toString());
		try 
		{
			Ordinatore.scambia(laboratorio, 1, 2);
		} 
		catch (LaboratorioException e) 
		{
			e.toString();
		}
		System.out.println(laboratorio.toString());
	}
*/
	//<------------------------------------------------------------PROVA COPIA ARRAY NODI------------------------------------------------------------>
/*	public static void main(String[] args) throws LaboratorioException 
	{
		LocalDate data= LocalDate.of(2018, 5, 15);
		LocalTime ora=LocalTime.of(16,30,0);
		LocalDateTime dataOra=LocalDateTime.of(data,ora);
		
		//LocalDate data1= LocalDate.of(2018, 3, 1);
		LocalTime ora1=LocalTime.of(16,32,0);
		LocalDateTime dataOra1=LocalDateTime.of(data,ora1);

		//LocalDate data2= LocalDate.of(2018, 3, 1);
		LocalTime ora2=LocalTime.of(16,34,0);
		LocalDateTime dataOra2=LocalDateTime.of(data,ora2);
		
		
		
		Accesso a=new Accesso(1,dataOra);
		Accesso a1=new Accesso(2,dataOra);
		Accesso a2=new Accesso(4,dataOra1);
		Accesso a3=new Accesso(3,dataOra2);
		Accesso a4=new Accesso(1,dataOra);
		
		Laboratorio laboratorio=new Laboratorio();
		
		laboratorio.registraAccesso(a);
		laboratorio.registraAccesso(a1);
		laboratorio.registraAccesso(a2);
		laboratorio.registraAccesso(a3);
		laboratorio.registraAccesso(a4);
		
		System.out.println(laboratorio.toString());
		laboratorio=Ordinatore.selectionSortDecrescente(laboratorio);
		System.out.println(laboratorio.toString());
	}
	*/
}
