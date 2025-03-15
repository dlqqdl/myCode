package edu.ncu.pay.demo.common.reponse;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class PageResponse<T> extends Response {
    private static final long serialVersionUID = -8750359054314544811L;
    private int total;
    private int page;
    private int size;

    private List<T> data;

    public PageResponse<T> success(List<T> data) {
        this.data = data;
        this.setSuccess(true);
        return this;
    }

    public PageResponse<T> fail(String code, String msg) {
        this.setSuccess(false);
        this.setCode(code);
        this.setMessage(msg);
        return this;
    }
}
