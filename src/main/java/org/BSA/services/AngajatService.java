package org.BSA.services;

import org.BSA.model.Angajat;
import org.BSA.model.User;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;

import java.util.Objects;

import static org.BSA.services.FileSystemService.getPathToFile;

public class AngajatService {
    private static ObjectRepository<Angajat> angajatRepository;

    public static void initDatabase() {
        Nitrite database = Nitrite.builder()
                .filePath(getPathToFile("Baza_de_date_angajat.db").toFile())
                .openOrCreate("test1", "test1");

        angajatRepository = database.getRepository(Angajat.class);
    }

    public static void addAngajat(String numeAngajat){
        angajatRepository.insert(new Angajat(numeAngajat));

    }

    private static final ObjectRepository<User> REPOSITORY= UserService.getUserRepository();




    public static String getnumeAngajat(String numeAngajat) {
        for (Angajat angajat : angajatRepository.find()) {
            if (Objects.equals(numeAngajat, angajat.getNumeAngajat())) {
                return angajat.getNumeAngajat();
            }
        }
        return null;
    }
    public static ObjectRepository<Angajat> getAngajatRepository(){
        return angajatRepository;
    }

}
