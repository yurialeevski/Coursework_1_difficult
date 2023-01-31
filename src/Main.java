public class Main {
    public static void main(String[] args) {

        EmployeeBook employeeBook = new EmployeeBook();

        System.out.println("\n---Добавим первого сотрудника методом \"Добавить сотрудника\"");
        employeeBook.addEmployee("Алексей", "Андреевич", "Баранов", 1, 100);
        System.out.println( "Выводим значения всех полей в консоль toString()");
        System.out.println(employeeBook);

        System.out.println("\n---Работает метод \"Добавить сотрудника\". Добавляем еще 10 сотрудников");
        System.out.println("---Десятый сотрудник - не должен поместиться в массив");
        employeeBook.addEmployee("Иван","Геннадьевич","Волков",1, 110);
        employeeBook.addEmployee("Ирина","Викторовна","Гусева",1, 120);
        employeeBook.addEmployee("Мария","Ивановна","Дятлова",2, 110);
        employeeBook.addEmployee("Евгения","Иосифовна","Голубева",2, 120);
        employeeBook.addEmployee("Николай","Степанович","Ежов",2, 130);
        employeeBook.addEmployee("Сергей","Леонидович","Жабин",3, 120);
        employeeBook.addEmployee("Варвара","Ильинишна","Воронина",4, 110);
        employeeBook.addEmployee("Никита","Сергеевич","Зайцев",4, 140);
        employeeBook.addEmployee("Михаил","Михайлович","Медведев",5, 110);
        employeeBook.addEmployee("Петр","Петррович","Петров",5, 110);
        employeeBook.checkInputDataPrintToString();
        System.out.println("Всего количество сотрудников: " + employeeBook.getNumberOfEmployees());

        System.out.println("\n---Работает метод удаления сотрудника");
        employeeBook.deleteEmployee("Медведве", 9); // В имени - ошибка. Сотрудник не будет удален
        employeeBook.checkInputDataPrintToString();
        System.out.println("Всего количество сотрудников: " + employeeBook.getNumberOfEmployees());
        employeeBook.deleteEmployee("Медведев", 9); // Имя написано верно. Сотрудник будет удален
        System.out.println("Всего количество сотрудников: " + employeeBook.getNumberOfEmployees());

        System.out.println("\n---Работает метод изменения номера отдела и зарплаты сотрудника");
        employeeBook.findEmployeeAndSetNewData("Никита", "Сергеевич", "Зайцев", 4, 5, 150);

        System.out.println("\n---Работает метод печати ФИО сотрудников по номеру отдела");
        employeeBook.printDepartmentsCompleteNameList();

        System.out.println("\n---Работает метод подсчета суммы затрат на зарплаты в месяц");
        System.out.println("Сумма затрат на зарплаты в месяц составляет: " + employeeBook.calculateTotalSalarySum() + " рублей");

        System.out.println("\n---Работает метод поиска сотрудника с минимальной зарплатой в месяц");
        employeeBook.findMinSalaryEmployee();

        System.out.println("\n---Работает метод поиска сотрудника с максимальной зарплатой в месяц");
        employeeBook.findMaxSalaryEmployee();

        System.out.println("\n---Работает метод подсчета среднего значения зарплат");
        System.out.printf("Средняя зарплата всех сотрудников в месяц составляет, рублей: %.2f\n",
                            employeeBook.calculateAverageSalaryPerMonth());

        System.out.println("\n---Работает метод печати ФИО всех сотрудников");
        employeeBook.printEmployeesCompleteNameList();

        //
        //Ниже - методы только из раздела "Повышенная сложность
        //

        int index = 5;
        System.out.println("\n---Работает метод индексации зарплат на величину: " + index + " %");
        employeeBook.wageIndexation(index);
        System.out.println("Значение после индексации:");
        employeeBook.checkInputDataPrintToString();
        int department = 3;
        System.out.println("\n---Методы работы с отделом №_" + department);
        employeeBook.findDepartmentMinSalaryEmployee(department);
        System.out.println();
        employeeBook.findDepartmentMaxSalaryEmployee(department);
        System.out.println();
        System.out.print("Сумма затрат на зарплаты в месяц в отделе №_" + department + " составляет, рублей: ");
        System.out.printf("%.2f\n", employeeBook.calculateDepartmentTotalSalarySum(department));
        System.out.print("Средняя зарплата в месяц в отделе №_" + department + " составляет, рублей: ");
        System.out.printf("%.2f\n", employeeBook.calculateDepartmentAverageSalary(department));
        index = 3;
        System.out.println("\n---Работает метод индексации зарплат в отделе: " + department + " на величину: " + index + " %");
        employeeBook.departmentWageIndexation(department, index);
        System.out.println("Значение после индексации:");
        employeeBook.checkInputDataPrintToString();
        System.out.println("\n---Работает метод печати всех сотрудников отдела: " + department + " (все данные, кроме отдела)");
        employeeBook.printDepartmentData(department);
        double salaryLimit = 130.0;
        System.out.println("\n---Работает метод поиска всех сотрудников с зарплатой меньше: " + salaryLimit);
        employeeBook.findEmployeeSalaryUpToLevel(salaryLimit);
        System.out.println("\n---Работает метод поиска всех сотрудников с зарплатой больше или равно: " + salaryLimit);
        employeeBook.findEmployeeSalaryFromLevel(salaryLimit);
    }
}
