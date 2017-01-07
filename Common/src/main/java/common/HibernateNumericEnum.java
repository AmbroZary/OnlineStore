package common;

import org.hibernate.type.EnumType;
import java.sql.Types;
import java.util.Properties;
public class HibernateNumericEnum extends EnumType {

    public void setParameterValues(Properties parameters) {
        parameters.setProperty(TYPE, "" + Types.BIGINT);
        super.setParameterValues(parameters);
    }
}