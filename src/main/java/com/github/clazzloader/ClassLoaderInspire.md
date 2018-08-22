当JVM要加载某个类时，是用当前所在类的ClassLoader加载的..如果使用自定的类加载器替换掉Application Loader怎么办？一下就是：

```java
if (!(this.getClass().getClassLoader() instanceOf CustomClassLoader)) {
            ClassLoader customClassLoader = ... // init CustomClassLoader
            Class<?> mainClass = customClassLoader.loadClass(this.getClass().getName());
            Object main = mainClass.newInstance();
            mainClass.getDeclaredMethod("foo").invoke(main);
            return;
        }
        ClassA a = new ClassA();
        a.methodB();
```
### ContextClassLoader作用

ContextClassLoader是每个线程持有的一个ClassLoader的应用，当一个线程被创建时会从父线程继承。
根据双亲委派机制，父ClassLoader是无法加载到子Classloader的classpath下的类的，那么当有这种需求出现时怎么办呢？

例子：jdbc的java.sql.DriverManager是rt.jar中的类，有Bootstrap加载，当需要记载特定的mysql jar包时，需要使用app loader是加载不到的，这时候使用contextclassLoader就可以了！

---
### Pandora是为了解决jar包依赖冲突。那么：

- 什么时候出现冲突？怎么出现的？怎么解决？

应用程序使用了hsf和metaq， hsf使用fastjson-1.0中的A方法，metaq使用了fastjson-2.0中的B->C。jvm加载类的时候，加载的不一样，就会导致ClassNotFound和MethodNotFound
因为双亲委派，fastjson可能只会被AppLoader加载一次！所以这两个依赖的不同必然导致问题！

- 解决

了解了原因， 解决思路也很直接：既然依赖两个不同的，那我就给你加载两个不同的->使用不同的加载器自然是不同的。 在双亲委派的体制下实现这个思路。

- 衍生问题

创建自定义的Loader加载类可以避免冲突，但是之间怎么相互调用呢？CustomePandoraMain.java 表示，类加载只负责加载，到jvm中都是可以相互使用的！

- 反编译

javap -verbose CustomPandoraMain.class

1.Constant pool 常量池中记录了每个方法的Methodref引用。

2.invokevirtual调用虚方法(静态方法、私有方法、实例构造器、父类方法、final方法都是非虚方法 :程序在编译时，就可以唯一确定一个可调用的版本，且这个方法在运行期不可改变)。

编译阶段类的相关调用已经确认了,写到了class的字节码文件中, jvm只是负责将相关的class加载到内存中。

### 我的疑问

metaq依赖fastjson2.0，按照我们的思路使用LoaderA加载，hsf依赖fastjson1.0,由LoaderB加载，metaQ需要使用HSF的时候怎么办？
其实站在JVM的角度上结合上面的"衍生问题"，类加载只负责加载类，进入JVM之后就可以相互调用了啊！所以，按我的理解metaq用HSF的时候，用的就是LoaderA
加载进来的依赖fastjson1.0的HSF，是没有问题的！

### 

之前用OSGi作隔离，保留了.sar的后缀。







