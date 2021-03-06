package com.google.code.proto.gcless;

import java.util.Map;
import java.util.HashMap;

final class EnumValue {

	private String name;
	private long id;

	private Map<String, String> options;

        public EnumValue() {
		options = new HashMap<String, String>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

        public void setOption(String option, String value) {
		this.options.put(option, value);
	}

	public Map<String, String> getOptions() {
		return this.options;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		EnumValue other = (EnumValue) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
