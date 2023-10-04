package Controler;


import Entity.PhoneEntity;
import Hibernate.HibernateUtils;
import Repository.Repository;
import org.hibernate.Session;
import org.hibernate.query.Query;
import java.util.List;

public class phoneDAO <E extends PhoneEntity> implements Repository<E> {
    @Override
    public boolean add(E e) {
        try (Session session = HibernateUtils.getSessionFactory().openSession();) {
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
        try (Session session = HibernateUtils.getSessionFactory().openSession();) {
            session.beginTransaction();
            PhoneEntity phone = session.get(PhoneEntity.class, id);
            return (E) phone;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<E> getAll() {

        try (Session session = HibernateUtils.getSessionFactory().openSession();) {
            session.beginTransaction();
            return (List<E>) session.createQuery("FROM PhoneEntity ", PhoneEntity.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean remove(String id) {
        try (Session session = HibernateUtils.getSessionFactory().openSession();) {
            session.beginTransaction();
            PhoneEntity phone = session.get(PhoneEntity.class, id);
            if (phone != null) {
                session.delete(phone);
                session.getTransaction().commit();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean remove(E e) {
        try (Session session = HibernateUtils.getSessionFactory().openSession();) {
            session.beginTransaction();
            session.delete(e);
            session.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(E e) {
        try (Session session = HibernateUtils.getSessionFactory().openSession();) {
            session.beginTransaction();
            PhoneEntity phone = session.get(PhoneEntity.class, e.getIdPhone());
            if (phone != null) {
                phone.setIdPhone(e.getIdPhone());
                phone.setColor(e.getColor());
                phone.setCountry(e.getCountry());
                phone.setPrice(e.getPrice());
                phone.setIdManu(e.getIdManu());
                phone.setQuantity(e.getQuantity());
                session.update(phone);
                session.getTransaction().commit();
                return true;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return false;
    }

    public void insertvalues() {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            session.beginTransaction();
            PhoneEntity phone1 = new PhoneEntity("1", "1", "Iphone", 100000000, "Gold", "USUK", 1000);
            PhoneEntity phone2 = new PhoneEntity("2", "1", "Samsung", 1000000, "White", "Chiana", 1000);
            PhoneEntity phone3 = new PhoneEntity("3", "1", "Acer", 100000000, "Pink", "Cambuchia", 1000);
            PhoneEntity phone4 = new PhoneEntity("4", "1", "Xiome", 1000000, "Black", "China", 1000);
            session.save(phone1);
            session.save(phone2);
            session.save(phone3);
            session.save(phone4);
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public E highestPhonePrice() {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            session.beginTransaction();
            Query<PhoneEntity> query = session.createQuery("FROM PhoneEntity ORDER BY price DESC", PhoneEntity.class);
            query.setMaxResults(1);
            E phoner = (E) query.uniqueResult();
            session.getTransaction().commit();
            return phoner;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<E> orderByCountryAndPriceDESC() {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            session.beginTransaction();
            List<PhoneEntity> phonelist = session.createQuery("FROM PhoneEntity ORDER BY country DESC,price desc ", PhoneEntity.class).list();
            return (List<E>) phonelist;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean checkPriceAbove50(E phone) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            session.beginTransaction();
            if(phone.getPrice()>50000000){return true;}
            return false;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
    public E getFirstPhoneHasPinkColorAndAbove15(){
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            session.beginTransaction();
            Query<PhoneEntity> query = session.createQuery("From PhoneEntity where color = 'Pink'and price > 15000000",PhoneEntity.class);
            List<PhoneEntity> phoneList = query.getResultList();

            session.getTransaction().commit();

            return phoneList.isEmpty() ? null : (E) phoneList.get(0);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
