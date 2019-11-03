package eu.glowacki.utp.assignment02;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import eu.glowacki.utp.assignment02.employee.Employee;
import eu.glowacki.utp.assignment02.employee.Manager;
import eu.glowacki.utp.assignment02.employee.Worker;
import eu.glowacki.utp.assignment02.payroll.PayrollEntry;

public final class HumanResourcesStatistics {


	public static List<PayrollEntry> payroll(List<Employee> employees) {
		List<PayrollEntry> payroll =new ArrayList<>();
		employees.forEach(emp -> payroll.add(new PayrollEntry(emp, emp.getSalary(), emp.bonus())));
			return payroll;

//		List<BigDecimal> pay = new ArrayList<>();
//		for(Employee e : employees){
//			if(filter.test(e)){
//				pay.add(e.getSalary());
//
//			}
//		}
	}

	public static List<PayrollEntry> subordinatesPayroll(Manager manager) {

		List<PayrollEntry> subpayroll =new ArrayList<>();
		manager.getManagersub().forEach(emp -> subpayroll.add(new PayrollEntry(emp, emp.getSalary(), emp.bonus())));
			return subpayroll;
//		List<PayrollEntry> pay = new ArrayList<>();
//		for(Worker e : manager.workers){
//			pay.add(new PayrollEntry(e,e.getSalary(),e.getBonus()));
//
//			}
//		return pay;

	}


	public static BigDecimal bonusTotal(List<Employee> employees) {
		if(employees != null) {
			BigDecimal sum = employees
					.stream()
					.map(Employee::bonus)
					.reduce((part, next) -> part.add(next)).get();

		/*BigDecimal sum = employees
				.stream()
				.map(Employee::bonus)
				.reduce(BigDecimal.ZERO, BigDecimal::add);*/
			return sum;
		}
		else return null;

	}
	public static Employee longestSeniority(List<Employee> employees) {
		if(employees !=null){
		Comparator<Employee> comparator = Comparator.comparing( Employee::seniority);
		Employee maxSen = employees
				.stream()
				.max(comparator)
				.get();
		return maxSen;
		}else return null;
	}
	public static BigDecimal highestSalary(List<Employee> employees){
		if(employees != null) {
			Comparator<Employee> comparator = Comparator.comparing(Employee::getSalary);
			Employee emp = employees
					.stream()
					.max(comparator)
					.get();
			return emp.getSalary();
		}else return null;
	}
	public static BigDecimal highestSalaryBonus(List<Employee> employees){
		List<BigDecimal> salaryBonus = employees
				.stream()
				.map(e -> e.getSalary()
				.add(e.bonus()))
				.collect(Collectors.toList());
		BigDecimal maxx =salaryBonus
				.stream()
				.reduce(BigDecimal.ZERO,BigDecimal::max);
		return maxx ;
	}
	public static List<Employee>  beginwithA(Manager manager){
		List<Employee> surnameA = manager.getManagersub()
				.stream()
				.filter(emp -> emp.get_surname().startsWith("A"))
				.collect(Collectors.toList());
		return surnameA;
	}
	public static List<Employee>  morethan1000(List<Employee> employees){
		List<Employee> moree =employees
				.stream()
				.filter(emp -> emp.getSalary().compareTo(BigDecimal.valueOf(1000))>0)
				.collect(Collectors.toList());
		return moree;
	}


	/// ...
	// rest of the methods specified in the assignment description
}