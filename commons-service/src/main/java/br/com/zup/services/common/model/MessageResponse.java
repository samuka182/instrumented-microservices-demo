package br.com.zup.services.common.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MessageResponse implements Serializable {

	private static final long serialVersionUID = 8832257059702667895L;
	private String code;
    private String description;
    private String complement;
    @JsonIgnore
    private transient Object[] params;

    public MessageResponse(){
    }

    public MessageResponse(String code) {
        this.code = code;
    }

    public MessageResponse(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public MessageResponse(String code, String description, Object... params) {
        this.code = code;
        this.description = description;
        this.params = params;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("MessageResponse [code=");
        builder.append(code);
        builder.append(", description=");
        builder.append(description);
        builder.append(", complement=");
        builder.append(complement);
        builder.append("]");
        return builder.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((code == null) ? 0 : code.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        MessageResponse other = (MessageResponse) obj;
        if (code == null) {
            if (other.code != null)
                return false;
        } else if (!code.equals(other.code)) {
            return false;
        }
        return true;
    }
}
