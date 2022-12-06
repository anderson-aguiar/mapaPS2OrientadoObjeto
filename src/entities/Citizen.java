package entities;

import java.time.LocalDate;

public abstract class Citizen {
    protected String name;
    protected String cpf;

    public Citizen(String name, String cpf) {
        this.name = name;
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public abstract boolean validateDate(String date, String date2);

    public abstract void addDates(LocalDate date);

}
