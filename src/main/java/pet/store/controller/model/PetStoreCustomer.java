package pet.store.controller.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PetStoreCustomer {

	private Long customerId;

	private String customer;

	public PetStoreCustomer(Long customerId, String customer) {
		this.customerId = customerId;
		this.customer = customer;

	}
}
