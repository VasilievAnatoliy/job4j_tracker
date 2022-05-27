package ru.job4j.tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.List;

public class HbmTracker implements Store, AutoCloseable {
    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();
    private final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();

    @Override
    public Item add(Item item) {
        Session session = sf.openSession();
        session.beginTransaction();
        session.save(item);
        session.getTransaction().commit();
        session.close();
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        boolean result = false;
        Session session = sf.openSession();
        session.beginTransaction();
        Query query = session.createQuery(
                "update Item s set s.item = :newItem where s.id = :fId");
        query.setParameter("newItem", item);
        query.setParameter("fId", id);
        result = query.executeUpdate() > 0;
        session.getTransaction().commit();
        session.close();
        return result;
    }

    @Override
    public boolean delete(int id) {
        boolean result = false;
        Session session = sf.openSession();
        session.beginTransaction();
        Query query = session.createQuery("delete from Student where id = :fId");
        query.setParameter("fId", id);
        result = query.executeUpdate() > 0;
        session.getTransaction().commit();
        session.close();
        return result;
    }

    @Override
    public List<Item> findAll() {
        Session session = sf.openSession();
        session.beginTransaction();
        List result = session.createQuery("from Item").list();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    @Override
    public List<Item> findByName(String name) {
        Session session = sf.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Item s where s.name = :fName");
                query.setParameter("fName", name);
                List result = (List) query;
        session.getTransaction().commit();
        session.close();
        return result;
    }

    @Override
    public Item findById(int id) {
        Session session = sf.openSession();
        session.beginTransaction();
        Item result = session.get(Item.class, id);
        session.getTransaction().commit();
        session.close();
        return result;
    }

    @Override
    public void close() throws Exception {
        StandardServiceRegistryBuilder.destroy(registry);
    }
}