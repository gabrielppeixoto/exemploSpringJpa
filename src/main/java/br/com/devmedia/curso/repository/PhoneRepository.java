package br.com.devmedia.curso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import br.com.devmedia.curso.entity.Phone;
import br.com.devmedia.curso.entity.Phone.TypePhone;

public interface PhoneRepository extends JpaRepository<Phone, Long> {
	
	@Modifying
	@Transactional
	@Query("update Phone p set p.number = ?1 where p.id = ?2")
	int setPhoneNumber(String number, Long id);
	
	@Modifying
	@Transactional
	@Query("update Phone p set p.type = ?1 where p.id = ?2")
	int setPhoneType(TypePhone type, Long id);
	
	@Modifying
	@Transactional
	@Query("delete from Phone p where p.number like ?1")
	int deleteByPhoneNumber(String number);
}
