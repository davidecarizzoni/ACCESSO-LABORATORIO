
public class AccessoMatricolaNotFoundException extends Exception 
{
	private String messaggio;
	public AccessoMatricolaNotFoundException(String messaggio)
	{
		this.messaggio=messaggio;
	}
	public String toString()
	{
		return messaggio;
	}
}
