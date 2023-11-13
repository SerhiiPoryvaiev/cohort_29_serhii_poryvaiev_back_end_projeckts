package hibernate;

import hibernate.domain.Event;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class EntityManagerDemo {

    static EntityManager em;
    public static void main(String[] args) {
        EntityManagerFactory factory=new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
       em = factory.createEntityManager();

        Event event = new Event("Christmas Fair", "Prague");
        event = save(event);
        System.out.println(event);
        System.out.println(findAll());
    }
    static List<Event> findAll(){
        return em.createQuery("SELECT e FROM Event e").getResultList();
    }
    static  Event findById(Integer id){
        return  em.find(Event.class,id);
    }
    static  Event save(Event event){
        em.getTransaction().begin();
        em.persist(event);
        em.getTransaction().commit();
        return event;
    }
    static Event remove(Integer id){
        Event event = findById(id);
        em.getTransaction().begin();
        em.persist(event);
        em.getTransaction().commit();
        return  event;
    }

}
