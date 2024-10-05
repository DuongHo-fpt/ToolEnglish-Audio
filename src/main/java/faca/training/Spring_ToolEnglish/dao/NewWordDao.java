package faca.training.Spring_ToolEnglish.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import faca.training.Spring_ToolEnglish.entities.NewWord;

public interface NewWordDao extends JpaRepository<NewWord, Integer> {

	@Query ("FROM NewWord ORDER BY NEWID()")
	List<NewWord> finvietnamese();
	@Query ("FROM NewWord WHERE dahoc is Null ORDER BY id ASC ")
	List<NewWord> findid();
	
	@Query("FROM NewWord n Where n.id =?1 and newdate >=?2")
	Optional<NewWord> findbynewdate(int id, LocalDate date);
	@Query("FROM NewWord n Where n.id BETWEEN :id AND :id2")
	List<NewWord> findlistdahoc(int id, int id2);
	@Query("FROM NewWord n Where n.id = :i and n.dahoc = '1'")
	NewWord findbyiddahoc(int i); 
	@Query("FROM NewWord n Where n.id = :i and n.dahoc is null")
	NewWord findbyidchuahoc(int i);
	
	@Query("FROM NewWord n Where n.dahoc = '1'")
	List<NewWord> findlistdahoc();
}
