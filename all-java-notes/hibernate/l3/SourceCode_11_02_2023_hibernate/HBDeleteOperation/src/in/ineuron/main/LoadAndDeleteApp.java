package in.ineuron.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.Model.Employee;
import in.ineuron.util.HibernateUtil;

public class LoadAndDeleteApp {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSession();
		Transaction transaction = null;
		Boolean flag = false;
		Employee employee = null;

		try {
			transaction = session.beginTransaction();
			employee = session.get(Employee.class, 21);
			if (employee != null) {
				session.delete(employee);
				flag = true;
			} else {
				System.out.println("Record not avaialble to delete");
				System.exit(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("object deleted...");
			} else {
				transaction.rollback();
				System.out.println("object failed to delete...");
			}
		}
	}

}
