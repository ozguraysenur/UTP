package eu.glowacki.utp.assignment10.repositories.test;

import eu.glowacki.utp.assignment10.dtos.UserDTO;
import eu.glowacki.utp.assignment10.repositories.GroupRepository;
import org.junit.Assert;
import org.junit.Test;
import eu.glowacki.utp.assignment10.UnimplementedException;
import eu.glowacki.utp.assignment10.dtos.GroupDTO;
import eu.glowacki.utp.assignment10.repositories.IGroupRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GroupRepositoryTest extends RepositoryTestBase<GroupDTO, IGroupRepository> {
	String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	String DATABASE_URL = "jdbc:oracle:thin:@10.01.01.34:1521:baza";
	String USERNAME = "s19358";
	String PASSWORD = "oracle12";

	@Test
	public void add() {
		int count = _repository.getCount();
		GroupDTO group =new GroupDTO(0,"nmae1","desc");
		_repository.add(group);
		int expected= count+1;
		int actual= _repository.getCount();

		Assert.assertEquals(expected,actual);
	}

	@Test
	public void update() {
		GroupDTO dto =new GroupDTO(1,"group1" ,"bests");
		_repository.add(dto);
		_repository.update(dto);
		List<GroupDTO> groupDTOS= _repository.findByName("group1");
		Assert.assertNotNull(groupDTOS);

	}
	
	@Test
	public void addOrUpdate() {
		GroupDTO dto =new GroupDTO(1,"group1" ,"bests");
		_repository.addOrUpdate(dto);
		int count= _repository.getCount();
		Assert.assertEquals(1,count);



	}

	@Test
	public void delete() {
		GroupDTO dto =new GroupDTO(1,"group1" ,"bests");
		_repository.add(dto);
		_repository.delete(dto);
		List<GroupDTO> groupDTOS= _repository.findByName("group1");
		int rep =_repository.getCount();
		Assert.assertEquals(0,rep);
	}

	@Test
	public void findById() {
		GroupDTO dto =new GroupDTO(1,"group1" ,"bests");
		_repository.add(dto);
		List<GroupDTO> groupDTOS=new ArrayList<>();
		groupDTOS.add(_repository.findById(1));
		Assert.assertNotNull(groupDTOS);

	}
	
	@Test
	public void findByName() {
		GroupDTO dto =new GroupDTO(1,"group1" ,"bests");
		_repository.add(dto);
		List<GroupDTO> groupDTOS= _repository.findByName("gro");
		Assert.assertEquals(1,groupDTOS.size());


	}

	@Override
	protected IGroupRepository Create() {
		GroupRepository gr = new GroupRepository(JDBC_DRIVER,DATABASE_URL,USERNAME,PASSWORD);
		return gr;
	}
}