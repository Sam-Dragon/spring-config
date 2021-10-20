package learn.spring.caching.model;

import java.util.Arrays;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {

	private String id;
	private String name;
	private Integer age;

	public static List<Student> students() {
		return Arrays.asList(new Student("1", "Rahul", 35), new Student("2", "Samuel", 40),
				new Student("3", "Radhe", 45), new Student("4", "Ramesh", 60));
	}
}
