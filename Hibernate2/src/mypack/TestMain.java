package mypack;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.*;
public class TestMain {

	public static void main(String[] args) {
	Configuration cfg=new Configuration();
	cfg.configure("hibernate.cfg.xml");
	SessionFactory factory=cfg.buildSessionFactory();
	Session session=factory.openSession();
	Transaction tr=session.beginTransaction();
Scanner sc=new Scanner(System.in);
String ch;
do
{
	Book b1=new Book();
	System.out.println("Enter bookid");
	int id=sc.nextInt();
	System.out.println("Enter title");
	sc.nextLine();
	String tit=sc.nextLine();
	System.out.println("Enter price");
	int pr=sc.nextInt();
	b1.setBid(id);
	b1.setTitle(tit);
	b1.setPrice(pr);
	session.save(b1);
	System.out.println("Add Another record?yes/no");
	ch=sc.next();
}while(ch.equals("yes"));
tr.commit();
session.close();	
}
	}