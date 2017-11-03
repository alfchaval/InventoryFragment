package com.example.usuario.inventory.pojo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author Alfonso Chamorro Valle
 * Clase pojo de los sectores
 */

public class Sector implements Parcelable {

    private int _ID;
    private String _name;
    private String _shortname;
    private String _description;
    private int _dependencyId;
    private boolean _enabled;
    private boolean _default;

    public Sector(int _ID, String _name, String _shortname, String _description, int _dependencyId, boolean _enabled, boolean _default) {
        this._ID = _ID;
        this._name = _name;
        this._shortname = _shortname;
        this._description = _description;
        this._dependencyId = _dependencyId;
        this._enabled = _enabled;
        this._default = _default;
    }

    public int get_ID() {
        return _ID;
    }

    public void set_ID(int _ID) {
        this._ID = _ID;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public String get_shortname() {
        return _shortname;
    }

    public void set_shortname(String _shortname) {
        this._shortname = _shortname;
    }

    public String get_description() {
        return _description;
    }

    public void set_description(String _description) {
        this._description = _description;
    }

    public int get_dependencyId() {
        return _dependencyId;
    }

    public void set_dependencyId(int _dependencyId) {
        this._dependencyId = _dependencyId;
    }

    public boolean is_enabled() {
        return _enabled;
    }

    public void set_enabled(boolean _enabled) {
        this._enabled = _enabled;
    }

    public boolean is_default() {
        return _default;
    }

    public void set_default(boolean _default) {
        this._default = _default;
    }

    @Override
    public String toString() {
        return "Sector{" +
                "_ID=" + _ID +
                ", _name='" + _name + '\'' +
                ", _shortname='" + _shortname + '\'' +
                ", _description='" + _description + '\'' +
                ", _dependencyId=" + _dependencyId +
                ", _enabled=" + _enabled +
                ", _default=" + _default +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(_ID);
        parcel.writeString(_name);
        parcel.writeString(_shortname);
        parcel.writeString(_description);
        parcel.writeInt(_dependencyId);
        parcel.writeByte((byte) (_enabled ? 1 : 0));
        parcel.writeByte((byte) (_default ? 1 : 0));
    }

    public static final Creator<Sector> CREATOR = new Creator<Sector>() {
        @Override
        public Sector createFromParcel(Parcel parcel) {
            return new Sector(
                    parcel.readInt(),
                    parcel.readString(),
                    parcel.readString(),
                    parcel.readString(),
                    parcel.readInt(),
                    parcel.readByte() == 1,
                    parcel.readByte() == 1
                    );
        }

        @Override
        public Sector[] newArray(int size) {
            return new Sector[size];
        }
    };
}
