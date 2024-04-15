package com.jsp.PharmacyApplication.util;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseStructuer<T> {
private String mesaage;
private int httpStatusCode;
private Object data;

}
