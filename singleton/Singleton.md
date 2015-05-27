###Singleton

#####Eager Loaded Thread Safe
```
Eagerly initialized static instance guarantees thread safety.
```

#####Lazy Loaded Thread Safe
```
The instance is lazily initialized and thus needs synchronization mechanism.
It has low efficient.
```

#####Enum
```
这种方式是Effective Java作者Josh Bloch 提倡的方式，它不仅能避免多线程同步问题，
而且还能防止反序列化重新创建新的对象，可谓是很坚强的壁垒啊，不过，个人认为由于1.5中才加入enum特性，
用这种方式写不免让人感觉生疏，在实际工作中，我也很少看见有人这么写过。
```

#####Double Check Locking Thread Safe


#####Initializaing On Demand Holder Idiom
```
 * Singleton objects usually are heavy to create and sometimes need to serialize them.
 * This class also shows how to preserve singleton in Serialized version of singleton.
```

```
这种方式同样利用了classloder的机制来保证初始化instance时只有一个线程，它跟第三种和第四种方式不同的是
（很细微的差别）：第三种和第四种方式是只要Singleton类被装载了，那么instance就会被实例化
（没有达到lazy loading效果），而这种方式是Singleton类被装载了，instance不一定被初始化。
因为SingletonHolder类没有被主动使用，只有显示通过调用getInstance方法时，才会显示装载SingletonHolder
类，从而实例化instance。想象一下，如果实例化instance很消耗资源，我想让他延迟加载，另外一方面，
我不希望在Singleton类加载时就实例化，因为我不能确保Singleton类还可能在其他的地方被主动使用从而被加载，
那么这个时候实例化instance显然是不合适的。这个时候，这种方式相比第三和第四种方式就显得很合理。
```


##### Two Questions
```
有两个问题需要注意：

1.如果单例由不同的类装载器装入，那便有可能存在多个单例类的实例。假定不是远端存取，例如一些servlet容器对每个
servlet使用完全不同的类装载器，这样的话如果有两个servlet访问一个单例类，它们就都会有各自的实例。

2.如果Singleton实现了java.io.Serializable接口，那么这个类的实例就可能被序列化和复原。
不管怎样，如果你序列化一个单例类的对象，接下来复原多个那个对象，那你就会有多个单例类的实例。

对第一个问题修复的办法是：

Java代码

1. private static Class getClass(String classname)

2. throws ClassNotFoundException {

3. ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

4.

5. if(classLoader == null)

6. classLoader = Singleton.class.getClassLoader();

7.

8. return (classLoader.loadClass(classname));

9. }

10. }

对第二个问题修复的办法是：

Java代码

1. public class Singleton implements java.io.Serializable {
2. public static Singleton INSTANCE = new Singleton();

3.

4. protected Singleton() {

5.

6. }

7. private Object readResolve() {

8. return INSTANCE;

9. }

10. }

对我来说，我比较喜欢第三种和第五种方式，简单易懂，而且在JVM层实现了线程安全（如果不是多个类加载器环境），
一般的情况下，我会使用第三种方式，只有在要明确实现lazy loading效果时才会使用第五种方式，另外，
如果涉及到反序列化创建对象时我会试着使用枚举的方式来实现单例，不过，我一直会保证我的程序是线程安全的，
而且我永远不会使用第一种和第二种方式，如果有其他特殊的需求，我可能会使用第七种方式，毕竟，JDK1.5已经没有双重检查锁定的问题了。

```

