package eu.glowacki.utp.assignment02.employee;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class Manager extends Worker {


	// attributes
	// * subordinates (a list of immediate subordinates)
	// * all subordinates (a list of subordinates in all hierarchy)
	//Trainee trainee;
	//Worker worker;
	private static List<Employee> managersub =new ArrayList<>(); //who works for this manager
	private static List<Employee> allsub =new ArrayList<>();  //all subordinates
	//private List<Trainee> trainees =new ArrayList<>();
	//private List<Worker> worker =new ArrayList<>();

	public Manager(String firstName,String surname, LocalDate birthday,
				   BigDecimal sal,Manager man, LocalDate _empdate,BigDecimal _bonus) {
		super(firstName,surname,birthday,sal,man,_empdate,_bonus);


	}
	public List<Employee> getManagersub() {
		return managersub;
	}

	public List<Employee> getAllsub(){
			List<Employee> allSub = new ArrayList<>(managersub);
			managersub.forEach(emp -> {
						if (emp instanceof Manager)
							allSub.addAll(((Manager) emp).getManagersub());
					}
			);
			return allSub;
		}

	public void managersubadd(Employee emp){
		managersub.add(emp);
	}
	public void allSubadd(Employee emp){
		allsub.add(emp);
	}


	/*public Manager(String firstName,String surname, LocalDate birthday,
				   BigDecimal sal, LocalDate _empdate,BigDecimal _bonus) {
		super(firstName,surname,birthday,sal,null,_empdate,_bonus);
	}*/

	//public Manager(String firstName,String surname, LocalDate birthday, BigDecimal sal, LocalDate _empdate) {
//
//		super(firstName,surname,birthday,sal,_empdate);
//	}


}