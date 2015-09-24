/**
 * 
 * @author Chris Hanson
 * @author Gautam Batra
 * 
 */
package edu.worcester.cs.kwurst;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StudentTest {
	private Student student1;
	

	@Before
	public void setUp() throws Exception {
		student1 = new Student ("Jane", "Smith");
	}

	@Test
	public void testGetCurrentEarnedCr() {
		int credits = 45;
		student1.setCurrentEarnedCr(credits);
		assertEquals(credits, student1.getCurrentEarnedCr());
	}
	@Test
	public void testGetAdditionalAnticipatedCr(){
		int anticipatedCr = 10;
		student1.setAnticipatedAdditionalCr(anticipatedCr);
		assertEquals(anticipatedCr, student1.getAnticipatedAdditionalCr());
	}
	@Test
	public void testReadyToGraduate1(){
		student1.setCurrentEarnedCr(120);
		student1.setGpa(2.0);
		student1.setMajorComplete(true);
		student1.setLascComplete(true);
		assertTrue(student1.readyToGraduate());
	}
	@Test
	public void testNotReadyToGraduate2(){
		student1.setCurrentEarnedCr(110);
		student1.setGpa(2.0);
		student1.setMajorComplete(true);
		student1.setLascComplete(true);
		assertFalse(student1.readyToGraduate());
	}
	@Test
	public void testNotReadyToGraduate3(){
		student1.setCurrentEarnedCr(120);
		student1.setGpa(0.0);
		student1.setMajorComplete(true);
		student1.setLascComplete(true);
		assertFalse(student1.readyToGraduate());
	}
	@Test
	public void testNotReadyToGraduate4(){
		student1.setCurrentEarnedCr(120);
		student1.setGpa(2.0);
		student1.setMajorComplete(false);
		student1.setLascComplete(true);
		assertFalse(student1.readyToGraduate());
	}
	@Test
	public void testNotReadyToGraduate5(){
		student1.setCurrentEarnedCr(120);
		student1.setGpa(2.0);
		student1.setMajorComplete(true);
		student1.setLascComplete(false);
		assertFalse(student1.readyToGraduate());
	}
	@Test
	public void testReadyToGraduate6(){
		student1.setCurrentEarnedCr(130);
		student1.setGpa(2.0);
		student1.setMajorComplete(true);
		student1.setLascComplete(true);
		assertTrue(student1.readyToGraduate());
	}
	@Test
	public void testGetCurrentRemaining1(){
		student1.setCurrentEarnedCr(20);
		assertEquals(100, student1.getCurrentRemainingCr());
	}
	@Test
	public void testGetCurrentRemaining2(){
		student1.setCurrentEarnedCr(120);
		assertEquals(0, student1.getCurrentRemainingCr());
	}
	@Test
	public void testGetCurrentRemaining3(){
		student1.setCurrentEarnedCr(130);
		assertEquals(0, student1.getCurrentRemainingCr());
	}
	@Test
	public void testGetGpa(){
		student1.setGpa(2.0);
		assertEquals(2.0, student1.getGpa(), 0.0);
	}
	@Test
	public void testGetFirstName(){
		student1.setFirstName("Joe");
		assertEquals("Joe", student1.getFirstName());
	}
	@Test
	public void testGetLastName(){
		student1.setLastName("Shmoe");
		assertEquals("Shmoe", student1.getLastName());
	}
	@Test
	public void testGetId(){
		String currentId = student1.getId();
		Student student2 = new Student("Bob", "Clark");
		int x = Integer.parseInt(currentId);
		x = x + 1;		
		currentId = String.format("%07d",x);
		assertEquals(currentId, student2.getId());
	}
	@Test
	public void testGetStudentCount(){
		int count = Student.getStudentCount();
		Student student2 = new Student ("Bob", "Clark");
		assertEquals(count +1, Student.getStudentCount());
	}
	@Test
	public void testGetLascComplete1(){
		student1.setLascComplete(true);
		assertTrue(student1.getLascComplete());
	}
	@Test
	public void testGetLascComplete2(){
		student1.setLascComplete(false);
		assertFalse(student1.getLascComplete());
	}
    @Test
	public void testGetMajorComplete1(){
		student1.setMajorComplete(true);
		assertTrue(student1.getMajorComplete());
	}
	@Test
	public void testGetMajorComplete2(){
		student1.setMajorComplete(false);
		assertFalse(student1.getMajorComplete());
	}

}
