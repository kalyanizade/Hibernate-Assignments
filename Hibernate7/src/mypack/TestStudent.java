package mypack;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
public class TestStudent {

	public static void main(String[] args) {
	Configuration cfg=new Configuration();
	cfg.configure("hibernate.cfg.xml");
	SessionFactory factory=cfg.buildSessionFactory();
	Session session=factory.openSession();
	Scanner sc=new Scanner(System.in);
	int ch;
	do
	{
System.out.println("\n1]Add Record\n2]Update Record\n3]Delete Record\n4]Retrrive All Records\n5]Search record\n6]Specific Records\n7]Exit");
	System.out.println("Enter u r Choice");
	ch=sc.nextInt();
	switch(ch)
	{
	case 1:
		System.out.println("Enter Rollno");
		int rn=sc.nextInt();
		System.out.println("Enter name");
		String nm=sc.next();
		System.out.println("Enter Marks");
		int m=sc.nextInt();
		Student s1=new Student();
		s1.setRollno(rn);
		s1.setStdname(nm);
		s1.setMarks(m);
		Transaction tr=session.beginTransaction();
		session.save(s1);
		System.out.println("Record Inserted");
		tr.commit();
		break;
	case 2:
		System.out.println("Enter Rollno");
		rn=sc.nextInt();
		System.out.println("Enter name");
		nm=sc.next();
		System.out.println("Enter Marks");
		m=sc.nextInt();
		tr=session.beginTransaction();
Query q=session.createQuery("update Student set stdname=:n,marks=:m where rollno=:r");
		q.setParameter("n",nm);
		q.setParameter("m", m);
		q.setParameter("r", rn);
		q.executeUpdate();
		tr.commit();
		System.out.println("Record Updated");
		break;
	case 3:
		System.out.println("Enter Rollno");
		rn=sc.nextInt();
q=session.createQuery("delete from Student where rollno=:r");
		q.setParameter("r",rn);
		tr=session.beginTransaction();
		q.executeUpdate();
		tr.commit();
		System.out.println("Record Deleted");
		break;
	case 4:
		q=session.createQuery("from Student");
		List li=q.list();
		Iterator itr=li.iterator();
		while(itr.hasNext())
		{
			s1=(Student)itr.next();
			System.out.println(s1);
		}
		break;
	case 5:
		System.out.println("Enter Rollno");
		rn=sc.nextInt();
		q=session.createQuery("from Student where rollno=:r");
		q.setParameter("r",rn);
		li=q.list();
		System.out.println(li);
		break;
	case 6:
		q=session.createQuery("from Student");
		q.setFirstResult(1);
		q.setMaxResults(2);
		li=q.list();
		System.out.println(li);
		break;
	}
	}while(ch!=7);
	session.close();
	}
}