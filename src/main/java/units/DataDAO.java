package units;

import bean.UserAccount;
import config.SecurityConfig;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;


public class DataDAO {

    private static final Map<String, UserAccount> mapUsers = new HashMap<String, UserAccount>();
    private static final String tempPass = "123";

    static {
        try {
            initUsers();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    private static void initUsers() throws NoSuchAlgorithmException {

        // This user has a role as USER.
        UserAccount emp = new UserAccount("user1",password(tempPass),  //
                SecurityConfig.ROLE_USER);

        // This user has 2 roles USER and AD.
        UserAccount mng = new UserAccount("admin1", password(tempPass),  //
                SecurityConfig.ROLE_USER, SecurityConfig.ROLE_ADMIN);

        mapUsers.put(emp.getUserName(), emp);
        mapUsers.put(mng.getUserName(), mng);
    }

    // Find a User by userName and password.
    public static UserAccount findUser(String userName, String password) {
        UserAccount u = mapUsers.get(userName);
        String hashPassword = password(tempPass);
        if (u != null && u.getPassword().equals(hashPassword)) {
            return u;
        }
        return null;
    }
    public static String password(String tempPass) {
        String md5Hex = DigestUtils.md5Hex(tempPass);
        return md5Hex;
    }

}