package Controler;

import Entity.ManufactureEntity;
import Hibernate.HibernateUtils;
import Repository.Repository;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class manufactureDAO<E extends ManufactureEntity> implements Repository<E> {
    @Override
    public boolean add(E e) {
        try(Session session = HibernateUtils.getSessionFactory().openSession();){
            session.beginTransaction();
            session.save(e);
            session.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }


    @Override
    public E get(String id) {
        try(Session session = HibernateUtils.getSessionFactory().openSession();){
            session.beginTransaction();
            ManufactureEntity manu = session.get(ManufactureEntity.class, id);
            return (E) manu;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<E> getAll() {
        try(Session session = HibernateUtils.getSessionFactory().openSession();) {
            session.beginTransaction();
            return (List<E>) session.createQuery("FROM ManufactureEntity", ManufactureEntity.class).list();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean remove(String id) {
        try(Session session = HibernateUtils.getSessionFactory().openSession();) {
            session.beginTransaction();
            ManufactureEntity manu = session.get(ManufactureEntity.class,id);
            if(manu!=null){
                session.delete(manu);
                session.getTransaction().commit();
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean remove(E e) {
        try(Session session = HibernateUtils.getSessionFactory().openSession();) {
            session.beginTransaction();
            session.delete(e);
            session.getTransaction().commit();
            return true;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(E e) {
        try(Session session = HibernateUtils.getSessionFactory().openSession();){
            session.beginTransaction();
            ManufactureEntity manu = session.get(ManufactureEntity.class,e.getIdManu());
            if(manu!=null){
                manu.setName(e.getName());
                manu.setEmployee(e.getEmployee());
                manu.setLocation(e.getLocation());
                session.update(manu);
                session.getTransaction().commit();
                return true;
            }
        }catch (Exception exception) {
            exception.printStackTrace();
        }
        return false;
    }
    public void insertvalues(){
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            session.beginTransaction();
            ManufactureEntity manu = new ManufactureEntity();
            manu.setIdManu(String.valueOf(1));
            manu.setName("Apple");
            manu.setLocation("US");
            manu.setEmployee(10000);
            session.save(manu);
            ManufactureEntity manu1 = new ManufactureEntity();
            manu1.setIdManu(String.valueOf(2));
            manu1.setName("Samsung");
            manu1.setLocation("Korea");
            manu1.setEmployee(1000);
            session.save(manu1);

            ManufactureEntity manu2 = new ManufactureEntity();
            manu2.setIdManu(String.valueOf(3));
            manu2.setName("Laptop");
            manu2.setLocation("Vietname");
            manu2.setEmployee(100);
            session.save(manu2);

            ManufactureEntity manu3 = new ManufactureEntity();
            manu3.setIdManu(String.valueOf(4));
            manu3.setName("CP");
            manu3.setLocation("US");
            manu3.setEmployee(100);
            session.save(manu3);

            ManufactureEntity manu4 = new ManufactureEntity();
            manu4.setIdManu(String.valueOf(5));
            manu4.setName("Acer");
            manu4.setLocation("China");
            manu4.setEmployee(100);
            session.save(manu4);

            session.getTransaction().commit();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public boolean checkAllManufactureHaveMoreThan100Employee(E manu){
        try(Session session = HibernateUtils.getSessionFactory().openSession();){
            session.beginTransaction();
            if(manu.getEmployee()>100) {
                return true;
            }
        }
        return false;
    }

    public long sumOfAllEmployeesOfTheManufacture(){
        try(Session session = HibernateUtils.getSessionFactory().openSession();) {
            session.beginTransaction();
            List<ManufactureEntity> manuList = session.createQuery("From ManufactureEntity ",ManufactureEntity.class).list();
            long sum = 0;
            for(ManufactureEntity manu:manuList){
                sum = sum + manu.getEmployee();
            }
            return sum;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return 0;
    }
    public E manufactureAtUS(){
        try(Session session = HibernateUtils.getSessionFactory().openSession();) {
            session.beginTransaction();

            Query<E> query = (Query<E>) session.createQuery("FROM ManufactureEntity WHERE location = 'US' ORDER BY idManu DESC", ManufactureEntity.class);
            query.setMaxResults(1);
            E manufacturer = query.uniqueResult();

            session.getTransaction().commit();
            if (manufacturer == null) {
                throw new InvalidOperationException("No manufacturer found in the USA.");
            }
            return manufacturer;
        } catch (InvalidOperationException e) {
            throw new RuntimeException(e);
        }
    }
}
