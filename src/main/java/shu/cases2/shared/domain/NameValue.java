package shu.cases2.shared.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class NameValue {
	 private final String value;
	private final String name;
	  
	@JsonCreator
	public NameValue(@JsonProperty("name") String name, @JsonProperty("value") String value) {
		 this.name = name;
		 this.value = value;
	}

    public String getValue() {
		return value;
	}

	public String getName() {
		return name;
	}

}
