package edu.ncu.pay.demo.common.reponse;

import lombok.Data;

import java.io.Serializable;

@Data
public class Response implements Serializable {
    private static final long serialVersionUID = 7454010471721602036L;

    private boolean success;
    private String code;
    private String message;

}
