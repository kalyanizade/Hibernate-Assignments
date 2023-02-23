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
	Transaction  tr=session.beginTransaction();
	Addresss a1=new Addresss();
	a1.setCity("Pune");
	a1.setCountry("India");
	a1.setState("MH");
	Employee  e1=new Employee();
	e1.setEmpname("Amit Patil");
	e1.setSalary(45678);
	e1.setAdr(a1);
	session.save(e1);
	tr.commit();
	session.close();

	}

}