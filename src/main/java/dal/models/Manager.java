package dal.models;
// Generated 17 nov. 2015 23:25:28 by Hibernate Tools 4.3.1.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Manager generated by hbm2java
 */
@Entity
@Table(name = "manager", catalog = "ZenLounge")
public class Manager implements java.io.Serializable {

	private Integer id;

	public Manager() {
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
