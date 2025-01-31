package in.ineuron.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.Model.Employee;
import in.ineuron.util.HibernateUtil;

public class DeleteRecordApp {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSession();
		Transaction transaction = null;
		Boolean flag = false;

		try {
			transaction = session.beginTransaction();
			Employee employee = new Employee();
			employee.setEmpId(22);
			session.delete(employee);
			flag = true;
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
