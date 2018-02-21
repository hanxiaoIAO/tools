package iniTool;

import java.util.ArrayList;
import java.util.List;

public class Section {
	
	String name;
	
	List<Property> Propertys = new ArrayList<Property>();
	
	public Section(String name) {
		this.name = name;
	}
	
	public String getSectionName(){
		return name;
	}

	public Property getProperty(String propertysKey) throws Throwable{
		for(Property property:Propertys){
			if(propertysKey.equals(property.getKey())){
				return property;
			}
		}
		return new Property("","");
//		throw new Throwable("不存在Property： "+propertysKey);
	}
	
	public List<Property> getPropertys(){
		return Propertys;
	}
	
	public String getPropertyValue(String key) throws Throwable{
		return getProperty(key).getValue();
	}

	public void addProperty(String key, String value) {
		Property property = new Property(key,value);
		Propertys.add(property);	
	}
	
	public void addProperty(Property property){
		Propertys.add(property);
	}

}
