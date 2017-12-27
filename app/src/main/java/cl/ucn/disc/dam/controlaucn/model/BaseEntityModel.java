package cl.ucn.disc.dam.controlaucn.model;

import com.raizlabs.android.dbflow.structure.BaseModel;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Created by Germán Rojo on 27-12-2017.
 */

public abstract class BaseEntityModel extends BaseModel {

    /**
     * @see Object#toString()
     */
    @Override
    public String toString() {

        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);

    }

}
