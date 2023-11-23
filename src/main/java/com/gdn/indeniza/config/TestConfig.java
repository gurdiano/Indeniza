package com.gdn.indeniza.config;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.gdn.indeniza.entities.Client;
import com.gdn.indeniza.entities.Dpvat;
import com.gdn.indeniza.entities.File;
import com.gdn.indeniza.entities.Order;
import com.gdn.indeniza.entities.User;
import com.gdn.indeniza.entities.enums.Status;
import com.gdn.indeniza.repositories.ClientRepository;
import com.gdn.indeniza.repositories.FileRepository;
import com.gdn.indeniza.repositories.OrderRepository;
import com.gdn.indeniza.repositories.ServiceRepository;
import com.gdn.indeniza.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ServiceRepository serviceRepository;
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private FileRepository fileRepository;
	

	@Override
	public void run(String... args) throws Exception {
		//User(Long id, String name, String password, String email, LocalDate creation)
		User u1 = new User(null, "Tiago", "sasaas@As05", "tiagofran2013@hotmail.com", LocalDate.now());
		User u2 = new User(null, "Sofia", "sofi@As05", "sofia@hotmail.com", LocalDate.now());
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		
		//Dpvat(String name, String sinistro, String hospital, Long id, Double cash)
		Dpvat s1 = new Dpvat("ação", "117953", "Hospital Sta Monica", null, 1200.00);
		Dpvat s2 = new Dpvat("reembolso", "057800", "Hospital São Marcos", null, 2200.00);
		Dpvat s3 = new Dpvat("processo", "465880", "Hospital de São Pualo", null, 3500.00);
		
		serviceRepository.saveAll(Arrays.asList(s1));
		
		//Client(Long id, String name, String cpf, String phone1, String phone2, String email)
		Client c1 = new Client(null, "Tiago Gurdiano", "46445890806", "11962627844", "11962627844", "tiagofran2013@hotmail.com");
		Client c2 = new Client(null, "Gustavo Pio", "57557907843", "11962627844", null, "gustavopissai@gmail.com");
		Client c3 = new Client(null, "Marin Paola", "62946075079", "48983909326", "51995906723", "xxmarinpaola@ph.com");
		
		clientRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		//Order(Long id, Status status, LocalDate date, Service service, Client client, User partner)
		Order o1 = new Order(null, Status.WAITING_DOCUMETATION, LocalDate.now(), s1, c1, u2);
		Order o2 = new Order(null, Status.WAITING_DOCUMETATION, LocalDate.now(), s2, c2, u1);
		Order o3 = new Order(null, Status.WAITING_DOCUMETATION, LocalDate.now(), s3, c1, u2);
		
		s1.setOrder(o1);
		s2.setOrder(o2);
		s3.setOrder(o3);
		
		serviceRepository.saveAll(Arrays.asList(s1, s2, s3));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		
		//File(Long id, String name, String path, LocalDate date, Order order)
		File f1 = new File(null, "arq.txt", "C:\\Users\\Tiago\\Desktop\\notes\\projeto_adv", LocalDate.now(), o1);
		
		fileRepository.saveAll(Arrays.asList(f1));
	}
}
