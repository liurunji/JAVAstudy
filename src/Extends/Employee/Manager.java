package Extends.Employee;

public class Manager extends Employee{
    private int manageSalary;

    public Manager() {

    }

    public Manager(String id, String name, int salary, int manageSalary) {
        super(id, name, salary);
        this.manageSalary = manageSalary;
    }

    public int getManageSalary() {
        return manageSalary;
    }

    public void setManageSalary(int manageSalary) {
        this.manageSalary = manageSalary;
    }

    @Override
    public void work() {
        //super.work();
        System.out.println("工作是管理其他人");
    }
}
