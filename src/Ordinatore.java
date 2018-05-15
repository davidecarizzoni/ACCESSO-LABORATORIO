import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class Ordinatore 
{	
	//<-------------------INTERI---------------->
	public static int scambia(int[] array, int pos1, int pos2)
	{
		int s;
		if(pos1<0 || pos1>=array.length || pos2<0 ||pos2>=array.length)
			return -1;
		s=array[pos1];
		array[pos1]=array[pos2];
		array[pos2]=s;
		return 0;
	}
	
	public static int[] copia(int[] array)
	{
		int[] arrayCopia=new int[array.length];
		for (int i = 0; i < arrayCopia.length; i++) 
		{
		arrayCopia[i]=array[i];	
		}
		
		return arrayCopia;
	}
	
	public static int[] selectionSortCrescente(int[] array)
	{
		int[] arrayOrdinato=copia(array);
		for (int i = 0; i < arrayOrdinato.length-1; i++) 
		{
			for (int j = i+1; j < arrayOrdinato.length; j++) 
			{
				if(arrayOrdinato[j]<arrayOrdinato[i])
					scambia(arrayOrdinato, i, j);
			}
		}
		return arrayOrdinato;
	}
	
	public static int[] selectionSortDecrescente(int[] array)
	{
		int[] arrayOrdinato=copia(array);
		for (int i = 0; i < arrayOrdinato.length-1; i++) 
		{
			for (int j = i+1; j < arrayOrdinato.length; j++) 
			{
				if(arrayOrdinato[j]>arrayOrdinato[i])
					scambia(arrayOrdinato, i, j);
			}
		}
		return arrayOrdinato;
	}
	
	
	//<-----------------STRINGHE------------------->
	public static int scambia(String[] array, int pos1, int pos2)
	{
		String s;
		if(pos1<0 || pos1>=array.length || pos2<0 ||pos2>=array.length)
			return -1;
		s=array[pos1];
		array[pos1]=array[pos2];
		array[pos2]=s;
		return 0;
	}
	public static String[] copia(String[] array)
	{
		String[] arrayCopia=new String[array.length];
		for (int i = 0; i < arrayCopia.length; i++) 
		{
		arrayCopia[i]=array[i];	
		}
		
		return arrayCopia;
	}
	public static String[] selectionSortCrescente(String[] array)
	{
		String[] arrayOrdinato=copia(array);
		for (int i = 0; i < arrayOrdinato.length-1; i++) 
		{
			for (int j = i+1; j < arrayOrdinato.length; j++) 
			{
				if(arrayOrdinato[j].compareTo(arrayOrdinato[i])<0)
					scambia(arrayOrdinato, i, j);
			}
		}
		return arrayOrdinato;
	}
	public static String[] selectionSortDecrescente(String[] array)
	{
		String[] arrayOrdinato=copia(array);
		for (int i = 0; i < arrayOrdinato.length-1; i++) 
		{
			for (int j = i+1; j < arrayOrdinato.length; j++) 
			{
				if(arrayOrdinato[j].compareTo(arrayOrdinato[i])>0)
					scambia(arrayOrdinato, i, j);
			}
		}
		return arrayOrdinato;
	}
	
//	<--------------------------------------------------------------NODI-------------------------------------------------------------------->
	//funziona quando non deve fare elimina in testa o elimina in coda
	public static void scambia(Laboratorio laboratorio, int pos1, int pos2) throws LaboratorioException 
	{
		if(pos1<=0 || pos1>laboratorio.getElementi() || pos2<=0 ||pos2>laboratorio.getElementi())
			throw new LaboratorioException("Posizioni non valide");
		Accesso a1,a2;
		a1=new Accesso(laboratorio.getAcesso(pos1));
		a2=new Accesso(laboratorio.getAcesso(pos2));
		
	//	System.out.println(a1.toString());
	//	System.out.println(a2.toString());
		
		laboratorio.eliminaInPosizione(pos2);
	//	System.out.println(laboratorio.toString());
		laboratorio.eliminaInPosizione(pos1);
	//	System.out.println(laboratorio.toString());
		
		
		laboratorio.inserisciInPosizione(a2, pos1);
	//	System.out.println(laboratorio.toString());
		laboratorio.inserisciInPosizione(a1, pos2);
	//	System.out.println(laboratorio.toString());
		//s=array[pos1];
		//array[pos1]=array[pos2];
		//array[pos2]=s;
		//return 0;
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
		
		Dipendente d=new Dipendente(1,"Davide");
		Dipendente d1=new Dipendente(2,"Diego");
		Dipendente d2=new Dipendente(3,"Luca");
		
		Accesso a=new Accesso(d,dataOra);
		Accesso a1=new Accesso(d2,dataOra);
		Accesso a2=new Accesso(d2,dataOra1);
		Accesso a3=new Accesso(d1,dataOra2);
		Accesso a4=new Accesso(d,dataOra);
		
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
			Ordinatore.scambia(laboratorio, 2, 3);
		} 
		catch (LaboratorioException e) 
		{
			e.toString();
		}
		System.out.println(laboratorio.toString());
	}
*/
}
