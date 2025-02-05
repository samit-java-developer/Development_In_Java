package in.ineuron.main;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import in.ineuron.model.Employee;
import in.ineuron.util.HibernateUtil;

public class SelectRecordApp {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		try {
			Query<Employee> query = session.createQuery("FROM in.ineuron.model.Employee WHERE empId=:id");
			query.setParameter("id", 1);
			List<Employee> employees = query.getResultList();
			employees.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
		}
	}

}
