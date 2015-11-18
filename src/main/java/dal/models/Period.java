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
 * Period generated by hbm2java
 */
@Entity
@Table(name = "period", catalog = "ZenLounge")
public class Period implements java.io.Serializable {

	private Integer id;
	private Date startdate;
	private Date enddate;

	public Period() {
	}

	public Period(Date startdate, Date enddate) {
		this.startdate = startdate;
		this.enddate = enddate;
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
	@Column(name = "startdate", length = 19)
	public Date getStartdate() {
		return this.startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "enddate", length = 19)
	public Date getEnddate() {
		return this.enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

}