package com.company;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import java.lang.annotation.Annotation;

/**
 * Created by maxim on 09.04.2021.
 */
public class HibernateUtil {
    private static SessionFactory factory;

    static {
        try {
            factory = new AnnotationConfiguration()
                    .configure("/com/company/hibernate.cfg.xml")
                    .buildSessionFactory();
        }catch (HibernateException e){
            e.printStackTrace();
        }
    }

    public static SessionFactory getFactory(){
        return factory;
    }
}
