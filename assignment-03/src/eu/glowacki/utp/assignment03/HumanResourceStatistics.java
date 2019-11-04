package eu.glowacki.utp.assignment03;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

import eu.glowacki.utp.assignment03.employee.Employee;
import eu.glowacki.utp.assignment03.employee.Trainee;
import eu.glowacki.utp.assignment03.employee.Worker;

public final class HumanResourceStatistics {

	// The best solution is to impleent the below features as static methods having a list of Employee as the first input argument.
	// In addition the list of arguments may be augmented with parameters required for the given feature.
	// najlepiej zaimplementowaæ poni¿sze metody jako statyczne, gdzie argumentem lista pracowników i odpowiednio dodatkowo to co wymagane w danym punkcie
	
	// (assignment 03)
	// methods:
	//
	// * search for Employees older than given employee and earning less than him
	//   wyszukaj osoby zatrudnione (Employee), które s¹ starsze od podanej innej zatrudnionej osoby oraz zarabiaj¹ mniej od niej
	public static List<Employee> olderThenAndEarnMore(List<Employee> allEmployees, Employee employee) {
		Predicate<Employee> older = e -> e.olderthan(employee);
		Predicate<Employee> lessEarn = e -> e.less(employee.getSalary().doubleValue())==1;
		Predicate<Employee> olderThanAndEarnsLess = older.and(lessEarn);

		return allEmployees //
				.stream() //
				.filter(olderThanAndEarnsLess)
				.collect(Collectors.toList());
		/*
		List<Employee> emp = allEmployees.
				stream()
				.filter(employee1 -> employee1.getAge() > employee.getAge() && employee1.getSalary().compareTo(employee.getSalary()) == -1)
				.collect(Collectors.toList());
		return emp;
		*/

	}
	public static Trainee tran(Employee e){
		return (Trainee) e;
	}
	public static boolean istran(Employee e){
		return e instanceof Trainee;
	}

	public  static Worker worker(Employee e){
		return (Worker) e;
	}
	public  static boolean isWorker(Employee e){
		return e instanceof Worker;
	}

	
	//
	// * search for Trainees whose practice length is longer than given number of days and raise their salary by 5%
	//   wyszukaj praktykantów (Trainee), których praktyka jest d³u¿sza od podanej liczby dni,
	//   a nastêpnie podnieœ ich uposa¿enie o 5%
	public static List<Trainee> practiceLengthLongerThan(List<Employee> allEmployees, int daysCount) {
		//List<Trainee> trainees =new ArrayList<>();
		Predicate<Trainee> practise = e -> e.Longer(daysCount)==1;
		Consumer<Trainee> raise = tr -> tr.setSalary(tr.getSalary().add(tr.getSalary().multiply(new BigDecimal(0.05))));

//		for(Employee e : allEmployees) {
////			if (e instanceof Trainee) {
////				if (practise.test((Trainee) e)) {
////					trainees.add((Trainee) e);
////					raise.accept((Trainee) e);
////				}
////			}
////		}
////		return trainees;
		return  allEmployees //
				.stream() //
				.filter(HumanResourceStatistics::istran)
				.map(HumanResourceStatistics::tran)
				.filter(practise)
				.map(employee -> {
					employee.setSalary(employee.getSalary().add(employee.getSalary().multiply(new BigDecimal(0.05))));
				return  employee; })
				.collect(Collectors.toList());

	}

	//
	// * search for Workers whose seniority is longer than given number of months and give them bonus of 300 if their bonus is smaller
	//   wyszukaj pracowników o sta¿u d³u¿szym ni¿ podana liczba miesiêcy,
	//   a nastêpnie przyznaj im premiê w wysokoœci 300 jeœli ich premia jest ni¿sza

	public static List<Worker> seniorityLongerThan1(List<Employee> allEmployees, int monthCount, Consumer<Worker> c) {
		//List <Worker> workers =new ArrayList<>();
		Predicate<Worker> p = w -> w.LongerMonth(monthCount)==1;
//		for (Employee e : allEmployees) {
//			if (e instanceof Worker) {
//				if (p.test((Worker) e)) {
//					workers.add((Worker) e);
//					if (((Worker) e).bonusGreater(300.0) == -1) {
//						c.accept((Worker) e);
//					}
//
//				}
//			}
//		}
//		return workers;
		return  allEmployees //
				.stream() //
				.filter(HumanResourceStatistics::isWorker)
				.map(HumanResourceStatistics::worker)
				.filter(p)
				.filter(e -> e.bonusGreater(300) > 0)
				.map(employee -> { employee.setBonus(new BigDecimal("300"));
						return employee;
		}).collect(Collectors.toList());

	}
	
	//
	// * search for Workers whose seniority is between 1 and 3 years and give them raise of salary by 10%
	//   wyszukaj pracowników o sta¿u pomiêdzy 1 a 3 lata i przyznaj im podwy¿kê w wysokoœci 10%
	public static List<Worker> seniorityBetweenOneAndThreeYears(List<Employee> allEmployees) {
		//List<Worker> workers = new ArrayList<>();
		Predicate<Worker> p = w -> w.seniority()>=1 && w.seniority()<=3;
		Consumer<Worker> raise = ww -> ww.setSalary(ww.getSalary().add(ww.getSalary().multiply(new BigDecimal(0.1))));

//		for(Employee e : allEmployees) {
//			if (e instanceof Worker) {
//				if (p.test((Worker) e)) {
//					workers.add((Worker) e);
//					raise.accept((Worker) e);
//				}
//			}
//}
//		return  workers;
		return  allEmployees //
				.stream() //
				.filter(HumanResourceStatistics::isWorker)
				.map(HumanResourceStatistics::worker)
				.filter(p)
				.map(employee -> {
					employee.setSalary(employee.getSalary().add(employee.getSalary().multiply(new BigDecimal(0.1))));
					return employee;
		}).collect(Collectors.toList());


	}
	
	//
	// * search for Workers whose seniority is longer than the seniority of a given employee and earn less than him and align their salary with the given employee
	//   wyszukaj pracowników o sta¿u d³u¿szym ni¿ sta¿ podanego pracownika i którzy zarabiaj¹ mniej od niego,
	//   nastêpnie zrównaj ich wynagrodzenie z wynagrodzeniem danego pracownika
	public static List<Worker> seniorityLongerThan2(List<Employee> allEmployees, Employee employee) {
		//List<Worker> workers = new ArrayList<>();
		Predicate<Worker> pre = sn -> sn.seniorityMonth() > employee.seniorityMonth();
		Predicate<Worker> lessEarn = e -> e.less(employee.getSalary().doubleValue())==1;
		Predicate<Worker> wwww = pre.and(lessEarn);

		Consumer<Worker> align = (work) -> work.setSalary(employee.getSalary());

//		for(Employee e : allEmployees) {
//			if (e instanceof Worker) {
//				if (pre.and(lessEarn).test((Worker) e)) {
//					workers.add((Worker) e);
//					align.accept((Worker) e);
//				}
//			}
//		}

		//return workers;
		return  allEmployees //
				.stream() //
				.filter(HumanResourceStatistics::isWorker)
				.map(HumanResourceStatistics::worker)
				.filter(wwww)
		.map(employe1 -> (Worker) employee).
				collect(Collectors.toList());



	}
	
	//
	// * search for Workers whose seniority is between 2 and 4 years and whose age is greater than given number of years
	//   wyszukaj pracowników o sta¿u pomiêdzy 2 i 4 lata i starszych ni¿ podana liczba lat
	public static List<Worker> seniorityBetweenTwoAndFourYearsAndAgeGreaterThan(List<Employee> allEmployees, int age) {
		List<Worker> workers = new ArrayList<>();
		Predicate<Worker> sen = e -> e.seniority()>= 2 && e.seniority()<= 4 ;
		Predicate<Worker> p = m -> m.getAge() > age ;
		Predicate<Worker> wwww = sen.and(p);
//		for(Employee e : allEmployees){
//			if (e instanceof Worker) {
//				if (sen.and(p).test((Worker) e)) {
//					workers.add((Worker) e);
//				}
//			}
//		}
/*
		List<Worker> workers = allEmployees.
				stream().
				filter(employee -> employee instanceof Worker &&
						((Worker) employee).seniority() > 2 &&
						((Worker) employee).seniority() < 4 &&
						employee.getAge() > age
				).
				map(employee -> (Worker) employee).
				collect(Collectors.toList());
*/

	//	return workers;
		return  allEmployees //
				.stream() //
				.filter(HumanResourceStatistics::isWorker)
				.map(HumanResourceStatistics::worker)
				.filter(wwww)
				.collect(Collectors.toList());

	}
}