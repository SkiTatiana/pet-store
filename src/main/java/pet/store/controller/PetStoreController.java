package pet.store.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import lombok.extern.slf4j.Slf4j;
import pet.store.controller.model.PetStoreCustomer;
import pet.store.controller.model.PetStoreData;
import pet.store.controller.model.PetStoreEmployee;
import pet.store.service.PetStoreService;

@RestController
@RequestMapping("/pet_store")
@Slf4j
public class PetStoreController {
	@Autowired
	private PetStoreService petStoreService;

	@PostMapping("/")
	@ResponseStatus(code = HttpStatus.CREATED)
	public PetStoreData insertPetStoreData(@RequestBody PetStoreData petStoreData) {
		log.info("Creating petStore {}", petStoreData);
		return petStoreService.savePetStore(petStoreData);

	}

	@PutMapping("/{petStoreId}")
	public PetStoreData updatePetStoreData(@PathVariable Long petStoreId, @RequestBody PetStoreData petStoreData) {
		petStoreData.setPetStoreId(petStoreId);
		log.info("Updating Pet Store {}", petStoreData);
		return petStoreService.savePetStore(petStoreData);
	}


	@PostMapping("/{petStoreId}/customer")
	@ResponseStatus(code = HttpStatus.CREATED)
	public PetStoreCustomer insertPetStoreCustomer(@PathVariable Long petStoreId,
			@RequestBody PetStoreCustomer customer) {

		log.info("Creating customer {} for petStore with ID={}", petStoreId, customer);

		return petStoreService.saveCustomer(petStoreId, customer);
	}

	@PostMapping("/{petStoreId}/employee")
	@ResponseStatus(code = HttpStatus.CREATED)
	public PetStoreEmployee insertPetStoreEmployee(@PathVariable Long petStoreId,
			@RequestBody PetStoreEmployee employee) {

		log.info("Creating employee {} for petStore with ID={}", petStoreId, employee);

		return petStoreService.saveEmployee(petStoreId, employee);
	}

	@GetMapping("/")
	public List<PetStoreData> retrieveAllPetStores() {
		log.info("Retrieve all pet stores.");
		return petStoreService.retrieveAllPetStores();
	}

	@GetMapping("/{petStoreId}")
	public PetStoreData retrievePetStoreById(@PathVariable Long petStoreId) {
		log.info("Retrieving pet store with ID= {}", petStoreId);

		return petStoreService.retrievePetStoreById(petStoreId);
	}

	@DeleteMapping("/{petStoreId}")
	public Map<String, String> deletePetStoreById (@PathVariable Long petStoreId) {
		log.info("Deleting pet store with ID=" + petStoreId + " .");
		petStoreService.deletePetStore(petStoreId);

		return Map.of("message" , "pet store with ID+" + petStoreId + " was deleted successfully.");




	}
}
