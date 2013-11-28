package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the AddressUpdate database table.
 * 
 */
@Entity
@NamedQuery(name="AddressUpdate.findAll", query="SELECT a FROM AddressUpdate a")
public class AddressUpdate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String address;

	private byte approved;

	@Column(name="approved_admin_id")
	private int approvedAdminId;

	private String cell;

	@Column(name="customer_id")
	private Integer customerId;

	private String email;

	private String firstName;

	private String lastName;

	@Temporal(TemporalType.DATE)
	private Date moveInDate;

	@Lob
	private String notes;

	private String state;

	private int zip;

	//bi-directional one-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="id", insertable=false, updatable=false)
	private Customer customer;

	public AddressUpdate() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public byte getApproved() {
		return this.approved;
	}

	public void setApproved(byte approved) {
		this.approved = approved;
	}

	public int getApprovedAdminId() {
		return this.approvedAdminId;
	}

	public void setApprovedAdminId(int approvedAdminId) {
		this.approvedAdminId = approvedAdminId;
	}

	public String getCell() {
		return this.cell;
	}

	public void setCell(String cell) {
		this.cell = cell;
	}

	public Integer getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getMoveInDate() {
		return this.moveInDate;
	}

	public void setMoveInDate(Date moveInDate) {
		this.moveInDate = moveInDate;
	}

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZip() {
		return this.zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}