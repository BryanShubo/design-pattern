package com.iluwatar;

/**
 * Thread-safe Singleton class.
 * The instance is lazily initialized and thus needs synchronization mechanism.
 */
public class IvoryTowerLazyLoadedThreadSafe {

	private static IvoryTowerLazyLoadedThreadSafe instance = null;
	
	private IvoryTowerLazyLoadedThreadSafe() {
	}

	public synchronized static IvoryTowerLazyLoadedThreadSafe getInstance() {
		/*
		 * The instance gets created only when it is called for first time.
		 * Lazy-loading
		 */
		if (instance == null) {
			instance = new IvoryTowerLazyLoadedThreadSafe();
		}

		return instance;
	}
}
