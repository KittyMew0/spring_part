import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.gson.Gson;

public class Person {
	String firstName;
	String lastName;
	int age;
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName() {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName() {
		this.lastName = lastName;
	}	
	
	public int getAge() {
		return age;
	}
	
	public void setAge() {
		this.age = age;
	}	
	
	
	//serialization
	Person person2 = new Person("Firstname", "Lastname", 27);
	Gson gson = new Gson();
	String json = gson.toJson(person2);
	System.out.println(json);
	
	
	//deserialization
	String json = "{\"first-name\":\"Firstname\",\"last-name\":\"Lastname\",\"age\":27}";
	Gson gson = new Gson();
	Person person = gson.fromJson(json, Person.class);
	System.out.println(person.getName()); 
	
	Person person = (Person) o;
	
	@Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("name", firstName)
                .append("last name", lastName)
                .append("age", age)
                .toString();
    }
	
	public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
     
        return new EqualsBuilder()
                .append(firstName, person.firstName)
                .append(lastName, person.lastName)
                .append(age, person.age)
                .isEquals();
    }
	
	@Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
        		.append(firstName)
                .append(lastName)
                .append(age)
                .toHashCode();
    }
	
	
}
