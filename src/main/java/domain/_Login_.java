package domain;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Ficha.class)
public class _Login_ {
    public static volatile SingularAttribute<Login, Integer> id;
    public static volatile SingularAttribute<Login, String> username;
    public static volatile SingularAttribute<Login, String> password;
    public static volatile SingularAttribute<Login, Timestamp> created_at;



    public static final String ID = "id";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String CREATED_AT = "created_at";

}
