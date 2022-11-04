package polypatemding.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import polypatemding.dao.CongthucDAO;
import polypatemding.entity.Congthuc;
import polypatemding.service.CongthucService;
import polypatemding.service.TintucService;

@Service
public class CongthucServiceimpl implements CongthucService {
	@Autowired

	CongthucDAO cdao;

	@Override
	public Page<Congthuc> findAll(Pageable pageable) {

		return cdao.findAll(pageable);
	}

	@Override
	public Congthuc create(Congthuc c) {
		return cdao.save(c);
	}
	
	@Override
	public void delete(Integer id) {
		cdao.deleteById(id);
	}

	@Override
	public Congthuc findbyid(Integer id) {
		// TODO Auto-generated method stub
		return cdao.findById(id).get();
	}

	@Override
	public List<Congthuc> listAll() {
		// TODO Auto-generated method stub
		return cdao.findAll();
	}

	@Override
	public List<Congthuc> findAll(String keyword) {
		if (keyword != null) {
			return cdao.findAll(keyword);
		}
		return cdao.findAll();
	}
	
	
	
}
