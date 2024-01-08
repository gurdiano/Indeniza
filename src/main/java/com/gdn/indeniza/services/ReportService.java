package com.gdn.indeniza.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdn.indeniza.entities.Order;
import com.gdn.indeniza.entities.Report;
import com.gdn.indeniza.entities.User;
import com.gdn.indeniza.repositories.ReportRepository;

@Service
public class ReportService {

	@Autowired
	private ReportRepository repository;
	@Autowired
	private OrderService orderService;
	
	public Report generateReport(LocalDate initialDate, LocalDate finalDate, User colab) {
		Report obj = new Report(null, initialDate, finalDate, colab, null);
		obj.setOrders(generateList(obj));
		return insert(obj);
	}
	
	private List<Order> generateList(Report obj){
		return orderService.getSeason(obj.getInitialDate(), obj.getFinalDate());
	}
	
	//CRUD
	public List<Report> findAll(){
		return repository.findAll();
	}
	
	public Report findById(Long id) {
		Optional<Report> obj = repository.findById(id);
		return obj.get();
	}
	
	public Report insert(Report obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Report update(Long id, Report obj) {
		Report entity = repository.getReferenceById(id);
		updateData(obj, entity);
		return repository.save(entity);
	}

	private void updateData(Report obj, Report entity) {
		entity.setInitialDate(obj.getInitialDate());
		entity.setFinalDate(obj.getFinalDate());
		entity.setColab(obj.getColab());
	}
	
}
