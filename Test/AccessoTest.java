import static org.junit.Assert.*;

import java.time.LocalDateTime;

import javax.security.auth.callback.LanguageCallback;

import org.junit.Test;

public class AccessoTest 
{

	@Test
	public void testCostruttoreAccesso() 
	{
		LocalDateTime dataOra=LocalDateTime.now();
		Accesso accesso=new Accesso(1,dataOra);
		assertTrue("Costruttore Accesso",accesso.getMatricola()==1 && accesso.getIdAccesso()==1 && accesso.getDataOra()==dataOra);
	}
	
	@Test
	public void testCostruttoreAccessoDefault() 
	{
		Accesso accesso=new Accesso();
		assertTrue("Costruttore di default Accesso",accesso.getMatricola()==0 && accesso.getIdAccesso()==0 && accesso.getDataOra()==null);
	}

	@Test
	public void testSetIdAccesso() 
	{
		Accesso accesso=new Accesso();
		accesso.setIdAccesso(1);
		assertTrue("setIdAccesso",accesso.getIdAccesso()==1);
	}
	
	@Test
	public void testSetMatricola() 
	{
		Accesso accesso=new Accesso();
		accesso.setMatricola(1);
		assertTrue("setMatricola",accesso.getMatricola()==1);
	}
	
	@Test
	public void testSetDataOra() 
	{
		Accesso accesso=new Accesso();
		LocalDateTime dataOra=LocalDateTime.now();
		accesso.setDataOra(dataOra);
		assertTrue("setDataOra",accesso.getDataOra()==dataOra);
	}

}
