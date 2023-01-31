public class Employee {
    private final String firstName;
    private final String middleName;
    private final String lastName;
    private int departmentNumber;
    private double getEmployeeSalary;
    private final int getId;
    public static int counter;

    public Employee(String firstName, String middleName, String lastName, int departmentNumber, double getEmployeeSalary) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.departmentNumber = departmentNumber;
        this.getEmployeeSalary = getEmployeeSalary;
        this.getId = counter;
        counter++;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getDepartmentNumber() {
        return departmentNumber;
    }

    public void setDepartmentNumber(int departmentNumber) {
        this.departmentNumber = departmentNumber;
    }

    public double getEmployeeSalary() {
        return getEmployeeSalary;
    }

    public void setEmployeeSalary(double getEmployeeSalary) {
        this.getEmployeeSalary = getEmployeeSalary;
    }

    public int getId() {
        return getId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", departmentNumber=" + departmentNumber +
                ", employeeSalary=" + getEmployeeSalary +
                ", id=" + getId +
                '}';
    }
}

