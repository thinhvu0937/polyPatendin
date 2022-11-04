package polypatemding.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import polypatemding.dao.RoleDAO;
import polypatemding.entity.Role;
import polypatemding.service.RoleService;
@Service
public class RoleServiceImpl implements RoleService{
	@Autowired
	RoleDAO rdao;
	
	@Override
	public List<Role> findAll() {
		return rdao.findAll(); 
	}

}
