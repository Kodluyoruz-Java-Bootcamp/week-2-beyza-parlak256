package emlakcepte.service;

import java.util.List;

import emlakcepte.dao.RealtyDao;
import emlakcepte.model.Realty;
import emlakcepte.model.User;
import emlakcepte.model.enums.RealtyType;

public class RealtyService {
	private RealtyDao realtyDao = new RealtyDao();

	public void createRealty(Realty realty) {
		realtyDao.saveRealty(realty);
		System.out.println("createRealty:: " + realty.getTitle());
	}

	public List<Realty> getAll() {
		return realtyDao.findAll();
	}

	public void printAll(List<Realty> realtyList) {
		realtyList.forEach(realty -> System.out.println(realty));
		;
	}

	public void getAllByProvince(String province) {
		getAll().stream().filter(realty -> realty.getProvince().equals(province)).count(); // daire sayısı bulmak için// count() kullandım
																							
		// .forEach(realty -> System.out.println(realty));

	}

	public List<Realty> getAllByUserName(User user) {

		return getAll().stream().filter(realty -> realty.getUser().getMail().equals(user.getMail())).toList();
	}


	public List<Realty> getActiveAllByUserName(User user) {
		return getAll().stream()
		.filter(realty -> realty.getUser().getMail().equals(user.getName()))
		.filter(realty -> RealtyType.ACTIVE.equals(realty.getStatus()))
		.toList(); 
	}
}






