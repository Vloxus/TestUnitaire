package fr.renater.idegest.tu;

import static org.junit.Assert.*;

import java.io.IOException;
import java.text.Normalizer;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

public class GestAjoutUsersTest extends TestCase{

	private GestAjoutUsers gau;  
	@Before
	public void setUp() throws Exception {
		 try {
		      this.gau = new GestAjoutUsers("testusers.xml");   
		    } catch (IOException e) {
		      fail("Création de l'OUT impossible !");
		    }
	}

	@Test
	  public void test2PremiersCarsGenUid() {
	    String uid = this.gau.genUid("Bob", "Martin");                      
	    assertTrue("Les 2 premiers caractères sont valides", uid.startsWith("bm"));  
	  }
	
	@Test
	  public void test2PremiersCarsGenUidBis() {
	    String uid = this.gau.genUid("Bob", "Martin");                 // 1
	    String premscar = uid.substring(0, 2);                         // 2
	    assertEquals("Les 2 premiers caractères sont valides", "bm", premscar); // 3
	  }
	
	 @Test
	  public void testMinuscule() {
	    String uid = this.gau.genUid("Bob", "Martin");                 // 1
	    String minuscule = uid.toLowerCase();                         // 2
	    assertEquals("Les caractéres sont minuscules", "bmartin", minuscule); // 3
	  }	
	 
	 @Test
	  public void testBonNombresCaracteres() 	{
	    String uid = this.gau.genUid("Bob", "Martin");                 // 1
	    int chaine = uid.length();
	    if ((chaine > 4 ) && ( chaine < 10 )) 	{
	    	assertEquals("Il y a entre 5 et 8 caractéres", "bmartin", uid);	
	    										}
	   else {
		    assertEquals("Il n'y a pas entre 5 et 8 caractéres", "bmartin", uid);	
	   		}
	    
	 } 
	 /*@Test
	 public void SpecialCharacters() 	{
		 String uid = this.gau.genUid("Bob", "Martin");
		 String normaliser = Normalizer.normalize(uid,  Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiatricalMarks}+", "");
				
		 assertEquals("pas de caractére indésirables", "bmartin",normaliser );
		 
		 
		 										}*/
	 @Test
	 public void testAddUser(){
		 User user;
		 User user2;
		 
		 user = gau.addUser("Bob",  "Martin");
		 System.out.println(""+user);
		 user2 = gau.addUser("Bob",  "Martin");
		 System.out.println(""+user2);
		 assertEquals("pas de caractére indésirables", "bmartin",user.getLogin() );
		 assertEquals("pas de caractére indésirables", "bmartin",user2.getLogin());
	 }
	 
	 
	  
	 

}
		 
		
		

	

 