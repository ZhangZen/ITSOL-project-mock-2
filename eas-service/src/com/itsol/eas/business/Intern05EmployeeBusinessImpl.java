package com.itsol.eas.business;

import com.itsol.eas.bo.Intern05EmployeeBO;
import com.itsol.eas.dao.Intern05EmployeeDAO;
import com.itsol.eas.dto.Intern05CitiesDTO;
import com.itsol.eas.dto.Intern05EmployeeDTO;
import com.itsol.eas.dto.Intern05EthnicDTO;
import com.viettel.service.base.business.BaseFWBusinessImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

@Service("intern05EmployeeBusinessImpl")
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Intern05EmployeeBusinessImpl
		extends BaseFWBusinessImpl<Intern05EmployeeDAO, Intern05EmployeeDTO, Intern05EmployeeBO>
		implements Intern05EmployeeBusiness {

	@Autowired
	private Intern05EmployeeDAO intern05EmployeeDAO;
	private StringBuilder allCities;

	public Intern05EmployeeBusinessImpl() {
		tModel = new Intern05EmployeeBO();
		tDAO = intern05EmployeeDAO;
	}

	@Override
	public Intern05EmployeeDAO gettDAO() {
		return intern05EmployeeDAO;
	}

	@Override
	public long count() {
		return intern05EmployeeDAO.count("Intern05EmployeeBO", null);
	}

	@Override
	public List<Intern05EmployeeDTO> getAll() {
		List<Intern05EmployeeDTO> employeeList = intern05EmployeeDAO.getAll();
		employeeList.forEach(t -> {
			t.setEmFullName(t.getEmFirstname() + " " + t.getEmLastname());
			if (t.getEmSex() == 1) {
				t.setEmSexString("Nam");
			}
			if (t.getEmSex() == 2) {
				t.setEmSexString("Nữ");
			}
			if (t.getEmSex() == 3) {
				t.setEmSexString("Không xác định");
			}
		});
		// Collections.sort(employeeList, (o1, o2) -> {
		// if (o1.getEmId() > o2.getEmId()) {
		// return 1;
		// }
		// if (o1.getEmId() < o2.getEmId()) {
		// return -1;
		// }
		// return 0;
		// });
		return employeeList;
	}

	@Override
	public Intern05EmployeeDTO getOneById(Long id) {
		Intern05EmployeeDTO intern05EmployeeDTO = intern05EmployeeDAO.getOneById(id);
		if (intern05EmployeeDTO.getEmSex() == 1) {
			intern05EmployeeDTO.setEmSexString("Nam");
		}
		if (intern05EmployeeDTO.getEmSex() == 2) {
			intern05EmployeeDTO.setEmSexString("Nữ");
		}
		if (intern05EmployeeDTO.getEmSex() == 3) {
			intern05EmployeeDTO.setEmSexString("Không xác định");
		}
		return intern05EmployeeDTO;
	}

	public List<Intern05EmployeeDTO> getByName(String name) {
		return intern05EmployeeDAO.getByName(name);
	}

	public List<Intern05EmployeeDTO> getByHometown(String hometown) {
		return intern05EmployeeDAO.getByHometown(hometown);
	}

	public List<Intern05EmployeeDTO> getByDepartment(String department) {
		return intern05EmployeeDAO.getByDepartment(department);
	}

	public List<Intern05EmployeeDTO> getByPosition(String position) {
		return intern05EmployeeDAO.getByPosition(position);
	}

	public List<Intern05EmployeeDTO> getByLiteracy(String literacy) {
		return intern05EmployeeDAO.getByLiteracy(literacy);
	}

	public List<Intern05EmployeeDTO> getBySalaryRate(Float salaryRate) {
		return intern05EmployeeDAO.getBySalaryRate(salaryRate);
	}

	public List<Intern05EmployeeDTO> getByBirthday(String birthday) {
		return intern05EmployeeDAO.getByBirthday(birthday);
	}

	public List<Intern05EmployeeDTO> getByStartedDate(String startedDate) {
		return intern05EmployeeDAO.getByStartedDate(startedDate);
	}

	public List<Intern05CitiesDTO> getAllCities() {
		return intern05EmployeeDAO.getAllCities();
	}

	public List<String> getAllCitiesName() {
		List<Intern05CitiesDTO> cityList = intern05EmployeeDAO.getAllCities();
		List<String> cityNameList = new ArrayList<>();
		for (int i = 0; i < cityList.size(); i++) {
			cityNameList.add(cityList.get(i).getCiName());
		}
		return cityNameList;
	}

	public String getAllCitiesNameString() {
		allCities = new StringBuilder();
		// List<String> cityList = getAllCitiesName();
		// for (String city : cityList) {
		// allCities.append(city + ", ");
		// }
		return allCities.toString();
	}

	public List<Intern05EthnicDTO> getAllEthnic() {
		return intern05EmployeeDAO.getAllEthnic();
	}

	public List<String> getAllEthnicName() {
		List<Intern05EthnicDTO> cityList = intern05EmployeeDAO.getAllEthnic();
		List<String> cityNameList = new ArrayList<>();
		for (int i = 0; i < cityList.size(); i++) {
			cityNameList.add(cityList.get(i).getEthName());
		}
		return cityNameList;
	}

	public List<Intern05EmployeeDTO> search(Intern05EmployeeDTO employeeDTO) {
		List<Intern05EmployeeDTO> employeeList = intern05EmployeeDAO.search(employeeDTO);
		employeeList.forEach(t -> {
			t.setEmFullName(t.getEmFirstname() + " " + t.getEmLastname());
			if (t.getEmSex() == 1) {
				t.setEmSexString("Nam");
			}
			if (t.getEmSex() == 2) {
				t.setEmSexString("Nữ");
			}
			if (t.getEmSex() == 3) {
				t.setEmSexString("Không xác định");
			}
		});
		return employeeList;
	}

}
