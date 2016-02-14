package com.sayantan.testingbed;

import com.sayantan.model.MessageHibModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import com.sayantan.utils.AppSupport;
import com.sayantan.utils.DBConnector;

import javax.persistence.*;
import java.util.List;

/**
 * Created by USER on 14-02-2016.
 */
public class HelloWorldHibAction extends AppSupport{
    /**
     * This is a sample action to see that the configuration works.
     */
    private static final long serialVersionUID = -8771080778934197074L;

    /*
     * To obtain the session object outside Hibernate
     */
    //Map<String, Object> session = ActionContext.getContext().getSession();
    //private static final Logger logger = Logger.getLogger(Delegate_fwdActionTest.class);
    Logger logger = LogManager.getRootLogger();

    @Override
    public String execute() {
        logger.info(" >>>>>>>>>>>>>>>>>>>>>>>>>> fwd_Action <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");

        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("black", new DBConnector().mysql);

        // First unit of work
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        // Persist data
        MessageHibModel MessageHib = new MessageHibModel("Hello World with JPA and JTA");
        em.persist(MessageHib);

        // Commit & close
        tx.commit();
        em.close();

        // Second unit of work
        EntityManager newEm = emf.createEntityManager();
        EntityTransaction newTx = newEm.getTransaction();
        newTx.begin();

        MessageHibModel m = new MessageHibModel();
        m.setText("Hello World with JPA and JTA");

        @SuppressWarnings("unchecked")
        List<EntityManager> MessageHibs = newEm
                .createQuery(
                        "select m from MessageHibModel m where m.text like :sText order by m.text asc")
                .setParameter("sText", m.getText())
                .setFlushMode(FlushModeType.COMMIT)
                //.setHint("org.hibernate.cacheMode",org.hibernate.CacheMode.IGNORE)
                .setHint("org.hibernate.cacheable", true)
                .setHint("org.hibernate.readOnly", true)
                .setHint("org.hibernate.comment", "My Comment...")
                .setFirstResult(1)
                //.getSingleResult()
                .setMaxResults(20)
                .getResultList();

        System.out.println(MessageHibs.size() + " Message(s) found:");

        for (Object m1 : MessageHibs) {
            MessageHibModel loadedMsg = (MessageHibModel) m1;
            System.out.println(loadedMsg.getText());
        }

        newTx.commit();
        newEm.close();

        // Shutting down the application
        emf.close();
        return "success";
    }
}

