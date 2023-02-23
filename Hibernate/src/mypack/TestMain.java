package mypack;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
public class TestMain {

	public static void main(String[] args) {
	Configuration cfg=new Configuration();
	cfg.configure("hibernate.cfg.xml");
SessionFactory factory=cfg.buildSessionFactory();
	Session session=factory.openSession();
Transaction tr=session.beginTransaction();
	Student s1=new Student();
	s1.setRollno(2);
	s1.setStdname("Amit Patil");
	s1.setMarks(70);
	session.save(s1);
	tr.commit();
	session.close();
	}
}