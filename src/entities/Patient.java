package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Patient extends Citizen {
    List<LocalDate> list = new ArrayList<>();

    public Patient(String name, String cpf) {
        super(name, cpf);
    }

    DateTimeFormatter sdf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Override
    public boolean validateDate(String date, String date2) {

        LocalDate data = LocalDate.parse(date, sdf);
        LocalDate data1 = data.plusDays(120);
        LocalDate data2 = LocalDate.parse(date2, sdf);
        if (data1.isAfter(data2)) {
            return false;
        }
        return true;
    }

    @Override
    public void addDates(LocalDate date) {
        if (!list.contains(date)) {
            list.add(date);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nNome: " + name);
        sb.append("\nCPF: " + cpf);
        for (int i = 0; i < list.size(); i++) {
            sb.append("\nData " + (i + 1) + ": " + list.get(i).format(sdf));
        }
        sb.append("\n------------------------------");
        String text = sb.toString();
        return text;
    }
}
