package pet.store.controller.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PetStoreEmployee {

	private Long employeeId;

	public PetStoreEmployee(Long employeeId) {
		this.employeeId = employeeId;
	}
}