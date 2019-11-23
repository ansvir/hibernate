import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();
        Session session=factory.openSession();
        Transaction t=session.beginTransaction();

        User u1=new User ();
        User u2=new User ();
        Authority a1=new Authority();
        Authority a2=new Authority();
        Authority a3=new Authority();

        u1.setEmail("aliaksandr@dsads.com");
        u1.setPassword("1245");
        u2.setEmail("mikhail@lhgfl.com");
        u2.setPassword("5421");
        a1.setName("create");
        a2.setName("update");
        a3.setName("insert");

        u1.addAuthority(a1);
        u2.addAuthority(a1);
        u2.addAuthority(a2);
        u2.addAuthority(a3);

        try {
            session.save(u1);
            session.save(u2);
            session.save(a1);
            session.save(a2);
            session.save(a3);
            System.out.println("Successfully saved");
        }
        catch (HibernateException he) {
            System.out.println("Save failed");
        }

        t.commit();
        session.close();
    }
}
