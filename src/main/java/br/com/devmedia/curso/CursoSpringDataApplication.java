package br.com.devmedia.curso;

import br.com.devmedia.curso.entity.Address;
import br.com.devmedia.curso.entity.Document;
import br.com.devmedia.curso.entity.Person;
import br.com.devmedia.curso.entity.Phone;
import br.com.devmedia.curso.entity.Phone.TypePhone;
import br.com.devmedia.curso.entity.User;
import br.com.devmedia.curso.entity.Address.TypeAddress;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.querydsl.QPageRequest;

import br.com.devmedia.curso.repository.AddressRepository;
import br.com.devmedia.curso.repository.DocumentRepository;
import br.com.devmedia.curso.repository.PersonRepository;
import br.com.devmedia.curso.repository.PhoneRepository;
import br.com.devmedia.curso.repository.UserRepository;

@SpringBootApplication
//@ImportResource(value = "spring-data.xml")
public class CursoSpringDataApplication implements CommandLineRunner {
	
	@Autowired
	private PersonRepository personRepository;
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private DocumentRepository documentRepository;
	@Autowired
	private PhoneRepository phoneRepository;
	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursoSpringDataApplication.class, args);
	}
	
	
	@Override
	public void run(String... args) throws Exception
	{
		//testConfiguration();
		//testSave();
		//testUpdate();
		//testDelete();
		//testSavePersons();
		//testDeletePersons();
		//testFindAndSort();
		//testFindByIds();
		//testExists();
		//testPagination();
		
		//testByAge();
		//testByFirstNameLike();
		//testByAndOr();
		//testByBetween();
		//testByAndBetween();
		//testByGreaterAndLess();
		//testByGreaterAndLEssEquals();
		//testByFirstNameGreaterThan();
		//testByStartAndEnd();
		//testByContaining();
		//testByAddressStartEnd();
		//testByInAndNotIn();
		//testByOrderBy();
		//testIgnoreCase();
		//testByNotNullAndNull();
		//testPhonesByNumber();
		//testFindByGreaterThanandOther();
		
		//findFirstName();
		//findFirstNameOrAge();
		//findFirstNameAndAge();
		//findPersonByCPFEndsWith();
		
		//findPErsonByAges();
		//findPersonByNames();
		//findDocumentByCPFStart();
		
		//findAddressPorCidade();
		//findAddressesPorEndereco();
		
		//testFunctionAddress();
		
		//testProcedureCPF();
		
		//updatePhones();
		//deletePhones();
		
		//findFirstLastName();
		//findTopAge();
		//findFirst3andTop3();
		
		//testUser();
	}

	private void testUser() {
		// TODO Auto-generated method stub
		User user = new User();
		user.setUsername("gpeixoto");
		user.setPassword("asdrfb444");
		
		if(user.isNew())
		{
			userRepository.save(user);
		}
		
		Example<User> ex = Example.of(user);
		User user2 = userRepository.findOne(ex).get();
		System.out.println(user2.toString());
	}


	private void findFirst3andTop3() {
		// TODO Auto-generated method stub
		List<Person> first3 = personRepository.findFirst3ByOrderByLastNameAsc();
		first3.forEach(System.out::println);
		
		List<Person> top3 = personRepository.findTop3ByOrderByAgeAsc();
		top3.forEach(System.out::println);
	}


	private void findTopAge() {
		// TODO Auto-generated method stub
		Person p1 = personRepository.findTopByOrderByAgeAsc();
		System.out.println(p1.toString());
		
		Person p2 = personRepository.findTopByOrderByAgeDesc();
		System.out.println(p2.toString());
	}


	private void findFirstLastName() {
		// TODO Auto-generated method stub
		Person p1 = personRepository.findFirstByOrderByLastNameAsc();
		System.out.println(p1.toString());
		
		Person p2 = personRepository.findFirstByOrderByLastNameDesc();
		System.out.println(p2.toString());
	}


	private void deletePhones() {
		// TODO Auto-generated method stub
		int result = phoneRepository.deleteByPhoneNumber("33414726");
		System.out.println("Result = " + result);
	}


	private void updatePhones() {
		// TODO Auto-generated method stub
		int result = phoneRepository.setPhoneNumber("12345679", 1L);
		int result2 = phoneRepository.setPhoneType(TypePhone.RESIDENCIAL, 1L);
		System.out.println("Result1 = " + result + "; Result 2 = " + result2);
	}


	private void testProcedureCPF() {
		// TODO Auto-generated method stub
		String cpf1 = documentRepository.replaceCPF(1L);
		System.out.println(cpf1);
	}


	private void testFunctionAddress() {
		// TODO Auto-generated method stub
		String ad1 = addressRepository.functionConcatenaEndereco(1L);
		System.out.println(ad1);
	}


	private void findAddressesPorEndereco() {
		// TODO Auto-generated method stub
		Address ad1 = addressRepository.buscaPorEndereco("Manaus", "Rua das Valquírias, 32");
		System.out.println(ad1.toString());
	}


	private void findAddressPorCidade() {
		// TODO Auto-generated method stub
		List<Address> addresses = addressRepository.buscaPorCidade("Manaus");
		addresses.forEach(System.out::println);
	}


	private void findDocumentByCPFStart() {
		// TODO Auto-generated method stub
		List<Document> documents = documentRepository.findByCPFStartWith("123");
		documents.forEach(System.out::println);
	}


	private void findPersonByNames() {
		// TODO Auto-generated method stub
		List<Person> persons = personRepository.findByFirstNames("Aline", "Fabiana", "Gilson");
		persons.forEach(System.out::println);
	}


	private void findPErsonByAges() {
		// TODO Auto-generated method stub
		List<Person> persons = personRepository.findByAgeBetween(28, 36);
		persons.forEach(System.out::println);
	}


	private void findPersonByCPFEndsWith() {
		// TODO Auto-generated method stub
		List<Person> persons = personRepository.findByDocumentCPFEndsWith("98");
		persons.forEach(System.out::println);
	}


	private void findFirstNameAndAge() {
		// TODO Auto-generated method stub
		List<Person> persons = personRepository.findByFirstNameAndAge(29, "Fabiana");
		persons.forEach(System.out::println);
	}


	private void findFirstNameOrAge() {
		// TODO Auto-generated method stub
		List<Person> persons = personRepository.findByFirstNameOrAge("Aline", 29);
		persons.forEach(System.out::println);
	}


	private void findFirstName() {
		// TODO Auto-generated method stub
		List<Person> persons = personRepository.findByFirstName("Aline");
		persons.forEach(System.out::println);
	}


	private void testFindByGreaterThanandOther() {
		// TODO Auto-generated method stub
		List<Person> p1 = personRepository.findByAgeGreaterThanOrderByFirstNameAscLastNameAsc(22);
		p1.forEach(System.out::println);
	}


	private void testPhonesByNumber() {
		// TODO Auto-generated method stub
		List<Person> p1 = personRepository.findByPhonesNumberStartingWith("3341");
		p1.forEach(System.out::println);
	}


	private void testByNotNullAndNull() {
		// TODO Auto-generated method stub
		List<Person> p1 = personRepository.findByDocumentIsNull();
		p1.forEach(System.out::println);
		System.out.println("*******************************************");
		List<Person> p2 = personRepository.findByDocumentIsNotNull();
		p2.forEach(System.out::println);
	}


	private void testIgnoreCase() {
		// TODO Auto-generated method stub
		List<Person> p1 = personRepository.findByFirstNameIgnoreCase("BRUNA");
		p1.forEach(System.out::println);
	}


	private void testByOrderBy() {
		// TODO Auto-generated method stub
		List<Address> a1 = addressRepository.findByCityOrderByTypeDesc("Manaus");
		a1.forEach(System.out::println);
	}


	private void testByInAndNotIn() {
		// TODO Auto-generated method stub
		List<Person> p1 = personRepository.findByAgeIn(24, 28, 36, 45);
		p1.forEach(System.out::println);
		System.out.println("*******************************************");
		List<Person> p2 = personRepository.findByAgeNotIn(24, 28, 36, 45);
		p2.forEach(System.out::println);
	}


	private void testByAddressStartEnd() {
		// TODO Auto-generated method stub
		List<Address> a1 = addressRepository.findByCityStartingWithOrStreetEndingWith("Man", "32");
		a1.forEach(System.out::println);
	}


	private void testByContaining() {
		// TODO Auto-generated method stub
		List<Address> a1 = addressRepository.findByStreetContaining("alq");
		a1.forEach(System.out::println);
	}


	private void testByStartAndEnd() {
		// TODO Auto-generated method stub
		List<Address> a1 = addressRepository.findByCityStartingWith("Man");
		a1.forEach(System.out::println);
		System.out.println("*******************************************");
		List<Address> a2 = addressRepository.findByStreetEndingWith("32");
		a2.forEach(System.out::println);
	}


	private void testByFirstNameGreaterThan() {
		// TODO Auto-generated method stub
		List<Person> p1 = personRepository.findByFirstNameGreaterThan("Bruna");
		p1.forEach(System.out::println);
	}


	private void testByGreaterAndLEssEquals() {
		// TODO Auto-generated method stub
		List<Person> p1 = personRepository.findByAgeGreaterThanEqual(28);
		p1.forEach(System.out::println);
		System.out.println("*******************************************");
		List<Person> p2 = personRepository.findByAgeLessThanEqual(28);
		p2.forEach(System.out::println);
	}


	private void testByGreaterAndLess() {
		// TODO Auto-generated method stub
		List<Person> p1 = personRepository.findByAgeGreaterThan(28);
		p1.forEach(System.out::println);
		System.out.println("*******************************************");
		List<Person> p2 = personRepository.findByAgeLessThan(28);
		p2.forEach(System.out::println);
	}


	private void testByAndBetween() {
		// TODO Auto-generated method stub
		List<Person> p1 = personRepository.findByLastNameAndAgeBetween("Figueira", 25, 35);
		p1.forEach(System.out::println);
	}


	private void testByBetween() {
		// TODO Auto-generated method stub
		List<Person> p1 = personRepository.findByAgeBetween(24, 29);
		p1.forEach(System.out::println);
	}


	private void testByAndOr() {
		// TODO Auto-generated method stub
		Person p1 = personRepository.findByFirstNameAndLastName("Aline", "de Souza");
		System.out.println(p1.toString());
		System.out.println("*******************************************");
		List<Person> p2 = personRepository.findByAgeOrFirstName(29, "Fabiana");
		p2.forEach(System.out::println);
	}


	private void testByFirstNameLike() {
		// TODO Auto-generated method stub
		List<Person> p1 = personRepository.findByFirstNameLike("Aline");
		p1.forEach(System.out::println);
		System.out.println("*******************************************");
		List<Person> p2 = personRepository.findByFirstNameNotLike("Aline");
		p2.forEach(System.out::println);
	}


	private void testByAge() {
		// TODO Auto-generated method stub
		List<Person> p1 = personRepository.findByAge(36);
		p1.forEach(System.out::println);
		
		System.out.println("*******************************************");
		List<Person> p2 = personRepository.findByAgeNot(36);
		p2.forEach(System.out::println);
	}


	private void testPagination() {
		// TODO Auto-generated method stub
		Page<Person> pages = personRepository.findAll(QPageRequest.of(0, 2));
		pages.getContent().forEach(System.out::println);
		
		pages = personRepository.findAll(QPageRequest.of(1, 2));
		pages.getContent().forEach(System.out::println);
	}


	private void testExists() {
		// TODO Auto-generated method stub
		
		boolean p1 = personRepository.existsById(5l);
		System.out.println("P1: " + p1);
		
		boolean p2 = personRepository.existsById(50l);
		System.out.println("P2: " + p2);
	}


	private void testFindByIds() {
		// TODO Auto-generated method stub
		List<Person> persons = personRepository.findAllById(Arrays.asList(1L, 3L, 6L));
		persons.forEach(System.out::println);
	}


	private void testFindAndSort() {
		// TODO Auto-generated method stub
		//List<Order> orderAsc = new ArrayList<Sort.Order>();
		//orderAsc.add(new Order(Direction.ASC, "lastName"));
		Sort sortAsc = Sort.by(Direction.ASC, "lastName");
		Sort sortDesc = Sort.by(Direction.DESC, "lastName");
		List<Person> persons = personRepository.findAll(sortAsc);
		persons.forEach(System.out::println);
	}


	private void testDeletePersons() {
		// TODO Auto-generated method stub
		Person p1 = personRepository.findById(25L).get();
		Person p2 = personRepository.findById(26L).get();
		Person p3 = personRepository.findById(27L).get();
		
		personRepository.deleteAll(Arrays.asList(p1, p2, p3));
		
		System.out.println("********************************************************");
		
		Person p4 = personRepository.findById(28L).get();
		Person p5 = personRepository.findById(29L).get();
		
		personRepository.deleteInBatch(Arrays.asList(p4, p5));
	}


	private void testSavePersons() {
		// TODO Auto-generated method stub
		Person p1 = new Person();
		p1.setFirstName("Evelyn Aline");
		p1.setLastName("Farias");
		p1.setAge(88);
		p1.setDocument(new Document("258.322.697-56", 17891511));
		
		Person p2 = new Person();
		p2.setFirstName("Tomás Miguel");
		p2.setLastName("Osvaldo Baptista");
		p2.setAge(60);
		p2.setDocument(new Document("247.105.037-96", 50181259));
		
		Person p3 = new Person();
		p3.setFirstName("Osvaldo Thales");
		p3.setLastName("Martin Vieira");
		p3.setAge(63);
		p3.setDocument(new Document("888.566.317-68", 11673500));
		
		Person p4 = new Person();
		p4.setFirstName("Fernanda Yasmin");
		p4.setLastName("Isabel Dias");
		p4.setAge(23);
		p4.setDocument(new Document("272.758.507-10", 27291685));
		
		Person p5 = new Person();
		p5.setFirstName("Esther Marli");
		p5.setLastName("Isis Nascimento");
		p5.setAge(46);
		p5.setDocument(new Document("272.758.507-11", 36908040));
		
		List<Person> persons = personRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		persons.forEach(System.out::println);
	}


	private void testDelete() {
		// TODO Auto-generated method stub
		personRepository.deleteById(23L);
		
		Optional<Person> p = personRepository.findById(17L);
		Person person = p.get();
		
		personRepository.delete(person);
	}


	private void testUpdate() {
		// TODO Auto-generated method stub
		Optional<Person> p = personRepository.findById(23L);
		Person person = p.get();
		
		System.out.println(person.toString());
		
		person.setLastName("Aguiar");
		
		personRepository.save(person);
		
		Optional<Person> p2 = personRepository.findById(23L);
		
		System.out.println(p2.get().toString());
	}


	private void testSave() {
		// TODO Auto-generated method stub
		Person person = new Person();
		person.setFirstName("João Luiz");
		person.setLastName("Rios");
		person.setAge(35);
		person.setDocument(new Document("111.222.333-44", 1234567));
		
		Address address = new Address();
		address.setCity("Manaus");
		address.setStreet("Rua das Valquírias, 32");
		address.setType(TypeAddress.RESIDENCIAL);
		
		Address address2 = new Address();
		address2.setCity("Manaus");
		address2.setStreet("Rua Alzira Bentes, 171");
		address2.setType(TypeAddress.COMERCIAL);
		
		person.setAddresses(Arrays.asList(address, address2));
		person.addPhone(new Phone(TypePhone.RESIDENCIAL, "33413726"));
		
		personRepository.save(person);
		
		Optional<Person> p2 = personRepository.findById(person.getId());
		
		System.out.println(p2.toString());
	}


	private void testConfiguration() {
		long total = personRepository.count();
		System.out.println("Total: " + total);
		
		total = addressRepository.count();
		System.out.println("Total: " + total);
		
		total = documentRepository.count();
		System.out.println("Total: " + total);
		
		total = phoneRepository.count();
		System.out.println("Total: " + total);
	}
}
