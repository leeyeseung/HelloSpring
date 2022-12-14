package com.sample.myapp;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Customer {
	private List<Object> lists;
	private Set<Object> sets;
	private Map<String, Object> maps;
	private Properties props;
	
	public List<Object> getLists() {
		return lists;
	}
	
	public Set<Object> getSets() {
		return sets;
	}
	
	public Map<String,Object> getMaps() {
		return maps;
	}
	
	public Properties getProps() {
		return props;
	}
	
	public void setLists(List<Object> lists) {
		this.lists = lists;
	}
	public void setSets(Set<Object> sets) {
		this.sets = sets;
	}
	public void setMaps(Map<String,Object> maps) {
		this.maps = maps;
	}
	public void setProps(Properties props) {
		this.props = props;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Customer [lists= " + lists + ", sets= " + sets + ", maps= " + maps + ", props= " + props + "]";
	}
}
