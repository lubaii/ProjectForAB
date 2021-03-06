package units;

import bean.UserAccount;
import config.SecurityConfig;
import org.apache.commons.codec.digest.DigestUtils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;


public class DataDAO {

    private static final Map<String, UserAccount> mapUsers = new HashMap<String, UserAccount>();
    private static final String tempPassAdmin = "202cb962ac59075b964b07152d234b70"; //Хеш параля получен так DigestUtils.md5Hex("456");
    private static final String tempPassUser = "250cf8b51c773f3f8dc8b4be867a9a02";// Хеш пароля получен так DigestUtils.md5Hex("123");

    static {
        try {
            initUsers();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    private static void initUsers() throws NoSuchAlgorithmException {

        // This user has a role as USER.
        UserAccount emp = new UserAccount("user1",tempPassUser,  //
                SecurityConfig.ROLE_USER);

        // This user has 2 roles USER and AD.
        UserAccount mng = new UserAccount("admin1", tempPassAdmin,  //
                SecurityConfig.ROLE_USER, SecurityConfig.ROLE_ADMIN);

        mapUsers.put(emp.getUserName(), emp);
        mapUsers.put(mng.getUserName(), mng);
    }

    // Find a User by userName and password.
    public static UserAccount findUser(String userName, String pass) throws NoSuchAlgorithmException {
        UserAccount u = mapUsers.get(userName);
        String tempPas = password(pass);
        if (u != null && tempPas.equals(tempPassAdmin)||u != null && tempPas.equals(tempPassUser)) {
            return u;
        }
        return null;
    }

    public static String password(String temp) {

        String md5Hex = DigestUtils.md5Hex(temp);
        return md5Hex;
    }
}