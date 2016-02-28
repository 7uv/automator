package com.sayantan.action;

import com.opensymphony.xwork2.ActionContext;
import com.sayantan.utils.AppSupport;
import org.apache.log4j.Logger;

import java.util.Map;

public class EntryAction extends AppSupport {
    /**
     * This is a sample test class to see that the configuration works.
     */
    private static final long serialVersionUID = -877772134197074L;
    private static final Logger logger = Logger.getLogger(EntryAction.class);
    /*
     * To obtain the session object outside Hibernate
     */
    Map<String, Object> session = ActionContext.getContext().getSession();

    public static void main(String[] args) {
        System.out.println("within main");
        EntryAction tsa = new EntryAction();
        tsa.execute();
    }

    @Override
    public String execute() {
        logger.info("session started!");
        return S;
    }
}
