package demos;

import java.util.ArrayList;

public class CommonDAO {

    public int register(LoginUserVo utilStu) {
        String sql = "INSERT into t_common (name,password,sex,city,email,hobby,role) VALUES(?,?,?,?,?,?,?);";
        int result = DBUtils.update(sql, utilStu.getName(), utilStu.getPassword(), utilStu.getSex(), utilStu.getCity(), utilStu.getEmail(), utilStu.getHobby(), "student");
        DBUtils.closeObject();
        return result;
    }

    public int login(LoginUserVo luv) {
        int result = 0;
        try {
            String sql = "SELECT count(name) FROM t_common WHERE `name`= ? AND `password`=? AND `role` =?";
            DBUtils.rs = DBUtils.query(sql, luv.getName(), luv.getPassword(), luv.getRole());
            while (DBUtils.rs.next()) {
                result = DBUtils.rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeObject();
        }
        return result;
    }

    public int modifyPwd(String name, String newPwd) {
        String sql = "UPDATE t_common SET `password` = ? WHERE `name` = ?";
        int result = DBUtils.update(sql, newPwd, name);
        DBUtils.closeObject();
        return result;
    }

    public LoginUserVo queryStuByName(String name) {
        LoginUserVo luv = null;
        try {
            String sql = "SELECT `name`,sex,email,hobby,city FROM t_common WHERE `name`=?";
            DBUtils.rs = DBUtils.query(sql, name);
            while (DBUtils.rs.next()) {
                luv = new LoginUserVo();
                luv.setName(DBUtils.rs.getString("name"));
                luv.setSex(DBUtils.rs.getString("sex"));
                luv.setEmail(DBUtils.rs.getString("email"));
                luv.setHobby(DBUtils.rs.getString("hobby"));
                luv.setCity(DBUtils.rs.getString("city"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeObject();
        }
        return luv;
    }

    public int modifyInfo(LoginUserVo upd) {
        String sql = "UPDATE t_common SET sex =?,email =?,hobby =?,city =? WHERE `name` =?";
        int result = DBUtils.update(sql, upd.getSex(), upd.getEmail(), upd.getHobby(), upd.getCity(), upd.getName());
        DBUtils.closeObject();
        return result;
    }

    public ArrayList<LoginUserVo> queryAllStu() {
        ArrayList<LoginUserVo> arrayList = new ArrayList<>();
        try {
            String sql = "SELECT `name`,sex,email,hobby,city FROM t_common WHERE role ='student'";
            DBUtils.rs = DBUtils.query(sql);
            while (DBUtils.rs.next()) {
                LoginUserVo luv = new LoginUserVo();
                luv.setName(DBUtils.rs.getString("name"));
                luv.setSex(DBUtils.rs.getString("sex"));
                luv.setEmail(DBUtils.rs.getString("email"));
                luv.setHobby(DBUtils.rs.getString("hobby"));
                luv.setCity(DBUtils.rs.getString("city"));
                arrayList.add(luv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeObject();
        }
        return arrayList;
    }

    public int delStuByNP(String name, String password) {
        String sql = "DELETE FROM t_common WHERE name =? AND password= ?";
        int result = DBUtils.update(sql, name, password);
        DBUtils.closeObject();
        return result;
    }
}