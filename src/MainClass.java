import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class MainClass 
{

	public static void main(String[] args) 
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
		Accesso a1=new Accesso(d1,dataOra);
		Accesso a2=new Accesso(d2,dataOra1);
		Accesso a3=new Accesso(d1,dataOra2);
		Accesso a4=new Accesso(d,dataOra);
		
		Laboratorio laboratorio=new Laboratorio();
		laboratorio.registraAccesso(a1);
		laboratorio.registraAccesso(a3);
		laboratorio.registraAccesso(a2);
		laboratorio.registraAccesso(a4);
		laboratorio.registraAccesso(a);
		
		System.out.println(laboratorio.toString());
		try 
		{
			laboratorio.salvaLaboratorio(data);
			System.out.println("Salvataggio su file binario avvenuto con successo");
		} 
		catch (IOException e) 
		{
			System.out.println("Impossibile scrivere su file");
		}

		
			try
			{
				laboratorio.esportaLaboratorioCSV(data);
				System.out.println("Salvataggio su file di testo avvenuto con successo");
			} 
			catch (LaboratorioException e) 
			{
				System.out.println(e.toString());
			} 
			catch (FileException e) 
			{
				System.out.println(e.toString());
			} 
			catch (IOException e) 
			{
				System.out.println("Impossibile scriver su file");

			}
		
	}

}
