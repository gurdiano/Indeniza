package com.gdn.indeniza.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gdn.indeniza.dtos.ReportDTO;
import com.gdn.indeniza.entities.Report;
import com.gdn.indeniza.services.ReportService;

@RestController
@RequestMapping(value = "/reports")
public class ReportResource {

	@Autowired
	private ReportService service;
	
	@GetMapping(value = "/generate")
	public ResponseEntity<Report> generateReport(@RequestBody ReportDTO obj){
		Report report = service.generateReport(obj.getInitialDate(), obj.getFinalDate(), obj.getColab());
		return ResponseEntity.ok().body(report);
	}
	
	@GetMapping
	public ResponseEntity<List<Report>> findAll(){
		List<Report> list = service.findAll(); 
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Report> findById(@PathVariable Long id){
		Report obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Report> insert(@RequestBody Report obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Report> update(@PathVariable Long id, @RequestBody Report obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
