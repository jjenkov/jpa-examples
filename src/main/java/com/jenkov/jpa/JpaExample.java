package com.jenkov.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;

public class JpaExample {


    public static void main(String[] args) throws IOException {


        //loadAndPrintPersistenceXml();


        EntityManagerFactory factory = Persistence.createEntityManagerFactory("cdbookstorePU");
        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();


        Artist artist = new Artist();
        artist.setFirstName("John");
        artist.setLastName("Doe");
        artist.setBio("John is a ...");
        artist.setEmail("john@doe.com");
        artist.setDateOfBirth(LocalDate.of(1980, 3, 28));

        transaction.begin();
        //entityManager.persist(artist);
        transaction.commit();

        System.out.println(artist.getId());
    }

    private static void loadAndPrintPersistenceXml() throws IOException {
        InputStream resourceAsStream = JpaExample.class.getClassLoader().getResourceAsStream("META-INF/persistence.xml");

        System.out.println(resourceAsStream);
        int data = resourceAsStream.read();
        while(data != -1) {
            System.out.print((char)data);
            data = resourceAsStream.read();
        }
        resourceAsStream.close();
        System.out.println("");
    }
}
