package polypatemding.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import polypatemding.dao.CategoryDAO;
import polypatemding.entity.Category;
import polypatemding.service.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	CategoryDAO cdao;
	
	@Override
	public List<Category> findAll() {
		return cdao.findAll();
	}

	@Override
	public Optional<Category> findById(Optional<String> cid) {
		// TODO Auto-generated method stub
		return cdao.findById(cid.get());
	}
	@Override
	public Category create(Category ca) {
		return cdao.save(ca);
	}

	@Override
	public List<Category> findAll(String keyword) {
		if (keyword != null) {
			return cdao.findAll(keyword);
		}
		return cdao.findAll();
	}
	
	
	
	
}
