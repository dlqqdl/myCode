package edu.ncu.pay.demo.common.reponse;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class SingleResponse<T> extends Response {
    private static final long serialVersionUID = -8750359054314544811L;

    private T data;

    public SingleResponse<T> success(T data) {
        this.data = data;
        this.setSuccess(true);
        return this;
    }

    public SingleResponse<T> fail(String code, String msg) {
        this.setSuccess(false);
        this.setCode(code);
        this.setMessage(msg);
        return this;
    }
}
