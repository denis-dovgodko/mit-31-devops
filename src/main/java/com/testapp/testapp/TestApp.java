package com.testapp.testapp;

import com.testapp.testapp.entities.*;

import java.time.DayOfWeek;
import java.util.*;

public class TestApp {
    public static void main(String[] args) {
        List<Client> clients = new ArrayList<>(java.util.List.of(
                new Client("Dima"),
                new Client("Anatolievna")
        ));
        List<Doctor> doctorList = new ArrayList<>(java.util.List.of(
                new Doctor("Omelchenko Aleksey Ivanovich",
                        java.util.List.of("Orthodontics"),
                        java.util.List.of(
                                new Procedure("Correction", 5),
                                new Procedure("Consultation", 20)
                        ),
                        java.util.List.of(3, 6)
                ),
                new Doctor("Katok Maxim Viktorovich",
                        java.util.List.of("Dental surgery", "Dental orthopedics"),
                        java.util.List.of(
                                new Procedure("Resection", 30),
                                new Procedure("Stitches removing", 8)
                        ),
                        java.util.List.of(4, 5, 6)
                )
        ));
        List<Schedule> scheduleList = setWeeklySchedule(doctorList);
        Scanner in = new Scanner(System.in);
        int currentUserIndex;
        while (true) {
            System.out.println("Log in. Please, enter index of your user");
            for (int i = 0; i < clients.size(); i++) {
                System.out.println(i + ") " + clients.get(i).getFullName());
            }
            System.out.println("Log in. Please, enter index of your user from list higher: ");
            try {
                currentUserIndex = Integer.parseInt(in.nextLine());
                System.out.println("Success!");
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error: Please, retype user index again");
            }
        }
        do {
            System.out.println("0) Book visit to doctor");
            System.out.println("1) My visits");
            System.out.println("Please, choose command: ");
            int command = Integer.parseInt(in.nextLine());
            switch (command) {
                case 0:
                    for (int i = 0; i < doctorList.size(); i++) {
                        System.out.println(i + ") " + doctorList.get(i).toString());
                    }
                    System.out.println("Please, choose doctor: ");
                    int doctor = Integer.parseInt(in.nextLine());
                    for (int i = 0; i < doctorList.get(doctor).getProcedures().size(); i++) {
                        System.out.println(i + ") " + doctorList.get(doctor).getProcedures().get(i));
                    }
                    System.out.println("Please, choose procedure: ");
                    int procedure = Integer.parseInt(in.nextLine());
                    for (int i = 0; i < doctorList.get(doctor).getWorking_days().size(); i++) {
                        System.out.println(doctorList.get(doctor).getWorking_days().get(i).getValue() + ") " + doctorList.get(doctor).getWorking_days().get(i));
                    }
                    System.out.println("Please, choose day: ");
                    int dayOfWeek = Integer.parseInt(in.nextLine());
                    List<Visit> desired = scheduleList.get(dayOfWeek).getDesiredVisits(doctorList.get(doctor).getFullName(), dayOfWeek, doctorList.get(doctor).getProcedures().get(procedure));
                    for (int i = 0; i< desired.size(); i++) {
                        System.out.println(i + ") " + desired.get(i).toString());
                    }
                    System.out.println("Please, choose visit: ");
                    int visit = Integer.parseInt(in.nextLine());
                    desired.get(visit).bookVisit(clients.get(currentUserIndex));
                    clients.get(currentUserIndex).getVisitList().add(desired.get(visit));
                    break;
                case 1:
                    List<Visit> my_visits = clients.get(currentUserIndex).getVisitList();
                    if(!my_visits.isEmpty()){
                        System.out.println("Your visits: ");
                        for(Visit vis : my_visits){
                            System.out.println(vis.getDoctor().toString() + " | " + vis.toString());
                        }
                    }
                default:
                    break;
            }
        } while (true);
    }

    public static List<Schedule> setWeeklySchedule(List<Doctor> doctorList) {
        List<Schedule> scheduleList = new ArrayList<>();
        for (int i = 1; i < 8; i++) {
            scheduleList.add(new Schedule(i));
        }
        for (Doctor doctor : doctorList) {
            for (DayOfWeek dayOfWeek : doctor.getWorking_days()) {
                scheduleList.get(dayOfWeek.getValue()).addVisits(doctor, dayOfWeek.getValue());
            }
        }
        return scheduleList;
    }
}

