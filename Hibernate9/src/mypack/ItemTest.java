package mypack;

import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ItemTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration c=new Configuration();
		c.configure("hibernate.cfg.xml");
		SessionFactory factory=c.buildSessionFactory();
		Session session=factory.openSession();
		Transaction t=session.beginTransaction();
		Item a1=new Item();
		a1.setName("TV");
		a1.setPrice(50000);
		Item a2=new Item();
		a2.setName("WM");
		a2.setPrice(60000);
		Item a3=new Item();
		a3.setName("AC");
		a3.setPrice(90000);
		Item a4=new Item();
		a4.setName("Freez");
		a4.setPrice(30000);
		Customer c1=new Customer();
		c1.setCustname("Raj");
		c1.setAddr("Pune");
		Customer c2=new Customer();
		c2.setCustname("Amit");
		c2.setAddr("Bombay");
		 ArrayList<Item> l1=new ArrayList<Item>(); 
		 l1.add(a1);
		 l1.add(a2);
		 l1.add(a4);
		 c1.setItm(l1);
		 ArrayList<Item> l2=new ArrayList<Item>(); 
		 l2.add(a1);
		 l2.add(a3);
		 l2.add(a4);
		 c2.setItm(l2);
		 session.persist(c1);
		 session.persist(c2);
		 t.commit();
		 session.close();
	}

}