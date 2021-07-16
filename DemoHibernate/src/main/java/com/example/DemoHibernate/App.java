package com.example.DemoHibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
		
		/*
		 * StudentName sn = new StudentName(); sn.setFname("John");
		 * sn.setLname("Chris"); sn.setMname("Roy");
		 * 
		 * Laptop laptop = new Laptop(); laptop.setLid(2); laptop.setLname("HP");
		 * 
		 * Student s = new Student(); s.setId(2); s.setSname(sn);
		 * s.setEmail("john@gmail.com"); s.getLaptop().add(laptop);
		 * 
		 * laptop.getStudent().add(s);
		 */
		 
    	
        Configuration con = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        SessionFactory sf = con.buildSessionFactory(reg);
        Session session = sf.openSession();
        
        session.beginTransaction();
        
		/*
		 * int d = 20;
		 * 
		 * Query q =
		 * session.createQuery("select id, sname from Student s where s.id > :d");
		 * q.setParameter("d", d); List<Object[]> student = (List<Object[]>) q.list();
		 * for(Object[] s: student) System.out.println(s[0] + " : " + s[1]);
		 */
        
		/*
		 * SQLQuery q = session.createSQLQuery("select * from Student where id > 20");
		 * q.addEntity(Student.class); List<Student> students = q.list(); for(Student s:
		 * students) System.out.println(s);
		 */
        
		/*
		 * SQLQuery q =
		 * session.createSQLQuery("select id, email from Student where id > 20");
		 * q.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP); List students =
		 * q.list(); for(Object o: students) { Map m = (Map)o;
		 * System.out.println(m.get("id") + " : " + m.get("email")); }
		 */
        
		/*
		 * StudentName sn = new StudentName(); sn.setFname("John");
		 * sn.setLname("Chris"); sn.setMname("Roy");
		 * 
		 * Laptop l = new Laptop(); l.setLid(50); l.setLname("Mac 50");
		 * 
		 * Student s = new Student(); s.setId(50); s.setSname(sn);
		 * s.setEmail("john@gmail.com"); s.getLaptop().add(l);
		 * 
		 * l.getStudent().add(s); session.save(l);
		 */
        Laptop lap = (Laptop) session.load(Laptop.class, 30);
        System.out.println(lap);
        session.getTransaction().commit();
		/*
		 * Query q1 = session1.createQuery("from Student where id=1");
		 * q1.setCacheable(true); //session.save(laptop); session.save(s);
		 * 
		 * Student s1 = (Student)q1.uniqueResult();
		 * 
		 * System.out.println(s1); session1.getTransaction().commit(); session1.close();
		 * 
		 * Session session2 = sf.openSession();
		 * 
		 * session2.beginTransaction(); Query q2 =
		 * session2.createQuery("from Student where id=1"); q2.setCacheable(true);
		 * 
		 * Student s2 = (Student)q2.uniqueResult();
		 * 
		 * System.out.println(s2); session2.getTransaction().commit(); session2.close();
		 */
    }
}
