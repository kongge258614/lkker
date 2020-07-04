package com.lkker.authentication.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * @author liliang on 2018/5/16.
 */
public class UsernameIsExitedException extends AuthenticationException {

    public UsernameIsExitedException(String msg) {
        super(msg);
    }

    public UsernameIsExitedException(String msg, Throwable t) {
        super(msg, t);
    }
}