package cl.ucn.disc.dam.controlaucn.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Created by pc on 19-12-2017.
 */

public abstract class BaseModel extends com.raizlabs.android.dbflow.structure.BaseModel{

    /**
     * @see Object#toString()
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
