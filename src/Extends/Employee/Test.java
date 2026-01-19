package Extends.Employee;

public class Test {
    public static void main(String[] args) {
        Manager m = new Manager("001","zhansgan",5000,210);
        m.work();
        m.eat();
        System.out.println(m.getId()+","+m.getName()+","+
                m.getSalary()+","+m.getManageSalary());
        System.out.println("---------------------");
        Cooker c = new Cooker();
        c.work();
        c.eat();
    }
}
