package eu.glowacki.utp.assignment10.repositories;

import eu.glowacki.utp.assignment10.UnimplementedException;
import eu.glowacki.utp.assignment10.dtos.GroupDTO;
import eu.glowacki.utp.assignment10.dtos.UserDTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository extends  RepositoryBase<UserDTO>  implements IUserRepository  {

    public UserRepository(String driver, String url, String username, String password) {
        super(driver, url, username, password);
    }

    @Override
    public List<UserDTO> findByName(String username) {
        List<UserDTO> userlist = new ArrayList<>();
        List<GroupDTO> groupList = new ArrayList<>();
        try {
        PreparedStatement statement = getConnection().prepareStatement
                ("SELECT user_login,user_password  FROM "+getTableName()
                        + " WHERE user_login LIKE ?");
            statement.setString(1, "%" + username + "%");
        ResultSet rs=statement.executeQuery();
        //   rs.beforeFirst();//set cursor to initial position

        while(rs.next()){

            String login= rs.getString(1);
            String pasword =rs.getString(2);
            UserDTO userdto =new UserDTO(login,pasword);

            statement = getConnection().prepareStatement("SELECT * FROM groups_users WHERE user_login=?");
            statement.setString(1,userdto.getLogin());
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {
                groupList.add(new GroupDTO(resultSet.getInt("group_id"),
                        resultSet.getString("group_name"),
                        resultSet.getString("group_description")));
            }
            userdto.setGroups(groupList);
            userlist.add(userdto);
        }
        return userlist;
    } catch (SQLException e) {
            throw new UnimplementedException();
    }
    }

    @Override
    String getTableName() {
        return "users";
    }

    @Override
    public void add(UserDTO dto) {
        try {
            String ss ="INSERT INTO users VALUES(?,?)";
            PreparedStatement statement = getConnection().prepareStatement(ss);
            statement.setString(1, dto.getLogin());
            statement.setString(2, dto.getPassword());
            statement.executeUpdate();
            statement.close();


        } catch (SQLException e) {
            throw new UnimplementedException();
        }

    }

    @Override
    public void update(UserDTO dto) {
        PreparedStatement updStatement = null;
        try {
            updStatement = getConnection().prepareStatement("UPDATE users " + "SET USER_PASSWORD = ? " + "WHERE USER_LOGIN = ?");
            updStatement.setString(1, dto.getPassword());
            updStatement.setString(2, dto.getLogin());

            updStatement.executeUpdate();


        } catch (SQLException e) {
            throw new UnimplementedException();

        } finally {
            try {
                updStatement.close();
                System.out.println("Successfully updated!");
            } catch (SQLException e) {

            }
        }

    }

    @Override
    public void delete(UserDTO dto) {
        try {
            String str ="DELETE FROM users WHERE USER_LOGIN = ?";
            PreparedStatement statement =getConnection().prepareStatement(str);
            statement.setString(1,dto.getLogin());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new UnimplementedException();
        }


        }
     @Override
        public UserDTO findById(int id) {
            return null;
        }

    }
