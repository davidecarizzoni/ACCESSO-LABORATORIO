import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
	 * @return
	 * @throws NumberFormatException inserimento dato non conforme
	 * @throws IOException impossibile leggere da dispositivo input
	 * return valore intero letto
	 */
	public int readInt() throws NumberFormatException, IOException
	{
		return(Integer.parseInt(reader.readLine())); 
		//il metodo readLine restituisce una stringa che viene poi convertita nel tipo di dato voluto con il metodo Parse, o charAt(per il char)
		//readLine può causare ecezione di tipo IOException, checkhed anche se avviene difficilmente con acquisimento da tastiera e più spesso quando si prendono dati da file
		//quando tipo di dato inserito è diverso da ciò che si aspetta--> NumberFormatException, (Runtime Exception, unchecked)
	}
	
	/**
	 * @return
	 * @throws NumberFormatException inserimento dato non conforme
	 * @throws IOException impossibile leggere da dispositivo input
	 * return valore short letto
	 */
	public short readShort() throws NumberFormatException, IOException
	{
		return(Short.parseShort(reader.readLine()));
	}
	
	/**
	 * @return
	 * @throws NumberFormatException inserimento dato non conforme
	 * @throws IOException impossibile leggere da dispositivo input
	 * return valore long letto
	 */
	public long readLong() throws NumberFormatException, IOException
	{
		return(Long.parseLong(reader.readLine()));
	}
	
	/**
	 * @return
	 * @throws NumberFormatException inserimento dato non conforme
	 * @throws IOException impossibile leggere da dispositivo input
	 * return valore Byte letto
	 */
	public byte readByte() throws NumberFormatException, IOException
	{
		return(Byte.parseByte(reader.readLine()));
	}
	
	/**
	 * @return
	 * @throws NumberFormatException inserimento dato non conforme
	 * @throws IOException impossibile leggere da dispositivo input
	 * return valore float letto
	 */
	public float readFloat() throws NumberFormatException, IOException
	{
		return(Float.parseFloat(reader.readLine()));
	}
	
	/**
	 * @return
	 * @throws NumberFormatException inserimento dato non conforme
	 * @throws IOException impossibile leggere da dispositivo input
	 * return valore double letto
	 */
	public double readDouble() throws NumberFormatException, IOException
	{
		return(Double.parseDouble(reader.readLine()));
	}
	
	/**
	 * @return
	 * @throws NumberFormatException inserimento dato non conforme
	 * @throws IOException impossibile leggere da dispositivo input
	 * return valore boolean letto
	 */
	public boolean readBoolean() throws NumberFormatException, IOException
	{
		return(Boolean.parseBoolean(reader.readLine()));
	}
	
	/**
	 * @return
	 * @throws NumberFormatException inserimento dato non conforme
	 * @throws IOException impossibile leggere da dispositivo input
	 * return carattere letto
	 */
	public char readChar() throws NumberFormatException, IOException
	{
		return(reader.readLine().charAt(0)); //prendo solo il primo carattere dei dati,della stringa inserita
	}
	
	/**
	 * @return
	 * @throws NumberFormatException inserimento dato non conforme
	 * @throws IOException impossibile leggere da dispositivo input
	 * return Stringa letta
	 */
	public String readString() throws NumberFormatException, IOException
	{
		return(reader.readLine());
	}
	
	
}

