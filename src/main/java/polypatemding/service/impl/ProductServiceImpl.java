package polypatemding.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import polypatemding.dao.ProductDAO;
import polypatemding.entity.Category;
import polypatemding.entity.Product;
import polypatemding.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDAO pdao;

	@Override
	public List<Product> findAll() {

		return pdao.findAll();
	}

	@Override
	public Product findById(Integer id) {

		return pdao.findById(id).get();
	}

	@Override
	public List<Product> findByCategoryId(String cid) {
		return pdao.findByCategoryId(cid);
	}



	@Override
	public Product update(Product p) {
		return pdao.save(p);
	}

	@Override
	public void delete(Integer id) {
		pdao.deleteById(id);
	}

	@Override
	public Page<Product> findByCategory(Category cate, Pageable pageable) {
		// TODO Auto-generated method stub
		return pdao.findByCategory(cate, pageable);
	}

	@Override
	public Page<Product> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return pdao.findAll(pageable);
	}

	@Override
	public Page<Product> findByKeyword(String search, Pageable pageable) {
		return pdao.findByKeyword("%" + search + "%", pageable);
	}

	@Override
	public void create(Product p) {
		pdao.save(p);
		
	}

	@Override
	public List<Product> findAll(String keyword) {
		if (keyword != null) {
			return pdao.findAll(keyword);
		}
		return pdao.findAll();
	}




	/*
	 * @Override public Product create(Product pro, Integer categoryid) {
	 * 
	 * Category cate = new Category(); cate.setId(categoryid);
	 * cate.setProducts(pro); pdao.save(cate);
	 * 
	 * return pdao.save(pro); }
	 */

}
