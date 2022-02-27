class Employee
{
    int emid;
    long mobile;
    String empname, address, mailid;
    float basic;
    void salary()
    {
        System.out.println("\n\n**Payment Slip*");
        float da,hra,pf,cf,gross;
        da = basic * 97/100;
        hra = basic * 10/100;
        pf = basic * 12/100;
        cf = basic * 0.001f;
        gross = basic + da + hra - pf -cf;
        System.out.println("Name of Employee: "+empname);
        System.out.println("Basic Salary: "+basic);
        System.out.println("Gross Salary: "+gross);
    };
}
class Programmer extends Employee
{
    Programmer(String name, int sal)
    {
        empname = name;
        basic = sal;
    }
}
class TeamLead extends Employee
{
    TeamLead(String name, int sal)
    {
        empname = name;
        basic = sal;
    }
}
class APM extends Employee
{
    APM(String name, int sal)
    {
        empname = name;
        basic = sal;
    }
}
 
 
 
class ProjectManager extends Employee
{
    ProjectManager(String name, int sal)
    {
        empname = name;
        basic = sal;
    }
}
public class Main
{
    public static void main(String[] args) 
    {
        Programmer P = new Programmer("Sameer", 47000);
        P.salary();
        
        TeamLead T = new TeamLead("Muskan", 60000);
        T.salary();
        
        APM A = new APM("Rahul", 75000);
        A.salary();
        
        ProjectManager M = new ProjectManager("Yash", 80000);
        M.salary();
    }
}
