package com.example.items;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ItemRepository extends JpaRepository<Item, Long> {
	
	@Query("SELECT it FROM Item it WHERE it.status = ?#{[0]}")
	public List<Item> findItemsByStatus(ItemStatus status);
}
