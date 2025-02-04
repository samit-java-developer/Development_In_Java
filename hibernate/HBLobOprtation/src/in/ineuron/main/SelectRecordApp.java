package in.ineuron.main;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.hibernate.Session;

import in.ineuron.Model.JobSeeker;
import in.ineuron.util.HibernateUtil;

public class SelectRecordApp {

	public static void main(String[] args) {

		Session session = null;
		session = HibernateUtil.getSession();
		FileOutputStream fo = null;
		FileWriter fw = null;
		try {
			JobSeeker js = session.get(JobSeeker.class, 1);

			JobSeeker js2 = session.get(JobSeeker.class, 1);
			System.out.println(js.hashCode() + " " + js2.hashCode());
			if (js != null) {
				System.out.println("Record found....");
				fo = new FileOutputStream("store/photo.jpeg");
				fo.write(js.getJsPhoto());

				fw = new FileWriter("store/resume.txt");
				fw.write(js.getJsResume());

				fo.flush();
				fw.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fo != null) {
				try {
					fo.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
