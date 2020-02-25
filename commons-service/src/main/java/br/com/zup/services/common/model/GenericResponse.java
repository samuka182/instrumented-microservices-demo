package br.com.zup.services.common.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GenericResponse<T> implements Serializable {

	private static final long serialVersionUID = -2914741580519325644L;
	private ResultCode resultCode;
    private transient T resultData;
    private MessageResponse error;
    private List<MessageResponse> errors;


    public GenericResponse() {
        super();
    }

    public GenericResponse(T resultData) {
        this.resultData = resultData;
    }

    public GenericResponse<T> appendError(MessageResponse message) {
        if (errors == null) {
            errors = new ArrayList<>();
        }
        errors.add(message);
        return this;
    }

    public GenericResponse<T> appendError(String code) {
        appendError(new MessageResponse(code, ""));
        return this;
    }

    public GenericResponse<T> appendError(String code, String description) {
        appendError(new MessageResponse(code, description));
        return this;
    }

    public boolean hasErrors() {
        return this.errors != null && !this.errors.isEmpty();
    }

    public GenericResponse<T> withErrors(List<MessageResponse> errors) {
        this.setErrors(errors);
        return this;
    }

    public GenericResponse<T> withError(MessageResponse error) {
        this.setError(error);
        return this;
    }

    public GenericResponse<T> withResultData(T resultData) {
        this.setResultData(resultData);
        return this;
    }

    public GenericResponse<T> withResultCode(ResultCode resultCode) {
        this.setResultCode(resultCode);
        return this;
    }

    public ResultCode getResultCode() {
        return resultCode;
    }

    public void setResultCode(ResultCode resultCode) {
        this.resultCode = resultCode;
    }

    public T getResultData() {
        return resultData;
    }

    public void setResultData(T resultData) {
        this.resultData = resultData;
    }

    public MessageResponse getError() {
        return error;
    }

    public void setError(MessageResponse error) {
        this.error = error;
    }

    public List<MessageResponse> getErrors() {
        return errors;
    }

    public void setErrors(List<MessageResponse> errors) {
        this.errors = errors;
    }

}
