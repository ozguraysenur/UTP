package eu.glowacki.utp.assignment10.repositories.test;

import eu.glowacki.utp.assignment10.repositories.UserRepository;
import org.junit.Assert;
import org.junit.Test;

import eu.glowacki.utp.assignment10.UnimplementedException;
import eu.glowacki.utp.assignment10.dtos.UserDTO;
import eu.glowacki.utp.assignment10.repositories.IUserRepository;

import java.util.ArrayList;
import java.util.List;

public final class UserRepositoryTest extends RepositoryTestBase<UserDTO, IUserRepository> {
	String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	String DATABASE_URL = "jdbc:oracle:thin:@10.01.01.34:1521:baza";
	String USERNAME = "s19358";
	String PASSWORD = "oracle12";

	@Test
	public void add() {
		int count = _repository.getCount();
		UserDTO user =new UserDTO("aksel","44444");
		_repository.add(user);
		int expected= count+1;
		int actual= _repository.getCount();

		Assert.assertEquals(expected,actual);
	}

	@Test
	public void update() {
		UserDTO dto =new UserDTO("group1" ,"bests");
		_repository.add(dto);
		_repository.update(dto);
		List<UserDTO> users= _repository.findByName("group1");
		Assert.assertNotNull(users);
	}
	
	@Test
	public void addOrUpdate() {
		UserDTO dto =new UserDTO("s19358" ,"secret");
		_repository.addOrUpdate(dto);
		int count= _repository.getCount();
		Assert.assertEquals(1,count);

	}
	@Test
	public void delete() {
		UserDTO dto =new UserDTO("s19358" ,"secret");
		_repository.add(dto);
		_repository.delete(dto);
		//List<UserDTO> groupDTOS= _repository.findByName("s19358");
		int rep =_repository.getCount();
		Assert.assertEquals(0,rep);
	}

	@Test
	public void findById() {
	}
	
	@Test
	public void findByName() {
		UserDTO dto =new UserDTO("s19358" ,"secret");
		_repository.add(dto);
		List<UserDTO> dtos= _repository.findByName("193");
		Assert.assertEquals(1,dtos.size());
	}

	@Override
	protected IUserRepository Create() {
		UserRepository uu = new UserRepository(JDBC_DRIVER,DATABASE_URL,USERNAME,PASSWORD);
		return uu;
	}
}