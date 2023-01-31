import java.util.Arrays;

public class EmployeeBook {
    private final Employee[] employees;
    private int numberOfEmployees;
    public EmployeeBook() {
        this.employees = new Employee[10];
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    @Override
    public String toString() {
        return "EmployeeBook{" +
                "employees=" + Arrays.toString(employees) +
                '}';
    }

    public void checkInputDataPrintToString() {
        for(int i = 0; i < numberOfEmployees; i++) {
            System.out.println(employees[i].toString());
        }
    }

    public void addEmployee(String firstName, String middleName, String lastName, int departmentNumber, double salaryAmount) {
        if (numberOfEmployees >= employees.length) {
            System.out.println("Невозможно добавить этого сотрудника. В книге нет места");
            return;
        }
        employees[numberOfEmployees] = new Employee(firstName, middleName, lastName, departmentNumber,salaryAmount);
        numberOfEmployees++;
    }

    public void deleteEmployee(String lastName, int id) {
        if(numberOfEmployees == 0) {
            System.out.println("В книге нет ни одной записи о сотрудниках");
            return;
        }
        for (int i = 0; i < numberOfEmployees; i++) {
            if(employees[i].getLastName().equals(lastName) && employees[i].getId() == id) {
                System.out.println("Сотрудник Фамилия: " + lastName + " id: " + id + " удален");
                System.arraycopy(employees, i + 1, employees, i, numberOfEmployees - i - 1);
                employees[numberOfEmployees - 1] = null;
                numberOfEmployees--;
                return;
            }
        }
        System.out.println("Сотрудник с именем " + lastName + " не найден");
    }

    public void findEmployeeAndSetNewData(String firstName,
                                                 String middleName,
                                                 String lastName,
                                                 int oldDepartmentNumber,
                                                 int newDepartmentNumber,
                                                 double newSalary) {
        if(numberOfEmployees == 0) {
            System.out.println("В книге нет ни одной записи о сотрудниках");
            return;
        }
        for (int i = 0; i < numberOfEmployees; i++) {
            if(employees[i].getFirstName().equals(firstName) &&
                    employees[i].getMiddleName().equals(middleName) &&
                    employees[i].getLastName().equals(lastName) &&
                    employees[i].getDepartmentNumber() == oldDepartmentNumber) {
                employees[i].setDepartmentNumber(newDepartmentNumber);
                employees[i].setEmployeeSalary(newSalary);
                System.out.println("Данные сотрудника " + lastName + " обновлены. Номер нового отдела: " +
                        newDepartmentNumber + " новая зарплата: " + newSalary);
                return;
            }
        }
        System.out.println("Сотрудник с именем " + lastName + " не найден");
    }

    public void printDepartmentsCompleteNameList() {
        if(numberOfEmployees == 0) {
            System.out.println("В книге нет ни одной записи о сотрудниках");
            return;
        }
        System.out.println("ФИО всех сотрудников по отделам");
        for (int d = 1; d <= 5 ; d++) {
            System.out.println("Номер отдела: " + d);
            for (int i = 0; i < numberOfEmployees; i++) {
                if(employees[i].getDepartmentNumber() == d) {
                    printEmployeeCompleteName(employees,i);
                    System.out.println();
                }
            }
        }
    }

    public void printEmployeeCompleteName(Employee[] employee, int id) {
        System.out.print(employee[id].getLastName() + " ");
        System.out.print(employee[id].getFirstName() + " ");
        System.out.print(employee[id].getMiddleName());
    }

    public double calculateTotalSalarySum() {
        double sum = 0;
        if(numberOfEmployees == 0) {
            System.out.println("В книге нет ни одной записи о сотрудниках");
            return sum;
        } else {
            for (int i = 0; i < numberOfEmployees; i++) {
                sum = sum + employees[i].getEmployeeSalary();
            }
        }
        return sum;
    }

    public void findMinSalaryEmployee() {
        if(numberOfEmployees == 0) {
            System.out.println("В книге нет ни одной записи о сотрудниках");
        } else {
            double min = employees[0].getEmployeeSalary();
            int id = employees[0].getId();
            for (int i = 1; i < numberOfEmployees; i++) {
                if (employees[i].getEmployeeSalary() < min) {
                    min = employees[i].getEmployeeSalary();
                    id = employees[i].getId();
                }
            }
            System.out.println("Минимальная зарплата у сотрудника id: " + id + ", фамилия: " +
                    employees[id].getLastName() + ", зарплата: " +
                    employees[id].getEmployeeSalary() + " рублей");
            for(int i = id + 1; i < numberOfEmployees; i++) {
                if(employees[i].getEmployeeSalary() == employees[id].getEmployeeSalary()) {
                    System.out.println("Также равна минимальной зарплата у сотрудника id: " +
                            employees[i].getId() + ", фамилия: " +
                            employees[i].getLastName() + ", зарплата: " +
                            employees[i].getEmployeeSalary() + " рублей");
                }
            }
        }
    }

    public void findMaxSalaryEmployee() {
        if(numberOfEmployees == 0) {
            System.out.println("В книге нет ни одной записи о сотрудниках");
        } else {
            double max = employees[0].getEmployeeSalary();
            int id = employees[0].getId();
            for (int i = 1; i < numberOfEmployees; i++) {
                if (employees[i].getEmployeeSalary() > max) {
                    max = employees[i].getEmployeeSalary();
                    id = employees[i].getId();
                }
            }
            System.out.println("Максимальная зарплата у сотрудника id: " + id + ", фамилия: " +
                    employees[id].getLastName() + ", зарплата: " +
                    employees[id].getEmployeeSalary() + " рублей");
            for(int i = id + 1; i < numberOfEmployees; i++) {
                if(employees[i].getEmployeeSalary() == employees[id].getEmployeeSalary()) {
                    System.out.println("Также равна максимальной зарплата у сотрудника id: " +
                            employees[i].getId() + ", фамилия: " +
                            employees[i].getLastName() + ", зарплата: " +
                            employees[i].getEmployeeSalary() + " рублей");
                }
            }
        }
    }

    public double calculateAverageSalaryPerMonth() {
        if (numberOfEmployees == 0) {
            System.out.println("В книге нет ни одной записи о сотрудниках");
            return 0.0;
        } else {
            return calculateTotalSalarySum() / numberOfEmployees;
        }
    }

    public void printEmployeesCompleteNameList() {
        if(numberOfEmployees == 0) {
            System.out.println("В книге нет ни одной записи о сотрудниках");
            return;
        }
        System.out.println("ФИО всех сотрудников");
        for (int i = 0; i < numberOfEmployees; i++) {
            printEmployeeCompleteName(employees,i);
            System.out.println();
        }
    }

    public void wageIndexation(int index) {
        if(numberOfEmployees == 0) {
            System.out.println("В книге нет ни одной записи о сотрудниках");
            return;
        }
        double salary;
        for (int i = 0; i < numberOfEmployees; i++) {
            salary = employees[i].getEmployeeSalary();
            salary = salary + salary / 100 * index;
            employees[i].setEmployeeSalary(salary);
        }
    }

    public void findDepartmentMinSalaryEmployee(int department) {
        if(numberOfEmployees == 0) {
            System.out.println("В книге нет ни одной записи о сотрудниках");
            return;
        }
        double min = 0.0;
        int id = 0;
        for (int i = 0; i < numberOfEmployees; i++) {
            if(employees[i].getDepartmentNumber() == department && min == 0.0) {
                min = employees[i].getEmployeeSalary();
                id = employees[i].getId();
            } else if (employees[i].getDepartmentNumber() == department && employees[i].getEmployeeSalary() < min) {
                min = employees[i].getEmployeeSalary();
                id = employees[i].getId();
            }
        }
        if(min == 0.0) {
            System.out.println("В отделе " + department + " нет ни одного сотрудника");
            return;
        }
        System.out.print("Минимальная зарплата в отделе №_" + department + " у сотрудника: ");
        printEmployeeCompleteName(employees, id);
        printEmployeeSalaryId(employees, id);
        for(int i = 0; i < numberOfEmployees; i++) {
            if(employees[i].getEmployeeSalary() == employees[id].getEmployeeSalary()) {
                System.out.print("Также равна минимальной зарплата у сотрудника : ");
                printEmployeeCompleteName(employees, i);
                printEmployeeSalaryId(employees, i);
            }
        }
    }

    public void printEmployeeSalaryId(Employee[] employee, int id) {
        System.out.print(" зарплата:");
        System.out.printf("%.2f",employee[id].getEmployeeSalary());
        System.out.println(" id:" + employee[id].getId());
    }

    public void findDepartmentMaxSalaryEmployee(int department) {
        if(numberOfEmployees == 0) {
            System.out.println("В книге нет ни одной записи о сотрудниках");
            return;
        }
        double max = 0.0;
        int id = 0;
        for (int i = 0; i < numberOfEmployees; i++) {
            if(employees[i].getDepartmentNumber() == department && max == 0.0) {
                max = employees[i].getEmployeeSalary();
                id = employees[i].getId();
            } else if (employees[i].getDepartmentNumber() == department && employees[i].getEmployeeSalary() > max) {
                max = employees[i].getEmployeeSalary();
                id = employees[i].getId();
            }
        }
        if(max == 0.0) {
            System.out.println("В отделе " + department + " нет ни одного сотрудника");
            return;
        }
        System.out.print("Максимальная зарплата в отделе №_" + department + " у сотрудника: ");
        printEmployeeCompleteName(employees, id);
        printEmployeeSalaryId(employees, id);
        for(int i = 0; i < numberOfEmployees; i++) {
            if(employees[i].getEmployeeSalary() == employees[id].getEmployeeSalary()) {
                System.out.print("Также равна максимальной зарплата у сотрудника : ");
                printEmployeeCompleteName(employees, i);
                printEmployeeSalaryId(employees, i);
            }
        }
    }

    public double calculateDepartmentTotalSalarySum(int department) {
        double sum = 0;
        if(numberOfEmployees == 0) {
            System.out.println("В книге нет ни одной записи о сотрудниках");
            return sum;
        } else {
            for (int i = 0; i < numberOfEmployees; i++) {
                if(employees[i].getDepartmentNumber() == department) {
                    sum = sum + employees[i].getEmployeeSalary();
                }
            }
        }
        return sum;
    }

    public double calculateDepartmentAverageSalary(int department) {
        double sum = 0;
        int employeeCounter = 0;
        if(Employee.counter == 0) {
            System.out.println("В книге нет ни одной записи о сотрудниках");
            return sum;
        } else {
            for (int i = 0; i < numberOfEmployees; i++) {
                if(employees[i].getDepartmentNumber() == department) {
                    sum = sum + employees[i].getEmployeeSalary();
                    employeeCounter++;
                }
            }
        }
        return sum / employeeCounter;
    }

    public void departmentWageIndexation(int department, int index) {
        double salary;
        if(numberOfEmployees == 0) {
            System.out.println("В книге нет ни одной записи о сотрудниках");
        } else {
            for (int i = 0; i < numberOfEmployees; i++) {
                if(employees[i].getDepartmentNumber() == department) {
                    salary = employees[i].getEmployeeSalary();
                    salary = salary + salary / 100 * index;
                    employees[i].setEmployeeSalary(salary);
                }
            }
        }
    }

    public void printDepartmentData(int department) {
        //System.out.println("Данные сотрудников отдела №_" + department);
        for (int i = 0; i < numberOfEmployees; i++) {
            if(employees[i].getDepartmentNumber() == department) {
                printEmployeeCompleteName(employees, i);
                printEmployeeSalaryId(employees, i);
            }
        }
    }

    public void findEmployeeSalaryUpToLevel(double salaryMaxLimit) {
        if(numberOfEmployees == 0) {
            System.out.println("В книге нет ни одной записи о сотрудниках");
        } else {
            for (int i = 0; i < numberOfEmployees; i++) {
                if(employees[i].getEmployeeSalary() < salaryMaxLimit) {
                    printEmployeeCompleteName(employees,i);
                    printEmployeeSalaryId(employees, i);
                }
            }
        }
    }

    public void findEmployeeSalaryFromLevel(double salaryMinLimit) {
        if(numberOfEmployees == 0) {
            System.out.println("В книге нет ни одной записи о сотрудниках");
        } else {
            for (int i = 0; i < numberOfEmployees; i++) {
                if(employees[i].getEmployeeSalary() >= salaryMinLimit) {
                    printEmployeeCompleteName(employees,i);
                    printEmployeeSalaryId(employees, i);
                }
            }
        }
    }

}

