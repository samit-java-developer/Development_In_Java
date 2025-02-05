package in.ineuron.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.Model.Employee;
import in.ineuron.util.HibernateUtil;

public class EmployeeTestApp {

	public static void main(String[] args) {
		Session session = null;
		Transaction tx = null;
		boolean flag = false;
		try {
			session = HibernateUtil.getSession();
			if (session != null) {
				tx = session.beginTransaction();
			}
			if (tx != null) {
				Employee employee = new Employee();
				employee.setEmpName("Samit Verma");
				employee.setEmpSal(100000.0);
				session.save(employee);
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				tx.commit();
				System.out.println("Object saved .....!! ");
			} else {
				tx.rollback();
				System.out.println("Object failed to save...!! ");
			}
		}

	}

}
