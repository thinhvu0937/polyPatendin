package polypatemding.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import polypatemding.dao.OrderDetailDAO;
import polypatemding.entity.TongHop;
import polypatemding.service.TongHopService;

@Service
public class TongHopServiceImpl implements TongHopService {
	@Autowired
	OrderDetailDAO ordao;
	@Override
	public List<TongHop> getTongHopList() {
		
		return ordao.getTotalSoldQuntity();
	}

}
