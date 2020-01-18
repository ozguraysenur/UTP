package eu.glowacki.utp.assignment10.repositories;

import eu.glowacki.utp.assignment10.UnimplementedException;
import eu.glowacki.utp.assignment10.dtos.GroupDTO;
import eu.glowacki.utp.assignment10.dtos.UserDTO;
import oracle.jdbc.proxy.annotation.Pre;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GroupRepository extends  RepositoryBase<GroupDTO>  implements IGroupRepository {
    Connection connection =getConnection();


    public GroupRepository(String driver, String url, String username, String password) {
        super(driver, url, username, password);
    }

    @Override
    public List<GroupDTO> findByName(String name) {
        List<GroupDTO> resultGroupList = new ArrayList<>();
        List<UserDTO> listOfUsers = new LinkedList<>();
        try {
        PreparedStatement statement = getConnection().prepareStatement
                ("SELECT group_id,group_name,group_description FROM "+getTableName()
                + " WHERE group_name LIKE ?");
        statement.setString(1, "%" + name + "%");
        ResultSet rs=statement.executeQuery();
         //   rs.beforeFirst();//set cursor to initial position

            while(rs.next()){
                int id =rs.getInt(1);
                String grpname= rs.getString(2);
                String desc =rs.getString(3);
                GroupDTO groupDTO =new GroupDTO(id,grpname,desc);

                statement = getConnection().prepareStatement("SELECT * FROM groups_users WHERE group_id=?");

                statement.setInt(1, groupDTO.getId());
                ResultSet res = statement.executeQuery();
                while (res.next()){
                    listOfUsers.add(new UserDTO(res.getString("user_login"), res.getString("user_password")));
                }
                groupDTO.setUsers(listOfUsers);

                resultGroupList.add(groupDTO);
            }
            return resultGroupList;
        } catch (SQLException e) {
           throw new UnimplementedException();
        }

    }

    @Override
    String getTableName() {
        return "groups";
    }

    @Override
    public void add(GroupDTO dto) {
        try {
            String ss ="INSERT INTO groups VALUES(?,?,?)";
        PreparedStatement statement = getConnection().prepareStatement(ss);
        statement.setInt(1, dto.getId());
        statement.setString(2, dto.getName());
        statement.setString(3, dto.getDescription());
        statement.executeUpdate();

            statement.close();


        } catch (SQLException e) {
            throw new UnimplementedException();
        }

    }

    @Override
    public void update(GroupDTO dto) {
        PreparedStatement updStatement = null;
        try {
            updStatement = getConnection().prepareStatement("UPDATE GROUPS " + "SET GROUP_NAME = ?, GROUP_DESCRIPTION = ? " + "WHERE GROUP_ID = ?");
            updStatement.setString(1, dto.getName());
            updStatement.setString(2, dto.getDescription());
            updStatement.setInt(3, dto.getId());
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
    public void delete(GroupDTO dto) {

        try {
        String str ="DELETE FROM groups WHERE group_id = ?";
        PreparedStatement statement =connection.prepareStatement(str);
        statement.setInt(1,dto.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new UnimplementedException();
        }


    }

    @Override
    public GroupDTO findById(int id) {

        GroupDTO group =null;
        try {
        PreparedStatement statement=getConnection().prepareStatement
                ("SELECT group_id,group_name,group_description FROM "+getTableName()
                + " WHERE group_id = ?");
        statement.setInt(1,id);
        ResultSet rs =statement.executeQuery();

        int exists= rs.getFetchSize();
            if(exists==1){
                rs.first();
                int groupId = rs.getInt(1);
                String groupName = rs.getString(2);
                String description= rs.getString(3);

                group=new GroupDTO(groupId,groupName,description);
            }
        } catch (SQLException e) {
            throw new UnimplementedException();
        }
        return group;
    }
}
