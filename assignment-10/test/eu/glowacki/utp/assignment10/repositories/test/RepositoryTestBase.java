package eu.glowacki.utp.assignment10.repositories.test;

import org.junit.After;
import org.junit.Before;

import eu.glowacki.utp.assignment10.dtos.DTOBase;
import eu.glowacki.utp.assignment10.repositories.IRepository;
import org.junit.BeforeClass;

import java.sql.SQLException;

public abstract class RepositoryTestBase<TDTO extends DTOBase, TRepository extends IRepository<TDTO>> {

	protected TRepository _repository;
	//String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

	@Before
	public void before() {
		_repository = Create();
		if (_repository != null) {
			_repository.beginTransaction();
		}
	}

	@After
	public void after() {
		if (_repository != null) {
			_repository.rollbackTransaction();
		}
	}

	protected abstract TRepository Create();
}