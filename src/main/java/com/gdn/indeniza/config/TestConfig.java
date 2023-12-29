	package com.gdn.indeniza.config;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.gdn.indeniza.entities.Address;
import com.gdn.indeniza.entities.Client;
import com.gdn.indeniza.entities.Dpvat;
import com.gdn.indeniza.entities.Hospital;
import com.gdn.indeniza.entities.Order;
import com.gdn.indeniza.entities.User;
import com.gdn.indeniza.entities.Vehicle;
import com.gdn.indeniza.entities.enums.Status;
import com.gdn.indeniza.repositories.AddressRepository;
import com.gdn.indeniza.repositories.ClientRepository;
import com.gdn.indeniza.repositories.HospitalRepository;
import com.gdn.indeniza.repositories.ServiceRepository;
import com.gdn.indeniza.repositories.UserRepository;
import com.gdn.indeniza.repositories.VehicleRepository;
import com.gdn.indeniza.resources.VehicleResource;
import com.gdn.indeniza.services.OrderService;
import com.gdn.indeniza.services.followService;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	//repositories
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ServiceRepository serviceRepository;
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private VehicleRepository vehicleRepository;
	@Autowired
	private HospitalRepository hospitalRepository;
	@Autowired
	private AddressRepository addressRepository;
	//services
	@Autowired
	private OrderService orderService;
	@Autowired
	private followService followService;
	//
	@Autowired
	private VehicleResource vehicleResource;

	@Override
	public void run(String... args) throws Exception {
	
//		Follow(Long id, LocalDateTime date, String registry, Status status, Order order, User user)
//		User(Long id, String name, String password, String email, LocalDateTime creation)
//		Order(Long id, Status status, LocalDate date, Service service, Client client, User partner)
//		Dpvat(String insuranceCompany, String sinistro, Long id, Double payment, Vehicle vehicle)
//		Vehicle(Long id, String type, String brand, String model, Integer manufacture, String plate, String renavam)
		
		User u1 = new User(null, "Tiago", "sasaas@As05", "tiagofran2013@hotmail.com", LocalDateTime.now());
		User u2 = new User(null, "Sofia", "sofi@As05", "sofia@hotmail.com", LocalDateTime.now());
		userRepository.saveAll(Arrays.asList(u1, u2));
		
		Vehicle v1 = new Vehicle(null, "Carro", "Volkswagem", "Golf", 2003, "AKX0I40", "06850165");
		Vehicle v2 = new Vehicle(null, "Carro", "Fiat", "Uno", 2011, "FHY9190", "06850166");
		Vehicle v3 = new Vehicle(null, "Moto", "Honda", "CB300", 2012, "THG7I77", "06850167");
		vehicleRepository.saveAll(Arrays.asList(v1, v2, v3));
		
		Dpvat s1 = new Dpvat("ação", "117953", null, 1200.00, v1);
		Dpvat s2 = new Dpvat("reembolso", "057800", null, 2200.00, v1);
		Dpvat s3 = new Dpvat("processo", "465880", null, 3500.00, v1);
		Dpvat s4 = new Dpvat("processo", "109820", null, 1500.00, v2);
		serviceRepository.saveAll(Arrays.asList(s1, s2, s3, s4));
		
		Address a1 = new Address(null, "06850165", "Rua Celso Capellossi", 51, "Parque Paraíso", "SP", "São Paulo");
		Address a2 = new Address(null, "06850165", "Rua Celso Capellossi", 51, "Parque Paraíso", "SP", "São Paulo");
		Address a3 = new Address(null, "06850165", "Rua Celso Capellossi", 51, "Parque Paraíso", "SP", "São Paulo");
		addressRepository.saveAll(Arrays.asList(a1, a2, a3));
		
		Hospital h1 = new Hospital(null, "Santa Monica", a1);
		Hospital h2 = new Hospital(null, "Hospital Geral", a2);
		Hospital h3 = new Hospital(null, "ProntoSocorro", a3);
		hospitalRepository.saveAll(Arrays.asList(h1, h2, h3));
		
		
		Client c1 = new Client(null, "marcos", LocalDate.now(), "32166352014", "532762162", "11962627844", "119808007815",
				"marcos@hotmail.com", "Maria Lucia", h1, a1);
		Client c2 = new Client(null, "lucia", LocalDate.now(), "40871744090", "532762162", "11962627844", "119808007815",
				"maria@hotmail.com", "Maria Antonia", h2, a2);
		Client c3 = new Client(null, "savio", LocalDate.now(), "28250477081", "532762162", "11962627844", "119808007815",
				"savio@hotmail.com", "Lucineia", h1, a3);
		clientRepository.saveAll(Arrays.asList(c1, c2, c3));
		

		Order o1 = orderService.createOrder(c1, u1, s1, Status.WAITING_APPROVAL);
		orderService.createOrder(c2, u1, s2, Status.WAITING_APPROVAL);
		orderService.createOrder(c3, u2, s3, Status.WAITING_APPROVAL);
		
		followService.CreateFollow("esperando fulando", Status.WAITING_DOCUMETATION, o1, u1);
		
		vehicleResource.findAll();
	}
}
