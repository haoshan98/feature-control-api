package com.haoshan.featurecontrolapi.exception;

import java.text.MessageFormat;

public class CustomNotFoundException extends RuntimeException{

    public CustomNotFoundException(String msg, Object ...vars) {
        super(MessageFormat.format(msg, vars));
    }
}
