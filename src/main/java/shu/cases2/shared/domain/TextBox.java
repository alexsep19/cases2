package shu.cases2.shared.domain;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TextBox implements Serializable{
	private static final long serialVersionUID = 1L;
	private Boolean checkbox;
	private String name;
    private Date birthday;
 
    public TextBox(){}
    
    @JsonCreator
	public TextBox(@JsonProperty("checkbox") boolean checkbox, @JsonProperty("name") String name , @JsonProperty("birthday") Date birthday){
    	this.checkbox = checkbox;
    	this.name = name;
    	this.birthday = birthday;
	}

    public Boolean isCheckbox() {
		return checkbox;
	}

	public void setCheckbox(Boolean checkbox) {
		this.checkbox = checkbox;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
}
