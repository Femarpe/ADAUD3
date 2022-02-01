package app;

import domain.Acceso;

import domain.Ficha;
import domain._Ficha_;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccesoAccesDB {


    public List<Acceso> getAccesos() throws SQLException {
        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Acceso> accesos;

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Acceso> criteria = builder.createQuery(Acceso.class);
        Root<Acceso> root = criteria.from(Acceso.class);
        criteria.select(root);
        accesos = session.createQuery(criteria).getResultList();
        //accesos.forEach(System.out::println);
        return accesos;
    }

    public void insert(Acceso acceso) throws SQLException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            session.save(acceso);

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
        System.out.println("Acceso con id: " + acceso.getIdacceso() + " creado");
    }



    public void delete(int idacceso) throws SQLException {

        Session session = HibernateUtil.getSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Ficha> criteria = builder.createQuery(Ficha.class);
        Root<Ficha> root = criteria.from(Ficha.class);
        criteria.select(root).where(builder.equal(root.get((_Ficha_.idpersonaje)), idacceso));
        Ficha ficha = session.createQuery(criteria).getSingleResult();

        session.delete(ficha);
        session.close();
        System.out.println("Acceso con id: " + idacceso + " borrado");
    }


    public boolean idInside(int id, List<Acceso> accesos) {
        boolean resultado = false;
        for (int i = 0; i < accesos.size(); i++) {
            if (accesos.get(i).getIdacceso() == id) {
                resultado = true;
            }
        }

        return resultado;
    }

    public int getPosition(int id, List<Acceso> accesos) {
        int salida = 0;
        for (int i = 0; i < accesos.size(); i++) {
            if (accesos.get(i).getIdacceso() == id) {
                salida = i;
            }
        }
        return salida;
    }

    public List<Acceso> accesosPorLogin(int idlogin, List<Acceso> accesos) {
        List<Acceso> salida = new ArrayList<>();
        for (int i = 0; i < accesos.size(); i++) {
            if (accesos.get(i).getIdlogin() == idlogin) {
                salida.add(accesos.get(i));
            }
        }
        return salida;
    }

}
