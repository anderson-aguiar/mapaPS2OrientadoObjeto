package app;

import entities.Citizen;
import entities.Employee;
import entities.Patient;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Citizen> list = new ArrayList<>();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.print("Nome enfermeira(o): ");
        String nome = sc.nextLine();
        System.out.print("Cpf enfermeira(o): ");
        String cpf = sc.nextLine();
        Citizen enf = new Employee(nome, cpf);
        System.out.println("------------------------------------");
        System.out.println();
        menu();
        int resp = sc.nextInt();
        sc.nextLine();
        while (resp != 3) {
            if (resp == 1) {

                int verificador = 0;
                System.out.print("Nome cidadão: ");
                nome = sc.nextLine();
                System.out.print("CPF cidadão: ");
                cpf = sc.nextLine();
                Citizen patient = new Patient(nome, cpf);
                System.out.printf("Data 1ª dose (dd/MM/yyyy): ");
                String aux = sc.nextLine();

                for (int i = 1; i <= 3; i++) {
                    System.out.printf("Data %dª dose (dd/MM/yyyy): ", (i + 1));
                    String date2 = sc.nextLine();
                    if (patient.validateDate(aux, date2)) {
                        LocalDate data = LocalDate.parse(aux, format);
                        LocalDate data1 = LocalDate.parse(date2, format);
                        patient.addDates(data);
                        patient.addDates(data1);
                        verificador = 1;
                    } else {
                        System.out.println();
                        System.out.println("Não tem dose disponivel para esse cidadão");
                        System.out.println("Cadastro não realizado");
                        verificador = 0;
                        break;
                    }
                    aux = date2;
                }
                if (verificador == 1) {
                    list.add(patient);
                    System.out.println("CADASTRO FINALIZADO COM SUCESSO.");
                }

            } else {
                System.out.println("----------------------------");
                for (Citizen obj : list) {
                    System.out.println(obj);
                }
            }
            menu();
            resp = sc.nextInt();
            sc.nextLine();
        }
        sc.close();

    }

    public static void menu() {
        System.out.println(">>>>>>>>>>MENU<<<<<<<<<<<");
        System.out.println("1 - Vacinar cidadão");
        System.out.println("2 - Listar Cidadões");
        System.out.println("3 - Sair");

    }
}
