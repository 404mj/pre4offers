package com.github.aop.javassist;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.NotFoundException;
import javassist.Translator;

/**
 * Author: fengchen.zsx
 * date: 2018/8/15 19:57
 */
public class VerboseTranslator implements Translator {

    @Override
    public void start(ClassPool classPool) throws NotFoundException, CannotCompileException {

    }

    public void onWrite(ClassPool pool, String cname) {
        System.out.println("onWrite called for " + cname);
    }

    @Override
    public void onLoad(ClassPool classPool, String s) throws NotFoundException, CannotCompileException {

    }
}
