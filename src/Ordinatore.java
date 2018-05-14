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
}
