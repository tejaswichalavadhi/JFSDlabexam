package com.klef.jfsd.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class ClientDemo {
    public static void main(String[] args) {
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        Scanner scanner = new Scanner(System.in);

        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            // Insert operation
            System.out.println("Inserting a new Department...");
            Department dept = new Department();
            dept.setName("Computer Science");
            dept.setLocation("Building A");
            dept.setHodName("Dr. Smith");
            session.save(dept);

            System.out.println("Inserted Department ID: " + dept.getDepartmentId());

            // Delete operation
            System.out.println("Enter Department ID to delete:");
            int deleteDeptId = scanner.nextInt();

            String hqlDelete = "DELETE FROM Department WHERE departmentId = :deptId";
            int deletedRows = session.createQuery(hqlDelete)
                                      .setParameter("deptId", deleteDeptId)
                                      .executeUpdate();

            if (deletedRows > 0) {
                System.out.println("Deleted Department with ID: " + deleteDeptId);
            } else {
                System.out.println("No Department found with ID: " + deleteDeptId);
            }

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessionFactory.close();
            scanner.close();
        }
    }
}