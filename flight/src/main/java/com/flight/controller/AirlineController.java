package com.flight.controller;

import java.util.List;
import javax.validation.Valid;
import javax.ws.rs.QueryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.flight.entity.Airline;
import com.flight.entity.AirlineEntity;
import com.flight.service.AirlineService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/airline")
public class AirlineController {

	@Autowired
	private AirlineService airlineService;

	@Autowired
	private KafkaTemplate<String, Object> template;

	private String topic = "flight-service";

	@GetMapping("/publish/{name}")
	public String publisher(@PathVariable String name) {
		template.send(topic, "Hi " + name + " welcome to Spring kafka.!!");
		return "Data published";
	}

	@GetMapping("/publishJson")
	public String publisher() {

		Airline airline = new Airline(11, "Lee", "9877876545", true, null);
		template.send(topic, airline);
		return "Json data published";

	}

	@GetMapping("/getallairline")
	public ResponseEntity<?> getAirline() {
		ResponseEntity<List<AirlineEntity>> responseEntity = new ResponseEntity<>(airlineService.getAllAirline(),
				HttpStatus.OK);
		return responseEntity;
	}

	@GetMapping("/getallairlines")
	public ResponseEntity<?> getAirlines() {

		ResponseEntity<List<AirlineEntity>> responseEntity = new ResponseEntity<>(airlineService.getAllAirline(),
				HttpStatus.OK);

		return responseEntity;
	}
	
	@GetMapping("/getallairlinenames")
	public ResponseEntity<?> getAirlineNames() {

		ResponseEntity<List<String>> responseEntity = new ResponseEntity<>(airlineService.getAllAirlineNames(),
				HttpStatus.OK);

		return responseEntity;
	}

	// @ExceptionHandler(RecordAlreadyPresentException.class)
	@PostMapping("/save")
	public ResponseEntity<?> saveAirline(@Valid @RequestBody Airline airline) {

		return airlineService.saveAirline(airline);
	}

	@PutMapping("/update/{airlineId}")
	public ResponseEntity<?> updateAirline(@RequestBody Airline airline, @PathVariable Integer airlineId) {
		// try {
		ResponseEntity<?> responseEntity = new ResponseEntity<>(airlineService.updateAirline(airline, airlineId),
				HttpStatus.OK);
		/*
		 * } catch (Exception e) { e.printStackTrace(); responseEntity = new
		 * ResponseEntity<>(HttpStatus.NOT_FOUND); }
		 */

		return responseEntity;
	}

	@PutMapping("/avilable/{airlineId}")
	public ResponseEntity<?> availablityAirline(@QueryParam("isBlock") Boolean isBlock,
			@PathVariable Integer airlineId) {
		// try {
		ResponseEntity<?> responseEntity = new ResponseEntity<>(airlineService.availablityAirline(isBlock, airlineId),
				HttpStatus.OK);
		/*
		 * } catch (Exception e) { e.printStackTrace(); responseEntity = new
		 * ResponseEntity<>(HttpStatus.NOT_FOUND); }
		 */
		return responseEntity;

	}

	@DeleteMapping("/delete/{airlineId}")
	public ResponseEntity<?> deleteFlight(@PathVariable Integer airlineId) {

		// try {
		ResponseEntity<?> responseEntity = new ResponseEntity<>(airlineService.deleteAirline(airlineId), HttpStatus.OK);
		/*
		 * } catch (Exception e) { e.printStackTrace(); responseEntity = new
		 * ResponseEntity<>(HttpStatus.NOT_FOUND); }
		 */
		return responseEntity;

	}

}