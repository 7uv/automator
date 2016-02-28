package com.sayantan.action.factory;

import com.opensymphony.xwork2.ActionInvocation;

import java.io.Serializable;

public interface AppResult extends Serializable {
    public void execute(ActionInvocation inv) throws Exception;
}
