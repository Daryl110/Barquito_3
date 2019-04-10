package com.eam.modelo;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Alvaro Corrales
 */
public class Conexion {
        
        private final String HOST_BD = "localhost",
                BD = "mydb",
                USUARIO_BD = "root",
                CONTRASENA_BD = "",
                DRIVER_BD = "com.mysql.jdbc.Driver",
                SERVIDOR_BD = "mysql",
                DIALECTO_BD = "org.hibernate.dialect.MySQL5InnoDBDialect",
                SHOW_SQL = "true",
                FORMAT_SQL = "true",
                ARQUITECTURA_JPA = "validate",
                PARAMETROS_CONEXION = "useTimezone=true&serverTimezone=GMT";
    
	private EntityManagerFactory factory;
        
        public Conexion(String unidad){
            //<editor-fold defaultstate="collapsed" desc=" Propiedades del persistence.xml ">
            /**
             * <properties>
                    <!-- Configuring JDBC properties -->
                    <property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/juzgado"/>
                    <property name="javax.persistence.jdbc.user" value="root"/>
                    <property name="javax.persistence.jdbc.password" value=""/>
                    <property name="javax.persistence.jdbc.driver" value="com.mysql.jdbc.Driver"/>
                    <!-- Hibernate properties -->
                    <property name="hibernate.show_sql" value="true"/>
                    <property name="hibernate.format_sql" value="true"/>
                    <property name="hibernate.dialect" value="org.hibernate.dialect.MySQL5InnoDBDialect"/>
                    <property name="hibernate.hbm2ddl.auto" value="validate"/>
                    <!-- Configuring Connection Pool 
                    <property name="hibernate.c3p0.min_size" value="5"/>
                    <property name="hibernate.c3p0.max_size" value="20"/>
                    <property name="hibernate.c3p0.timeout" value="500"/>
                    <property name="hibernate.c3p0.max_statements" value="50"/>
                    <property name="hibernate.c3p0.idle_test_period" value="2000"/>-->
                </properties>
            */
            //</editor-fold>
            Map propiedades = new HashMap();
            //Propiedades de la persistencia
            propiedades.put("javax.persistence.jdbc.url", "jdbc:"+SERVIDOR_BD+"://"+HOST_BD+":3306/"+BD+"?"+PARAMETROS_CONEXION);
            propiedades.put("javax.persistence.jdbc.user", USUARIO_BD);
            propiedades.put("javax.persistence.jdbc.password", CONTRASENA_BD);
            propiedades.put("javax.persistence.jdbc.driver", DRIVER_BD);
            //Propiedades del hibernate
            propiedades.put("hibernate.show_sql", SHOW_SQL);
            propiedades.put("hibernate.format_sql", FORMAT_SQL);
            propiedades.put("hibernate.dialect", DIALECTO_BD);
            propiedades.put("hibernate.hbm2ddl.auto", ARQUITECTURA_JPA);
            
            factory = Persistence.createEntityManagerFactory(unidad, propiedades);
        }

	public EntityManagerFactory getFactory() {
		return factory;
	}

	public void setFactory(EntityManagerFactory factory) {
		this.factory = factory;
	}
	
	
}
