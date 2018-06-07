package com.exampleserver.demo.Dao;

import com.exampleserver.demo.Entities.task;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Component
public class taskDaoImpl implements taskDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<task> getAllTasks() {
        Session session = sessionFactory.openSession();

        Criteria criteria = session.createCriteria(task.class);
        List<task> list = criteria.list();
        return list;
    }

    @Override
    public task saveTask(task task) {
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        session.save(task);

        session.getTransaction().commit();
        return task;

    }

    @Override
    public int deleteTaskById(int id) {
        Session session = sessionFactory.openSession();

        task task = session.get(task.class, id);

        if (task == null) {
            return 0;

        } else {

            session.beginTransaction();

            session.delete(task);

            session.getTransaction().commit();

            return 1;
        }
    }

    @Override
    public task updateTask(task b) {
        Session session = sessionFactory.openSession();


        session.beginTransaction();

        session.update(b);

        session.getTransaction().commit();

        return b;
    }
}
