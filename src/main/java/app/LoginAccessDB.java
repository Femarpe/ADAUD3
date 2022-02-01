package app;

import domain.Ficha;
import domain.Login;
import domain._Login_;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.*;
import java.util.List;

public class LoginAccessDB {


    public List<Login> getLogins() throws SQLException {
        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Login> logins;

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Login> criteria = builder.createQuery(Login.class);
        Root<Login> root = criteria.from(Login.class);
        criteria.select(root);
        logins = session.createQuery(criteria).getResultList();
        //logins.forEach(System.out::println);
        return logins;
    }

    public void insert(Login login) throws SQLException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            session.save(login);

        } catch (Exception e) {
            if (session != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            {
                session.getTransaction().commit();
                session.close();
            }
        }
        System.out.println("usuario con id: " + login.getId() + " creado");
    }
    public void update(Login login) throws SQLException {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.update(login);

        transaction.commit();
        session.close();
        System.out.println("usuario con id: " + login.getId() + " actualizado");
    }

    public void delete(int idlogin) throws SQLException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Ficha> criteria = builder.createQuery(Ficha.class);
        Root<Ficha> root = criteria.from(Ficha.class);
        criteria.select(root).where(builder.equal(root.get((_Login_.ID)), idlogin));
        Ficha ficha = session.createQuery(criteria).getSingleResult();

        session.delete(ficha);
        session.close();
        System.out.println("usuario con id: " + idlogin + " borrado");

    }


    public boolean idInside(int id, List<Login> logins) {
        boolean resultado = false;
        for (int i = 0; i < logins.size(); i++) {
            if (logins.get(i).getId() == id) {
                resultado = true;
            }
        }

        return resultado;
    }

    public int getPosition(int id, List<Login> logins) {
        int salida = 0;
        for (int i = 0; i < logins.size(); i++) {
            if (logins.get(i).getId() == id) {
                salida = i;
            }
        }
        return salida;
    }
}
