package in.ineuron.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.Model.JobSeeker;
import in.ineuron.util.HibernateUtil;

public class InsertApp {

	public static void main(String[] args) {

		Session session = null;
		Transaction tx = null;
		boolean flag = false;
		byte[] imageContent = null;
		char[] resumeContent = null;

		try (FileInputStream fis = new FileInputStream("photo.jpeg")) {
			imageContent = new byte[(int) fis.available()];
			fis.read(imageContent);
			File f = new File("resume.txt");
			try (FileReader fr = new FileReader(f)) {
				resumeContent = new char[(int) f.length()];
				fr.read(resumeContent);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			session = HibernateUtil.getSession();
			if (session != null) {
				tx = session.beginTransaction();
			}
			if (tx != null) {
				JobSeeker js = new JobSeeker();
				js.setJsName("deepak");
				js.setIsActive(true);
				js.setJsPhoto(imageContent);
				js.setJsResume(resumeContent);
				session.save(js);
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				tx.commit();
				System.out.println("Object saved..! ");
			} else {
				System.out.println("Object failed to save..! ");
				tx.rollback();
			}
		}

	}

}
