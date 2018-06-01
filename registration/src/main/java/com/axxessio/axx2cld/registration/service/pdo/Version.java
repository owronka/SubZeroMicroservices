package com.axxessio.axx2cld.registration.service.pdo;

import java.math.BigInteger;

import javax.persistence.EntityManager;

public class Version {
	private static long version = 3;
	
	private static BigInteger sequence = null;

	private Version () {
		
	}
	
	synchronized public static long getNextVersion (EntityManager em) {
		if (sequence == null || version == sequence.longValue()) {
			sequence = (BigInteger) em.createNativeQuery("values (next value for A2C_VERSION)").getResultList().get(0);
		}
		
		version++;
		
		return version;
	}
}
