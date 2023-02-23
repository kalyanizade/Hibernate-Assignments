package mypack;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestMain {
public static void main(String args[])
{
	Configuration cfg=new Configuration();
	cfg.configure("hibernate.cfg.xml");
	SessionFactory factory=cfg.buildSessionFactory();
	Session session=factory.openSession();
	Transaction tr=session.beginTransaction();
	Employee e1=new Employee();
	e1.setName("Amit Patil");
	Regular_Employee e2=new Regular_Employee();
	e2.setName("Raj Patil");
	e2.setSalary(45546);
	e2.setBonus(5000);
	Contract_Employee e3=new Contract_Employee();
	e3.setName("Ajay Patil");
	e3.setPay_per_hour(500);
	e3.setContract_period("2 years");
	session.save(e1);
	session.save(e2);
	session.save(e3);
	tr.commit();
	session.close();
}
}
