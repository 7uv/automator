package com.sayantan.action;

import com.sayantan.utils.AppSupport;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Delegate_fwdAction extends AppSupport {
    /**
     * This is a sample test class to see that the configuration works.
     */
    private static final long serialVersionUID = -8771080772134197074L;

	/*
	 * To obtain the session object outside Hibernate
	 */
    //Map<String, Object> session = ActionContext.getContext().getSession();
    //private static final Logger logger = Logger.getLogger(Delegate_fwdActionTest.class);
    Logger logger = LogManager.getRootLogger();

    public static void main(String[] args) {
        Delegate_fwdAction tsa = new Delegate_fwdAction();
        tsa.execute();
    }

    @Override
    public String execute() {
        logger.info(" >>>>>>>>>>>>>>>>>>>>>>>>>> fwd_Action <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        return S;
    }
}
