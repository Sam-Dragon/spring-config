package learn.spring.caching.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student")
public class Student {

	@Id
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "hiredate")
	private LocalDate hiredate;

	@CreationTimestamp
	@Column(name = "created_date", updatable = false, insertable = true)
	private LocalDate createdDate;

	@Column(name = "created_by", updatable = false, insertable = true)
	private String createdBy;

	@UpdateTimestamp
	@Column(name = "modified_date", updatable = true)
	private LocalDate modifiedDate;

	@Column(name = "modified_by", updatable = true)
	private String modifiedBy;
}
