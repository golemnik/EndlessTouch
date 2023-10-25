package com.golem.tech.schema.basicRealesations.mTransferBasics.exceptions;

public class ContainerTransformException extends RuntimeException{
    public ContainerTransformException (String expected, String provided) {
        super("Expected " +
                "<" + expected + ">" +
                " ---> provided " +
                "<" + provided + ">");
    }
}
