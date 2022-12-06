package entities;

import java.time.LocalDate;

public class Employee extends Citizen {
    protected String occupation;

    public Employee(String name, String cpf) {
        super(name, cpf);
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }


    @Override
    public boolean validateDate(String date, String date2) {
        return false;
    }

    @Override
    public void addDates(LocalDate date) {

    }


}
