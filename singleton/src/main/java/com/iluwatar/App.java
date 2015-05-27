package com.iluwatar;

/**
 *
 * Singleton pattern ensures that the class (IvoryTower) can have only one
 * existing instance and provides global access to that instance.
 *
 * http://stackoverflow.com/questions/70689/what-is-an-efficient-way-to-implement-a-singleton-pattern-in-java
 *
 */
public class App {

	public static void main(String[] args) {

		// eagerly initialized singleton
		IvoryTowerEagerLoadedThreadSafe ivoryTower1 = IvoryTowerEagerLoadedThreadSafe.getInstance();
		IvoryTowerEagerLoadedThreadSafe ivoryTower2 = IvoryTowerEagerLoadedThreadSafe.getInstance();
		System.out.println("ivoryTower1=" + ivoryTower1);
		System.out.println("ivoryTower2=" + ivoryTower2);
        System.out.println();

		// lazily initialized singleton
		IvoryTowerLazyLoadedThreadSafe threadSafeIvoryTower1 = IvoryTowerLazyLoadedThreadSafe
				.getInstance();
		IvoryTowerLazyLoadedThreadSafe threadSafeIvoryTower2 = IvoryTowerLazyLoadedThreadSafe
				.getInstance();
		System.out.println("threadSafeIvoryTower1=" + threadSafeIvoryTower1);
		System.out.println("threadSafeIvoryTower2=" + threadSafeIvoryTower2);
        System.out.println();

		// enum singleton
		IvoryTowerEnum enumIvoryTower1 = IvoryTowerEnum.INSTANCE;
		IvoryTowerEnum enumIvoryTower2 = IvoryTowerEnum.INSTANCE;
		System.out.println("enumIvoryTower1=" + enumIvoryTower1);
		System.out.println("enumIvoryTower2=" + enumIvoryTower2);
        System.out.println();



        IvoryTowerDoubleCheckLockingThreadSafe dcl1 = IvoryTowerDoubleCheckLockingThreadSafe.getInstance();
        System.out.println(dcl1);
        IvoryTowerDoubleCheckLockingThreadSafe dcl2 = IvoryTowerDoubleCheckLockingThreadSafe.getInstance();
        System.out.println(dcl2);
        System.out.println();

        InitializingOnDemandHolderIdiom demandHolderIdiom = InitializingOnDemandHolderIdiom.getInstance();
		System.out.println(demandHolderIdiom);
		InitializingOnDemandHolderIdiom demandHolderIdiom2 = InitializingOnDemandHolderIdiom.getInstance();
		System.out.println(demandHolderIdiom2);
        System.out.println();


    }
}
