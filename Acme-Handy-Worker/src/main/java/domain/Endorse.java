
package domain;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Access(AccessType.PROPERTY)
public class Endorse extends DomainEntity {

	private Date		moment;
	private String		coments;
	private Customer	customer;
	private HandyWorker	handyWorkerSender;
	private HandyWorker	handyWorkerReceiver;


	@ManyToOne(optional = false)
	@Valid
	public HandyWorker getHandyWorkerSender() {
		return this.handyWorkerSender;
	}

	public void setHandyWorkerSender(final HandyWorker handyWorkerSender) {
		this.handyWorkerSender = handyWorkerSender;
	}

	@ManyToOne(optional = false)
	@Valid
	public HandyWorker getHandyWorkerReceiver() {
		return this.handyWorkerReceiver;
	}

	public void setHandyWorkerReceiver(final HandyWorker handyWorkerReceiver) {
		this.handyWorkerReceiver = handyWorkerReceiver;
	}

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	public Date getMoment() {
		return this.moment;
	}

	public void setMoment(final Date moment) {
		this.moment = moment;
	}
	@NotBlank
	@Size(min = 1)
	public String getComents() {
		return this.coments;
	}

	public void setComents(final String coments) {
		this.coments = coments;
	}

	@Valid
	@ManyToOne(optional = false)
	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(final Customer customer) {
		this.customer = customer;
	}

}
