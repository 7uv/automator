/**
 * @author suv
 */
package com.sayantan.action.factory;

import com.opensymphony.xwork2.ActionInvocation;

import java.io.Serializable;

public interface AppInterceptor extends Serializable {
    void init();

    void destroy();

    String intercept(ActionInvocation inv) throws Exception;
}
