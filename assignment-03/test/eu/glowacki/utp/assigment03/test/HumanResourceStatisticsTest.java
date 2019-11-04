package eu.glowacki.utp.assigment03.test;

import eu.glowacki.utp.assignment03.HumanResourceStatistics;
import eu.glowacki.utp.assignment03.employee.Employee;
import eu.glowacki.utp.assignment03.employee.Manager;
import eu.glowacki.utp.assignment03.employee.Trainee;
import eu.glowacki.utp.assignment03.employee.Worker;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class HumanResourceStatisticsTest {

    Manager director =new Manager("Aksel","Ozgur", LocalDate.of(1970,6,17),"20000",
            null,LocalDate.of(1990,3,7),new BigDecimal("0"));
    Manager manager1 =new Manager("Nuray","Ozgur", LocalDate.of(1972,5,18),"5000",
            director,LocalDate.of(1995,4,18),new BigDecimal("500"));
    Worker worker1 =new Worker("Reyhan","Azgur", LocalDate.of(1998,10,06)
            ,"2500",manager1,LocalDate.of(2018,5,12),new BigDecimal("200"));
    Worker worker2 =new Worker("Bilal","Ozgur", LocalDate.of(1995,1,17)
            ,"2600",manager1,LocalDate.of(2019,2,6),new BigDecimal("200"));
    Worker worker3 =new Worker("Busra","Yilmaz", LocalDate.of(1997,10,29)
            ,"2100",manager1,LocalDate.of(2019,7,18),new BigDecimal("100"));
    Trainee trainee1 =new Trainee("Ahmet","Can", LocalDate.of(1983,7,28)
            ,"1850",manager1,LocalDate.of(2019,10,1));
    Trainee trainee2 =new Trainee("Merve","Unal", LocalDate.of(1997,8,12)
            ,"2500",manager1,LocalDate.of(2017,4,23));
    Manager manager2 =new Manager("Umit","Kaz", LocalDate.of(1996,3,22)
            ,"1000",director,LocalDate.of(2019,10,11),new BigDecimal("50"));
    Worker worker4 =new Worker("Caner","Metin", LocalDate.of(1990,8,30)
            ,"3000",director,LocalDate.of(2010,4,1),new BigDecimal("350"));
    Worker worker5 =new Worker("Kadir","Inanir", LocalDate.of(1979,12,3)
            ,"1750",director,LocalDate.of(2014,8,8),new BigDecimal("250"));

    private List<Employee> _allEmployees =new ArrayList<>();



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
    public void olderThenAndEarnMore(){
        List<Employee> old =HumanResourceStatistics.olderThenAndEarnMore(_allEmployees,worker2);
        Assert.assertEquals(2,old.size());
        Assert.assertEquals(old.get(0),trainee1);
    }
    @Test
    public void practiceLengthLongerThan(){
        List<Trainee> trainee =HumanResourceStatistics.practiceLengthLongerThan(_allEmployees,10);
        Assert.assertEquals(2,trainee.size());
        Assert.assertEquals(trainee.get(0),trainee1);
    }
    @Test
    public void seniorityLongerThan1(){
        List<Worker> worker =HumanResourceStatistics.seniorityLongerThan1(_allEmployees,15,e -> e.setBonus(new BigDecimal("300")));
        Assert.assertEquals(2,worker.size());
       // Assert.assertEquals(worker.get(0),director);
    }
    @Test
    public void seniorityBetweenOneAndThreeYears(){
        List<Worker> worker =HumanResourceStatistics.seniorityBetweenOneAndThreeYears(_allEmployees);
        Assert.assertEquals(1,worker.size());
        Assert.assertEquals(worker.get(0),worker1);
    }
    @Test
    public void seniorityLongerThan2(){
        List<Worker> worker =HumanResourceStatistics.seniorityLongerThan2(_allEmployees,worker3);
        Assert.assertEquals(1,worker.size());
       // Assert.assertEquals(worker.get(0),worker5);
    }
    @Test
    public void seniorityBetweenTwoAndFourYearsAndAgeGreaterThan(){
        List<Worker> worker =HumanResourceStatistics.seniorityBetweenTwoAndFourYearsAndAgeGreaterThan(_allEmployees,20);
        Assert.assertEquals(0,worker.size());
       // Assert.assertEquals(worker.get(0),worker5);
    }



}