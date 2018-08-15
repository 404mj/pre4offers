package com.github.aop.javassist;

import javassist.ClassPool;
import javassist.Loader;
import javassist.Translator;

/**
 * Author: fengchen.zsx
 * date: 2018/8/15 19:56
 * <p>
 * java -cp .:javassist.jar JavassistRun
 * <p>
 * 在Translator中添加--加载需要hack的类--特殊的逻辑！
 */
public class JavassistRun {

    public static void main(String[] args) {
        args = new String[]{"Run"};
        if (args.length >= 1) {
            try {
                // set up class loader with translator
                Translator xlat = new VerboseTranslator();
                ClassPool pool = ClassPool.getDefault();
                Loader loader = new Loader(pool);
                loader.addTranslator(pool, xlat);

                // invoke "main" method of target class
                String[] pargs = new String[args.length - 1];
                System.arraycopy(args, 1, pargs, 0, pargs.length);

                loader.run(args[0], pargs);

            } catch (Exception e) {
                e.printStackTrace();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }

        } else {
            System.out.println("Usage: JavassistRun main-class args...");
        }
    }
}
