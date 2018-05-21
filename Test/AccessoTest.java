import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.AfterClass;
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
//  il test viene commentato perchè essendo statico, agisce su tutti gli oggetti della classe accesso, facendo fallire 
//  il test del metodo costruttore in quanto pone l'idAccesso=3
//il test non provoca fallimenti nel costruttore se si setta l'attributo con il valore '0' essendo utilizzato per la costruzione del primo oggetto della classe accesso	
	@Test
	public void testSetContaAccessi() 
	{
		Accesso.setContaAccessi(0);
		assertTrue("setIdAccesso",Accesso.getContaAccessi()==0);
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
	
	@Test
	public void testEquals() 
	{
		LocalDateTime dataOra=LocalDateTime.now();
		Accesso accesso=new Accesso(1,dataOra);
		Accesso accesso1=new Accesso(accesso);
		assertTrue("setEquals",accesso.equals(accesso1)==true);
	}
	

}
