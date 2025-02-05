package in.ineuron.generator;

import java.io.Serializable;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class RandomGenerator implements IdentifierGenerator {

	static int no;
	static {
		no = 100;
	}
	static {
		System.out.println("RandomGenerator static block");
	}

	public RandomGenerator() {
		System.out.println("RandomGenerator.RandomGenerator()");
	}

	@Override
	public Serializable generate(SharedSessionContractImplementor arg0, Object arg1) throws HibernateException {
		System.out.println("RandomGenerator.generate()");
		no++;
		return "INEURON" + no;
	}

}
