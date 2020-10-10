package units;

import org.apache.commons.codec.digest.DigestUtils;

public class PasswordHash {
    private String pas = null;

    public PasswordHash(String pas) {
        this.pas = pas;
    }

    public PasswordHash() {
    }
    public  String password(String tempPass) {
        String md5Hex = DigestUtils.md5Hex(tempPass);
        return md5Hex;
    }
}
