package com.iluwatar;

/**
 * 
 * Singleton class.
 * Eagerly initialized static instance guarantees thread safety.
 * 
 */
public class IvoryTowerEagerLoadedThreadSafe {

	private static IvoryTowerEagerLoadedThreadSafe instance = new IvoryTowerEagerLoadedThreadSafe();

	private IvoryTowerEagerLoadedThreadSafe() {
	}

	public static IvoryTowerEagerLoadedThreadSafe getInstance() {
		return instance;
	}
}
