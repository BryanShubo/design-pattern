package com.iluwatar;

/**
 * Double check locking
 * 
 * http://www.cs.umd.edu/~pugh/java/memoryModel/DoubleCheckedLocking.html
 * 
 * Broken under Java 1.4.
 * @author mortezaadi@gmail.com
 *
 */
public class IvoryTowerDoubleCheckLockingThreadSafe {
	
	private static volatile IvoryTowerDoubleCheckLockingThreadSafe INSTANCE;

	/**
	 * private constructor to prevent client from instantiating.
	 * 
	 */
	private IvoryTowerDoubleCheckLockingThreadSafe() {
		//to prevent instantiating by Reflection call 
		if(INSTANCE != null)
			throw new IllegalStateException("Already initialized.");
	}
	
	public static IvoryTowerDoubleCheckLockingThreadSafe getInstance() {
		//local variable increases performance by 25 percent 
		//Joshua Bloch "Effective Java, Second Edition", p. 283-284
		IvoryTowerDoubleCheckLockingThreadSafe result = INSTANCE;
		if (result == null) {
			synchronized (IvoryTowerDoubleCheckLockingThreadSafe.class) {
				result = INSTANCE;
				if (result == null) {
					INSTANCE = result = new IvoryTowerDoubleCheckLockingThreadSafe();
				}
			}
		}
		return result;
	}
}
