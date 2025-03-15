package edu.ncu.pay.demo.common.request;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class PageRequest<T> extends Request {
    private static final long serialVersionUID = -8750359054314544811L;
    private int page;
    private int size;
    private T param;
}
