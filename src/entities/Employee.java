package entities;

import java.time.LocalDate;

public class Employee extends Citizen {
    public Employee(String name, String cpf) {
        super(name, cpf);
    }

    @Override
    public boolean validateDate(String date, String date2) {
        return false;
    }

    @Override
    public void addDates(LocalDate date) {

    }


}
