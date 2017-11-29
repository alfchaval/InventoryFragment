package com.example.usuario.inventoryfragment.ui.utils;

public class AddEdit {
    //interface AddEditMode
    public static final int ADD_MODE = 0;
    public static final int EDIT_MODE = 1;
    private int mode;

    public AddEdit() {
        this.mode = ADD_MODE;
    }

    public AddEdit(int mode) {
        if(mode < ADD_MODE || mode > EDIT_MODE) {
            throw new IllegalArgumentException("invalid AddEditMode: " + mode);
        }
        this.mode = mode;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

}
