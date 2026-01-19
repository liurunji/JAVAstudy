package Extends.Employee;

public class Cooker extends Employee{

    public Cooker() {
    }

    public Cooker(String id, String name, int salary) {
        super(id, name, salary);
    }

    @Override
    public void work() {
        //super.work();
        System.out.println("厨师工作是炒菜");
    }
}
