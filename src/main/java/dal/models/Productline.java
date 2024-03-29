package dal.models;
// Generated 17 nov. 2015 23:25:28 by Hibernate Tools 4.3.1.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Productline generated by hbm2java
 */
@Entity
@Table(name = "productline", catalog = "ZenLounge")
public class Productline implements java.io.Serializable {

	private Integer id;
	private int quantity;
	private Integer idshoppingcart;
	private Integer idorder;
	private int idproduct;

	public Productline() {
	}

	public Productline(int quantity, int idproduct) {
		this.quantity = quantity;
		this.idproduct = idproduct;
	}

	public Productline(int quantity, Integer idshoppingcart, Integer idorder, int idproduct) {
		this.quantity = quantity;
		this.idshoppingcart = idshoppingcart;
		this.idorder = idorder;
		this.idproduct = idproduct;
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

	@Column(name = "quantity", nullable = false)
	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Column(name = "idshoppingcart")
	public Integer getIdshoppingcart() {
		return this.idshoppingcart;
	}

	public void setIdshoppingcart(Integer idshoppingcart) {
		this.idshoppingcart = idshoppingcart;
	}

	@Column(name = "idorder")
	public Integer getIdorder() {
		return this.idorder;
	}

	public void setIdorder(Integer idorder) {
		this.idorder = idorder;
	}

	@Column(name = "idproduct", nullable = false)
	public int getIdproduct() {
		return this.idproduct;
	}

	public void setIdproduct(int idproduct) {
		this.idproduct = idproduct;
	}

}
