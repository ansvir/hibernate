import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AddToDB {
    public static void main(String[] args) {
        //creating configuration object
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file
        //creating seession factory object
        SessionFactory factory=cfg.buildSessionFactory();
        //creating session object
        Session session=factory.openSession();
        //creating transaction object
        Transaction t=session.beginTransaction();
        User ue1=new User ();
        Authority ae1=new Authority();
//        Table te1=new Table();
        User ue2=new User ();
        Authority ae2=new Authority();
//        Table te2=new Table();
        ue1.setId(124);
        ue1.setEmail("aleksandr@dsads.com");
        ue1.setPassword("1245");
        ae1.setId(124);
        ae1.setName("Aleksandr");
//        te1.setAuthId(124);
//        te1.setUserId(124);
        ue2.setId(140);
        ue2.setEmail("mikhail@lhgfl.com");
        ue2.setPassword("5421");
        ae2.setId(140);
        ae2.setName("Mikhail");
//        te2.setAuthId(140);
//        te2.setUserId(140);
        session.persist(ue1);//persisting the object
        session.persist(ae1);
        session.persist(ue2);//persisting the object
        session.persist(ae2);
//        session.persist(te1);
//        session.persist(te2);
        t.commit();//transaction is commited
        session.close();
        System.out.println("successfully saved");
    }
}
