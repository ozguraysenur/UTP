package eu.glowacki.utp.assignment10.repositories;

import eu.glowacki.utp.assignment10.UnimplementedException;
import eu.glowacki.utp.assignment10.dtos.DTOBase;

import java.sql.*;

public abstract class RepositoryBase<TDTO extends DTOBase> implements IRepository<TDTO>{

    private Connection connection;
    PreparedStatement statement;

    public RepositoryBase(String driver ,String url ,String username ,String password){
        try {
            Class.forName(driver);
            connection= DriverManager.getConnection(url,username,password);
            connection.setAutoCommit(false);
        } catch (ClassNotFoundException  exc)  {  // driver class could not be loaded
            System.out.println("Driver could not be loaded");
            System.out.println(exc);
            System.exit(1);

        } catch (SQLException exc) { // connection could not be established
            System.out.println("Connection could not be established: " + url);
            System.out.println(exc);
            System.exit(1);
        }
    }

    @Override
    public Connection getConnection() {
        return connection;
    }

    @Override
    public void addOrUpdate(TDTO dto) {
        if(dto == null)
            return;
        if(exists(dto)) {
            update(dto);
        } else {
            add(dto);
        }
    }

    @Override
    public void beginTransaction() {
        try {
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            throw new UnimplementedException();
        }

    }

    @Override
    public void commitTransaction() {
        try {
            connection.commit();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            throw new UnimplementedException();
        }

    }

    @Override
    public void rollbackTransaction() {
        try {
            connection.rollback();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            throw new UnimplementedException();
        }
    }

    @Override
    public int getCount() {

         String query= "SELECT * FROM " + getTableName();
        int result=0;
        try {
            statement=connection.prepareStatement(query);
            ResultSet rs=statement.executeQuery();
            if(rs.next()){
                result++;
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            this.rollbackTransaction();

        }

        return result;

    }
    @Override
    public boolean exists(TDTO dto) {
        boolean exists=false;
        if(dto.hasExistingId()){
            TDTO saved =findById(dto.getId());
            if(saved!= null){
                exists=true;
            }

        }
        return exists;
    }
    abstract  String getTableName();


    }

