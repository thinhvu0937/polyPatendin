package polypatemding.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import polypatemding.dao.TintucDAO;
import polypatemding.entity.Tintuc;
import polypatemding.service.TintucService;

@Service
public  class TintucServiceImpl implements TintucService {

	@Autowired
	TintucDAO tdao;

	@Override
	public Page<Tintuc> findAll(Pageable pageable) {
		return tdao.findAll(pageable);
	}

	@Override
	public Tintuc create(Tintuc n) {
		return tdao.save(n);
	}

	@Override
	public void delete(Integer id) {
		tdao.deleteById(id);
		
	}



	@Override
	public List<Tintuc> listAll() {
		// TODO Auto-generated method stub
		return tdao.findAll();
	}

	@Override
	public List<Tintuc> findAll(String keyword) {
		if (keyword != null) {
			return tdao.findAll(keyword);
		}
		return tdao.findAll();
	}

	@Override
	public Tintuc finbyid(Integer id) {
		// TODO Auto-generated method stub
		return tdao.findById(id).get();
	}
}
	

	

