package dal.models;
// Generated 17 nov. 2015 23:25:28 by Hibernate Tools 4.3.1.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Member generated by hbm2java
 */
@Entity
@Table(name = "member", catalog = "ZenLounge")
public class Member implements java.io.Serializable {

	private Integer id;
	private Date joiningdate;

	public Member() {
	}

	public Member(Date joiningdate) {
		this.joiningdate = joiningdate;
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

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "joiningdate", nullable = false, length = 19)
	public Date getJoiningdate() {
		return this.joiningdate;
	}

	public void setJoiningdate(Date joiningdate) {
		this.joiningdate = joiningdate;
	}

}
