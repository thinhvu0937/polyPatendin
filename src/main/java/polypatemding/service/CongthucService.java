package polypatemding.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import polypatemding.entity.Congthuc;

public interface CongthucService {
	Page<Congthuc> findAll(Pageable pageable);

	Congthuc create(Congthuc c);

	void delete(Integer id);

	Congthuc findbyid(Integer id);
	List<Congthuc> listAll();
	List<Congthuc> findAll(String keyword);
}
