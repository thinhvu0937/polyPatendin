 package polypatemding.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import polypatemding.dao.LienHeDAO;

import polypatemding.entity.LienHe;

import polypatemding.service.LienHeService;

@Service
public class LienHeServiceImpl implements LienHeService{

	@Autowired
	LienHeDAO ldao;

	@Override
	public List<LienHe> findAll() {
		return ldao.findAll();
	}

	@Override
	public LienHe create(LienHe l) {
		return ldao.save(l);
	}

	@Override
	public LienHe finbyid(String name) {
		// TODO Auto-generated method stub
		return ldao.findById(name).get();
	}

	@Override
	public void delete(String name) {
		// TODO Auto-generated method stub
		ldao.deleteById(name);
		
	}

	@Override
	public List<LienHe> findAll(String keyword) {
		if (keyword != null) {
			return ldao.findAll(keyword);
		}
		return ldao.findAll();
	}

	

	
}
