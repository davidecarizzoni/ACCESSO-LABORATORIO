
public class LaboratorioException extends Exception 
{
	private String messaggio;
	 
	public LaboratorioException(String messaggio)
	{
		this.messaggio=messaggio;
	}
	
	public String toString()
	{
		return messaggio;
	}
}
