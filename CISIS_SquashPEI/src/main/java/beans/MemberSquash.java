package beans;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.apache.commons.beanutils.BeanUtils;

/**
 *
 * @author BJ
 */
public class MemberSquash {

    private boolean allowInformationOnWebsite;
    private boolean allowPhotoUse;

    public boolean isAllowInformationOnWebsite() {
        return allowInformationOnWebsite;
    }

    public void setAllowInformationOnWebsite(boolean allowInformationOnWebsite) {
        this.allowInformationOnWebsite = allowInformationOnWebsite;
    }

    public boolean isAllowPhotoUse() {
        return allowPhotoUse;
    }

    public void setAllowPhotoUse(boolean allowPhotoUse) {
        this.allowPhotoUse = allowPhotoUse;
    }
    
    
    
}


