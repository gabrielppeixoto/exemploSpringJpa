package br.com.devmedia.curso.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.devmedia.curso.entity.Person;


public interface PersonRepository extends JpaRepository<Person, Long> {
	List<Person> findByAge(Integer age);
	
	List<Person> findByAgeNot(Integer age);
	
	List<Person> findByFirstNameLike(String firstName);
	
	List<Person> findByFirstNameNotLike(String firstName);
	
	Person findByFirstNameAndLastName(String firstName, String lastName);
	
	List<Person> findByAgeOrFirstName(Integer age, String firstName);
	
	List<Person> findByAgeBetween(int min, int max);
	
	List<Person> findByLastNameAndAgeBetween(String lastName, int min, int max);
	
	List<Person> findByAgeGreaterThan(Integer age);
	
	List<Person> findByAgeLessThan(Integer age);
	
	List<Person> findByAgeGreaterThanEqual(Integer age);
	
	List<Person> findByAgeLessThanEqual(Integer age);
	
	List<Person> findByFirstNameGreaterThan(String firstName);
	
	List<Person> findByAgeIn(Integer... args);
	
	List<Person> findByAgeNotIn(Integer... args);
	
	List<Person> findByFirstNameIgnoreCase(String firstName);
	
	List<Person> findByDocumentIsNull();
	
	List<Person> findByDocumentIsNotNull();
	
	List<Person> findByPhonesNumberStartingWith(String number);
	
	List<Person> findByAgeGreaterThanOrderByFirstNameAscLastNameAsc(Integer age);
	
	@Query("select p from Person p where p.firstName like ?1")
	List<Person> findByFirstName(String firstName);
	
	@Query("select p from Person p where p.firstName like ?1 or p.age = ?2")
	List<Person> findByFirstNameOrAge(String firstName, Integer age);
	
	@Query("select p from Person p where p.firstName like ?2 and p.age = ?1")
	List<Person> findByFirstNameAndAge(Integer age, String firstName);
	
	@Query("select p from Person p where p.document.cpf like %?1")
	List<Person> findByDocumentCPFEndsWith(String value);
	
	@Query("select p from Person p where p.age >= :min and p.age <= :max")
	List<Person> findByAgeBetween(@Param("min") Integer start, @Param("max") Integer end);
	
	@Query("select p from Person p where p.firstName in :names order by p.age asc")
	List<Person> findByFirstNames(@Param("names") String... firstNames);
	
	Person findFirstByOrderByLastNameDesc();
	
	Person findFirstByOrderByLastNameAsc();
	
	Person findTopByOrderByAgeAsc();
	
	Person findTopByOrderByAgeDesc();
	
	List<Person> findTop3ByOrderByAgeAsc();
	
	List<Person> findFirst3ByOrderByLastNameAsc();
}
