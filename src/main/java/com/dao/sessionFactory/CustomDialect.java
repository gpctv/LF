package com.dao.sessionFactory;

import java.sql.Types;

import org.hibernate.dialect.SQLServerDialect;
import org.hibernate.type.StandardBasicTypes;

public class CustomDialect extends SQLServerDialect{
	public CustomDialect() {   
        super();   
        registerHibernateType(Types.NCHAR, StandardBasicTypes.CHARACTER.getName()); 
        registerHibernateType(Types.NCHAR, 1, StandardBasicTypes.CHARACTER.getName());
        registerHibernateType(Types.NCHAR, 255, StandardBasicTypes.STRING.getName());
        registerHibernateType(Types.NVARCHAR, StandardBasicTypes.STRING.getName()); 
    }  
}
