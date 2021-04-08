package br.com.devmedia.curso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.devmedia.curso.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
	List<Address> findByCityStartingWith(String city);
	
	List<Address> findByStreetEndingWith(String street);
	
	List<Address> findByStreetContaining(String street);
	
	List<Address> findByCityStartingWithOrStreetEndingWith(String city, String street);
	
	List<Address> findByCityOrderByTypeDesc(String city);
	
	//usando @NamedQUery
	List<Address> buscaPorCidade(String cidade);
	
	//usando @NativeNamedQueries
	Address buscaPorEndereco(String city, String street);
	
	@Query(value = "select * from ADDRESSES where city like ?1 and street like ?2", nativeQuery = true)
	Address buscaPorCidadeRua(String city, String street);
	
	//usando function
	String functionConcatenaEndereco(Long id);
	
	@Query(value = "select funcConcatAddress(?1)", nativeQuery = true)
	String functionConcatenaEndereco2(Long id);
}
