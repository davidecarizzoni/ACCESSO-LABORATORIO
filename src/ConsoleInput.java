import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Classe per le operazioni di input dalla tastiera
 * @author Davide Carizzoni
 * @version 1.0
 */
public class ConsoleInput 
{
	private InputStreamReader input;
	private BufferedReader reader;
	
	/**
	 * Costruttore
	 */
	public ConsoleInput()
	{
		input=new InputStreamReader(System.in);
		reader=new BufferedReader(input);
	}
	
	/**
	 * @return valore intero letto
	 * @throws NumberFormatException inserimento dato non conforme
	 * @throws IOException impossibile leggere da dispositivo input
	 */
	public int readInt() throws NumberFormatException, IOException
	{
		return(Integer.parseInt(reader.readLine())); 
		//il metodo readLine restituisce una stringa che viene poi convertita nel tipo di dato voluto con il metodo Parse, o charAt(per il char)
		//readLine può causare ecezione di tipo IOException, checkhed anche se avviene difficilmente con acquisimento da tastiera e più spesso quando si prendono dati da file
		//quando tipo di dato inserito è diverso da ciò che si aspetta--> NumberFormatException, (Runtime Exception, unchecked)
	}
	
	/** 
	 * @return  valore short letto
	 * @throws NumberFormatException inserimento dato non conforme
	 * @throws IOException impossibile leggere da dispositivo input
	 */
	public short readShort() throws NumberFormatException, IOException
	{
		return(Short.parseShort(reader.readLine()));
	}
	
	/**
	 * @return valore long letto
	 * @throws NumberFormatException inserimento dato non conforme
	 * @throws IOException impossibile leggere da dispositivo input
	 */
	public long readLong() throws NumberFormatException, IOException
	{
		return(Long.parseLong(reader.readLine()));
	}
	
	/**
	 * @return valore Byte letto
	 * @throws NumberFormatException inserimento dato non conforme
	 * @throws IOException impossibile leggere da dispositivo input
	 */
	public byte readByte() throws NumberFormatException, IOException
	{
		return(Byte.parseByte(reader.readLine()));
	}
	
	/**
	 * @return valore float letto
	 * @throws NumberFormatException inserimento dato non conforme
	 * @throws IOException impossibile leggere da dispositivo input * return 
	 */
	public float readFloat() throws NumberFormatException, IOException
	{
		return(Float.parseFloat(reader.readLine()));
	}
	
	/**
	 * @return valore double letto
	 * @throws NumberFormatException inserimento dato non conforme
	 * @throws IOException impossibile leggere da dispositivo input
	 */
	public double readDouble() throws NumberFormatException, IOException
	{
		return(Double.parseDouble(reader.readLine()));
	}
	
	/**
	 * @return valore boolean letto
	 * @throws NumberFormatException inserimento dato non conforme
	 * @throws IOException impossibile leggere da dispositivo input
	 */
	public boolean readBoolean() throws NumberFormatException, IOException
	{
		return(Boolean.parseBoolean(reader.readLine()));
	}
	
	/**
	 * @return carattere letto
	 * @throws NumberFormatException inserimento dato non conforme
	 * @throws IOException impossibile leggere da dispositivo input
	 */
	public char readChar() throws NumberFormatException, IOException
	{
		return(reader.readLine().charAt(0)); //prendo solo il primo carattere dei dati,della stringa inserita
	}
	
	/**
	 * @return Stringa letta
	 * @throws NumberFormatException inserimento dato non conforme
	 * @throws IOException impossibile leggere da dispositivo input
	 */
	public String readString() throws NumberFormatException, IOException
	{
		return(reader.readLine());
	}
	
	
}

