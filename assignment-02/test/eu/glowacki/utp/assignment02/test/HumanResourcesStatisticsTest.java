package eu.glowacki.utp.assignment02.test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import eu.glowacki.utp.assignment02.employee.Trainee;
import eu.glowacki.utp.assignment02.employee.Worker;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import eu.glowacki.utp.assignment02.HumanResourcesStatistics;
import eu.glowacki.utp.assignment02.employee.Employee;
import eu.glowacki.utp.assignment02.employee.Manager;
import eu.glowacki.utp.assignment02.payroll.PayrollEntry;

public class HumanResourcesStatisticsTest {
	
	// Create a HR structure which resembles the below one:
	//
	// Director (an instance of Manager class (Director does not have a manager)
	//   |- Manager01
	//        |- Worker
	//        |- Worker
	//        |- Trainee
	//        |- ...
	//   |- Manager02
	//        |- ...
	//   |- ...
	//   |- Worker
	//   |- Worker
	//   |- Trainee
	Manager director =new Manager("Aksel","Ozgur", LocalDate.of(1970,6,17),new BigDecimal("20000"),
			null,LocalDate.of(1990,3,7),new BigDecimal("0"));
	Manager manager1 =new Manager("Nuray","Ozgur", LocalDate.of(1972,5,18),new BigDecimal("5000"),
			director,LocalDate.of(1995,4,18),new BigDecimal("500"));
	Worker worker1 =new Worker("Reyhan","Azgur", LocalDate.of(1998,10,06)
			,new BigDecimal("2500"),manager1,LocalDate.of(2018,5,12),new BigDecimal("200"));
	Worker worker2 =new Worker("Bilal","Ozgur", LocalDate.of(1995,1,17)
			,new BigDecimal("2600"),manager1,LocalDate.of(2019,2,6),new BigDecimal("200"));
	Worker worker3 =new Worker("Busra","Yilmaz", LocalDate.of(1997,10,29)
			,new BigDecimal("2100"),manager1,LocalDate.of(2019,7,18),new BigDecimal("100"));
	Trainee trainee1 =new Trainee("Ahmet","Can", LocalDate.of(1983,7,28)
			,new BigDecimal("1850"),manager1,LocalDate.of(2019,11,17));
	Trainee trainee2 =new Trainee("Merve","Unal", LocalDate.of(1997,8,12)
			,new BigDecimal("2500"),manager1,LocalDate.of(2017,4,23));
	Manager manager2 =new Manager("Umit","Kaz", LocalDate.of(1996,3,22)
			,new BigDecimal("1000"),director,LocalDate.of(2019,10,11),new BigDecimal("50"));
	Worker worker4 =new Worker("Caner","Metin", LocalDate.of(1990,8,30)
			,new BigDecimal("3000"),director,LocalDate.of(2010,4,1),new BigDecimal("350"));
	Worker worker5 =new Worker("Kadir","Inanir", LocalDate.of(1979,12,3)
			,new BigDecimal("1750"),director,LocalDate.of(2014,8,8),new BigDecimal("250"));
//	Worker worker6 =new Worker();
//	Trainee trainee3 =new Trainee();
//	Trainee trainee4 =new Trainee();
//	Trainee trainee5 =new Trainee();
//	Manager manager3 =new Manager();
//	Trainee trainee6 =new Trainee();
//	Trainee trainee7 =new Trainee();
//	Trainee trainee8 =new Trainee();
//	Worker worker7 =new Worker();
//	Worker worker8 =new Worker();
//	Worker worker9 =new Worker();



	private List<Employee> _allEmployees =new ArrayList<>();
	// all employees ---  i.e. Workers, Trainees and their Managers and top Director (also an instance of Manager class)
	//private List<Employee> manager1subs =new ArrayList<>();
	@Before
	public void before(){
		_allEmployees.addAll(Arrays.asList(director,manager1,worker1,trainee1,worker2,worker3,trainee2,manager2,worker4,worker5));

		director.allSubadd(manager1);
		director.allSubadd(manager2);
		//director.allSubadd(trainee1);


		manager1.managersubadd(worker1);
		manager1.managersubadd(trainee1);
		manager1.managersubadd(worker2);
		manager1.managersubadd(worker3);
		manager1.managersubadd(trainee2);

		manager2.managersubadd(worker4);
		manager2.managersubadd(worker5);
	}
	
	@Test
	public void payroll() {

		HumanResourcesStatistics.payroll(_allEmployees);
	}
	@Test
	public void subordinatesPayroll() {
		HumanResourcesStatistics.subordinatesPayroll(manager1);
	}

	@Test
	public void bonusTotal() {
		BigDecimal total = HumanResourcesStatistics.bonusTotal(_allEmployees);
		Assert.assertEquals(new BigDecimal("1650"), total);
	}
	@Test
	public void longestSenior(){
		Employee longest=HumanResourcesStatistics.longestSeniority(_allEmployees);
		Assert.assertEquals(director,longest);
	}
	@Test
	public void highestWithoutBonus(){
		BigDecimal highest=HumanResourcesStatistics.highestSalary(_allEmployees);
		Assert.assertEquals(director.getSalary(),highest);
	}
	@Test
	public void highestWithBonus(){
		BigDecimal salarybonus=HumanResourcesStatistics.highestSalaryBonus(_allEmployees);
		Assert.assertEquals(director.getSalary().add(director.bonus()),salarybonus);
	}
	@Test
	public void beginWithA(){
		List<Employee> witha =HumanResourcesStatistics.beginwithA(manager1);
		Assert.assertEquals(6,witha.size());
		Assert.assertEquals(witha.get(0).get_surname(),"Azgur");

	}
	@Test
	public void morethan1000(){
		List<Employee> more=HumanResourcesStatistics.morethan1000(_allEmployees);
		Assert.assertEquals(more.get(0),director);
	}

	/// ...
	// rest of the methods specified in the assignment description
}