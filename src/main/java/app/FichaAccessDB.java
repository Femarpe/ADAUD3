package app;

import domain.Ficha;
import domain._Ficha_;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.*;
import java.util.List;

public class FichaAccessDB {


    public List<Ficha> getFichas() throws SQLException {
        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Ficha> fichas;

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Ficha> criteria = builder.createQuery(Ficha.class);
        Root<Ficha> root = criteria.from(Ficha.class);
        criteria.select(root);
        fichas = session.createQuery(criteria).getResultList();
        //fichas.forEach(System.out::println);

        return fichas;
    }

    public void insert(Ficha ficha) {


        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            session.save(ficha);

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


        System.out.println("ficha de personaje con id: " + ficha.getIdpersonaje() + " creada");
    }

    public void update(Ficha ficha) {



        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.update(ficha);

        transaction.commit();
        session.close();
        System.out.println("ficha con id: " + ficha.getIdpersonaje() + " actualizada");
    }

    public void delete(int id){


        Session session = HibernateUtil.getSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Ficha> criteria = builder.createQuery(Ficha.class);
        Root<Ficha> root = criteria.from(Ficha.class);
        criteria.select(root).where(builder.equal(root.get((_Ficha_.IDPERSONAJE)), id));
        Ficha ficha = session.createQuery(criteria).getSingleResult();

        session.delete(ficha);
        session.close();

        System.out.println("la ficha con id: " + id + " ha sido borrada");
    }


    public boolean idInside(int id, List<Ficha> fichas) {
        boolean resultado = false;
        for (int i = 0; i < fichas.size(); i++) {
            if (fichas.get(i).getIdpersonaje() == id) {
                resultado = true;
            }
        }

        return resultado;
    }

    public int getPosition(int id, List<Ficha> fichas) {
        int salida = 0;
        for (int i = 0; i < fichas.size(); i++) {
            if (fichas.get(i).getIdpersonaje() == id) {
                salida = i;
            }
        }
        return salida;
    }

}
