package eu.glowacki.utp.assignment03.employee;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Manager extends Worker {
	
	// (assignment 02)
	// attributes:
	// * subordinates (a list of immediate subordinates)
	// * all subordinates (a list of subordinates in all hierarchy)
    private static List<Employee> managersub =new ArrayList<>(); //who works for this manager
    private static List<Employee> allsub =new ArrayList<>();  //all subordinates

    public Manager(String firstName, String surname, LocalDate birthday,
                   String sal, Manager man, LocalDate _empdate, BigDecimal _bonus) {
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
}